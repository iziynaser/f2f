<template>
    <div>
                  <b-nav-item-dropdown :text="$t('CATALOG_SITE')" right>

          <b-dropdown-item href="#" >
                <b-button  size="sm" variant="link" @click="createCatalogTabs(0,$t('CATALOG_SETTING'))">{{$t('CATALOG_SETTING')}}</b-button>
          </b-dropdown-item>

          <b-dropdown-item href="#" >
              <b-button  size="sm" variant="link" @click="createCatalogTabs(1,$t('CATALOG_categories'))">{{$t('CATALOG_categories')}}</b-button>
          </b-dropdown-item>

          <b-dropdown-item href="#" >
              <b-button  size="sm" variant="link" @click="createCatalogTabs(2,$t('CATALOG_products'))">{{$t('CATALOG_products')}}</b-button>
          </b-dropdown-item>

          <b-dropdown-item href="#" >
              <b-button  size="sm" variant="link" @click="createCatalogTabs(3,$t('CATALOG_brands'))">{{$t('CATALOG_brands')}}</b-button>
          </b-dropdown-item>

          <b-dropdown-item href="#" >
              <b-button  size="sm" variant="link" @click="createCatalogTabs(4,$t('CATALOG_TITLE'))">{{$t('CATALOG_TITLE')}}</b-button>
          </b-dropdown-item>

          <!-- <b-dropdown-item href="#" >
              <router-link to="/humanres">{{$t('CATALOG_features')}}</router-link>
          </b-dropdown-item> -->

          <!-- <b-dropdown-item href="#" >
              <router-link to="/createPromotion">{{$t('CATALOG_promos')}}</router-link>
          </b-dropdown-item> -->

          <!-- <b-dropdown-item href="#" >
              <router-link to="/humanres">{{$t('CATALOG_priceRules')}}</router-link>
          </b-dropdown-item> -->

          <!-- <b-dropdown-item href="#" >
              <router-link to="/humanres">{{$t('CATALOG_stores')}}</router-link>
          </b-dropdown-item> -->

          <!-- <b-dropdown-item href="#" >
              <router-link to="/humanres">{{$t('CATALOG_shipping')}}</router-link>
          </b-dropdown-item> -->

          <!-- <b-dropdown-item href="#" >
              <router-link to="/humanres">{{$t('CATALOG_imageManagement')}}</router-link>
          </b-dropdown-item> -->



        </b-nav-item-dropdown>

    </div>
</template>

<script>


export default {
    name:'catalogMenu',
    props:{
          } ,
    data() {
        return {
      cp: [

           ]
        }
    },
  methods: {
    createCatalogTabs(idParam, nameParam) {
      let atab = {
        id: idParam ,
        name: nameParam,
        contnt : this.cp[idParam]
      }
      atab.id = (atab.id + 40);
      //console.log('catalog :'+atab);
      this.$emit('createAppTab',atab);
    }
  },    
}
</script>

<style scoped>

</style>