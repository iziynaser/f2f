<template>
    <div>

                  <b-table striped hover :items="searchResult" small
                           :fields="searchFields"  head-variant="dark" responsive caption-top  
                           :busy="isBusy"
                           >
                           <template v-slot:table-caption>login history</template>   
                           <template v-slot:table-busy>
                                 <div class="text-center text-danger my-2">
                                    <b-spinner class="align-middle"></b-spinner>
                                    <strong>loading</strong>
                                 </div>  
                           </template>
                           <template v-slot:cell(index)="data">
                                 {{data.index+1}}
                           </template>                           
                           <template v-slot:cell(device)="data">
                                 {{data.item.device.substring(1,50)}} 
                           </template>
                  </b-table>                
        
            </div>
</template>

<script>

import axiosInstance from '@/api/axiosInstance';

export default {
    name:'loginHistory',
    props:{
          } ,
    data(){
      return {
        errors:{},
        isBusy:false,
        searchResult:[],    
        searchFields:[
              {key:'index',label: this.$t('index')},
              {key:'ip',label: this.$t('ip')},
              {key:'device',label: this.$t()},
              {key:'username',label: this.$t('username')},
              {key:'clientId',label: this.$t('clientId')},
              {key:'dateCreated',label: this.$t('dateCreated')}
        ],          
      }
    } ,
    methods:{
          loadListOfLoginHistory(){
                console.log('load list of login history called');
                  var self = this;
            axiosInstance({
                        method:'GET',
                        url:'/loginHistory/',
                        withCredentials:true
                  })
                  .then(function (res) {
                        console.log('login history');
                        self.searchResult = res.data.data; 
                  }).catch(function (error) {              
                        console.log(error);              
                  }) ;
          }
    },
    mounted(){
          this.loadListOfLoginHistory();
    }
}
</script>

<style scoped>

</style>