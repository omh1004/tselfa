import { defineStore } from 'pinia';
import UserApiService from "./UserApiService.js";

export const useStore = defineStore('useStore',{
    state:()=>({
        loading:false,
    }),
    getters:{
        getUsers:()=>{
            const userList = UserApiService.getAllUsers();
            return userList;
        }
    }
})