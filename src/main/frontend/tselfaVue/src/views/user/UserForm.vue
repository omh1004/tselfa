<template>
  <div>
    <h2>{{ isEditing ? '사용자 수정' : '사용자 등록' }}</h2>

    <div v-if="isLoading" class="text-center my-5">
      <div class="spinner-border" role="status">
        <span class="visually-hidden">로딩 중...</span>
      </div>
    </div>

    <form v-else @submit.prevent="submitForm" class="mt-4">
      <div class="mb-3">
        <label for="instCode" class="form-label">강사코드</label>
        <input
            type="text"
            class="form-control"
            id="instCode"
            v-model="formData.instCode"
            :disabled="isEditing"
            required
        >
      </div>

      <div class="mb-3">
        <label for="userId" class="form-label">아이디</label>
        <input
            type="text"
            class="form-control"
            id="userId"
            v-model="formData.userId"
            required
        >
      </div>

      <div class="mb-3">
        <label for="pwd" class="form-label">비밀번호</label>
        <input
            type="password"
            class="form-control"
            id="pwd"
            v-model="formData.pwd"
            :required="!isEditing"
        >
        <div class="form-text" v-if="isEditing">변경하지 않으려면 비워두세요.</div>
      </div>

      <div class="mb-3">
        <label for="name" class="form-label">이름</label>
        <input
            type="text"
            class="form-control"
            id="name"
            v-model="formData.name"
            required
        >
      </div>

      <div class="mb-3">
        <label for="nick" class="form-label">닉네임</label>
        <input
            type="text"
            class="form-control"
            id="nick"
            v-model="formData.nick"
        >
      </div>

      <div class="mb-3">
        <label for="email" class="form-label">이메일</label>
        <input
            type="email"
            class="form-control"
            id="email"
            v-model="formData.email"
            required
        >
      </div>

      <div class="mb-3">
        <label for="phone" class="form-label">전화번호</label>
        <input
            type="tel"
            class="form-control"
            id="phone"
            v-model="formData.phone"
        >
      </div>

      <div class="d-flex gap-2">
        <button type="submit" class="btn btn-primary" @click="submitForm">
          {{ isEditing ? '수정' : '등록' }}
        </button>
        <button type="button" class="btn btn-secondary" @click="goBack">
          취소
        </button>
      </div>
    </form>
  </div>
</template>

<script>
import { ref, computed, onMounted } from 'vue'
import { useRouter, useRoute } from 'vue-router'
import UserApiService from '../services/UserApiService'

export default {
  name: 'UserForm',
  props: {
    id: {
      type: String,
      required: false
    }
  },
  setup(props) {
    const router = useRouter()
    const route = useRoute()
    const isLoading = ref(false)

    const formData = ref({
      instCode: '',
      userId: '',
      pwd: '',
      name: '',
      nick: '',
      email: '',
      phone: '',
      joinDt: null,
      loginDt: null,
      wdDt: null
    })

    const isEditing = computed(() => !!props.id)

    // 수정 모드일 경우 기존 사용자 정보 불러오기
    onMounted(async () => {
      if (isEditing.value) {
        isLoading.value = true
        try {
          const user = await UserApiService.getUserById(props.id)
          // 비밀번호는 보안상 제외하고 나머지 정보만 폼에 채움
          const { pwd, ...userData } = user
          Object.assign(formData.value, userData)
        } catch (error) {
          console.error('사용자 정보 로딩 오류:', error)
        } finally {
          isLoading.value = false
        }
      }
    })

    // 폼 제출 처리
    const submitForm = async () => {
      isLoading.value = true
      try {
        if (isEditing.value) {
          // 비밀번호가 비어있으면 제외 (기존 비밀번호 유지)
          const updateData = { ...formData.value }
          if (!updateData.pwd) {
            delete updateData.pwd
          }

          await UserApiService.updateUser(props.id, updateData)
          router.push(`/users/${props.id}`)
        } else {
          // 신규 등록 시 현재 날짜 자동 설정
          formData.value.joinDt = new Date().toISOString().substr(0, 10)

          const newUser = await UserApiService.createUser(formData.value)
          router.push(`/users/${newUser.instCode}`)
        }
      } catch (error) {
        console.error('폼 제출 오류:', error)
      } finally {
        isLoading.value = false
      }
    }

    // 뒤로가기 함수
    const goBack = () => {
      router.back()
    }

    return {
      formData,
      isLoading,
      isEditing,
      submitForm,
      goBack
    }
  }
}
</script>