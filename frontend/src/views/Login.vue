<script setup>
import {ref} from 'vue';import axios from 'axios';import {useRouter} from 'vue-router';
const u=ref('admin');const p=ref('admin123');const r=useRouter();
const login=async()=>{const res=await axios.post(import.meta.env.VITE_API_BASE_URL+'/login',{username:u.value,password:p.value});if(res.data.code===200){localStorage.setItem('user',JSON.stringify(res.data.data));r.push('/home')}else alert(res.data.message)}
</script><template><div><h2>登录</h2><input v-model='u'/><input type='password' v-model='p'/><button @click='login'>登录</button></div></template>
