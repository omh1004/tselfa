<template>
  <div id="app">
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
      <div class="container">
        <router-link class="navbar-brand" to="/">사용자 관리 시스템</router-link>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
          <ul class="navbar-nav">
            <li class="nav-item">
              <router-link class="nav-link" to="/">홈</router-link>
            </li>
            <li class="nav-item">
              <router-link class="nav-link" to="/users">사용자 목록</router-link>
            </li>
            <li class="nav-item">
              <router-link class="nav-link" to="/users/new">사용자 등록</router-link>
            </li>
            <li class="nav-item">
              <router-link class="nav-link" to="/about">소개</router-link>
            </li>
            <li class="nav-item">
              <a href="#" @click="popup">T셀파</a>
            </li>
          </ul>
        </div>
      </div>
    </nav>

    <div class="container mt-4">
      <router-view />
    </div>

    <footer class="bg-light text-center text-lg-start mt-5">
      <div class="text-center p-3" style="background-color: rgba(0, 0, 0, 0.05);">
        © 2025 사용자 관리 시스템
      </div>
    </footer>
  </div>
</template>

<script>
export default {
  name: 'App',
  methods:{
    popup(){
      window.open('http://localhost:3000/sub01','_blank','width=1600,height=900')
    }
  }
}
</script>

<style>
#app {
  font-family: 'Noto Sans KR', sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  min-height: 100vh;
  display: flex;
  flex-direction: column;
}

.container {
  flex: 1;
}
</style>