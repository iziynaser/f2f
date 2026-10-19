<template>
    <div>
          create catalog view
              <b-card no-body>
                  <b-tabs pills card>
                        <b-tab :title="this.$t('CATALOG_SEARCH')">
                            <cCatalogMain/>
                        </b-tab>
                        <b-tab :title="this.$t('CPRODUCT_CREATE_content')">
                            <!-- <cProductContent/>  -->
                        </b-tab>
                         <b-tab :title="this.$t('C_PRODUCT_MEASURE_TITLE')">
                            <!-- <cProductMeasure/> -->
                         </b-tab>   
                        <b-tab :title="this.$t('CPRODUCT_CREATE_price')">
                            <!-- <cProductPrice/> -->
                        </b-tab> 
                        <b-tab :title="this.$t('CPRODUCT_CREATE_category')">
                             <!-- <cProductCategory/>    -->
                        </b-tab>
                        <b-tab :title="this.$t('CPRODUCT_CREATE_features')">
                            <!-- <cProductFeature/> -->
                        </b-tab> 
                        <b-tab :title="this.$t('CPRODUCT_CREATE_cost')">
                        
                        </b-tab> 
                        <b-tab :title="this.$t('CPRODUCT_CREATE_keywords')">
                            <!-- <cProductKeyword/> -->
                        </b-tab>
                        <b-tab :title="this.$t('CPRODUCT_CREATE_inventory')">                              
                              <!-- <cProductInventory/>                               -->
                        </b-tab>
                        <b-tab :title="this.$t('CPRODUCT_CREATE_supplier')">
                            <!-- <cProductSupplier/> -->
                        </b-tab>   
                  </b-tabs>
              </b-card>
    </div>
</template>

<script>

import cCatalogMain from './cCatalogMain'

export default {
    name:'createCatalog',
    props:{
          } ,
    data(){
      return {
        
      }
    } ,
    methods:{

    },
    components:{
        cCatalogMain
    }
}
</script>

<style scoped>

</style>