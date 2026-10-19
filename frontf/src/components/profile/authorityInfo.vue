<template>
    <div>
        <!-- authority information -->
        <!-- <b-collapse id="loginHistory"> -->
          <b-card>
              <!-- <b-card-header>authority information </b-card-header> -->
              <b-list-group v-for="authority in userAuthorities" :key="authority">
                <b-list-group-item>{{authority}}</b-list-group-item>
              </b-list-group>   
          </b-card>          
      <!-- </b-collapse> -->
    </div>
</template>

<script>

import axiosInstance from '@/api/axiosInstance';

export default {
    name:'authorityInfo',
    props:{
          } ,
    data(){
      return {
              userAuthorities:[],
      }
    } ,
    methods:{
        doGetAuthorities:function(){
              let self = this;
          axiosInstance({
                method:'GET',
                url:'/user/me',
                withCredentials:true
              })
              .then(function (response) {                
                self.userAuthorities = response.data.authorities;
                self.nickName = response.data.nickName;
                //console.log(response.data.authorities);  
          }).catch(function (error) {              
              console.log(error);              
        }) ;          
        },
    },
    mounted(){
      this.doGetAuthorities();
    },      
}
</script>

<style scoped>

</style>