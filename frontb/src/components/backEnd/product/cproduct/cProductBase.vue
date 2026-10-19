<template>
    <div>
            <b-container fluid> 
               <b-row>
                   <b-col sm="3">
                       <b-card no-body header-bg-variant="success" :header="$t('C_PRODUCT_BASE_TITLE')">
                        <b-list-group flush>
                            <b-list-group-item v-b-toggle.c1 
                                               href="#c1" button 
                                               @click="togglingDone(0)">
                                               {{$t('C_PRODUCT_BASE_PRTYPES')}} 
                            </b-list-group-item>
                            <b-list-group-item v-b-toggle.c2 
                                                @click="togglingDone(1)"
                                               href="#c2" button>
                                               {{$t('C_PRODUCT_BASE_MTYPES')}}
                            </b-list-group-item>
                            <b-list-group-item v-b-toggle.c3 href="#c3" 
                                                 @click="togglingDone(2)"
                                                button>
                                                {{$t('C_PRODUCT_BASE_PTYPES')}}
                            </b-list-group-item>
                        </b-list-group>
                        </b-card> 
                   </b-col>
                   <b-col xl="9">
                        <div>
                            <!-- open here
                            <hr /> -->
                            <b-collapse v-model="c[0]" ref="c1" id="c1">
                                <div>                                       
                                        <f2fBaseInfo  :label="this.$t('price_types')"
                                                      url="/ProductPrice/list"
                                                      saveUrl="/ProductPrice/save"
                                                      deleteUrl="/ProductPrice/del"  />
                                </div>
                            </b-collapse>
                            <b-collapse v-model="c[1]" ref="c2" id="c2">
                                <div>                                        
                                        <f2fBaseInfo  :label="this.$t('measure_types')"
                                                      url="/MeasureType/list" 
                                                      saveUrl="/MeasureType/save"
                                                      deleteUrl="/MeasureType/del"
                                        />
                                </div>
                            </b-collapse>
                            <b-collapse v-model="c[2]" ref="c3" id="c3">
                                <div>                                       
                                        <f2fBaseInfo  :label="this.$t('product_types')"
                                                      url="/ProductType/list"
                                                      saveUrl="/ProductType/save"
                                                      deleteUrl="/ProductType/del"
                                        />
                                </div>
                            </b-collapse>
                        </div>
                   </b-col>
               </b-row>
           </b-container> 
    </div>
</template>

<script>

import f2fBaseInfo from '../../../base/f2fBaseInfo'

export default {
    name:'cProductBase',
    components:{
        f2fBaseInfo
    },
    props:{
          } ,
    data(){
      return {
         c:[false,false,false],
      }
    } ,
    methods:{
        togglingDone(id){

            for(let i in this.c)
                this.c[i]= false;

            this.c[id]= true;    
        },
    }      
}
</script>

<style scoped>

</style>