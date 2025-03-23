<template>
    <div class="about-container">
      <h1>사용자 관리 시스템 소개</h1>
      <div class="card mt-4">
        <div class="card-body">
          <h5 class="card-title">프로젝트 정보</h5>
          <p class="card-text">
            이 프로젝트는 Spring Boot와 Vue.js를 사용하여 만든 사용자 관리 시스템입니다.
            사용자를 추가, 조회, 수정, 삭제할 수 있는 기능을 제공합니다.
          </p>
        </div>
      </div>
      
      <div class="card mt-4">
        <div class="card-body">
          <h5 class="card-title">기술 스택</h5>
          <ul class="list-group list-group-flush">
            <li class="list-group-item">프론트엔드: Vue.js 3, Vue Router, 기본 Fetch API</li>
            <li class="list-group-item">백엔드: Spring Boot, Spring Data JPA</li>
            <li class="list-group-item">데이터베이스: MySQL/H2</li>
          </ul>
        </div>
      </div>
      
      <div class="card mt-4">
        <div class="card-body">
          <h5 class="card-title">기능</h5>
          <ul class="list-group list-group-flush">
            <li class="list-group-item">사용자 목록 조회</li>
            <li class="list-group-item">사용자 상세 정보 조회</li>
            <li class="list-group-item">사용자 등록</li>
            <li class="list-group-item">사용자 정보 수정</li>
            <li class="list-group-item">사용자 삭제</li>
          </ul>
        </div>
      </div>
      
      <div class="mt-4">
        <router-link to="/" class="btn btn-primary">홈으로 돌아가기</router-link>
      </div>
    </div>
  </template>
  
  <script>
  export default {
    name: 'About'
  }
  </script>
  
  <style scoped>
  .about-container {
    max-width: 800px;
    margin: 0 auto;
    padding: 20px 0;
  }
  </style>