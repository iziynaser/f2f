<template>
    <div>

      <b-nav-item-dropdown text="CMS" right>

          <b-dropdown-item href="#" >
              <router-link to="/createContent">{{$t('CONTENT_webSite')}}</router-link>
          </b-dropdown-item>

        </b-nav-item-dropdown>

    </div>
</template>

<script>
export default {
    name:'cms',
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