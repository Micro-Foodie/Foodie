<!-- 文章缩略图 -->
<template>
  <div>
    <div id="article-panel">
      <div class="article-list">
        <div v-for="item in dis_articleListInfo">
          <articleListItem :key="item.id" :data="item">
            <!-- v-if="item.isTop == 1" -->
          </articleListItem>
        </div>

        <!-- <div v-for="item in dis_articleListInfo">
          <articleListItem  :key="item.id" :data="item">
          </articleListItem>
        </div> -->
      </div>
      <div class="pagination">
        <el-pagination :current-page="currentPage" :page-size="totalpagenumber" :total="totalCount"
          layout="->,prev, pager, next,jumper" @current-change="handlePageChange"></el-pagination>
      </div>
    </div>

  </div>
</template>

<script setup>
import { ref, onMounted, watch } from 'vue';
import router from "@/router/index.js"
import { useStore } from 'vuex'; // ！！！
import { loadArticle, recommendArticle } from "@/api/article.js"
import articleListItem from "@/components/articleListItem.vue"
import axios from 'axios';

const store = useStore();
// 子组件接收父组件的传值 和 子路由接收父路由的传值不同
// 前者：defineProps()
// 后者：router.currentRoute.value.params.pBoardId

const pBoardId = ref(router.currentRoute.value.params.pBoardId);

// 存储获取的文章数据
const articleListInfo = ref([]);

const dis_articleListInfo = ref([]);
const currentPage = ref(1);   // 当前页码
const pageSize = 8;          // 每页元素数量
const totalpagenumber = ref(1);  //总页数
const totalCount = ref(0);

// 获取文章数据
const fetchData = async () => {

  //   axios.get('https://www.mxnzp.com/api/cookbook/category?&app_id=uunkojnlttcj1i2i&app_secret=AqLl9iivtCsXTlbZJIu6P8Kibg1NClBB',
  //   {
  //     params:{
  //       category_id: 334
  //     }
  //   })
  //   .then(response => {
  //   // 处理响应数据
  //   const Categories = response.data;
  //   console.log(Categories)

  //   /*console.log(三级分类of 2)
  //   {code: 1, msg: '数据返回成功！', data: Array(8)}
  // code: 1
  // data: Array(8)
  // 0: {id: 3, name: '家常菜', floor: 3}  //没有数据
  // 1: {id: 4, name: '快手菜', floor: 3}  //没有数据
  // 2: {id: 5, name: '下饭菜', floor: 3}
  // 3: {id: 6, name: '素菜', floor: 3}
  // 4: {id: 7, name: '大鱼大肉', floor: 3}  //没有数据
  // 5: {id: 8, name: '下酒菜', floor: 3}
  // 6: {id: 9, name: '小清新', floor: 3}
  // 7: {id: 10, name: '创意菜', floor: 3}
  // length: 8
  // [[Prototype]]: Array(0)
  // msg: "数据返回成功！"
  // */

  //   /* console.log(二级分类 of 1)
  //   {code: 1, msg: '数据返回成功！', data: Array(5)}
  // code: 1
  // data: Array(5)
  // 0: {id: 2, name: '菜式', floor: 2}
  // 1: {id: 11, name: '特色食品', floor: 2}
  // 2: {id: 23, name: '特殊场合', floor: 2}
  // 3: {id: 32, name: '功效', floor: 2}
  // 4: {id: 38, name: '人群', floor: 2}
  // length: 5
  // [[Prototype]]: Array(0)
  // msg: "数据返回成功！"*/

  // /* console.log(二级分类 of 317)
  // {code: 1, msg: '数据返回成功！', data: Array(3)}
  // code: 1
  // data: Array(3)
  // 0: {id: 318, name: '汤粥主食', floor: 2}
  // 1: {id: 328, name: '面条', floor: 2}
  // 2: {id: 334, name: '饭', floor: 2}
  // length: 3
  // [[Prototype]]: Array(0)
  // msg: "数据返回成功！" */

  //   /*console.log(一级分类)
  //   结果{code: 1, msg: '数据返回成功！', data: Array(9)}
  // code: 1
  // data: 
  // Array(9)
  //   0: {id: 1, name: '热门专题', floor: 1}
  //   1: {id: 44, name: '烘焙甜品饮料', floor: 1}
  //   2: {id: 69, name: '肉类', floor: 1}
  //   3: {id: 150, name: '蔬菜水果', floor: 1}
  //   4: {id: 317, name: '汤粥主食', floor: 1}
  //   5: {id: 341, name: '口味特色', floor: 1}
  //   6: {id: 375, name: '水产', floor: 1}
  //   7: {id: 417, name: '蛋奶豆制品', floor: 1}
  //   8: {id: 452, name: '米面干果腌咸', floor: 1}
  //   length: 9
  //   [[Prototype]]: Array(0)
  // msg: "数据返回成功！"*/
  //   })


  let p_board_id = pBoardId.value;
  if (p_board_id == 0)
    p_board_id = 1;

  //重要的文章获取！！！
  // // 不能使用绝对地址，用相对地址
  // const ret = await axios.get('https://www.mxnzp.com/api/cookbook/list/category?&app_id=uunkojnlttcj1i2i&app_secret=AqLl9iivtCsXTlbZJIu6P8Kibg1NClBB',
  //   { params: {
  //       category_id: 7,
  //       page: p_board_id,
  //     }
  //   })
  // console.log(ret.data)


  //console.log(p_board_id);
  // if (p_board_id == 0) {
  //   const params = {
  //     user_id: store.state.Info.id
  //   };
  //   result = await recommendArticle(params)
  // }
  // else {
  //   const params = {
  //     p_board_id: p_board_id,
  //   };
  //   result = await loadArticle(params);
  // }

  const ret = {
    data: {
      code: 1,
      data: {
        list: [
          { id: 100086, name: '干锅花菜', desc: '', ingredient: Array(11), cover: 'http://power-api.cretinzp.com:8000/cookbook_file/6…/8/d/3/3/7/c/26f89936c833479398ec7132db8ce7c0.jpg' },
          { id: 100087, name: '🔥茄子这样做也太费米饭了吧', desc: '今天分享一道超级下饭的家常红烧茄子，简单好吃，一端上桌就秒光！茄子这样做真的太费米饭了😭😭儿子说：比饭店做的好吃', ingredient: Array(3), cover: 'http://power-api.cretinzp.com:8000/cookbook_file/9…/8/8/3/b/e/7/9e518360a57f49c39660e72ba73b2036.jpg' },
          { id: 100088, name: '鲜香嫩滑！好吃不胖的蒜香炒口蘑！', desc: '今天分享一道蒜香炒口蘑，清爽不油腻，爽脆嫩滑。配上一大碗米饭超好吃！喜欢口蘑的必须试试～做法简单，好吃不胖……', ingredient: Array(5), cover: 'http://power-api.cretinzp.com:8000/cookbook_file/c…/0/5/7/a/9/c/f1c63ae9aac8494cb81f4b4edef98989.jpg' },
          { id: 100089, name: '下饭菜！超级好吃，盖饭棒棒哒！', desc: '我这人没废话开干', ingredient: Array(9), cover: 'http://power-api.cretinzp.com:8000/cookbook_file/f…/3/3/d/8/1/1/048230d9db5f4b50b2988c4343d6b196.jpg' },
          { id: 100091, name: '米饭杀手四季豆肉丝', desc: '每次做这道菜，家人都要干一大碗饭，超级超级费米饭！', ingredient: Array(2), cover: 'http://power-api.cretinzp.com:8000/cookbook_file/4…/3/3/7/d/9/6/5a12b18ad875419f8441fccb6a0beb2e.jpg' },
          { id: 100092, name: '酸辣咸甜的醋溜白菜🥬', desc: '今天来做一道很下饭的素菜！\n真的做法简单又下饭！\n酸辣开胃！厨房小白也能轻松get！', ingredient: Array(4), cover: 'http://power-api.cretinzp.com:8000/cookbook_file/a/8/2/4/e/a/5/4a3dd6bfe6d346c79039afbafe73c263.jpg' },
          { id: 100094, name: '素🉑50道家常菜😊附做法', desc: '', ingredient: Array(2), cover: 'http://power-api.cretinzp.com:8000/cookbook_file/f…/a/5/a/8/2/8/653466b691f7428a8a16786732e4113f.jpg' },
          { id: 100095, name: '蚂蚁上树——肉末粉条的完美结合', desc: '', ingredient: Array(6), cover: 'http://power-api.cretinzp.com:8000/cookbook_file/7…/1/d/f/a/7/c/19f5a3057e644178a52701e88c05cd2e.jpg' },
          { id: 100096, name: '藕蒸肉', desc: '秋天吃藕胜过肉，又脆又甜。这道莲藕蒸肉饼特别好吃哦', ingredient: Array(8), cover: 'http://power-api.cretinzp.com:8000/cookbook_file/5…/9/d/7/5/7/8/a6aee86ff46044b0852f0add485c3fe1.jpg' },
        ],
        page: 1,
        totalCount: 44620,
        totalPage: 4462,
      },
    }
  }

  articleListInfo.value = ret.data.data.list;
  currentPage.value = 1;
  //totalpagenumber.value = Math.ceil(articleListInfo.value.length / pageSize);   //计算总页数
  totalpagenumber.value = ret.data.data.totalPage;
  //totalCount.value = articleListInfo.value.length;
  totalCount.value = ret.data.data.totalCount;
  dis_articleListInfo.value = articleListInfo.value.slice(0, 9);
};

const handlePageChange = async (page) => {
  if (page >= 1 && page <= totalpagenumber.value) {

    //console.log(page)
    currentPage.value = page;
    const start = (currentPage.value - 1) * pageSize;
    const end = start + pageSize;
    // const ret = await axios.get('https://www.mxnzp.com/api/cookbook/list/category?&app_id=uunkojnlttcj1i2i&app_secret=AqLl9iivtCsXTlbZJIu6P8Kibg1NClBB',
    // { params: {
    //     category_id: 7,
    //     page: currentPage.value,
    //   }
    // })

    const ret = {
      data: {
        code: 1,
        data: {
          list: [
            { id: 100512, name: '家常酸菜鱼', desc: '', ingredient: Array(4), cover: 'http://power-api.cretinzp.com:8000/cookbook_file/8…/d/a/b/8/f/c/750d2029744f48d3a6577ea7239adb8f.jpg' },
            { id: 100543, name: '鲜嫩入味！好吃到舔手指的南瓜蒜香蒸排骨', desc: '嗨喽，宝宝们好！\n今天分享一道蒜香味的蒸排骨，用南瓜打底，南瓜软糯香甜，排骨鲜嫩多汁又入味，汤汁拌着米饭🍚，不仅宝宝爱吃，大人也能吃一大碗！做法简单，值得一试', ingredient: Array(7), cover: 'http://power-api.cretinzp.com:8000/cookbook_file/d…/4/c/f/2/5/9/6f532a8e458841579630c4e83b469d35.jpg' },
            { id: 100549, name: '蒸鲈鱼🐟简单快速家常菜', desc: '蒸鲈鱼是广东人从小吃到大的一道菜，也是粤菜酒楼的经典菜式，是很容易做的一道家常菜。\n鲈鱼口感鲜嫩，营养价值很高、健脾益肾，鱼刺也很少，适合小孩老人吃。', ingredient: Array(5), cover: 'http://power-api.cretinzp.com:8000/cookbook_file/1…/e/4/8/7/f/c/efa446c7842a415594dcc267d678ea31.jpg' },
            { id: 100565, name: '酸辣鲜香金汤酸菜鱼', desc: '汤鲜味美，酸辣鲜香，吃腻了大鱼大肉，这盆黯然销魂金汤酸菜鱼，是深秋的正确打开方式，一碗下肚，微辣劲爽…都够吃啦！戳这里可以get同款，美味又快手喔👉 https://s.tb.cn/c.0Fi2qv', ingredient: Array(6), cover: 'http://power-api.cretinzp.com:8000/cookbook_file/8…/7/3/2/4/4/a/2dc4a6871e9842d48d60c74280551e61.jpg' },
            { id: 100575, name: '夏日神仙凉菜｜凉拌肘花', desc: '', ingredient: Array(8), cover: 'http://power-api.cretinzp.com:8000/cookbook_file/9…/c/f/9/d/e/4/89b0fc8ebd21414bb001ab8ffdac74a2.jpg' },
            { id: 100588, name: '辣子鸡', desc: '', ingredient: Array(24), cover: 'http://power-api.cretinzp.com:8000/cookbook_file/e…/6/4/2/8/c/6/131a3e2a9a0d4d67be95e9c1e2253698.jpg' },
            { id: 100591, name: '腊味｜蒜苗炒腊猪肉', desc: '', ingredient: Array(10), cover: 'http://power-api.cretinzp.com:8000/cookbook_file/c…/2/5/8/4/4/d/aee533dd901a4141838518804a566534.jpg' },
            { id: 100713, name: '经典家常菜🥩土豆烧牛肉', desc: '我不允许你还没吃过的川菜经典的家常菜之一，餐桌上的王者，土豆烧牛肉😍😍😍，跟着做，不好吃你回来打我，哈哈哈哈哈', ingredient: Array(11), cover: 'http://power-api.cretinzp.com:8000/cookbook_file/9…/f/c/b/2/3/a/9a3191bdaa9445b79faaf1dbe5efd751.jpg' },
            { id: 100745, name: '家常菜🥢双椒烧鲈鱼', desc: '菜品之间，即可以相互融合，也可以相互借鉴\n\n同一种食材，总是想尝试不同的做法\n\n今天烧鲈鱼，打算寻找一种新的味道\n\n以前只做过红烧，今天加点青红椒试试吧😬', ingredient: Array(5), cover: 'http://power-api.cretinzp.com:8000/cookbook_file/d…/c/8/b/a/1/1/69aa4a51fac3488382b20d07da15b4b2.jpg' },
            { id: 100750, name: '双重奶酪的快乐‼️奶酪年糕辣鸡翅', desc: '这一锅热乎乎又甜辣浓郁的奶酪年糕辣鸡翅，双重奶酪香浓，超拉丝巨满足！糯叽叽的年糕和一嗦就脱骨的鸡翅太…023年1月31日跟做本菜谱并上传你的跟做作品，即有机会获得妙可蓝多产品大礼包，中奖率非常高哦~~', ingredient: Array(14), cover: 'http://power-api.cretinzp.com:8000/cookbook_file/4…/e/a/6/e/c/0/d597fe341a8747ce87009a79ff885226.jpg' },
          ],
          page: 1,
          totalCount: 44620,
          totalPage: 4462,
        },
      }
    }
    console.log(ret.data)
    articleListInfo.value = ret.data.data.list;
    dis_articleListInfo.value = articleListInfo.value.slice(0, 9);
  }
}

// 在组件挂载时获取初始文章数据
onMounted(() => {
  fetchData();
});

// 使用 watch 监听父级路由参数的变化
watch(() => router.currentRoute.value.params.pBoardId, (newValue) => {
  // console.log(newValue);
  pBoardId.value = newValue;
  fetchData();
});
</script>

<style>
#article-panel {
  height: 1220px;
  width: 85vw;
  margin-left: auto;
  margin-right: auto;
  margin-top: 2vh;
  box-shadow: 0 2px 6px 0 #ddd;
  display: flex;
  flex-direction: column;
  justify-content: space-between;
  align-items: center;
}

.article-list {
  width: 80vw;
  /* display: flex; */
  justify-content: center;
  align-items: center;
  margin: 0px auto;
  flex: 1;
}

.pagination {
  display: flex;
  justify-content: center;
  margin-left: auto;
  margin-right: auto;
  margin-bottom: 10px;
  order: 1;
}
</style>

