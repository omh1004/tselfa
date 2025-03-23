<template>
  <div>
    <h2>사용자 상세 정보</h2>

    <div v-if="isLoading" class="text-center my-5">
      <div class="spinner-border" role="status">
        <span class="visually-hidden">로딩 중...</span>
      </div>
    </div>

    <div v-else-if="!user" class="alert alert-danger">
      사용자 정보를 찾을 수 없습니다.
    </div>

    <div v-else>
      <div class="card mb-4">
        <div class="card-header d-flex justify-content-between align-items-center">
          <h5 class="mb-0">{{ user.name }} ({{ user.nick || '닉네임 없음' }})</h5>
          <div>
            <router-link :to="`/users/${user.instCode}/edit`" class="btn btn-sm btn-warning me-2">
              수정
            </router-link>
            <button @click="confirmDelete" class="btn btn-sm btn-danger">
              삭제
            </button>
          </div>
        </div>
        <div class="card-body">
          <div class="row mb-3">
            <div class="col-md-3 fw-bold">강사 코드:</div>
            <div class="col-md-9">{{ user.instCode }}</div>
          </div>
          <div class="row mb-3">
            <div class="col-md-3 fw-bold">아이디:</div>
            <div class="col-md-9">{{ user.userId }}</div>
          </div>
          <div class="row mb-3">
            <div class="col-md-3 fw-bold">이메일:</div>
            <div class="col-md-9">{{ user.email }}</div>
          </div>
          <div class="row mb-3">
            <div class="col-md-3 fw-bold">전화번호:</div>
            <div class="col-md-9">{{ user.phone || '없음' }}</div>
          </div>
          <div class="row mb-3">
            <div class="col-md-3 fw-bold">가입일:</div>
            <div class="col-md-9">{{ formatDate(user.joinDt) }}</div>
          </div>
          <div class="row mb-3">
            <div class="col-md-3 fw-bold">마지막 로그인:</div>
            <div class="col-md-9">{{ formatDate(user.loginDt) || '로그인 기록 없음' }}</div>
          </div>
        </div>
      </div>

      <div class="d-flex gap-2">
        <router-link to="/users" class="btn btn-secondary">
          목록으로
        </router-link>
      </div>
    </div>
  </div>
</template>

<script>
import { ref, onMounted } from 'vue'
import { useRouter } from 'vue-router'
import UserApiService from '../services/UserApiService'

export default {
  name: 'UserDetail',
  props: {
    id: {
      type: String,
      required: true
    }
  },
  setup(props) {
    const router = useRouter()
    const user = ref(null)
    const isLoading = ref(false)

    // 사용자 정보 로드
    const loadUser = async () => {
      isLoading.value = true
      try {
        user.value = await UserApiService.getUserById(props.id)
      } catch (error) {
        console.error('사용자 정보 로딩 오류:', error)
      } finally {
        isLoading.value = false
      }
    }

    // 컴포넌트 마운트 시 사용자 정보 로드
    onMounted(() => {
      loadUser()
    })

    // 사용자 삭제 확인
    const confirmDelete = async () => {
      if (confirm(`${user.value.name} 사용자를 정말 삭제하시겠습니까?`)) {
        isLoading.value = true
        try {
          await UserApiService.deleteUser(props.id)
          router.push('/users')
        } catch (error) {
          console.error('사용자 삭제 오류:', error)
        } finally {
          isLoading.value = false
        }
      }
    }

    // 날짜 포맷팅 함수
    const formatDate = (dateString) => {
      if (!dateString) return null
      const date = new Date(dateString)
      return date.toLocaleDateString('ko-KR')
    }

    return {
      user,
      isLoading,
      confirmDelete,
      formatDate
    }
  }
}
</script>