<template>
    <div>
        <!-- brands -->
        <!-- <brandMain/>    -->
        <categoryBrowser/>
    </div>
</template>

<script>

import categoryBrowser from '../../base/categoryBrowser'

export default {
    name:'contentCategories',
    props:{
          } ,
    data(){
      return {
        
      }
    } ,
    methods:{

    },
    components:{
        // brandMain
        categoryBrowser
    }
}
</script>

<style scoped>

</style>