<template>
  <div>
    <label class="border" v-if="errorMessage">{{errorMessage}}</label>
      <b-form>
        <b-form-group>      
          <b-row>
            <b-col class="col-2">{{$t('LOGIN_username')}}</b-col>
            <b-col class="col-4">
              <b-form-input id="username" v-model="form.username"  :placeholder="this.$t('LOGIN_usernamePlaceHolder')" />
            </b-col>
          </b-row>
      </b-form-group>
      <b-form-group>
          <b-row>
            <b-col class="col-2">{{$t('LOGIN_password')}}</b-col>
            <b-col class="col-4">
              <b-form-input  id="password" type="password" v-model="form.password"  required :placeholder="this.$t('LOGIN_passwordPlaceHolder')" />
            </b-col>
          </b-row>
      </b-form-group>
      <b-form-group>
                <b-button variant="success" @click="doLoginWithDefaultData()">register</b-button>
                
                <!-- <b-button variant="danger" @click="checkTokenIsValid()">
                    checkTokenIsValid
                </b-button> -->

      </b-form-group>      
      </b-form>
  </div>  
</template>

<script>

import {mapActions} from 'vuex'
import axios from 'axios'
import store from '../store'

  export default {
      name:'login',
      data(){
        return{
        errorMessage:'',
        errors:[],
        visible : true,
        isDebugEnabled: true,
        globalErrorMessage:'',          
          form:{
              username:'',
              password:''
          }
        }
      },
      methods:{
...mapActions(['finalizeLogin','login']),          
doLoginWithDefaultData(){

var self = this;//.errorMessage;
console.log('username:',self.form.username,',password:',self.form.password);
axios.get('/oauth/token',{
  params:{
     client_id:'SampleClientId',
     client_secret:'tgb.258',
     grant_type:'password',
     scope:'user_info',
     username:self.form.username,
     password:self.form.password
  }
})
     .then(function (response) {    
                store.dispatch('finalizeLogin',response.data)
        }).catch(function (error) {
            //self.errorMessage=error.response.data.error_description;
            //console.log(self.errorMessage);
            if(error.message.includes("invalid token"))
            self.$store.commit("showToast",self.$t('LOGIN_INVALID_USERNAME_PASSWORD'));
        }) ;
} ,


checkTokenIsValid:()=>{ 
  //var token = "e5f4a9ea-3c94-4890-bc08-cc60a65657f9";
  var token = this.$store.
  axios({
    method: 'get',
    url: '/oauth/check_token',  
    params:{
      token: {token}
    }
  }).then(function (response) {
      console.log(response);
      console.log(response.data);
  })
    .catch(function (error) {
        console.log(error);
        console.log(error.data);
  }) ;
}


      },
      
      }
</script>
