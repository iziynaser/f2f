<template>
    <div>
            <router-link left to="/">
                <b-img left :src="urlI('/images/logo/logo.png')" ></b-img>
            </router-link>     
    </div>
</template>

<script>

import { baseUrl } from '../../api/util';

export default {
    name:'Logo',
    data(){
        return{}
    },
    methods:{
      urlI(u){
        return baseUrl(u)
      }
    } 
}
</script>

<style scoped>

</style>
