<!-- 此处为举报帖子的举报界面 -->
<!-- 我在想举报部分做个弹窗不做界面了 -->
<template>
    <div>
        <div class="announcement-page">
            <div id="header">
                <navTop></navTop>
            </div>
            <!-- 按钮 -->
            <div class="announ-button" :class="navBarFixed == true ? 'navBarWrap' : ''">
                <!-- 返回按钮 -->
                <el-form-item>
                    <el-button type="primary" class="announ-back-button" @click="ReturnAnnoun">
                        <span class="iconfont icon-Back"></span>
                        <span>返回</span>
                    </el-button>
                </el-form-item>
                <!-- 发布按钮 -->
                <el-form-item>
                    <el-button type="primary" class="announ-publish-button" @click="Publish">
                        <span class="iconfont icon-publish"></span>
                        <span>提交</span>
                    </el-button>
                </el-form-item>
            </div>
            <!-- 展示举报页 -->
            <div class="announ-announcement-form">
                <span class="announ-announcement-title-word">举报原因</span>
                <div class="announ-announcement-title">
                </div>
                <span class="announ-announcement-content-word">详细说明</span>
                <div class="announ-announcement-content">
                </div>
            </div>
        </div>
    </div>
</template>

<script setup>
import { ref, reactive } from 'vue';
import router from "@/router/index.js"
import navTop from "@/components/navTop.vue"


const formData = reactive({
    keywords: '',
});


const doHome = () => {
    //返回用户主页
    router.push({ name: 'homeUser' })
};

const doUser = () => {
    //返回用户个人信息页
    router.push({ name: 'userHomePage' })
};

const doLogOut = () => {
    //登出
    router.push({ name: 'login' })
};


const ReturnAnnoun = () => {
    //这里进行返回帖子详情操作
    //这里还不确定，因为每个帖子举报的回退要退回对应帖子
    router.push({ name: 'announcementDetail' })
};


</script>

<style scoped>

#header {
    /* 如果调整height，记得去 @/components/navTop.vue 中调整 header-content 样式 */
    height: 10vh;
    width: 100vw;
    box-shadow: 0 2px 6px 0 #ddd;
}
.announcement-page {
    background-image: url('@/assets/report.png');
    background-position: center;
    background-repeat: no-repeat;
    background-size: cover;
    height: 98vh;
    width: 99vw;
}

.announ-head-form {
    position: sticky;
    top: 5%;
    left: 35%;
    /*transform: translate(-50%, -50%);*/
    height: 10%;
    width: 50%;
}




.homepageIcon {
    position: absolute;
    left: 73%;
    top: 70px;
    font-size: 33px;
    color: rgb(55, 192, 255)
}

.homepageIcon:hover {
    opacity: 0.8;
}

.userpageIcon {
    position: absolute;
    left: 78%;
    top: 70px;
    font-size: 33px;
    color: rgb(55, 192, 255)
}

.userpageIcon:hover {
    opacity: 0.8;
}


/* 顶部导航按钮-退出登录 */
.forum-logout-button {
    /*登出按钮相关设置 */
    position: absolute;
    top: 59px;
    left: 1230px;
    height: 33px;
    width: 70px;
    background: #08664B;
    border-color: black;
    border-radius: 14px;
    box-shadow: 0px 4px 4px 0px gray;
}

.announ-button {
    position: sticky;
    top: 800px;
    left: 90%;
    width: 30%;
}

/* 返回按钮 */
.announ-back-button {
    position: sticky;
    top: 70px;
    left: 91%;
    height: 69%;
    background: #08664B;
}

/* 发布按钮 */
.announ-publish-button {
    position: sticky;
    top: 70px;
    left: 91%;
    height: 69%;
    background: #08664B;
}


/* 该版式为公告版式 */
.announ-announcement-form {
    position: absolute;
    top: 230px;
    left: 50px;
    height: 400px;
    width: 1200px;
    border-radius: 12px;
    background-color: #ccd1cf;
}

.announ-announcement-title {
    position: absolute;
    top: 28px;
    left: 80px;
    height: 55px;
    width: 1040px;
    border-radius: 12px;
    background-color: white;
}

.announ-announcement-title-word {
    position: absolute;
    top: 40px;
    left: 10px;
}

.announ-announcement-content {
    position: absolute;
    top: 120px;
    left: 80px;
    height: 245px;
    width: 1040px;
    border-radius: 12px;
    background-color: white;
}

.announ-announcement-content-word {
    position: absolute;
    top: 130px;
    left: 10px;
}
</style>