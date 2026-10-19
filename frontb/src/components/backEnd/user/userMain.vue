<template>
    <div>
          user main
              <b-card no-body>
                  <b-tabs pills card>
                        <b-tab :title="$t('user_list')">
                            <userList :items="items" @bClicked="setIndexes"/>
                        </b-tab>
                        <b-tab :title="$t('user_roles')">
                            <userRoles :items="roles" /> 
                        </b-tab>
                        <b-tab :title="$t('user_additional')">
                            <userDetails :userDetailsForm="userDetailsForm" />    
                        </b-tab>
                        <b-tab :title="$t('user_setting')">
                            <userSettings />
                        </b-tab>
                  </b-tabs>
              </b-card>
    </div>
</template>

<script>

import * as axios from 'axios';

import userList from './userList'
import userRoles from './userRoles'
import userDetails from './userDetails'

export default {
    name:'userMain',
    props:{
          } ,
    data(){
      return {
          items:[], 
          roles:[],
          userId:0,  
          userDetailsForm:{
              nickName:'',
              mobile:'',
              city:'',
              address:''
          } 
      }
    } ,
    methods:{
        listOfUserDetails(){
                var self = this;
                this.errors= {};
                this.isBusy = true;
                axios({
                    method:'GET',
                    url:'/management/user/details',
                    params:{
                        id:this.userId,
                    }
                })
                .then(function(res){
                      console.log(res.data);  
                      self.userDetailsForm.nickName = res.data.nickName;
                      self.userDetailsForm.mobile = res.data.mobile ;
                      self.userDetailsForm.city = res.data.city ;
                      self.userDetailsForm.address = res.data.address ;
                })
                .catch(function(error){
                    console.log(error)    ;
                });
        },
        setIndexes(selectedItems){
            if(selectedItems.length>0)  {
                 this.roles = selectedItems[0].roles;
                 this.userId = selectedItems[0].id;
                 this.listOfUserDetails();
            }          
        },
        listOfUsers(){
                var self = this;
                this.errors= {};
                this.isBusy = true;
                axios({
                    method:'GET',
                    url:'/management/user/list',
                })
                .then(function(res){
                      //console.log(res.data);  
                      self.items = res.data.data; 
                })
                .catch(function(error){
                    console.log(error)    ;
                });
        },
    },
    components:{
        userList ,
        userRoles ,
        userDetails
    },
    mounted(){
            this.listOfUsers();
    }   ,
    computed:{
    }
}
</script>

<style scoped>

</style>