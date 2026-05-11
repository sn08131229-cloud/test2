import { createApp } from 'vue';import {createRouter,createWebHistory} from 'vue-router';import Login from './views/Login.vue';import Home from './views/Home.vue';
const router=createRouter({history:createWebHistory(),routes:[{path:'/',component:Login},{path:'/home',component:Home}]});
createApp({template:'<router-view />'}).use(router).mount('#app');
