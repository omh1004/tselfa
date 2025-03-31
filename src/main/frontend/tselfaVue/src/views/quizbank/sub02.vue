<script>
import { common } from '../../assets/js/common.js'

export default {
  name: "sub02.vue",
  data(){
    return{
      chapterList:[],
      sortedChapterNameList:{},
      evaluationList:[],
      allChecked:false,
      allDisabled:true,
      quizNum:'',
      lowest:0,
      low:0,
      middle:0,
      high:0,
      highest:0,
      lowestinp:0,
      lowinp:0,
      middleinp:0,
      highinp:0,
      highestinp:0,
      quizsum:0,
      addEvent:true,
      activeList:{
        teaactive:false,
        stuactive:false,
        eval1active:false,
        eval2active:false,
        eval3active:false,
        eval4active:false,
        eval5active:false,
        eval6active:false,
        objectiveactive:false,
        subjectiveactive:false,
        quiz10:false,
        quiz15:false,
        quiz20:false,
        quiz25:false,
        quiz30:false,
        stepActive:{
          lowestactive:false,
          lowactive:false,
          middleactive:false,
          highactive:false,
          highestactive:false,
        },
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
            console.log("작동하면 외쳐!");
          } else {
            _this.removeClass('active');
            _this.parents('.check-group').next('div').stop().slideDown('fast');
            console.log("작동하면 외치라고!");
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
            vm.allDisabled=false;
            vm.activeList.teaactive=true;
            vm.activeList.stuactive=true;
            vm.activeList.eval1active=true;
            vm.activeList.eval2active=true;
            vm.activeList.eval3active=true;
            vm.activeList.eval4active=true;
            vm.activeList.eval5active=true;
            vm.activeList.eval6active=true;
            vm.activeList.objectiveactive=true;
            vm.activeList.subjectiveactive=true;
            vm.activeList.quiz30=true;
            vm.quizNum=30;
            vm.activeList.stepActive.lowestactive=true;
            vm.activeList.stepActive.lowactive=true;
            vm.activeList.stepActive.middleactive=true;
            vm.activeList.stepActive.highactive=true;
            vm.activeList.stepActive.highestactive=true;
            $(".range-wrap .range").show();
            vm.stepNumChange();
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
            vm.allChecked=false;
            vm.allDisabled=true;
            vm.activeList.teaactive=false;
            vm.activeList.stuactive=false;
            vm.activeList.eval1active=false;
            vm.activeList.eval2active=false;
            vm.activeList.eval3active=false;
            vm.activeList.eval4active=false;
            vm.activeList.eval5active=false;
            vm.activeList.eval6active=false;
            vm.activeList.objectiveactive=false;
            vm.activeList.subjectiveactive=false;
            vm.activeList.quiz10=false;
            vm.activeList.quiz15=false;
            vm.activeList.quiz20=false;
            vm.activeList.quiz25=false;
            vm.activeList.quiz30=false;
            vm.quizNum='';
            vm.activeList.stepActive.lowestactive=false;
            vm.activeList.stepActive.lowactive=false;
            vm.activeList.stepActive.middleactive=false;
            vm.activeList.stepActive.highactive=false;
            vm.activeList.stepActive.highestactive=false;
            $(".btn-wrap .btn-line").removeClass('active');
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

          if(_this.text()=='최하') vm.activeList.stepActive.lowestactive=!vm.activeList.stepActive.lowestactive;
          else if(_this.text()=='하') vm.activeList.stepActive.lowactive=!vm.activeList.stepActive.lowactive;
          else if(_this.text()=='중') vm.activeList.stepActive.middleactive=!vm.activeList.stepActive.middleactive;
          else if(_this.text()=='상') vm.activeList.stepActive.highactive=!vm.activeList.stepActive.highactive;
          else if(_this.text()=='최상') vm.activeList.stepActive.highestactive=!vm.activeList.stepActive.highestactive;

          vm.stepNumChange();

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
      console.log("chapter의 끝");
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
      console.log("sortChapter의 끝");
      this.addEvent=false;
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
        fetch('http://localhost:8080/api/itemlist',{

        }).then(response=>response.json())
            .then(data=>console.log(data));
      });
    },
    getEvaluation(){
      fetch('http://localhost:8080/api/evaluationlist')
          .then(response=>response.json())
          .then(data=>{
            for(let i=0;i<data.evaluationList.length;i+=3){
              this.evaluationList.push(data.evaluationList.slice(i,i+3));
            }
            console.log("data",data);
            console.log("evalu",this.evaluationList);
            console.log("evaluation의 끝");
          });
    },
    // 이거 동작하는지 봐줘
    stepNumChange(){
      const activeStep = Object.keys(this.activeList.stepActive).filter(key=>this.activeList.stepActive[key]==true);
      console.log("activeStep",activeStep);
      const stepNum = activeStep.map(step=>step.slice(0,-6));
      console.log("stepNum",stepNum);
      stepNum.forEach(num=>{
        this[num]=Math.floor(this.quizNum/stepNum.length);
        console.log(this[num]);
      })
    },
    popupClose(){
      if(window.opener){
        window.close();
      }else{
        alert("창을 닫을 수 없습니다!");
      }
    },
    cancelQuizCount(){
      if(this.activeList.stepActive.lowestactive==true) this.lowestinp=this.lowest;
      if(this.activeList.stepActive.lowactive==true) this.lowinp=this.low;
      if(this.activeList.stepActive.middleactive==true) this.middleinp=this.middle;
      if(this.activeList.stepActive.highactive==true) this.highinp=this.high;
      if(this.activeList.stepActive.highestactive==true) this.highestinp=this.highest;
    },
    popupInputChange(){
      if(this.quizsum==this.quizNum){
        this.quizsum = 0;
        if(this.activeList.stepActive.lowestactive==true) {
          this.quizsum += this.lowest;
          this.lowest=this.lowestinp;
        }
        if(this.activeList.stepActive.lowactive==true) {
          this.quizsum += this.low;
          this.low=this.lowinp;
        }
        if(this.activeList.stepActive.middleactive==true) {
          this.quizsum += this.middle;
          this.middle=this.middleinp;
        }
        if(this.activeList.stepActive.highactive==true) {
          this.quizsum += this.high;
          this.high=this.highinp;
        }
        if(this.activeList.stepActive.highestactive==true) {
          this.quizsum += this.highest;
          this.highest=this.highestinp;
        }

        // 기존 코드 사용해서 팝업창 닫기
        let _dim = $(".dim");
        let _html = $("html , body");

        let _this = $(this);
        $(".pop-wrap").hide();
        _html.css("overflow", "auto");
        _dim.fadeOut();
      }
    },
    difficultyQuizCount(){
      this.quizsum = 0;
      if(this.activeList.stepActive.lowestactive==true) this.quizsum += this.lowestinp;
      if(this.activeList.stepActive.lowactive==true) this.quizsum += this.lowinp;
      if(this.activeList.stepActive.middleactive==true) this.quizsum += this.middleinp;
      if(this.activeList.stepActive.highactive==true) this.quizsum += this.highinp;
      if(this.activeList.stepActive.highestactive==true) this.quizsum += this.highestinp;
    },
    evalActive(gindex,index){
      this.activeList[`eval${gindex*3+index+1}active`]=!this.activeList[`eval${gindex*3+index+1}active`];
    }
  },
  watch:{
    lowest(cur,ori){
      if(this.activeList.stepActive.lowestactive) {
        this.quizsum += (cur - ori);
        this.lowestinp = this.lowest;
      }
    },
    low(cur,ori){
      if(this.activeList.stepActive.lowactive) {
        this.quizsum += (cur - ori);
        this.lowinp = this.low;
      }
    },
    middle(cur,ori){
      if(this.activeList.stepActive.middleactive) {
        this.quizsum += (cur - ori);
        this.middleinp = this.middle;
      }
    },
    high(cur,ori){
      if(this.activeList.stepActive.highactive) {
        this.quizsum += (cur - ori);
        this.highinp = this.high;
      }
    },
    highest(cur,ori){
      if(this.activeList.stepActive.highestactive){
        this.quizsum += (cur-ori);
        this.highestinp=this.highest;
      }
    },
    "activeList.stepActive.lowestactive":function(cur,ori) {
      if (!cur && ori) {
        this.quizsum -= this.lowest;
        this.lowest = 0;
      }
    },
    "activeList.stepActive.lowactive":function(cur,ori) {
      if (!cur && ori) {
        this.quizsum -= this.low;
        this.low = 0;
      }
    },
    "activeList.stepActive.middleactive":function(cur,ori) {
      if (!cur && ori) {
        this.quizsum -= this.middle;
        this.middle = 0;
      }
    },
    "activeList.stepActive.highactive":function(cur,ori) {
      if (!cur && ori) {
        this.quizsum -= this.high;
        this.high = 0;
      }
    },
    "activeList.stepActive.highestactive":function(cur,ori) {
      if (!cur && ori) {
        this.quizsum -= this.highest;
        this.highest = 0;
      }
    },
  },
  mounted(){
    this.getChapter();
    this.getEvaluation();
    this.$nextTick(() => {
      console.log("뭐가 먼저 됨?");
    })
  },
  updated(){
    if(!this.addEvent){
      this.$nextTick(() => {
        common();
        this.jquery();
        console.log("이거 된거임?")
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
        <button type="button" class="del-btn" @click="popupClose"></button>
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
                      <input type="checkbox" id="chk01_00" v-model="allChecked" class="allCheck que-allCheck">
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
                        <button type="button" class="btn-line" :class="{active:activeList.quiz10}" :disabled="allDisabled" @click="quizNum=$event.target.innerText;stepNumChange();">10</button>
                        <button type="button" class="btn-line" :class="{active:activeList.quiz15}" :disabled="allDisabled" @click="quizNum=$event.target.innerText;stepNumChange();">15</button>
                        <button type="button" class="btn-line" :class="{active:activeList.quiz20}" :disabled="allDisabled" @click="quizNum=$event.target.innerText;stepNumChange();">20</button>
                        <button type="button" class="btn-line" :class="{active:activeList.quiz25}" :disabled="allDisabled" @click="quizNum=$event.target.innerText;stepNumChange();">25</button>
                        <button type="button" class="btn-line" :class="{active:activeList.quiz30}" :disabled="allDisabled" @click="quizNum=$event.target.innerText;stepNumChange();">30</button>
                      </div>
                      <div class="input-area">
                        <span class="num">총 <input type="text" v-model.number="quizNum" :disabled="allDisabled" @blur="quizNum>30?quizNum=30:quizNum-=quizNum%5;stepNumChange();"> 문제</span>
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
                      <button type="button" class="btn-line" :class="{active:activeList.teaactive}" :disabled="allDisabled">교사용(교사용 DVD, 지도서, 신규 개발 등)</button>
                      <button type="button" class="btn-line" :class="{active:activeList.stuactive}" :disabled="allDisabled">학생용(자습서, 평가문제집 등)</button>
                    </div>
                  </div>
                  <div class="box">
                    <div class="title-wrap">
                      <span class="tit-text">평가 영역</span>
                      <div class="right-area">
                      </div>
                    </div>
                    <div class="btn-wrap multi" v-for="(evalGroup,gindex) in evaluationList">
                      <button type="button" :id="evalu.domainId" class="btn-line" :class="{active:activeList[`eval${gindex*3+index+1}active`]}"
                              :disabled="allDisabled" v-for="(evalu,index) in evalGroup" @click="evalActive(gindex,index)">{{ evalu.domainName }}</button>
                    </div>
                  </div>
                  <div class="box">
                    <div class="title-wrap">
                      <span class="tit-text">문제 형태</span>
                      <div class="right-area">
                      </div>
                    </div>
                    <div class="btn-wrap multi">
                      <button type="button" class="btn-line" :class="{active:activeList.objectiveactive}" :disabled="allDisabled">객관식</button>
                      <button type="button" class="btn-line" :class="{active:activeList.subjectiveactive}" :disabled="allDisabled">주관식</button>
                    </div>
                  </div>
                  <div class="box">
                    <div class="title-wrap">
                      <span class="tit-text">난이도 구성</span>
                    </div>
                    <div class="step-wrap">
                      <button type="button" class="btn-line type02 color01" data-step="stap1" :class="{active:activeList.stepActive.lowestactive}" :disabled="allDisabled">최하</button>
                      <button type="button" class="btn-line type02 color02" data-step="stap2" :class="{active:activeList.stepActive.lowactive}" :disabled="allDisabled">하</button>
                      <button type="button" class="btn-line type02 color03" data-step="stap3" :class="{active:activeList.stepActive.middleactive}" :disabled="allDisabled">중</button>
                      <button type="button" class="btn-line type02 color04" data-step="stap4" :class="{active:activeList.stepActive.highactive}" :disabled="allDisabled">상</button>
                      <button type="button" class="btn-line type02 color05" data-step="stap5" :class="{active:activeList.stepActive.highestactive}" :disabled="allDisabled">최상</button>
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
                      <span class="range color01" data-step="stap1">최하({{ lowest }})</span>
                      <span class="range color02" data-step="stap2">하({{ low }})</span>
                      <span class="range color03" data-step="stap3">중({{ middle }})</span>
                      <span class="range color04" data-step="stap4">상({{ high }})</span>
                      <span class="range color05" data-step="stap5">최상({{ highest }})</span>
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
          <button type="button" class="pop-close" @click="cancelQuizCount"></button>
        </div>
        <div class="pop-content">
          <span class="txt">문제 수를 입력하여<br> 난이도별 문제 수를 조정하세요.</span>
          <div class="range-wrap">
            <!-- S: 문제 수 맞지 않을 시 .fail 클래스 추가 -->
            <div class="range color01" data-step="stap1" :class="{fail:quizsum!=quizNum}">
              <span class="color01">최하</span>
              <input type="number" v-model.number="lowestinp" @blur="difficultyQuizCount">
            </div>
            <div class="range color02" data-step="stap2" :class="{fail:quizsum!=quizNum}">
              <span class="color02">하</span>
              <input type="number" v-model.number="lowinp" @blur="difficultyQuizCount">
            </div>
            <div class="range color03" data-step="stap3" :class="{fail:quizsum!=quizNum}">
              <span class="color03">중</span>
              <input type="number" v-model.number="middleinp" @blur="difficultyQuizCount">
            </div>
            <div class="range color04" data-step="stap4" :class="{fail:quizsum!=quizNum}">
              <span class="color04">상</span>
              <input type="number" v-model.number="highinp" @blur="difficultyQuizCount">
            </div>
            <div class="range color05" data-step="stap5" :class="{fail:quizsum!=quizNum}">
              <span class="color05">최상</span>
              <input type="number" v-model.number="highestinp" @blur="difficultyQuizCount">
            </div>
            <div class="range total" :class="{fail:quizsum!=quizNum}">
              <span>합계</span>
              <span class="num">{{ quizsum }}</span>
            </div>
            <!-- E: 문제 수 맞지 않을 시 .fail 클래스 추가 -->
          </div>
        </div>
        <div class="pop-footer">
          <button @click="cancelQuizCount">초기화</button>
          <button @click="popupInputChange" :class="{disabled:quizsum!=quizNum}">저장</button>
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