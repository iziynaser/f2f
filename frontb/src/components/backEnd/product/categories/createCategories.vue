<template>
    <div>
          {{$t('C_CATEGORIES_TITLE')}}
              <b-card no-body>
                  <b-tabs pills card>
                        <b-tab :title="this.$t('C_CATEGORIES_MAIN_PART')">
                            <categoriesMain/>
                        </b-tab>
                        <b-tab :title="this.$t('category_attribute')">
                            <div>
                                <b-card no-body>
                                    <b-tabs pills card vertical>
                                        <b-tab :title="this.$t('category_sizes')">
                                            <categoriesSize/>
                                        </b-tab>
                                        <b-tab :title="this.$t('category_colors')">
                                            <categoriesColor/>
                                        </b-tab>
                                        <b-tab :title="this.$t('category_suitableFor')">
                                            <categoriesSuitableFor/>
                                        </b-tab>
                                        <b-tab :title="this.$t('category_types')">
                                            <categoriesType/>
                                        </b-tab>
                                        <b-tab :title="this.$t('category_other')">
                                             <categoriesOther/>   
                                        </b-tab>
                                    </b-tabs>
                                </b-card>
                            </div>                                
                        </b-tab>
                        <b-tab :title="this.$t('C_CATEGORIES_CONTENT')">
                             <categoriesContent/>   
                        </b-tab>
                        <b-tab :title="this.$t('C_CATEGORIES_ADD_P_T_C')">
                            <categoriesProduct/>
                        </b-tab>
                  </b-tabs>
              </b-card>
    </div>
</template>

<script>

import categoriesMain from './categoriesMain'
import categoriesProduct from './categoriesProduct'
import categoriesContent from './categoriesContent'
import categoriesSize from './categoriesSize'
import categoriesColor from './categoriesColor'
import categoriesType from './categoriesType'
import categoriesOther from './categoriesOther'
import categoriesSuitableFor from './categoriesSuitableFor'

export default {
    name:'createCategories',
    props:{
          } ,
    data(){
      return {
        
      }
    } ,
    methods:{

    },
    components:{
        categoriesMain,
        categoriesProduct,
        categoriesContent,
        categoriesSize,
        categoriesColor,
        categoriesType,
        categoriesOther,
        categoriesSuitableFor
    }
}
</script>

<style scoped>

</style>