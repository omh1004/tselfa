import { createRouter, createWebHistory } from 'vue-router'
import Home from './views/Home.vue'
import UserList from './views/user/UserList.vue'
import UserDetail from './views/user/UserDetail.vue'
import UserForm from './views/user/UserForm.vue'


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
    }
]

const router = createRouter({
    history: createWebHistory(),
    routes
})

export default router