<template>
    <div v-if="isSucceed">
        {{name}}
        <b-badge variant="primary" pill>{{count}}</b-badge>          
    </div>
</template>

<script>
import axios from 'axios'

export default {
    name:'f2fBadge',
    props:{
        name:{
            required : true,
            type: String
        },
        address:{
            required : false,
            default: "",
            type: String
        },
        count:{
            required : false ,
            default: 0,
            type: Number
        },
          } ,
    data(){
      return {
        isSucceed : true
        //count: 0
      }
    } ,
    methods:{
        countofdetectedNameUrl(){
            var self = this;
            if (self.address!==""){                
                axios.get(self.address,{
                    params : {
                        productId : 2
                    }
                })
                .then(function(res){
                    self.count = res.data ;
                })
                .catch(function(){
                    self.isSucceed = false
                })
            } else if (self.count==0) {
                self.isSucceed = false
            }

        }
    },
    mounted(){
        this.countofdetectedNameUrl();
    }      
}
</script>

<style scoped>

</style>