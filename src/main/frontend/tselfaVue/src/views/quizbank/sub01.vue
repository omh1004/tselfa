<script>
import { common } from '../../assets/js/common.js'

export default {
  name: "sub01.vue",
  data:()=>{
    return{
      chapterList:[],
      sortedChapterIdList:{},
      sortedChapterNameList:{},
    }
  },
  methods:{
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
    }
  },
  mounted(){
    this.getChapter();
    common();
  }
}
</script>

<template>
  <div id="wrap" class="full-pop-que">
    <div class="full-pop-wrap">
      <div class="pop-header">
        <ul class="title">
          <li class="active"><img src="../../assets/image/ico_step_active.png" alt="">출제 방법 선택</li>
        </ul>
        <button type="button" class="del-btn"></button>
      </div>
      <div class="pop-content">
        <div class="view-box">
          <div class="view-top">
            <div class="paper-info">
              <span>수학 1</span>
              이준열(2015) 수정
              ..... <!-- 더미와 API 데이터 구분용 -->
              <p v-if="chapterList.length>0">{{ chapterList[0].subjectName }}</p>
            </div>
            <div class="btn-wrap">
              <button class="btn-icon"><i class="edit"></i>선택한 시험지 편집하기</button>
              <button class="btn-icon"><i class="newpaper"></i>신규 시험지 만들기</button>
            </div>
          </div>
          <div> <!-- test -->
<!--            <div v-for="chapter in chapterList">-->
<!--              &lt;!&ndash; 이걸 봤을 때 이 3개로 묶어야 할 듯 &ndash;&gt;-->
<!--              <p>{{ chapter.largeChapterName }}</p>-->
<!--              <p>{{ chapter.mediumChapterName }}</p>-->
<!--              <p>{{ chapter.smallChapterName }}</p>-->
<!--              <p>비우는칸</p>-->
<!--            </div>-->
          </div>
<!--          -->
          <div class="view-bottom">
            <div class="tab-list-type01 unit-acc-wrap">
              <div class="scroll-inner" v-for="large in Object.keys(sortedChapterNameList)">
                <button type="button" class="acc-btn">jquery가 작동을 안 해</button>
                <div class="cnt">
                  <div class="table">
                    <!-- s 230706 선택 삭제, 편집하기 추가 -->
                    <div class="fix-head">
                      <span>시험지명</span>
                      <span>미리보기</span>
                      <span>편집하기</span>
                      <span>다운로드</span>
                    </div>
                    <!-- e 230706 선택 삭제, 편집하기 추가 -->
<!--                    -->
<!--                    -->
                    <div class="tbody">{{ large }}
                      <div class="col" v-for="medium in Object.keys(sortedChapterNameList[large])">
                        <span class="tit" v-for="small in Object.keys(sortedChapterNameList[large][medium])">{{ medium }} > {{ small }} > 1회</span>
                        <span><button type="button" class="pop-btn btn-icon2" data-pop="prev-pop"><i
                            class="preview"></i></button></span>
                        <span><button type="button" class="btn-icon2"><i class="edit-type02"></i></button></span><!--230706 편집하기 버튼 추가-->
                        <span>
                          <div class="btn-wrap"><button type="button" class="btn-default">전체</button> <button
                              type="button" class="btn-default">문제</button> <button type="button" class="btn-default">정답
                              + 해설</button></div>
                        </span>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>

      </div>


    </div>
    <div class="dim"></div>
    <!-- 미리보기 팝업 -->
    <div id="q-preview" class="pop-wrap prev-type " data-pop="prev-pop">
      <div class="pop-inner">
        <div class="pop-header">
          <span>미리보기</span>
          <button type="button" class="pop-close"></button>
        </div>
        <div class="pop-content">
          <div class="btn-wrap">
            <button type="button" class="btn-icon"><i class="download"></i>다운로드</button>
          </div>
          <div class="view-box">
            <div class="scroll-inner">
              <!-- <img src="../../assets/image/sample_prev.jpg" alt="">
              <img src="../../assets/image/sample_prev.jpg" alt=""> -->
              <!--230824 림 추가-->
              <div class="view-data">
                <div class="example-area">
                  <div class="example-box">
                    <div class="item-question">
                      <span class="numbering">1.</span>
                      <img src="../../assets/image/sampling-question.png" alt="">
                    </div>

                    <div class="choice-contanier">
                      <ul class="answer-input">
                        <li>
                          <img src="../../assets/image/sampling-question-1.png" alt="">
                        </li>
                        <li>
                          <img src="../../assets/image/sampling-question-1.png" alt="">
                        </li>
                        <li>
                          <img src="../../assets/image/sampling-question-1.png" alt="">
                        </li>
                        <li>
                          <img src="../../assets/image/sampling-question-1.png" alt="">
                        </li>
                        <li>
                          <img src="../../assets/image/sampling-question-1.png" alt="">
                        </li>
                      </ul>
                    </div>

                    <div class="answer-container">
                      <span class="answer-tit">(정답)</span>
                      <div class="answer-img" style="height:25px; background:lightgray"><img src="../../assets/image/answer-img.png" alt=""></div>
                    </div>

                    <div class="explain-answer">
                      <span class="explain-tit">(해설)</span>
                      <div class="explain-img"><img src="../../assets/image/sampling-question2.png" alt=""></div>
                    </div>
                  </div>
                </div>

                <div class="example-area">
                  <div class="example-box">
                    <div class="item-question">
                      <span class="numbering numbering-numbers">10~20. </span>
                      <img src="../../assets/image/sampling-question.png" alt="">
                    </div>

                    <div class="choice-contanier">
                      <ul class="answer-input">
                        <li>
                          <img src="../../assets/image/sampling-question-1.png" alt="">
                        </li>
                        <li>
                          <img src="../../assets/image/sampling-question-1.png" alt="">
                        </li>
                        <li>
                          <img src="../../assets/image/sampling-question-1.png" alt="">
                        </li>
                        <li>
                          <img src="../../assets/image/sampling-question-1.png" alt="">
                        </li>
                        <li>
                          <img src="../../assets/image/sampling-question-1.png" alt="">
                        </li>
                      </ul>
                    </div>

                    <div class="answer-container">
                      <span class="answer-tit">(정답)</span>
                      <div class="answer-img" style="height:25px; background:lightgray"><img src="../../assets/image/answer-img.png" alt=""></div>
                    </div>

                    <div class="explain-answer">
                      <span class="explain-tit">(해설)</span>
                      <div class="explain-img"><img src="../../assets/image/sampling-question2.png" alt=""></div>
                    </div>
                  </div>
                </div>

                <div class="example-area">
                  <div class="example-box">
                    <div class="item-question">
                      <span class="numbering">1.</span>
                      <img src="../../assets/image/sampling-question.png" alt="">
                    </div>

                    <div class="choice-contanier">
                      <ul class="answer-input">
                        <li>
                          <img src="../../assets/image/sampling-question-1.png" alt="">
                        </li>
                        <li>
                          <img src="../../assets/image/sampling-question-1.png" alt="">
                        </li>
                        <li>
                          <img src="../../assets/image/sampling-question-1.png" alt="">
                        </li>
                        <li>
                          <img src="../../assets/image/sampling-question-1.png" alt="">
                        </li>
                        <li>
                          <img src="../../assets/image/sampling-question-1.png" alt="">
                        </li>
                      </ul>
                    </div>

                    <div class="answer-container">
                      <span class="answer-tit">(정답)</span>
                      <div class="answer-img" style="height:25px; background:lightgray"><img src="../../assets/image/answer-img.png" alt=""></div>
                    </div>

                    <div class="explain-answer">
                      <span class="explain-tit">(해설)</span>
                      <div class="explain-img"><img src="../../assets/image/sampling-question2.png" alt=""></div>
                    </div>
                  </div>
                </div>

                <div class="example-area">
                  <div class="example-box">
                    <div class="item-question">
                      <span class="numbering">1.</span>
                      <img src="../../assets/image/sampling-question.png" alt="">
                    </div>

                    <div class="choice-contanier">
                      <ul class="answer-input">
                        <li>
                          <img src="../../assets/image/sampling-question-1.png" alt="">
                        </li>
                        <li>
                          <img src="../../assets/image/sampling-question-1.png" alt="">
                        </li>
                        <li>
                          <img src="../../assets/image/sampling-question-1.png" alt="">
                        </li>
                        <li>
                          <img src="../../assets/image/sampling-question-1.png" alt="">
                        </li>
                        <li>
                          <img src="../../assets/image/sampling-question-1.png" alt="">
                        </li>
                      </ul>
                    </div>

                    <div class="answer-container">
                      <span class="answer-tit">(정답)</span>
                      <div class="answer-img" style="height:25px; background:lightgray"><img src="../../assets/image/answer-img.png" alt=""></div>
                    </div>

                    <div class="explain-answer">
                      <span class="explain-tit">(해설)</span>
                      <div class="explain-img"><img src="../../assets/image/sampling-question2.png" alt=""></div>
                    </div>
                  </div>
                </div>

              </div>
            </div>
          </div>
        </div>
        <!--<div class="pop-footer">
          <div class="page-num">
            <span>1 / 2</span>
          </div>
        </div> -->
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