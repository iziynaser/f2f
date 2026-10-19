<template>
    <div>
          {{$t('profiles')}}
              <b-card no-body>
                  <b-tabs pills card>
                        <b-tab :title="$t('personalInfo')">
                            <personalInfo/>                            
                        </b-tab>
                        <b-tab :title="$t('loginHistory')">
                            <loginHistory/> 
                        </b-tab>
                        <b-tab :title="$t('authorities')">
                            <authorityInfo/>    
                        </b-tab>
                        <b-tab :title="$t('address')">
                            <!-- <myAddress/> -->
                        </b-tab>
                        <b-tab :title="$t('emails')">
                            <emails/>
                        </b-tab>
                  </b-tabs>
              </b-card>
    </div>
</template>

<script>

import loginHistory from './loginHistory'
import personalInfo from './personalInfo'
//import myAddress from './myAddress'
import emails from './emails'
import authorityInfo from './authorityInfo'

export default {
    name:'createProfiles',
    props:{
          } ,
    data(){
      return {
        
      }
    } ,
    methods:{

    },
    components:{
        loginHistory,
        personalInfo,
        //myAddress,
        emails,
        authorityInfo
    }
}
</script>

<style scoped>

</style>