<template>
  <div>
    <h2>사용자 목록</h2>

    <div v-if="isLoading" class="text-center my-5">
      <div class="spinner-border" role="status">
        <span class="visually-hidden">로딩 중...</span>
      </div>
    </div>

    <div v-else-if="users.length === 0" class="alert alert-info">
      등록된 사용자가 없습니다.
    </div>

    <div v-else class="table-responsive">
      <table class="table table-striped">
        <thead>
        <tr>
          <th>강사코드</th>
          <th>이름</th>
          <th>닉네임</th>
          <th>이메일</th>
          <th>전화번호</th>
          <th>가입일</th>
          <th>작업</th>
        </tr>
        </thead>
        <tbody>
        <tr v-for="user in users" :key="user.instCode">
          <td>{{ user.instCode }}</td>
          <td>{{ user.name }}</td>
          <td>{{ user.nick }}</td>
          <td>{{ user.email }}</td>
          <td>{{ user.phone }}</td>
          <td>{{ formatDate(user.joinDt) }}</td>
          <td>
            <div class="btn-group">
              <router-link :to="`/users/${user.instCode}`" class="btn btn-sm btn-info">
                보기
              </router-link>
              <router-link :to="`/users/${user.instCode}/edit`" class="btn btn-sm btn-warning mx-1">
                수정
              </router-link>
              <button @click="deleteUser(user.instCode)" class="btn btn-sm btn-danger">
                삭제
              </button>
            </div>
          </td>
        </tr>
        </tbody>
      </table>
    </div>
  </div>
</template>

<script>
import { computed, onMounted } from 'vue'


export default {
  name: 'UserList',
  setup() {
    const store = useStore()

    // 컴포넌트 마운트 시 사용자 목록 조회
    onMounted(() => {
      store.dispatch('fetchUsers')
    })

    // Vuex 상태 조회
    const users = computed(() => store.getters.getUsers)
    const isLoading = computed(() => store.state.loading)

    // 사용자 삭제 핸들러
    const deleteUser = async (id) => {
      if (confirm('이 사용자를 정말 삭제하시겠습니까?')) {
        await store.dispatch('deleteUser', id)
      }
    }

    // 날짜 포맷팅 함수
    const formatDate = (dateString) => {
      if (!dateString) return '-'
      const date = new Date(dateString)
      return date.toLocaleDateString('ko-KR')
    }

    return {
      users,
      isLoading,
      deleteUser,
      formatDate
    }
  }
}
</script>