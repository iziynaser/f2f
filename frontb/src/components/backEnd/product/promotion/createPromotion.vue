<template>
    <div>
          product poromotion
              <b-card no-body>
                  <b-tabs pills card>
                        <b-tab :title="this.$t('PRODUCT_POROMO_TITLE')">
                            <cPromoMain/>
                        </b-tab>
                        <b-tab :title="this.$t('PRODUCT_POROMO_STORES')">
                            <cPromoRule/>
                        </b-tab>
                         <b-tab :title="this.$t('PRODUCT_POROMO_RULES')">
                            <cPromoStore/> 
                         </b-tab>   
                        <b-tab :title="this.$t('PRODUCT_POROMO_RESTRICT')">
                            <cPromoRestrict/> 
                        </b-tab> 
                  </b-tabs>
              </b-card>
    </div>
</template>

<script>

import cPromoMain from './cPromoMain'
import cPromoRule from './cPromoRule'
import cPromoStore from './cPromoStore'

export default {
    name:'createPromotion',
    props:{
          } ,
    data(){
      return {
        
      }
    } ,
    methods:{

    },
    components:{
        cPromoMain,
        cPromoRule,
        cPromoStore   
    }
}
</script>

<style scoped>

</style>