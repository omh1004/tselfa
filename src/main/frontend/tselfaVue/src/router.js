import { createRouter, createWebHistory } from 'vue-router'
import Home from './views/Home.vue'
import UserList from './views/user/UserList.vue'
import UserDetail from './views/user/UserDetail.vue'
import UserForm from './views/user/UserForm.vue'
import error from "./views/quizbank/error.vue";
import loading from "./views/quizbank/loading.vue";
import sub01 from "./views/quizbank/sub01.vue";
import sub02 from "./views/quizbank/sub02.vue";
import sub03_01 from "./views/quizbank/sub03_01.vue";
import sub03_01_01 from "./views/quizbank/sub03_01_01.vue";
import sub03_02_01 from "./views/quizbank/sub03_02_01.vue";
import sub03_02_02 from "./views/quizbank/sub03_02_02.vue";
import sub03_03 from "./views/quizbank/sub03_03.vue";
import sub04_01 from "./views/quizbank/sub04_01.vue";
import sub04_02 from "./views/quizbank/sub04_02.vue";


const routes = [
    {
        path: '/',
        name: 'Home',
        component: Home
    },
    {
        path: '/users',
        name: 'UserList',
        component: UserList
    },
    {
        path: '/users/:id',
        name: 'UserDetail',
        component: UserDetail,
        props: true
    },
    {
        path: '/users/new',
        name: 'UserCreate',
        component: UserForm
    },
    {
        path: '/users/:id/edit',
        name: 'UserEdit',
        component: UserForm,
        props: true
    },
    {
        path: '/about',
        name: 'About',
        // 라우트 레벨 코드 스플리팅
        component: () => import('./views/About.vue')
    },

// 이 아래는 테스트용. 배포에 사용 안 함
    {
        path:'/error',
        name:'error',
        component:error,
    },
    {
        path:'/loading',
        name:'loading',
        component:loading,
    },
    {
        path:'/sub01',
        name:'sub01',
        component:sub01,
    },
    {
        path:'/sub02',
        name:'sub02',
        component:sub02,
    },
    {
        path:'/sub03_01',
        name:'sub03_01',
        component:sub03_01,
    },
    {
        path:'/sub03_01_01',
        name:'sub03_01_01',
        component:sub03_01_01,
    },
    {
        path:'/sub03_02_01',
        name:'sub03_02_01',
        component:sub03_02_01,
    },
    {
        path:'/sub03_02_02',
        name:'sub03_02_02',
        component:sub03_02_02,
    },
    {
        path:'/sub03_03',
        name:'sub03_03',
        component:sub03_03,
    },
    {
        path:'/sub04_01',
        name:'sub04_01',
        component:sub04_01,
    },
    {
        path:'/sub04_02',
        name:'sub04_02',
        component:sub04_02,
    }
]

const router = createRouter({
    history: createWebHistory(),
    routes
})

export default router