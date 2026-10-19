<template>
    <div>

        <b-card no-body>
            <b-tabs pills card vertical>
                <b-tab :title="this.$t('AdressMain_selectFromExisting')">
                    <AdressContent/>
                </b-tab>
                <b-tab title="select adress company">
                    <AdressCompany/>
                </b-tab>
                <b-tab :title="this.$t('AdressMain_addNewAdress')">
                    <AdressCreate/>
                </b-tab>
            </b-tabs>
        </b-card>

    </div>
</template>

<script>

import AdressCreate from './AdressCreate'
import AdressContent from './AdressContent'
import AdressCompany from './AdressCompany'

export default {
    name:'AdressMain',
    components:{
        AdressCreate,AdressContent,AdressCompany
    },
    props:{
          } ,
    data(){
      return {
        
      }
    } ,
    methods:{

    }      
}
</script>

<style scoped>

</style>