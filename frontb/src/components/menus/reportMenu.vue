<template>
    <div>
        <b-nav-item-dropdown :text="$t('REPORT_SITE')" right>
          <b-dropdown-item href="#" >
              <router-link to="/humanres">WebSite</router-link>
          </b-dropdown-item>
        </b-nav-item-dropdown>
    </div>
</template>

<script>
export default {
    name:'reportMenu',
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