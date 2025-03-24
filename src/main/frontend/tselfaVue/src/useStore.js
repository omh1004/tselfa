import { defineStore } from 'pinia';
import UserApiService from "./UserApiService.js";

export const useStore = defineStore('useStore',{
    state:()=>({
        loading:true,
    }),
    getters:{
        getUsers:async ()=>{
            const userList = await UserApiService.getAllUsers();
            this.loading = false;
            return userList;
        }
    }
})