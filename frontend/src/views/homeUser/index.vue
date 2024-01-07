<template>
    <div>
        <!-- ********************************* -->
        <el-dialog v-model="showTipTapEditor" title="发布文章" width="80%" height="80%" align-center>
            <tiptapEditor initial-content="
          <p> </p>
          <p> </p>
          <p> </p>
          <p> </p>
          <p> </p>
          " :active-buttons="[
              'bold',
              'italic',
              'strike',
              'underline',
              'code',
              'image',
              'h1',
              'h2',
              'h3',
              'bulletList',
              'orderedList',
              'blockquote',
              'codeBlock',
              'horizontalRule',
              'undo',
              'redo',
          ]" @update="test"></tiptapEditor>
        </el-dialog>
        <!-- ********************************* -->

        <div style="background-color: #DDF3FF;">
            <div class="header">
                <navTop></navTop>
            </div>
            <div class="recommendTitle">
                今日菜谱推荐
            </div>
            <div class="todayRecommend" v-for="(item, index) in todayRecommendList" :key="index"
                :style="{ left: `${index * 18 + 8}rem` }">
                <img class="recommendPictureContainer" :src="item.cover">
                <div class="recommendArticleTitle"> {{ item.name }} </div>
            </div>

            <el-card class="foodType" v-for="(item, index) in foodTypeList" :key="index"
                :style="{ top: `${index * 7.5 + 9}rem` }" @click="handleFoodTypeJump(index + 1)">
                <img class="foodTypePictureContainer" :src="item.foodPicture">
                <div style="font-size: 32px; font-weight: 400;" class="foodTypeName"> {{ item.foodType }} </div>
            </el-card>

            <el-form class="enter-forum" :inline="true">
                <el-form-item>
                    <el-button class="buttonEnterAndPost" @click="toAllFood">
                        <span>进入论坛&nbsp;</span>
                        <span class="iconfont icon-ic_play_black"></span>
                    </el-button>
                </el-form-item>
                <el-form-item>
                    <el-button class="buttonEnterAndPost" @click="showTipTapEditor = true">
                        <span>发布文章&nbsp;</span>
                        <span class="iconfont icon-pen-to-square"></span>
                    </el-button>
                </el-form-item>
            </el-form>
        </div>
    </div>
</template>

<script setup>
import { ref, reactive, onMounted } from 'vue';
import router from "@/router/index.js"
import navTop from "@/components/navTop.vue"
import axios from 'axios';

const foodTypeList = ref([
    { foodType: '中餐', foodPicture: 'https://cdn.pixabay.com/photo/2015/09/16/20/10/dough-943245_640.jpg' },
    { foodType: '西餐', foodPicture: 'https://cdn.pixabay.com/photo/2017/12/10/14/47/pizza-3010062_640.jpg' },
    { foodType: '甜品', foodPicture: 'https://media.istockphoto.com/id/478461614/photo/sponge-cake-with-cream-and-strawberries.webp?b=1&s=612x612&w=0&k=20&c=bTMay5Dz2wk_ZEB3_Bdu2tnfE8OpIhGrr6SBi_fnJSY=' },
    { foodType: '其他', foodPicture: 'https://cdn.pixabay.com/photo/2018/08/03/08/33/food-3581341_960_720.jpg' }
]);

const todayRecommendList = ref(//[
    // { name: '【莓莓蛋糕】不用刀！做法很简单！', cover: 'https://cdn.pixabay.com/photo/2018/05/01/18/23/eclair-3366437_960_720.jpg' },
    // { name: '【寿司】一口一个寿司！超可爱！', cover: 'https://cdn.pixabay.com/photo/2015/09/06/00/28/sushi-926628_1280.jpg' },
    // { name: '【塔可】简单又健康！', cover: 'https://cdn.pixabay.com/photo/2017/03/17/16/44/taco-2152097_1280.jpg' },
    //]
);


onMounted(() => {
    getArticleInfo();
});

const getArticleInfo = async () => {

    //重要的文章获取！！！
    // 不能使用绝对地址，用相对地址
    const ret = await axios.get('https://www.mxnzp.com/api/cookbook/list/category?&app_id=uunkojnlttcj1i2i&app_secret=AqLl9iivtCsXTlbZJIu6P8Kibg1NClBB',
        {
            params: {
                category_id: 7,
                page: 1,
            }
        })

    todayRecommendList.value = ret.data.data.list.slice(0, 3);

    router.push(`forumArticleDetail/${data.id}`);
};

const handleFoodTypeJump = (index) => {
    switch (index) {
        case 1:
            console.log(index);
            toChineseFood();
            break;
        case 2:
            toWesternFood();
            break;
        case 3:
            toDessert();
            break;
        case 4:
            toOthers();
            break;
        default:
            break;
    }
};

const FormData = reactive({
    keyword: '',
});

const toAllFood = () => {
    router.push(`/forum/0`);
};

const toChineseFood = () => {

    router.push(`/forum/1`);
};

const toWesternFood = () => {
    router.push(`/forum/2`);
};

const toDessert = () => {
    router.push(`/forum/3`);
};

const toOthers = () => {
    router.push(`/forum/4`);

};

// START 发布文章
const showTipTapEditor = ref(false)
// END 发布文章
</script>

<style scoped>
span {
    font-family: AlimamaShuHeiTi-Bold;
    font-weight: 2000;
}

.homeUser-page {
    background-image: url('@/assets/background.png');
    background-position: center center;
    /* 背景图片位置 */
    background-repeat: no-repeat;
    /* 背景图片是否重复 */
    background-size: 100% 100%;
    /* 背景图片大小 */
    height: 98vh;
    /* 背景图片宽高 */
    width: 99vw;
}


.header {
    position: absolute;
    width: 100%;
}

.recommendTitle {
    position: absolute;
    top: 8rem;
    left: 27rem;
    font-size: 30px;
    font-weight: 600;
    /* background-color: lightblue; */
}

.todayRecommend {
    position: absolute;
    top: 13rem;
    height: 30rem;
    width: 15rem;
    /* background-color: beige; */
}

.recommendPictureContainer {
    height: 24rem;
    width: 15rem;
    border-radius: 50px;
}

.recommendArticleTitle {
    display: flex;
    position: relative;
    font-size: 20px;
    font-weight: 400;
    top: 1rem;
    left: 0rem;
    height: 4rem;
    width: 15rem;
    /* background-color: khaki; */
}

.foodType {
    display: flex;
    position: absolute;
    left: 70rem;
    height: 6rem;
    width: 18rem;
}

.foodTypePictureContainer {
    display: flex;
    position: absolute;
    height: 4rem;
    width: 7rem;
    top: 1rem;
    left: 2rem;
    border-radius: 10px;
    /* background-color: aquamarine; */
}

.foodTypeName {
    position: absolute;
    align-items: center;
    height: 3.5rem;
    width: 5rem;
    left: 11rem;
    top: 1.5rem;
    /* background-color: aqua; */
}















.enter-forum {
    position: absolute;
    top: 85%;
    left: 77%;
}


.buttonEnterAndPost {
    height: 100%;
    width: 110%;
    background-color: black;
    color: #ffffff;
}

.button0:hover {
    opacity: 0.8;
}

.classify {
    position: absolute;
    top: 20%;
    left: 70%;
}



.button1 {
    width: 368px;
    height: 120px;
    border: none;
    background: url('@/assets/chinese_food.png');
    background-position: center;
    background-repeat: no-repeat;
    background-size: cover;
    background-color: aqua;
}

.button1:hover {
    opacity: 0.8;
}

.button-image {
    width: 250px;
    height: 100px;

}

.button2 {
    width: 368px;
    height: 120px;
    border: none;
    background: url('@/assets/western_food.png');
    background-position: center;
    background-repeat: no-repeat;
    background-size: cover;
}

.button2:hover {
    opacity: 0.8;
}

.button3 {
    width: 368px;
    height: 120px;
    border: none;
    background: url('@/assets/dessert.png');
    background-position: center;
    background-repeat: no-repeat;
    background-size: cover;
}

.button3:hover {
    opacity: 0.8;
}

.button4 {
    width: 368px;
    height: 120px;
    border: none;
    background: url('@/assets/others.png');
    background-position: center;
    background-repeat: no-repeat;
    background-size: cover;
}

.button4:hover {
    opacity: 0.8;
}


/* .ml-11 {
    margin-left: 0.69rem;
}

.ml-129 {
    margin-left: 8.06rem;
}

.mt-99 {
    margin-top: 6.19rem;
}

.ml-7 {
    margin-left: 0.44rem;
}

.mt-102 {
    margin-top: 6.38rem;
}

.page {
    background-color: #ffffff;
    background-image: url('https://ide.code.fun/api/image?token=657dd24e28456c00116a9218&name=7a1ad3e38d043e8b3934d172ab285ab1.png');
    background-size: 100% 100%;
    background-repeat: no-repeat;
    height: 100%;
    width: 100%;
    overflow-y: auto;
    overflow-x: hidden;
}

.section {
    background-color: #f6f2ec;
    width: 90rem;
    height: 64rem;
}

.section_2 {
    padding: 4.25rem 1rem 2.5rem 1.75rem;
    background-color: #fffdfd;
    border-radius: 1.25rem;
    width: 62.75rem;
}

.pos {
    position: absolute;
    left: 2.13rem;
    top: 17.94rem;
}

.group {
    margin-right: 4.75rem;
    width: 30.25rem;
}

.text {
    color: #1e1e1e;
    font-size: 2.5rem;
    font-family: Inter;
    font-weight: 600;
    line-height: 2.36rem;
}

.text-wrapper {
    margin-top: 0.75rem;
    padding: 0.75rem 0;
    background-color: #1e1e1e;
    border-radius: 625rem;
    width: 6.95rem;
    height: 2.94rem;
}

.text_2 {
    color: #ffffff;
    font-size: 1.5rem;
    font-family: Inter;
    font-weight: 600;
    line-height: 1.41rem;
}

.group_3 {
    margin-top: 1.25rem;
}

.image_5 {
    margin-top: 11.25rem;
    width: 3.13rem;
    height: 3.13rem;
}

.image_2 {
    border-radius: 1.25rem;
    width: 16.38rem;
    height: 24.56rem;
}

.image_3 {
    border-radius: 1.25rem;
    width: 16.44rem;
    height: 24.56rem;
}

.group_5 {
    margin-top: 0.88rem;
    padding: 0 4.75rem;
}

.group_6 {
    padding-left: 0.63rem;
}

.font_2 {
    font-size: 1.5rem;
    font-family: Inter;
    line-height: 1.81rem;
    font-weight: 600;
    color: #1e1e1e;
}

.text_5 {
    line-height: 1.42rem;
}

.section_3 {
    padding: 4.38rem 0.75rem;
    background-color: #ffffff;
    border-radius: 1.25rem;
    width: 17.31rem;
}

.pos_2 {
    position: absolute;
    right: 1.81rem;
    top: 17.94rem;
}

.image {
    border-radius: 1.25rem;
    width: 9.06rem;
    height: 6.06rem;
}

.image_4 {
    border-radius: 1.25rem;
    width: 9rem;
    height: 6.06rem;
}

.group_2 {
    margin-right: 0.38rem;
}

.font {
    font-size: 2.5rem;
    font-family: Itim;
    line-height: 2.3rem;
    color: #1e1e1e;
}

.image_6 {
    border-radius: 1.25rem;
    width: 9.75rem;
    height: 6.06rem;
}

.image_7 {
    border-radius: 1.25rem;
    width: 9.88rem;
    height: 6.56rem;
}

.group_4 {
    margin-right: 0.5rem;
}

.text_3 {
    line-height: 2.29rem;
}

.text_4 {
    line-height: 2.29rem;
}

/************************************************************
** 请将全局样式拷贝到项目的全局 CSS 文件或者当前页面的顶部 **
** 否则页面将无法正常显示                                  **
************************************************************/

/* html {
    font-size: 16px;
}

body {
    margin: 0;
    font-family: -apple-system, BlinkMacSystemFont, 'Segoe UI', 'Roboto', 'Oxygen', 'Ubuntu', 'Cantarell', 'Fira Sans',
        'Droid Sans', 'Helvetica Neue', 'Microsoft Yahei', sans-serif;
}

body * {
    box-sizing: border-box;
    flex-shrink: 0;
}

#app {
    width: 100vw;
    height: 100vh;
}

.flex-row {
    display: flex;
    flex-direction: row;
}

.flex-col {
    display: flex;
    flex-direction: column;
}

.justify-start {
    justify-content: flex-start;
}

.justify-end {
    justify-content: flex-end;
}

.justify-center {
    justify-content: center;
}

.justify-between {
    justify-content: space-between;
}

.justify-around {
    justify-content: space-around;
}

.justify-evenly {
    justify-content: space-evenly;
}

.items-start {
    align-items: flex-start;
}

.items-end {
    align-items: flex-end;
}

.items-center {
    align-items: center;
}

.items-baseline {
    align-items: baseline;
}

.items-stretch {
    align-items: stretch;
}

.self-start {
    align-self: flex-start;
}

.self-end {
    align-self: flex-end;
}

.self-center {
    align-self: center;
}

.self-baseline {
    align-self: baseline;
}

.self-stretch {
    align-self: stretch;
}

.flex-1 {
    flex: 1 1 0%;
}

.flex-auto {
    flex: 1 1 auto;
}

.grow {
    flex-grow: 1;
}

.grow-0 {
    flex-grow: 0;
}

.shrink {
    flex-shrink: 1;
}

.shrink-0 {
    flex-shrink: 0;
}

.relative {
    position: relative;
}

.ml-2 {
    margin-left: 0.13rem;
}

.mt-2 {
    margin-top: 0.13rem;
}

.ml-4 {
    margin-left: 0.25rem;
}

.mt-4 {
    margin-top: 0.25rem;
}

.ml-6 {
    margin-left: 0.38rem;
}

.mt-6 {
    margin-top: 0.38rem;
}

.ml-8 {
    margin-left: 0.5rem;
}

.mt-8 {
    margin-top: 0.5rem;
}

.ml-10 {
    margin-left: 0.63rem;
}

.mt-10 {
    margin-top: 0.63rem;
}

.ml-12 {
    margin-left: 0.75rem;
}

.mt-12 {
    margin-top: 0.75rem;
}

.ml-14 {
    margin-left: 0.88rem;
}

.mt-14 {
    margin-top: 0.88rem;
}

.ml-16 {
    margin-left: 1rem;
}

.mt-16 {
    margin-top: 1rem;
}

.ml-18 {
    margin-left: 1.13rem;
}

.mt-18 {
    margin-top: 1.13rem;
}

.ml-20 {
    margin-left: 1.25rem;
}

.mt-20 {
    margin-top: 1.25rem;
}

.ml-22 {
    margin-left: 1.38rem;
}

.mt-22 {
    margin-top: 1.38rem;
}

.ml-24 {
    margin-left: 1.5rem;
}

.mt-24 {
    margin-top: 1.5rem;
}

.ml-26 {
    margin-left: 1.63rem;
}

.mt-26 {
    margin-top: 1.63rem;
}

.ml-28 {
    margin-left: 1.75rem;
}

.mt-28 {
    margin-top: 1.75rem;
}

.ml-30 {
    margin-left: 1.88rem;
}

.mt-30 {
    margin-top: 1.88rem;
}

.ml-32 {
    margin-left: 2rem;
}

.mt-32 {
    margin-top: 2rem;
}

.ml-34 {
    margin-left: 2.13rem;
}

.mt-34 {
    margin-top: 2.13rem;
}

.ml-36 {
    margin-left: 2.25rem;
}

.mt-36 {
    margin-top: 2.25rem;
}

.ml-38 {
    margin-left: 2.38rem;
}

.mt-38 {
    margin-top: 2.38rem;
}

.ml-40 {
    margin-left: 2.5rem;
}

.mt-40 {
    margin-top: 2.5rem;
}

.ml-42 {
    margin-left: 2.63rem;
}

.mt-42 {
    margin-top: 2.63rem;
}

.ml-44 {
    margin-left: 2.75rem;
}

.mt-44 {
    margin-top: 2.75rem;
}

.ml-46 {
    margin-left: 2.88rem;
}

.mt-46 {
    margin-top: 2.88rem;
}

.ml-48 {
    margin-left: 3rem;
}

.mt-48 {
    margin-top: 3rem;
}

.ml-50 {
    margin-left: 3.13rem;
}

.mt-50 {
    margin-top: 3.13rem;
}

.ml-52 {
    margin-left: 3.25rem;
}

.mt-52 {
    margin-top: 3.25rem;
}

.ml-54 {
    margin-left: 3.38rem;
}

.mt-54 {
    margin-top: 3.38rem;
}

.ml-56 {
    margin-left: 3.5rem;
}

.mt-56 {
    margin-top: 3.5rem;
}

.ml-58 {
    margin-left: 3.63rem;
}

.mt-58 {
    margin-top: 3.63rem;
}

.ml-60 {
    margin-left: 3.75rem;
}

.mt-60 {
    margin-top: 3.75rem;
}

.ml-62 {
    margin-left: 3.88rem;
}

.mt-62 {
    margin-top: 3.88rem;
}

.ml-64 {
    margin-left: 4rem;
}

.mt-64 {
    margin-top: 4rem;
}

.ml-66 {
    margin-left: 4.13rem;
}

.mt-66 {
    margin-top: 4.13rem;
}

.ml-68 {
    margin-left: 4.25rem;
}

.mt-68 {
    margin-top: 4.25rem;
}

.ml-70 {
    margin-left: 4.38rem;
}

.mt-70 {
    margin-top: 4.38rem;
}

.ml-72 {
    margin-left: 4.5rem;
}

.mt-72 {
    margin-top: 4.5rem;
}

.ml-74 {
    margin-left: 4.63rem;
}

.mt-74 {
    margin-top: 4.63rem;
}

.ml-76 {
    margin-left: 4.75rem;
}

.mt-76 {
    margin-top: 4.75rem;
}

.ml-78 {
    margin-left: 4.88rem;
}

.mt-78 {
    margin-top: 4.88rem;
}

.ml-80 {
    margin-left: 5rem;
}

.mt-80 {
    margin-top: 5rem;
}

.ml-82 {
    margin-left: 5.13rem;
}

.mt-82 {
    margin-top: 5.13rem;
}

.ml-84 {
    margin-left: 5.25rem;
}

.mt-84 {
    margin-top: 5.25rem;
}

.ml-86 {
    margin-left: 5.38rem;
}

.mt-86 {
    margin-top: 5.38rem;
}

.ml-88 {
    margin-left: 5.5rem;
}

.mt-88 {
    margin-top: 5.5rem;
}

.ml-90 {
    margin-left: 5.63rem;
}

.mt-90 {
    margin-top: 5.63rem;
}

.ml-92 {
    margin-left: 5.75rem;
}

.mt-92 {
    margin-top: 5.75rem;
}

.ml-94 {
    margin-left: 5.88rem;
}

.mt-94 {
    margin-top: 5.88rem;
}

.ml-96 {
    margin-left: 6rem;
}

.mt-96 {
    margin-top: 6rem;
}

.ml-98 {
    margin-left: 6.13rem;
}

.mt-98 {
    margin-top: 6.13rem;
}

.ml-100 {
    margin-left: 6.25rem;
}

.mt-100 {
    margin-top: 6.25rem;
}  */
</style>