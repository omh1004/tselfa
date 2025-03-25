<script>
export default {
  name: "sub04_02.vue"
}
</script>

<template>
  <div id="wrap" class="full-pop-que">
    <div class="full-pop-wrap">
      <div class="pop-header">
        <ul class="title">
          <li>STEP 1 단원선택</li>
          <li>STEP 2 문항 편집</li>
          <li class="active">STEP 3 시험지 저장</li>
        </ul>
        <button type="button" class="del-btn"></button>
      </div>
      <div class="pop-content">
        <div class="view-box save-complete">
          <div class="btn-wrap">
            <button class="btn-default"><a href="javascript:;">처음으로</a></button>
          </div>

          <div class="save-wrap">
            <img src="../../assets/image/save.png" alt="저장완료 이미지">
            <span class="txt">
							시험지가 저장되었습니다.
							<p>저장된 시험지는 시험지 보관함 메뉴에서 확인 가능합니다. </p>
						</span>
            <div class="btn-wrap">
              <button class="btn-icon">시험지 보관함으로 이동</button>
            </div>
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