<template>
    <div>

          <b-card v-show="!isEditFormMode">
              <b-card-header>breif personal information </b-card-header>
              <div ref="viewPersonalInfo">
                <b-row>
                  <b-col>{{$t('PROFILE_PERSONAL_INFO_nickName')}}</b-col>
                  <b-col>{{personalInfo.nickName}}</b-col>
                  <b-col>{{$t('PROFILE_PERSONAL_INFO_mobile')}}</b-col>
                  <b-col>{{personalInfo.mobile}}</b-col>
                </b-row>
                <b-row>
                  <b-col>{{$t('PROFILE_PERSONAL_INFO_email')}}</b-col>
                  <b-col>{{personalInfo.email}}</b-col>
                  <b-col>{{$t('PROFILE_PERSONAL_INFO_city')}}</b-col>
                  <b-col>{{personalInfo.city}}</b-col>
                </b-row>
                <b-row>
                  <b-col>{{$t('PROFILE_PERSONAL_INFO_birthday')}}</b-col>
                  <b-col>{{personalInfo.birthday}}</b-col>
                  <b-col>{{$t('PROFILE_PERSONAL_INFO_gender')}}</b-col>
                  <b-col>{{personalInfo.gender}}</b-col>
                </b-row>
                <b-row>
                  <b-col>{{$t('PROFILE_PERSONAL_INFO_username')}}</b-col>
                  <b-col>{{personalInfo.username}}</b-col>
                  <b-col>{{$t('PROFILE_PERSONAL_INFO_province')}}</b-col>
                  <b-col>{{personalInfo.province}}</b-col>
                </b-row>
                <b-row>
                  <b-col>{{$t('PROFILE_PERSONAL_INFO_address')}}</b-col>
                  <b-col>{{personalInfo.address}}</b-col>
                </b-row>
              </div>
              <hr/>
              <b-link @click="editOrSavePersonalInfo">edit</b-link>
          </b-card>       
          <b-card v-show="isEditFormMode">
              <b-card-header>breif personal information </b-card-header>
              <div ref="editPersonalInfo">
                <b-row class="my-1">
                  <b-col>{{$t('PROFILE_PERSONAL_INFO_nickName')}}</b-col>
                  <b-col><b-input/></b-col>
                  <b-col>{{$t('PROFILE_PERSONAL_INFO_mobile')}}</b-col>
                  <b-col><b-input/></b-col>
                </b-row>
                <b-row class="my-1">
                  <b-col>{{$t('PROFILE_PERSONAL_INFO_email')}}</b-col>
                  <b-col><b-input/></b-col>
                  <b-col>{{$t('PROFILE_PERSONAL_INFO_city')}}</b-col>
                  <b-col><b-input/></b-col>
                </b-row>
                <b-row class="my-1">
                  <b-col>{{$t('PROFILE_PERSONAL_INFO_birthday')}}</b-col>
                  <b-col><b-input/></b-col>
                  <b-col>{{$t('PROFILE_PERSONAL_INFO_gender')}}</b-col>
                  <b-col><b-input/></b-col>
                </b-row>
                <b-row class="my-1">
                  <b-col>{{$t('PROFILE_PERSONAL_INFO_username')}}</b-col>
                  <b-col><b-input/></b-col>
                  <b-col>{{$t('PROFILE_PERSONAL_INFO_province')}}</b-col>
                  <b-col><b-input/></b-col>
                </b-row>
                <b-row class="my-1">
                  <b-col>{{$t('PROFILE_PERSONAL_INFO_address')}}</b-col>
                  <b-col><b-input/></b-col>
                </b-row>
              </div>
              <hr/>
              <b-link @click="editOrSavePersonalInfo">save</b-link>
          </b-card>       
    </div>
</template>

<script>

import axiosInstance from '@/api/axiosInstance';

export default {
    name:'personalInfo',
    props:{
          } ,
    data(){
        return{
          isEditFormMode:false,
          visible:true,
          errors:[],
          //userAuthorities:[],
          nickName:'',          
          // emailAddress:{
          //   emailType:'',
          //   email:'',
          //   personId:''
          // },
          personalInfo:{
            birthday: '' ,
            address: '',
            gender: '',
            province: '',
            city: '',
            nickName: '',
            mobile: '',
            email: '',
            username: '',
          },
        isDebugEnabled: true,
        globalErrorMessage:''
        }
    } ,
    methods:{
        editOrSavePersonalInfo:function(){
          this.isEditFormMode = !this.isEditFormMode;
        },
        addNewEmailAddressToUser:function(){
          const token = window.localStorage.getItem('access_token');
          let vx = {
                     address:"eeeee@test.com",
                     fullName:"naser iziy",
                     addressType:{
                        id:"1",
                        name:"personal adress type",
                        description:"this is personal adress type"
                     },
                     access_token: token
                  };

          axiosInstance({
                method:'POST',
                url:'/emailAdress/create',
                data: JSON.stringify(vx),
                params: vx,
                headers:{ 
                  'Authorization': 'Bearer ' + token ,
                  'Content-Type' : 'application/json'
                },
                withCredentials:true,
                json:true,
                crossorigin:true
              })
              .then(function (response) {
                console.log(response);
          }).catch(function (error) {              
              console.log(error);              
        }) ;

           // axios.post('/emailAdress/create',vx,{headers: {Authorization:"Bearer "+token}})

        },
          doUserProfile:function(){ 
            let self = this;
            axiosInstance({
                method:'GET',
                url:'/userProfile',
              })
              .then(function (response) {
                if(response){
                    self.personalInfo.birthday = response.data.birthday;
                    self.personalInfo.address = response.data.address ;
                    self.personalInfo.gender = response.data.gender ;
                    self.personalInfo.province = response.data.province ;
                    self.personalInfo.city = response.data.city ;
                    self.personalInfo.nickName = response.data.nickName ;
                    self.personalInfo.mobile = response.data.mobile ;
                    self.personalInfo.email = response.data.email ;
                    self.personalInfo.username = response.data.username ;
                    //this.$refs.editPersonalInfo
                    //this.$refs.viewPersonalInfo

                }else{
                  //this.$refs.editPersonalInfo.display=none;
                  //this.$refs.viewPersonalInfo.display= none;
                }
          }).catch(function (error) {              
              console.log(error);              
        }) ;
      } ,

    }   ,
    mounted(){
      this.doUserProfile();
    }   
}
</script>

<style scoped>

</style>