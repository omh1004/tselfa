<template>
    <div class="home-container">
      <div class="jumbotron bg-light p-5 rounded">
        <h1 class="display-4">사용자 관리 시스템</h1>
        <p class="lead">이 시스템은 강사 사용자를 관리하기 위한 간단한 웹 애플리케이션입니다.</p>
        <hr class="my-4">
        <p>사용자를 등록, 조회, 수정, 삭제할 수 있습니다.</p>
        <router-link to="/users" class="btn btn-primary btn-lg">사용자 관리 시작하기</router-link>
      </div>
      
      <div class="row mt-5">
        <div class="col-md-4 mb-4">
          <div class="card h-100">
            <div class="card-body">
              <h5 class="card-title">사용자 조회</h5>
              <p class="card-text">등록된 모든 사용자를 조회하고 상세 정보를 확인할 수 있습니다.</p>
              <router-link to="/users" class="btn btn-outline-primary">사용자 목록</router-link>
            </div>
          </div>
        </div>
        
        <div class="col-md-4 mb-4">
          <div class="card h-100">
            <div class="card-body">
              <h5 class="card-title">사용자 등록</h5>
              <p class="card-text">새로운 사용자를 시스템에 등록할 수 있습니다.</p>
              <router-link to="/users/new" class="btn btn-outline-success">사용자 등록</router-link>
            </div>
          </div>
        </div>
        
        <div class="col-md-4 mb-4">
          <div class="card h-100">
            <div class="card-body">
              <h5 class="card-title">시스템 정보</h5>
              <p class="card-text">이 시스템에 대한 자세한 정보를 확인할 수 있습니다.</p>
              <router-link to="/about" class="btn btn-outline-info">자세히 보기</router-link>
            </div>
          </div>
        </div>
      </div>
    </div>
  </template>
  
  <script>
  export default {
    name: 'Home'
  }
  </script>
  
  <style scoped>
  .home-container {
    max-width: 1200px;
    margin: 0 auto;
  }
  </style>