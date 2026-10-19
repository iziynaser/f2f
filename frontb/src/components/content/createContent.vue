<template>
    <div>
          <!-- create content view -->
              <b-card no-body>
                  <b-tabs pills card>
                        <b-tab :title="this.$t('C_WEB_MAIN_TITLE')">
                            <cwebMain/>
                        </b-tab>
                        <b-tab :title="this.$t('C_WEB_SOCIAL_TITLE')">
                            <cwebSocial/>
                        </b-tab>
                         <b-tab :title="this.$t('C_WEB_OTHER_SETTING')">
                            <cwebOther/>
                         </b-tab>   
                  </b-tabs>
              </b-card>
    </div>
</template>

<script>

import cwebSocial from './websites/cwebSocial'
import cwebMain from './websites/cwebMain'
import cwebOther from './websites/cwebOther'

export default {
    name:'createContent',
    props:{
          } ,
    data(){
      return {
        
      }
    } ,
    methods:{

    },
    components:{
      cwebSocial ,
      cwebMain ,
      cwebOther
    }
}
</script>

<style scoped>

</style>