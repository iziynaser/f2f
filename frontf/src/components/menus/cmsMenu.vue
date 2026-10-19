<template>
    <div>
        <b-dropdown variant="success" id="dropdown-1" text="CMS" class="m-md-2">
                <b-dropdown-item v-for="menu in cmenus" :key="menu.id"  :id="menu.id"  >
                    {{menu.name}}
                </b-dropdown-item>
        </b-dropdown>
    </div>
</template>

<script>


import axiosInstance from '@/api/axiosInstance';

export default {
    name:'cmsMenu',
    props:{
          } ,
    data(){
      return {
        isDropdown2Visible:false,
        cType:9,
        cId:1,
        cmenus:[],
        menus:[],
      }
    } ,
    methods:{    
        returnSubArray(){

        }   , 
        loadCMSMenus(id,type){
                var self = this;
                const url = `/Category/listById`;
                axiosInstance.get(url,{
                params:{id:id,cId:type}
            })
                .then(function(res){
                     //console.log(res.data);
                    self.cmenus = res.data;                   
                    //console.log(res.data);
                })
                .catch(function(error){
                    console.log(error)    ;
                });
        },
    } ,
    mounted:function(){
        this.$root.$on('bv::dropdown::show',bvEvent=>{
            if(bvEvent.componentId === 'dropdown-2'){
                this.isDropdown2Visible = true ;
            }
        })
        this.$root.$on('bv::dropdown::hide',bvEvent =>{
            if(bvEvent.componentId === 'dropdown-2'){
                this.isDropdown2Visible = false ;
            }
            if(this.isDropdown2Visible){
                bvEvent.preventDefault()
            }
        })
    },created(){
        this.loadCMSMenus(this.cId,this.cType);
    }     
}
</script>

<style scoped>

</style>