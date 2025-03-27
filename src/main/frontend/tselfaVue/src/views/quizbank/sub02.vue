<script>
import { common } from '../../assets/js/common.js'

export default {
  name: "sub02.vue",
  data(){
    return{
      chapterList:[],
      sortedChapterNameList:{},
      quizNum:30,
      lowest:0,
      low:0,
      middle:0,
      high:0,
      highest:0,
      quizsum:20,
      addEvent:false,
      activeList:{
        teaactive:false,
        stuactive:false,
        dataactive:false,
        underactive:false,
        applyactive:false,
        knowactive:false,
        concactive:false,
        objectiveactive:false,
        subjectiveactive:false,
        lowestactive:false,
        lowactive:false,
        middleactive:false,
        highactive:false,
        highestactive:false,
      },
    }
  },
  methods:{
    // jquery가 많이 들어있어 일단 보류
    jquery() {
      const vm = this;
      $(function () {
        // depth
        let depBtn = $('.dep-btn');

        function depFunc() {
          let _this = $(this);

          if (!_this.hasClass('active')) {
            _this.addClass('active');
            _this.parents('.check-group').next('div').stop().slideUp('fast');

          } else {
            _this.removeClass('active');
            _this.parents('.check-group').next('div').stop().slideDown('fast');
          }

          _this.parents('.check-group').toggleClass('on');
        }

        depBtn.on('click', depFunc);


        // que-checkbox
        let queChkAll = $('.que-allCheck');

        function queCheckFunc() {
          let _this = $(this);

          let checkedbox = $('.unit-cnt>ul').find('input[type=checkbox]:checked');

          if(checkedbox.length<=1){
            vm.activeList.teaactive=true;
            vm.activeList.stuactive=true;
            vm.activeList.dataactive=true;
            vm.activeList.underactive=true;
            vm.activeList.applyactive=true;
            vm.activeList.knowactive=true;
            vm.activeList.concactive=true;
            vm.activeList.objectiveactive=true;
            vm.activeList.subjectiveactive=true;
            vm.activeList.lowestactive=true;
            vm.activeList.lowactive=true;
            vm.activeList.middleactive=true;
            vm.activeList.highactive=true;
            vm.activeList.highestactive=true;
            $(".range-wrap .range").show();
          }

          if (_this.prop('checked')) {
            _this.parents().next('ul').find('input[type=checkbox]').prop('checked', true);
          } else {
            _this.parents().next('ul').find('input[type=checkbox]').prop('checked', false);
          }

          if (_this.prop('checked') && _this.hasClass('depth01')) {
            _this.parents('.check-group').next('div').find('input[type=checkbox]').prop('checked', true);
          } else {
            _this.parents('.check-group').next('div').find('input[type=checkbox]').prop('checked', false);
          }

          if (_this.prop('checked')) {
            _this.parents('table').find('input[type=checkbox]').prop('checked', true);
          } else {
            _this.parents('table').find('input[type=checkbox]').prop('checked', false);
          }

          checkedbox = $('.unit-cnt>ul').find('input[type=checkbox]:checked');

          if(checkedbox.length<=1){
            vm.activeList.teaactive=false;
            vm.activeList.stuactive=false;
            vm.activeList.dataactive=false;
            vm.activeList.underactive=false;
            vm.activeList.applyactive=false;
            vm.activeList.knowactive=false;
            vm.activeList.concactive=false;
            vm.activeList.objectiveactive=false;
            vm.activeList.subjectiveactive=false;
            vm.activeList.lowestactive=false;
            vm.activeList.lowactive=false;
            vm.activeList.middleactive=false;
            vm.activeList.highactive=false;
            vm.activeList.highestactive=false;
            $(".range-wrap .range").hide();
            $(".range-wrap .range.total").show();
          }
        }

        queChkAll.on('click', queCheckFunc);


        // $(".type-box .box .range").hide();
        $(".pop-content .range-wrap .range").hide();
        $(".pop-content .range-wrap .range.total").show();
        let stepBtn = $('.step-wrap .btn-line');

        function stepFunc() {
          let _this = $(this);
          let stepData = _this.data('step');

          _this.toggleClass('active');

          if (_this.hasClass('active')) {
            $(".range[data-step='" + stepData + "']").show();
          } else {
            $(".range[data-step='" + stepData + "']").hide();
          }

        }

        stepBtn.on('click', stepFunc);
      })
    },
    getChapter(){
      fetch('http://localhost:8080/api/chapterlist')
          .then(response=>response.json())
          .then(data=>{
            this.chapterList = data.chapterList;
            console.log(data);
            console.log(this.chapterList);
            this.sortChapter();
          });
    },
    sortChapter(){
      this.chapterList.forEach(c=>{
        const largeKey = Object.keys(this.sortedChapterNameList);
        const largeChap = largeKey!=null?largeKey.find(lk => lk == c.largeChapterName):null;
        if(largeChap!=null){
          const mediumKey = Object.keys(this.sortedChapterNameList[largeChap]);
          const mediumChap = mediumKey!=null?mediumKey.find(mk => mk == c.mediumChapterName):null;
          if(mediumChap!=null){
            const smallKey = Object.keys(this.sortedChapterNameList[largeChap][mediumChap]);
            const smallChap = smallKey!=null?smallKey.find(sk => sk == c.smallChapterName):null;
            if(smallChap!=null){
              this.sortedChapterNameList[c.largeChapterName][c.mediumChapterName][c.smallChapterName].push(c.topicChapterName);
            }
            else{
              this.sortedChapterNameList[c.largeChapterName][c.mediumChapterName][c.smallChapterName] = [];
              this.sortedChapterNameList[c.largeChapterName][c.mediumChapterName][c.smallChapterName].push(c.topicChapterName);
            }
          }
          else{
            this.sortedChapterNameList[c.largeChapterName][c.mediumChapterName] = {};
            this.sortedChapterNameList[c.largeChapterName][c.mediumChapterName][c.smallChapterName] = [];
            this.sortedChapterNameList[c.largeChapterName][c.mediumChapterName][c.smallChapterName].push(c.topicChapterName);
          }
        }else{
          this.sortedChapterNameList[c.largeChapterName] = {};
          this.sortedChapterNameList[c.largeChapterName][c.mediumChapterName] = {};
          this.sortedChapterNameList[c.largeChapterName][c.mediumChapterName][c.smallChapterName] = [];
          this.sortedChapterNameList[c.largeChapterName][c.mediumChapterName][c.smallChapterName].push(c.topicChapterName);
        }
      })
      console.log(this.sortedChapterNameList);
    },
    quizNumSet(){
      const inputsum = this.lowest+this.low+this.middle+this.high+this.highest;

      if(this.quizsum==inputsum){
        // 이건 나중에 생각해볼게
      }
    },
    editQuiz(){
      $(".depth04 input[type=checkbox]:checked").next("label").children("span").toArray().forEach(span=>{
        const getTopic = this.chapterList.find(chapter=>chapter.topicChapterName==span.innerText);
        console.log(getTopic);
        // fetch 써야 함? 기능 만들기 귀찮은데
        // 개발중 사용금지
        // fetch('http://localhost:8080/api/itemlist')
        //     .then(response=>response.json())
        //     .then(data=>console.log(data));
      });
    },
  },
  mounted(){
    this.getChapter();
    common();
  },
  updated(){
    if(!this.addEvent){
      this.$nextTick(() => {
        this.jquery();
      })
      this.addEvent=true;
    }
  }
}

</script>

<template>
  <div id="wrap" class="full-pop-que">
    <div class="full-pop-wrap">
      <div class="pop-header">
        <ul class="title">
          <li class="active">STEP 1 단원선택</li>
          <li>STEP 2 문항 편집</li>
          <li>STEP 3 시험지 저장</li>
        </ul>
        <button type="button" class="del-btn"></button>
      </div>
      <div class="pop-content">
        <div class="view-box">
          <div class="view-top">
            <div class="paper-info">
              <span>국어 1-1</span>
              노미숙(2015)
              <p v-if="chapterList.length>0">{{ chapterList[0].subjectName }}</p>
            </div>
          </div>
          <div class="view-bottom">
            <div class="view-box-wrap">
              <div class="unit-box-wrap">
                <div class="unit-box">
                  <div class="unit-cnt scroll-inner">
                    <div class="title-top">
                      <span>단원정보</span>
                      <input type="checkbox" id="chk01_00" class="allCheck">
                      <label for="chk01_00">전체선택</label>
                    </div>
                    <ul>
                      <li v-for="(large, lindex) in Object.keys(sortedChapterNameList)">
                        <div class="check-group title">
                          <div class="title-chk">
                            <input type="checkbox" :id="'chk'+lindex" class="que-allCheck depth01">
                            <label :for="'chk'+lindex">
                              <button type="button" class="dep-btn active">{{ large }}</button>
                            </label>
                          </div>
                        </div>
                        <div class="depth02">
                          <template v-for="(medium, mindex) in Object.keys(sortedChapterNameList[large])">
                            <div class="check-group">
                              <input type="checkbox" :id="'chk'+lindex+'_'+mindex" class="que-allCheck depth01">
                              <label :for="'chk'+lindex+'_'+mindex">
                                <button type="button" class="dep-btn active">{{ medium }}</button>
                              </label>
                            </div>
                            <div class="depth03">
                              <template v-for="(small, sindex) in Object.keys(sortedChapterNameList[large][medium])">
                                <div class="check-group">
                                  <input type="checkbox" :id="'chk'+lindex+'_'+mindex+'_'+sindex" class="que-allCheck depth01">
                                  <label :for="'chk'+lindex+'_'+mindex+'_'+sindex">
                                    <button type="button" class="dep-btn active">{{ small }}</button>
                                  </label>
                                </div>
                                <div class="depth04">
                                  <template v-for="(topic, tindex) in sortedChapterNameList[large][medium][small]">
                                    <div class="check-group">
                                      <input type="checkbox" :id="'chk'+lindex+'_'+mindex+'_'+sindex+'_'+tindex">
                                      <label :for="'chk'+lindex+'_'+mindex+'_'+sindex+'_'+tindex">
                                        <span>{{ topic }}</span>
                                      </label>
                                    </div>
                                  </template>
                                </div>
                              </template>
                            </div>
                          </template>
                        </div>
                      </li>
                    </ul>
                  </div>
                </div>
              </div>
              <div class="type-box-wrap">
                <div class="type-box scroll-inner">
                  <div class="title-top">
                    <span>출제옵션</span>
                  </div>
                  <div class="box">
                    <div class="title-wrap">
                      <span class="tit-text">문제 수<em>최대 30문제</em></span>
                    </div>
                    <div class="count-area">
                      <div class="btn-wrap">
                        <button type="button" class="btn-line" @click="quizNum=$event.target.innerText">10</button>
                        <button type="button" class="btn-line" @click="quizNum=$event.target.innerText">15</button>
                        <button type="button" class="btn-line" @click="quizNum=$event.target.innerText">20</button>
                        <button type="button" class="btn-line" @click="quizNum=$event.target.innerText">25</button>
                        <button type="button" class="btn-line active" @click="quizNum=$event.target.innerText">30</button>
                      </div>
                      <div class="input-area">
                        <span class="num">총 <input type="text" v-model.number="quizNum"> 문제</span>
                        <div class="txt">*5의 배수로 입력해주세요. </div>
                      </div>

                    </div>
                  </div>
                  <div class="box">
                    <div class="title-wrap">
                      <span class="tit-text">출처</span>
                      <div class="right-area">
                      </div>
                    </div>
                    <div class="btn-wrap multi">
                      <button type="button" class="btn-line" :class="{active:activeList.teaactive}">교사용(교사용 DVD, 지도서, 신규 개발 등)</button>
                      <button type="button" class="btn-line" :class="{active:activeList.stuactive}">학생용(자습서, 평가문제집 등)</button>
                    </div>
                  </div>
                  <div class="box">
                    <div class="title-wrap">
                      <span class="tit-text">평가 영역</span>
                      <div class="right-area">
                      </div>
                    </div>
                    <div class="btn-wrap multi">
                      <button type="button" class="btn-line" :class="{active:activeList.dataactive}">자료 해석</button>
                      <button type="button" class="btn-line" :class="{active:activeList.underactive}">이해</button>
                      <button type="button" class="btn-line" :class="{active:activeList.applyactive}">적용</button>
                    </div>
                    <div class="btn-wrap multi">
                      <button type="button" class="btn-line" :class="{active:activeList.knowactive}">지식</button>
                      <button type="button" class="btn-line" :class="{active:activeList.concactive}">결론도출</button>
                    </div>
                  </div>
                  <div class="box">
                    <div class="title-wrap">
                      <span class="tit-text">문제 형태</span>
                      <div class="right-area">
                      </div>
                    </div>
                    <div class="btn-wrap multi">
                      <button type="button" class="btn-line" :class="{active:activeList.objectiveactive}">객관식</button>
                      <button type="button" class="btn-line" :class="{active:activeList.subjectiveactive}">주관식</button>
                    </div>
                  </div>
                  <div class="box">
                    <div class="title-wrap">
                      <span class="tit-text">난이도 구성</span>
                    </div>
                    <div class="step-wrap">
                      <button type="button" class="btn-line type02 color01" data-step="stap1" :class="{active:activeList.lowestactive}">최하</button>
                      <button type="button" class="btn-line type02 color02" data-step="stap2" :class="{active:activeList.lowactive}">하</button>
                      <button type="button" class="btn-line type02 color03" data-step="stap3" :class="{active:activeList.middleactive}">중</button>
                      <button type="button" class="btn-line type02 color04" data-step="stap4" :class="{active:activeList.highactive}">상</button>
                      <button type="button" class="btn-line type02 color05" data-step="stap5" :class="{active:activeList.highestactive}">최상</button>
                    </div>
                  </div>
                  <div class="box">
                    <div class="title-wrap">
											<span class="tit-text">난이도별 문제 수
												<button type="button" class="btn-icon2 pop-btn" data-pop="que-range-pop"><i
                            class="setting"></i></button>
											</span>
                    </div>
                    <div class="range-wrap">
                      <span class="range color01" data-step="stap1">최하(n)</span>
                      <span class="range color02" data-step="stap2">하(n)</span>
                      <span class="range color03" data-step="stap3">중(n)</span>
                      <span class="range color04" data-step="stap4">상(n)</span>
                      <span class="range color05" data-step="stap5">최상(n)</span>
                    </div>
                  </div>

                </div>
                <div class="bottom-box">
                  <p class="total-num">총 <span>30</span>문제</p>
                </div>
              </div>
            </div>
          </div>
        </div>

      </div>
      <div class="step-btn-wrap">
        <button type="button" class="btn-step" @click="$router.push('/sub01')">출제 방법 선택</button>
        <button type="button" class="btn-step next pop-btn" data-pop="que-pop" @click="editQuiz">STEP2 문항 편집</button><!-- 230629 pop-btn 추가-->
      </div>


    </div>
    <div class="dim"></div>

    <!-- 난이도 문제 수 설정 팝업 -->
    <div class="pop-wrap range-type" data-pop="que-range-pop">
      <div class="pop-inner">
        <div class="pop-header">
          <span>난이도별 문제 수 설정</span>
          <button type="button" class="pop-close"></button>
        </div>
        <div class="pop-content">
          <span class="txt">문제 수를 입력하여<br> 난이도별 문제 수를 조정하세요.</span>
          <div class="range-wrap">
            <!-- S: 문제 수 맞지 않을 시 .fail 클래스 추가 -->
            <div class="range color01 fail" data-step="stap1">
              <span class="color01">최하</span>
              <input type="number" v-model.number="lowest">
            </div>
            <div class="range color02" data-step="stap2">
              <span class="color02">하</span>
              <input type="number" v-model.number="low">
            </div>
            <div class="range color03" data-step="stap3">
              <span class="color03">중</span>
              <input type="number" v-model.number="middle">
            </div>
            <div class="range color04" data-step="stap4">
              <span class="color04">상</span>
              <input type="number" v-model.number="high">
            </div>
            <div class="range color05" data-step="stap5">
              <span class="color05">최상</span>
              <input type="number" v-model.number="highest">
            </div>
            <div class="range total fail">
              <span>합계</span>
              <span class="num">{{ quizsum }}</span>
            </div>
            <!-- E: 문제 수 맞지 않을 시 .fail 클래스 추가 -->
          </div>
        </div>
        <div class="pop-footer">
          <button>초기화</button>
          <button class="disabled">저장</button>
        </div>
      </div>
    </div>

    <!-- 문항 충족하지 않을 시 노출 팝업 -->
    <div class="pop-wrap range-type02" data-pop="que-pop">
      <div class="pop-inner">
        <div class="pop-header">
          <span>문항 구성 자동 변경</span>
          <button type="button" class="pop-close"></button>
        </div>
        <div class="pop-content">
          <span class="txt">사용자가 원하는 문항 구성을 할 수 없어<br>문항 구성이 자동으로 변경되었습니다.</span>
          <div class="range-wrap">
            <div class="range" data-step="stap1">
              <span class="color01">최하</span>
              <span class="num">2</span>
            </div>
            <div class="range" data-step="stap2">
              <span class="color02">하</span>
              <span class="num">5</span>
            </div>
            <div class="range" data-step="stap3">
              <span class="color03">중</span>
              <span class="num">6</span>
            </div>
            <div class="range" data-step="stap4">
              <span class="color04">상</span>
              <span class="num">5</span>
            </div>
            <div class="range" data-step="stap5">
              <span class="color05">최상</span>
              <span class="num">2</span>
            </div>
            <div class="range total">
              <span>합계</span>
              <span class="num">20</span>
            </div>
          </div>
          <span class="txt">해당 문제 구성으로 출제하시겠습니까?</span>
        </div>
        <div class="pop-footer">
          <button>취소</button>
          <button class="pop-close">확인</button>
        </div>
      </div>
    </div>
  </div>
</template>

<style scoped>
@import 'https://cdn.jsdelivr.net/npm/swiper@8/swiper-bundle.min.css';
@import 'https://code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css';
@import '../../assets/css/font.css';
@import '../../assets/css/reset.css';
@import '../../assets/css/common.css';

</style>