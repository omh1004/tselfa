<script>
export default {
name: "loading.vue"
}
</script>

<template>
  <div id="wrap" class="full-pop-que">
    <div class="full-pop-wrap">
      <div class="pop-header">
        <!-- <ul class="title">
          <li>STEP 1 단원선택</li>
          <li>STEP 2 문항편집</li>
          <li class="active">STEP 3 시험지 저장</li>
        </ul>
        <button type="button" class="del-btn"></button> -->
      </div>
      <div class="pop-content">
        <div class="loading-cnt">
          <img src="../../assets/image/loading_icon.gif" alt="로딩중">
          <div class="txt-box">
            <span class="tit">LOADING<br>잠시만 기다려주세요.</span>
            <span class="txt">이 화면이 지속되면 페이지를 <em>새로고침</em> 해 주세요.</span>
          </div>
        </div>
      </div>
    </div>
    <div class="dim"></div>
  </div>
</template>

<style scoped>
@import 'https://cdn.jsdelivr.net/npm/swiper@8/swiper-bundle.min.css';
@import 'https://code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css';
@import '../../assets/css/font.css';
@import '../../assets/css/reset.css';
@import '../../assets/css/common.css';

</style>