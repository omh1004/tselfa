<script>
import { common } from '../../assets/js/common.js'

export default {
  name: "sub03_01_01.vue",
  methods:{
    jquery:$(function () {


      let _leg = $('.view-que').length;
      let arr = [];

      viewListFunc();

      $(".view-que-list").change(function () {
        let _leg = $('.view-que').length;
        let arr = [];

        viewListFunc();
      })

      function viewListFunc() {
        $('.col').on('click', function () {

          let _idx = $(this).index();

          for (var i = 0; i < _leg; i++) {
            arr.push($('.view-que').eq(i).offset().top - 270);
          }

          console.log(arr);

          $('.view-que-list').animate({
            scrollTop: arr[_idx]
          }, 400);

          let _this = $(this);
          if (!_this.hasClass('active')) {
            _this.parents('.test.ui-sortable').find('.col').removeClass('active');
            _this.addClass('active');
            $('.view-que-box').removeClass('active');
            $('.view-que-box').eq(_idx).addClass('active');
          };

        })
      }
    })
  },
  mounted(){
    this.jquery;
    common();
  }
}
</script>

<template>
  <div id="wrap" class="full-pop-que">
    <div class="full-pop-wrap">
      <div class="pop-header">
        <ul class="title">
          <li>STEP 1 단원선택</li>
          <li class="active">STEP 2 문항 편집</li>
          <li>STEP 3 시험지 저장</li>
        </ul>
        <button type="button" class="del-btn"></button>
      </div>
      <div class="pop-content">
        <div class="view-box">
          <div class="view-top">
            <div class="paper-info">
              <span>국어 1</span>
              노미숙(2015)
            </div>
            <button class="btn-default btn-research"><i class="research"></i>재검색</button>
            <button class="btn-default pop-btn" data-pop="que-scope-pop">출제범위</button>
          </div>
          <div class="view-bottom type01">
            <div class="cnt-box">
              <div class="cnt-top">
                <span class="title">문제 목록</span>
                <div class="right-area">
                  <div class="select-wrap">
                    <button type="button" class="select-btn">문제만 보기</button>
                    <ul class="select-list" style="display: none;">
                      <li>
                        <a href="javascript:;">문제+정답 보기</a>
                      </li>
                      <li>
                        <a href="javascript:;">문제+해설+정답 보기</a>
                      </li>
                      <li class="disabled">
                        <a href="javascript:;">편집단계에서만 적용되는 보기 옵션</a>
                      </li>
                    </ul>
                  </div>
                  <div class="select-wrap">
                    <button type="button" class="select-btn">사용자 정렬</button>
                    <ul class="select-list">
                      <li>
                        <a href="javascript:;">단원순</a>
                      </li>
                      <li>
                        <a href="javascript:;">난이도순</a>
                      </li>
                      <li>
                        <a href="javascript:;">문제 형태순</a>
                      </li>
                    </ul>
                  </div>
                </div>
              </div>
              <div class="view-que-list scroll-inner" style="display: -webkit-box;-webkit-box-orient:vertical">
                <!-- s: 지문 영역 -->
                <div class="view-que-box">
                  <div class="que-top">
                    <div class="title">
                      <span class="num">1 ~ 4</span>
                    </div>
                  </div>
                  <div class="view-que">
                    <div class="que-content">
                      <p class="txt">※ 다음 시를 읽고, 물음에 답하시오.</p>
                    </div>
                    <div class="que-bottom">
                      <div class="passage-area">
                        ㉠ 누가 잘 익은 콩을 저렇게 쏟고 있나<br>
                        ㉡ 또로록 마당 가득 실로폰 소리 난다<br>
                        &nbsp;&nbsp;&nbsp;&nbsp;소나기그치고 나면 하늘빛이 더 맑다
                      </div>
                    </div>
                  </div>
                </div>
                <!-- e: 지문 영역 -->
                <div class="view-que-box">
                  <div class="que-top">
                    <div class="title">
                      <span class="num">1</span>
                      <div class="que-badge-group">
                        <span class="que-badge green">중</span>
                        <span class="que-badge gray">객관식</span>
                      </div>
                    </div>
                    <div class="btn-wrap">
                      <button type="button" class="btn-error pop-btn" data-pop="error-report-pop"></button>
                      <button type="button" class="btn-delete"></button>
                    </div>
                  </div>
                  <div class="view-que">
                    <div class="que-content">
                      <p class="txt">㉠ 과 같이 표현한 까닭을 쓰시오.</p>
                      소나기가 내리는 소리와 <input type="text" readonly> 을/를 쏟는 소리가 비슷하게 느껴졌기 때문이다.
                    </div>
                    <div class="que-bottom">
                      <div class="data-area">
                        <div class="que-info">
                          <p class="answer"><span class="label">해설</span></p>
                          <div class="data-answer-area">
                            <!-- s: 해설 데이터 영역 -->
                            <div class="paragraph" style="text-align: Justify"><span class="txt">해설 텍스트가 나오는 영역입니다.해설
																텍스트가
																나오는 영역입니다.해설 텍스트가 나오는 영역입니다.해설 텍스트가 나오는 영역입니다.</span></div>
                            <div class="paragraph" style="text-align: Justify"><span class="txt">해설 텍스트가 나오는 영역입니다.해설
																텍스트가
																나오는 영역입니다.해설 텍스트가 나오는 영역입니다.해설 텍스트가 나오는 영역입니다.</span></div>
                            <!-- e: 해설 데이터 영역 -->
                          </div>
                        </div>
                      </div>
                      <div class="data-area type01">
                        <div class="que-info">
                          <p class="answer"><span class="label type01">정답</span></p>
                          <div class="data-answer-area">
                            <!-- s: 정답 데이터 영역 -->
                            <div class="paragraph" style="text-align: Justify"><span class="txt"> ①</span></div>
                            <!-- e: 정답 데이터 영역 -->
                          </div>
                        </div>
                        <button type="button" class="btn-similar-que btn-default"><i class="similar"></i> 유사 문제</button>
                      </div>
                    </div>

                  </div>
                  <div class="que-info-last">
                    <p class="chapter">1. 새로운 시작 > (1) 시의 아름다움1. 새로운 시작 > (1) 시의 아름다움1. 새로운 시작 > (1) 시의 아름다움1. 새로운 시작 >
                      (1) 시의 아름다움</p>
                  </div>
                </div>
                <div class="view-que-box">
                  <div class="que-top">
                    <div class="title">
                      <span class="num">2</span>
                      <div class="que-badge-group">
                        <span class="que-badge purple">하</span>
                        <span class="que-badge gray">주관식</span>
                      </div>
                    </div>
                    <div class="btn-wrap">
                      <button type="button" class="btn-error pop-btn" data-pop="error-report-pop"></button>
                      <button type="button" class="btn-delete"></button>
                    </div>
                  </div>
                  <div class="view-que">
                    <div class="que-content">
                      <p class="txt">5×5×13×13×13×13을 거듭제곱으로 나타낼 5의 지수를 a, 13의 거듭제곱의 밑을 b라 하자. 이때 b−a의 값을 구하시오.
                        5×5×13×13×13×13을 거듭제곱으로 나타낼 5의 지수를 a, 13의 거듭제곱의 밑을 b라 하자. 이때 b−a의 값을 구하시오. 5×5×13×13×13×13을
                        거듭제곱으로
                        나타낼 5의 지수를 a, 13의 거듭제곱의 밑을 b라 하자. 이때 b−a의 값을 구하시오.</p>
                      <ul>
                        <ol><em>①</em><span>3의 4에 대한 비3의 4에 대한 비3의 4에 대한 비3의 4에 대한 비3의 4에 대한 비3의 4에 대한 비3의 4에 대한 비3의 4에
														대한
														비3의 4에 대한 비3의 4에 대한 비3의 4에 대한 비3의 4에 대한 비</span></ol>
                        <ol><em>②</em><span>3의 4에 대한 비</span></ol>
                        <ol><em>③</em><span>4에 대한 3의 비</span></ol>
                        <ol><em>④</em><span>3에 대한 4의 비</span></ol>
                        <ol><em>⑤</em><span>3과 4의 비</span></ol>
                      </ul>
                    </div>
                    <div class="que-bottom">
                      <button type="button" class="btn-similar-que btn-default"><i class="similar"></i> 유사 문제</button>
                    </div>
                  </div>
                  <div class="que-info-last">
                    <p class="chapter">자연수의 성질>소인수분해>거듭제곱>거듭제곱으로표현</p>
                  </div>
                </div>
                <div class="view-que-box">
                  <div class="que-top">
                    <div class="title">
                      <span class="num">3</span>
                      <div class="que-badge-group">
                        <span class="que-badge yellow">상</span>
                        <span class="que-badge gray">주관식</span>
                      </div>
                    </div>
                    <div class="btn-wrap">
                      <button type="button" class="btn-error pop-btn" data-pop="error-report-pop"></button>
                      <button type="button" class="btn-delete"></button>
                    </div>
                  </div>
                  <div class="view-que">
                    <div class="que-content">
                      <p class="txt">5×5×13×13×13×13을 거듭제곱으로 나타낼 5의 지수를 a, 13의 거듭제곱의 밑을 b라 하자. 이때 b−a의 값을 구하시오.</p>
                    </div>
                    <div class="que-bottom">
                      <div class="data-area">
                        <div class="que-info">
                          <p class="answer"><span class="label">해설</span></p>
                          <div class="data-answer-area">
                            <!-- s: 해설 데이터 영역 -->
                            <div class="paragraph" style="text-align: Justify"><span class="txt">해설 텍스트가 나오는 영역입니다.해설
																텍스트가
																나오는 영역입니다.해설 텍스트가 나오는 영역입니다.해설 텍스트가 나오는 영역입니다.</span></div>
                            <div class="paragraph" style="text-align: Justify"><span class="txt">해설 텍스트가 나오는 영역입니다.해설
																텍스트가
																나오는 영역입니다.해설 텍스트가 나오는 영역입니다.해설 텍스트가 나오는 영역입니다.</span></div>
                            <!-- e: 해설 데이터 영역 -->
                          </div>
                        </div>
                      </div>
                      <div class="data-area type01">
                        <div class="que-info">
                          <p class="answer"><span class="label type01">정답</span></p>
                          <div class="data-answer-area">
                            <!-- s: 정답 데이터 영역 -->
                            <div class="paragraph" style="text-align: Justify"><span class="txt"> ①</span></div>
                            <div class="paragraph" style="text-align: Justify"><span class="txt"> ①</span></div>
                            <div class="paragraph" style="text-align: Justify"><span class="txt"> ①</span></div>
                            <!-- e: 정답 데이터 영역 -->
                          </div>
                        </div>
                        <button type="button" class="btn-similar-que btn-default"><i class="similar"></i> 유사 문제</button>
                      </div>
                    </div>
                  </div>
                  <div class="que-info-last">
                    <p class="chapter">자연수의 성질>소인수분해>거듭제곱>거듭제곱으로표현</p>
                  </div>
                </div>
                <div class="view-que-box">
                  <div class="que-top">
                    <div class="title">
                      <span class="num">4</span>
                      <div class="que-badge-group">
                        <span class="que-badge purple">하</span>
                        <span class="que-badge gray">주관식</span>
                      </div>
                    </div>
                    <div class="btn-wrap">
                      <button type="button" class="btn-error pop-btn" data-pop="error-report-pop"></button>
                      <button type="button" class="btn-delete"></button>
                    </div>
                  </div>
                  <div class="view-que">
                    <div class="que-content">
                      <p class="txt">5×5×13×13×13×13을 거듭제곱으로 나타낼 5의 지수를 a, 13의 거듭제곱의 밑을 b라 하자. 이때 b−a의 값을 구하시오.</p>
                      <ul>
                        <ol><em>①</em><span>3 대 4</span></ol>
                        <ol><em>②</em><span>3의 4에 대한 비</span></ol>
                        <ol><em>③</em><span>4에 대한 3의 비</span></ol>
                        <ol><em>④</em><span>3에 대한 4의 비</span></ol>
                        <ol><em>⑤</em><span>3과 4의 비</span></ol>
                      </ul>
                    </div>
                    <div class="que-bottom">
                      <button type="button" class="btn-similar-que btn-default"><i class="similar"></i> 유사 문제</button>
                    </div>
                  </div>
                  <div class="que-info-last">
                    <p class="chapter">자연수의 성질>소인수분해>거듭제곱>거듭제곱으로표현</p>
                  </div>
                </div>
              </div>
              <div class="bottom-box">
                <div class="que-badge-group type01">
                  <div class="que-badge-wrap">
                    <span class="que-badge purple">하</span>
                    <span class="num">5</span>
                  </div>
                  <div class="que-badge-wrap">
                    <span class="que-badge green">중</span>
                    <span class="num">15</span>
                  </div>
                  <div class="que-badge-wrap">
                    <span class="que-badge yellow">상</span>
                    <span class="num">25</span>
                  </div>
                </div>
                <p class="total-num">총 <span>30</span>문제</p>
              </div>
            </div>
            <div class="cnt-box type01">
              <div class="tab-wrap">
                <ul class="tab-menu-type01">
                  <li class="ui-tab-btn active">
                    <a href="javascript:;">문제지 요약</a>
                  </li>
                  <li class="ui-tab-btn">
                    <a href="javascript:;">유사 문제</a>
                  </li>
                  <li class="ui-tab-btn">
                    <a href="javascript:;">삭제 문항</a>
                  </li>
                </ul>
                <div class="contents on">
                  <div class="table half-type">
                    <!--지문 있는 테이블 유형-->
                    <div class="fix-head">
                      <span>이동</span>
                      <span>번호</span>
                      <span>문제 유형</span>
                      <!--시험지명-->
                      <span>문제 형태</span>
                      <span>난이도</span>
                    </div>
                    <div class="tbody">
                      <div class="scroll-inner">
                        <div class="test ui-sortable" id="table-1">
                          <!-- s: 지문 묶음 영역-->
                          <div class="depth-01">
                            <div class="dragHandle ui-sortable-handle drag-type02"><img
                                src="../images/common/ico_move_type01.png" alt=""></div>
                            <div class="col-group">
                              <div class="col depth-02">
                                <a href="javascript:;">
																	<span class="dragHandle ui-sortable-handle drag-type01"><img
                                      src="../images/common/ico_move_type02.png" alt=""></span>
                                  <span>1</span>
                                  <!-- S 230808 tooltip-wrap 추가-->
                                  <span class="tit">
																		<div class="txt">자연수의 성질&gt;소인수분해&gt;거듭제곱&gt;거듭제곱으로표현</div>
																		<div class="tooltip-wrap">
																			<button type="button" class="btn-tip"></button>
																			<div class="tooltip type01">
																				<div class="tool-type01">
																					시험지명블라블라~~시험지명블라블라~~시험지명블라블라~~시험지명블라블라~~시험지명블라블라~~시험지명블라블라~~</div>
																			</div>
																		</div>
																	</span>
                                  <!-- E 230808 tooltip-wrap 추가-->
                                  <span>주관식</span>
                                  <span>
																		<span class="que-badge">하</span>
																	</span>
                                </a>
                              </div>
                              <div class="col depth-02">
                                <a href="javascript:;">
																	<span class="dragHandle ui-sortable-handle drag-type01"><img
                                      src="../images/common/ico_move_type02.png" alt=""></span>
                                  <span>2</span>
                                  <!-- S 230808 tooltip-wrap 추가-->
                                  <span class="tit">
																		<div class="txt">자연수의 성질&gt;소인수분해&gt;거듭제곱&gt;거듭제곱으로표현</div>
																		<div class="tooltip-wrap">
																			<button type="button" class="btn-tip"></button>
																			<div class="tooltip type01">
																				<div class="tool-type01">
																					시험지명블라블라~~시험지명블라블라~~시험지명블라블라~~시험지명블라블라~~시험지명블라블라~~시험지명블라블라~~</div>
																			</div>
																		</div>
																	</span>
                                  <!-- E 230808 tooltip-wrap 추가-->
                                  <span>객관식</span>
                                  <span>
																		<span class="que-badge">중</span>
																	</span>
                                </a>
                              </div>
                              <div class="col depth-02">
                                <a href="javascript:;">
																	<span class="dragHandle ui-sortable-handle drag-type01"><img
                                      src="../images/common/ico_move_type02.png" alt=""></span>
                                  <span>3</span>
                                  <!-- S 230808 tooltip-wrap 추가-->
                                  <span class="tit">
																		<div class="txt">대단원&gt;중단원&gt;소단원&gt;토픽</div>
																		<div class="tooltip-wrap">
																			<button type="button" class="btn-tip"></button>
																			<div class="tooltip type01">
																				<div class="tool-type01">
																					시험지명블라블라~~시험지명블라블라~~시험지명블라블라~~시험지명블라블라~~시험지명블라블라~~시험지명블라블라~~</div>
																			</div>
																		</div>
																	</span>
                                  <!-- E 230808 tooltip-wrap 추가-->
                                  <span>주관식</span>
                                  <span>
																		<span class="que-badge">중</span>
																	</span>
                                </a>
                              </div>
                              <div class="col depth-02">
                                <a href="javascript:;">
																	<span class="dragHandle ui-sortable-handle drag-type01"><img
                                      src="../images/common/ico_move_type02.png" alt=""></span>
                                  <span>4</span>
                                  <!-- S 230808 tooltip-wrap 추가-->
                                  <span class="tit">
																		<div class="txt">대단원&gt;중단원&gt;소단원&gt;토픽</div>
																		<div class="tooltip-wrap">
																			<button type="button" class="btn-tip"></button>
																			<div class="tooltip type01">
																				<div class="tool-type01">
																					시험지명블라블라~~시험지명블라블라~~시험지명블라블라~~시험지명블라블라~~시험지명블라블라~~시험지명블라블라~~</div>
																			</div>
																		</div>
																	</span>
                                  <!-- E 230808 tooltip-wrap 추가-->
                                  <span>객관식</span>
                                  <span>
																		<span class="que-badge">하</span>
																	</span>
                                </a>
                              </div>
                            </div>
                          </div>
                          <!-- e : 지문 묶음 영역-->
                          <div class="col">
                            <a href="javascript:;">
															<span class="dragHandle ui-sortable-handle"><img
                                  src="../images/common/ico_move_type01.png" alt=""></span>
                              <span></span>
                              <span>5</span>
                              <!-- S 230808 tooltip-wrap 추가-->
                              <span class="tit">
																<div class="txt">대단원&gt;중단원&gt;소단원&gt;토픽</div>
																<div class="tooltip-wrap">
																	<button type="button" class="btn-tip"></button>
																	<div class="tooltip type01">
																		<div class="tool-type01">
																			시험지명블라블라~~시험지명블라블라~~시험지명블라블라~~시험지명블라블라~~시험지명블라블라~~시험지명블라블라~~</div>
																	</div>
																</div>
															</span>
                              <!-- E 230808 tooltip-wrap 추가-->
                              <span>주관식</span>
                              <span>
																<span class="que-badge">중</span>
															</span>
                            </a>
                          </div>
                          <div class="col">
                            <a href="javascript:;">
															<span class="dragHandle ui-sortable-handle"><img
                                  src="../images/common/ico_move_type01.png" alt=""></span>
                              <span></span>
                              <span>6</span>
                              <!-- S 230808 tooltip-wrap 추가-->
                              <span class="tit">
																<div class="txt">대단원&gt;중단원&gt;소단원&gt;토픽</div>
																<div class="tooltip-wrap">
																	<button type="button" class="btn-tip"></button>
																	<div class="tooltip type01">
																		<div class="tool-type01">
																			시험지명블라블라~~시험지명블라블라~~시험지명블라블라~~시험지명블라블라~~시험지명블라블라~~시험지명블라블라~~</div>
																	</div>
																</div>
															</span>
                              <!-- E 230808 tooltip-wrap 추가-->
                              <span>주관식</span>
                              <span>
																<span class="que-badge">중</span>
															</span>
                            </a>
                          </div>
                          <div class="col">
                            <a href="javascript:;">
															<span class="dragHandle ui-sortable-handle"><img
                                  src="../images/common/ico_move_type01.png" alt=""></span>
                              <span></span>
                              <span>7</span>
                              <!-- S 230808 tooltip-wrap 추가-->
                              <span class="tit">
																<div class="txt">대단원&gt;중단원&gt;소단원&gt;토픽</div>
																<div class="tooltip-wrap">
																	<button type="button" class="btn-tip"></button>
																	<div class="tooltip type01">
																		<div class="tool-type01">
																			시험지명블라블라~~시험지명블라블라~~시험지명블라블라~~시험지명블라블라~~시험지명블라블라~~시험지명블라블라~~</div>
																	</div>
																</div>
															</span>
                              <!-- E 230808 tooltip-wrap 추가-->
                              <span>객관식</span>
                              <span>
																<span class="que-badge">하</span>
															</span>
                            </a>
                          </div>
                          <div class="col">
                            <a href="javascript:;">
															<span class="dragHandle ui-sortable-handle"><img
                                  src="../images/common/ico_move_type01.png" alt=""></span>
                              <span></span>
                              <span>8</span>
                              <!-- S 230808 tooltip-wrap 추가-->
                              <span class="tit">
																<div class="txt">대단원&gt;중단원&gt;소단원&gt;토픽</div>
																<div class="tooltip-wrap">
																	<button type="button" class="btn-tip"></button>
																	<div class="tooltip type01">
																		<div class="tool-type01">
																			시험지명블라블라~~시험지명블라블라~~시험지명블라블라~~시험지명블라블라~~시험지명블라블라~~시험지명블라블라~~</div>
																	</div>
																</div>
															</span>
                              <!-- E 230808 tooltip-wrap 추가-->
                              <span>주관식</span>
                              <span>
																<span class="que-badge">중</span>
															</span>
                            </a>
                          </div>
                          <!-- s: 지문 묶음 영역-->
                          <div class="depth-01">
                            <div class="dragHandle ui-sortable-handle drag-type02"><img
                                src="../images/common/ico_move_type01.png" alt=""></div>
                            <div class="col-group">
                              <div class="col depth-02">
                                <a href="javascript:;">
																	<span class="dragHandle ui-sortable-handle drag-type01"><img
                                      src="../images/common/ico_move_type02.png" alt=""></span>
                                  <span>9</span>
                                  <!-- S 230808 tooltip-wrap 추가-->
                                  <span class="tit">
																		<div class="txt">대단원&gt;중단원&gt;소단원&gt;토픽</div>
																		<div class="tooltip-wrap">
																			<button type="button" class="btn-tip"></button>
																			<div class="tooltip type01">
																				<div class="tool-type01">
																					시험지명블라블라~~시험지명블라블라~~시험지명블라블라~~시험지명블라블라~~시험지명블라블라~~시험지명블라블라~~</div>
																			</div>
																		</div>
																	</span>
                                  <!-- E 230808 tooltip-wrap 추가-->
                                  <span>객관식</span>
                                  <span>
																		<span class="que-badge">상</span>
																	</span>
                                </a>
                              </div>
                              <div class="col depth-02">
                                <a href="javascript:;">
																	<span class="dragHandle ui-sortable-handle drag-type01"><img
                                      src="../images/common/ico_move_type02.png" alt=""></span>
                                  <span>10</span>
                                  <!-- S 230808 tooltip-wrap 추가-->
                                  <span class="tit">
																		<div class="txt">자연수의 성질&gt;소인수분해&gt;거듭제곱&gt;거듭제곱으로표현</div>
																		<div class="tooltip-wrap">
																			<button type="button" class="btn-tip"></button>
																			<div class="tooltip type01">
																				<div class="tool-type01">
																					시험지명블라블라~~시험지명블라블라~~시험지명블라블라~~시험지명블라블라~~시험지명블라블라~~시험지명블라블라~~</div>
																			</div>
																		</div>
																	</span>
                                  <!-- E 230808 tooltip-wrap 추가-->
                                  <span>주관식</span>
                                  <span>
																		<span class="que-badge">하</span>
																	</span>
                                </a>
                              </div>
                            </div>
                          </div>
                          <!-- e : 지문 묶음 영역-->
                          <div class="col">
                            <a href="javascript:;">
															<span class="dragHandle ui-sortable-handle"><img
                                  src="../images/common/ico_move_type01.png" alt=""></span>
                              <span></span>
                              <span>11</span>
                              <!-- S 230808 tooltip-wrap 추가-->
                              <span class="tit">
																<div class="txt">대단원&gt;중단원&gt;소단원&gt;토픽</div>
																<div class="tooltip-wrap">
																	<button type="button" class="btn-tip"></button>
																	<div class="tooltip type01">
																		<div class="tool-type01">
																			시험지명블라블라~~시험지명블라블라~~시험지명블라블라~~시험지명블라블라~~시험지명블라블라~~시험지명블라블라~~</div>
																	</div>
																</div>
															</span>
                              <!-- E 230808 tooltip-wrap 추가-->
                              <span>객관식</span>
                              <span>
																<span class="que-badge">하</span>
															</span>
                            </a>
                          </div>
                          <div class="col">
                            <a href="javascript:;">
															<span class="dragHandle ui-sortable-handle"><img
                                  src="../images/common/ico_move_type01.png" alt=""></span>
                              <span></span>
                              <span>12</span>
                              <!-- S 230808 tooltip-wrap 추가-->
                              <span class="tit">
																<div class="txt">대단원&gt;중단원&gt;소단원&gt;토픽</div>
																<div class="tooltip-wrap">
																	<button type="button" class="btn-tip"></button>
																	<div class="tooltip type01">
																		<div class="tool-type01">
																			시험지명블라블라~~시험지명블라블라~~시험지명블라블라~~시험지명블라블라~~시험지명블라블라~~시험지명블라블라~~</div>
																	</div>
																</div>
															</span>
                              <!-- E 230808 tooltip-wrap 추가-->
                              <span>주관식</span>
                              <span>
																<span class="que-badge">중</span>
															</span>
                            </a>
                          </div>
                        </div>
                      </div>
                    </div>
                  </div>
                  <div class="bottom-box">
                    <div class="que-badge-group">
                      <div class="que-badge-wrap">
                        <span class="que-badge gray">객관식</span>
                        <span class="num">35</span>
                      </div>
                      <div class="que-badge-wrap">
                        <span class="que-badge gray">주관식</span>
                        <span class="num">15</span>
                      </div>
                    </div>
                  </div>
                </div>
                <div class="contents">
                  탭 컨텐츠 (2)
                </div>
                <div class="contents">
                  탭 컨텐츠 (3)
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
      <div class="step-btn-wrap">
        <button type="button" class="btn-step">STEP 1 단원 선택</button>
        <button type="button" class="btn-step next">STEP 3 시험지 저장 </button>
      </div>


    </div>
    <div class="dim"></div>

    <!-- 문항 오류 신고 팝업 -->
    <div class="pop-wrap table-type" data-pop="error-report-pop">
      <div class="pop-inner">
        <div class="pop-header">
          <span>문항 오류 신고</span>
          <button type="button" class="pop-close"></button>
        </div>
        <div class="pop-content">
          <table>
            <colgroup>
              <col width="30%">
              <col width="*">
            </colgroup>
            <tbody>
            <tr>
              <th>오류유형</th>
              <td>
                <div class="select-wrap">
                  <button type="button" class="select-btn">문제오류</button>
                  <ul class="select-list">
                    <li>
                      <a href="javascript:;">문제오류</a>
                    </li>
                    <li>
                      <a href="javascript:;">정답오류</a>
                    </li>
                    <li>
                      <a href="javascript:;">풀이오류</a>
                    </li>
                    <li>
                      <a href="javascript:;">이미지오류</a>
                    </li>
                    <li>
                      <a href="javascript:;">유형오류</a>
                    </li>
                    <li>
                      <a href="javascript:;">기타</a>
                    </li>
                  </ul>
                </div>
              </td>
            </tr>
            <tr>
              <th>첨부파일</th>
              <td class="file">
                <input type="text" placeholder="최대 100MB까지 등록가능">
                <button type="button" class="btn-icon">파일 첨부</button>
              </td>
            </tr>
            <tr>
              <th>오류 내용</th>
              <td>
                <textarea name="" id="" cols="30" rows="4" placeholder="오류내용을 간단히 적어주세요. (최대 50자)"></textarea>
              </td>
            </tr>
            </tbody>
          </table>
        </div>
        <div class="pop-footer">
          <button type="button">신고하기</button>
        </div>
      </div>
    </div>

    <!-- 출제범위 팝업 -->
    <div class="pop-wrap scope-type" data-pop="que-scope-pop">
      <div class="pop-inner">
        <div class="pop-header">
          <span>국어 1-1</span>
          <button type="button" class="pop-close"></button>
        </div>
        <div class="pop-content scroll-inner">
          <div class="scope-wrap">
            <ul>1. 새로운 시작
              <li>(1)시의 아름다움
                <span>[1] 포근한 봄</span>
                <span>[2] 포근한 봄</span>
              </li>
              <li>(2)산문의 향기
                <span>[1] 꿩</span>
              </li>
            </ul>
            <ul>2. 세상과 함께 자라는 꿈
              <li>(1) 자료 찾으며 책 읽기
                <span>[1] 버터 플라이</span>
              </li>
              <li>(2) 통일성 있게 글 쓰기</li>
            </ul>
            <ul>3. 언어랑 국어랑 놀자
              <li>(1) 언어의 본질과 국어 생활</li>
              <li>(2) 우리말의 아홉 품사</li>
            </ul>
            <ul>4. 더불어 살아가기
              <li>(1) 문학과 갈등</li>
              <li>(2) 토의하기</li>
            </ul>
            <ul>1. 새로운 시작
              <li>(1)시의 아름다움</li>
              <li>(2)산문의 향기</li>
            </ul>
          </div>
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