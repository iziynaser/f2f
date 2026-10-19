<template>
    <div>
        <multiselect v-model="value" 
                     :options="options" 
                     :searchable="true" 
                     :close-on-select="false" 
                     :show-labels="false"
                     placeholder="choose a brand"
                     style="multiselect"
                     >
        </multiselect>
    </div>
</template>

<script>

import Multiselect from 'vue-multiselect'

export default {
    name:'brands',
    props:['cardImage'] ,
    data(){
        return{
            value:'',
            options : ['Casio',
                       'Sony',
                       'Lg',
                       'Arj',
            ]
        }
    },
    components:{
        Multiselect
    }
}
</script>

<style src="vue-multiselect/dist/vue-multiselect.min.css"></style>


<style scoped >
    .multiselect{
        width: 200px;
    }
</style>
