<script>
export default {
  name: "error.vue"
}
</script>

<template>
  <div id="wrap" class="full-pop-que">
    <div class="full-pop-wrap">
      <div class="pop-header">
        <!-- <ul class="title">
          <li>STEP 1 단원선택</li>
          <li>STEP 2 문항 편집</li>
          <li class="active">STEP 3 시험지 저장</li>
        </ul>
        <button type="button" class="del-btn"></button> -->
      </div>
      <div class="pop-content">
        <div class="error-cnt">
          <img src="../../assets/image/error.png" alt="에러">
          <div class="txt-box">
            <span class="tit">요청하신 페이지를 찾을 수 없습니다</span>
            <span class="txt">요청하신 페이지를 처리하는 도중 예기치 못한 에러가 발생했습니다. <br>잠시 후 다시 시도해주세요.</span>
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