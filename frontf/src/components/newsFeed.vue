<template>
<div>
    
    <div @click="getNews">
       yy {{cnts}}
    </div>
        
        {{nws.length}}

        <ul>
            <li v-for="n in nws">
                {{n.id}},{{n.name}},{{n.age}}
            </li>
        </ul>
</div>



</template>

<script>
//import axios from 'axios'
export default {    
    name:'newsFeed' ,
    props:['cnts'],
    data(){
        return{
            nws:[]
        }
    },
    methods:{
        getNews:function(){
            this.axios.get("http://127.0.0.1:9090/dogs",{
                crossDomain:true
            })
            .then(response=>{
                this.nws = response.data
            });
        }
    }
    }

</script>

<style scoped>

</style>
