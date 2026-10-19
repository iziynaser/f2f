<template>
  <div id="app" class="app-wrapper">
      <HeaderSite/>   
        <main class="container" role="main">
          <router-view></router-view>      
      </main>  
      <footers/> 
  </div>
</template>

<script>

import footers from './components/footers'

import HeaderSite from './front/HeaderSite.vue'

export default {
  name: 'App',
  components: {
    HeaderSite,
    footers,
},
  methods:{
  },
  data () {
    return {
    }
  }
}

</script>

<style scoped>
  .app-wrapper{
    margin-top: 10px;
  }
</style>
