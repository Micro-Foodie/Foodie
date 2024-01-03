
<template>
<div class="flex-col justify-start relative page">
  <div class="section"></div>
  <div class="flex-col section_2 pos">
    <div class="flex-row justify-between items-start self-end group">
      <span class="text">推荐菜谱</span> 
      <button class="text_2" @click="handleMoreClick">更多</button>
    </div>
    <div class="flex-row justify-between self-stretch group_3">
      <!-- 替换图片为按钮 -->
      <button class="self-start image_5" @click="handleButtonClick('button1')"><!-- 按钮内容或占位符 --></button>
      <button class="image_2" @click="handleButtonClick('button2')"><!-- 按钮内容或占位符 --></button>
      <button class="image_3" @click="handleButtonClick('button3')"><!-- 按钮内容或占位符 --></button>
      <button class="image_3" @click="handleButtonClick('button4')"><!-- 按钮内容或占位符 --></button>
      <button class="self-start image_5" @click="handleButtonClick('button5')"><!-- 按钮内容或占位符 --></button>
    </div>
    <div class="flex-col self-stretch group_5">
      <div class="flex-row justify-center items-center group_6">
        <span class="font_2">【莓莓酸奶】不用用刀！</span>
        <span class="font_2 ml-11">【寿司】一口一个寿司！</span>
        <span class="font_2 text_5 ml-11">【塔克】简单又健康！</span>
      </div>
      <div class="flex-row">
        <span class="font_2">做法很简单！</span>
        <span class="font_2 ml-129">超可爱</span>
      </div>
    </div>
  </div>
  <div class="flex-col section_3 pos_2">
    <div class="flex-row items-center">
      <div class="flex-col items-center flex-1">
        <!-- 替换图片为按钮 -->
        <button class="image" @click="handleButtonClick('button6')"><!-- 按钮内容或占位符 --></button>
        <button class="mt-38 image_4" @click="handleButtonClick('button7')"><!-- 按钮内容或占位符 --></button>
      </div>
      <div class="ml-20 flex-col items-center shrink-0 group_2">
        <span class="font">中餐</span>
        <span class="font mt-99">西餐</span>
      </div>
    </div>
    <div class="mt-38 flex-row items-center">
      <div class="flex-col items-center flex-1">
        <!-- 替换图片为按钮 -->
        <button class="image_6" @click="handleButtonClick('button8')"><!-- 按钮内容或占位符 --></button>
        <button class="mt-38 image_7" @click="handleButtonClick('button9')"><!-- 按钮内容或占位符 --></button>
      </div>
      <div class="flex-col items-center shrink-0 group_4 ml-7">
        <span class="font text_3">甜品</span>
        <span class="font text_4 mt-102">其他</span>
      </div>
    </div>
  </div>
</div>

</template>

<script>

export default {
  methods: {
    handleMoreClick() {
      // 处理“更多”按钮点击事件的方法
      console.log('“更多”按钮被点击了！');
      // 在这里添加具体的处理逻辑，比如发送请求或者改变页面状态等
    },
    handleButtonClick(buttonId) {
      // 处理其他按钮点击事件的方法
      console.log(`按钮 ${buttonId} 被点击了！`);
      // 根据不同的按钮 ID 执行不同的操作
      if (buttonId === 'button1') {
        // 按钮 1 的处理逻辑
      } else if (buttonId === 'button2') {
        // 按钮 2 的处理逻辑
      }
      // 可以根据具体情况进行逻辑处理
    }
  }
}

</script>

<style>
.ml-11 {
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

html {
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
}
</style>


