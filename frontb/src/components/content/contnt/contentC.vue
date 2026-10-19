<template>
    <div>          
          <div>
            {{form.title}}
          </div>
          <div v-html="form.body">            
          </div>          
    </div>
</template>

<script>

import * as axios from 'axios';

export default {
    name:'contentC',
    props:{
          } ,
    data(){
      return {
        form:{
          body:'',
          title:'',
          code:''
        }
      }
    } ,
    created() {        
            this.loadContent();
    },     
    methods:{
        loadContent(){
            var self = this;
            const url = `/content/load`;
            axios.get(url,{
                params:{
                    code : '123',
                    language:'fa'
                }
            })
                .then(function(res){
                    console.log(res.data);
                    self.form.body = res.data.body
                })
                .catch(function(error){
                    console.log('error load content ....'+error);
                });
        }

    }      
}
</script>

<style scoped>

</style>