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
        <div id="container">
            <div id="header">
                <navTop></navTop>
            </div>
            <div id="choice-buttons">
                <el-form :inline="true" class="form-container">
                    <template v-for="(button, index) in buttonStyle" :key="index">
                        <el-form-item>
                            <el-button @click="handleButtonClick(index)" :class="`button button${index}`">
                                {{ button.name }}
                            </el-button>
                        </el-form-item>
                    </template>
                </el-form>
            </div>
            <div id="content_wrapper">
                <router-view></router-view>
            </div>
        </div>
        <div>
            <el-affix position="top" :offset="700" class="mainaffix">
                <el-button
                    :icon="House"
                    type="primary"
                    
                    class="add-new-button"
                    :disabled="currentPath"
                    @click="showTipTapEditor = true"
                    round>
                <span>发布文章</span>
                    <span class="iconfont icon-icon-add"></span>
                    
                </el-button>
            </el-affix>
        </div>
    </div>
</template>

<script setup>
import { ref, reactive,computed } from 'vue';
import router from "@/router/index.js"
import navTop from "@/components/navTop.vue"

const pBoardId = ref(0);  // 默认为 0，即全部板块

const buttonStyle = [
    { name: "全部", hoverOpacity: 0.8 },
    { name: "中餐", hoverOpacity: 0.8 },
    { name: "西餐", hoverOpacity: 0.8 },
    { name: "甜点", hoverOpacity: 0.8 },
    { name: "其他", hoverOpacity: 0.8 }
];

// 点击本页面上的按钮，跳转到相应的板块
const handleButtonClick = (p_board_id) => {
    router.push(`/forum/${p_board_id}`); // 根据 pBoardId 跳转到对应的子板块页面
    pBoardId.value = p_board_id;  // 更新 pBoardId
};

// START 发布文章
const showTipTapEditor = ref(false)
// END 发布文章
const currentPath = computed(() => {
  // 取出当前路由相对值的方法
  return router.currentRoute.value.path === "/";  
});
</script>

<style>
#container {
    height: 100vh;
    width: 100vw;
}

#header {
    /* 如果调整height，记得去 @/components/navTop.vue 中调整 header-content 样式 */
    height: 10vh;
    width: 100vw;
    box-shadow: 0 2px 6px 0 #ddd;
}

#choice-buttons {
    height: auto;
    width: 100vw;
    margin-top: 2vh;
    margin-bottom: 2vh;
}

.form-container {
    display: flex;
    justify-content: center;
    align-items: center;
}

.button {
    width: 240px;
    height: 70px;
    border: none;
    background-position: 20%;
    background-repeat: no-repeat;
    background-size: cover;
}

.button:hover {
    opacity: 0.8;
}

#content_warpper {
    width: 100vw;
    height: 80vh;

}

.button0 {
    background: url('@/assets/forum-classify/all.png');
}

.button1 {
    background: url('@/assets/forum-classify/chinesefood.png');
}

.button2 {
    background: url('@/assets/forum-classify/westernfood.png');
}

.button3 {
    background: url('@/assets/forum-classify/dessert.png');
}

.button4 {
    background: url('@/assets/forum-classify/others.png');
}
.announ-add-new {
    position: sticky;
}


.add-new-button {
    height:100%;
    width:120%;
    background: #000000;
}
.mainaffix {
  position: absolute;
  left: 1200px;
  top: 700px;
}
</style>