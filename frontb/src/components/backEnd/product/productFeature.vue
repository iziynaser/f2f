<template>
    <div>
                      <div>
                        <div v-for="group in groupIdsWithNames" :key="group.id">
                            <b-container>

                              {{group.gname}}

                              <div v-if="group.gitems" class="box">

                                  <div>
                                    <b-row v-for="im in group.gitems" :key="im.id" class="text-right">                                  
                                      <b-col>  
                                        {{im.itemname}}
                                      </b-col>
                                      <b-col>
                                      <div v-if="im.itemvalues">
                                        <div>
                                          <div v-for="iin in im.itemvalues" :key="iin.id">
                                            {{iin.itemvalue}}
                                          </div>
                                        </div>
                                      </div>

                                      </b-col>  


                                    </b-row>
                                  </div> 
                              </div>
                              

                            </b-container>
                        </div>
                      </div>          
    </div>
</template>

<script>

import axios from 'axios'

export default {
    name:'productFeature',
   props:{
        id:Number
          } ,
     data(){
      return {
        brand:'',
        category:'',
        topFeatures:'',
        searchResult:[],      
        isBusy:false,
        errors:{},
        groupIds:[],
        groupIdsWithNames:[],
        itemIds:[],
        itemIdsWithNames:[],
        itemsIds:[],
      }
    } ,
    methods:{
          onSearchResult() {                
                var self = this;

                var groupIds = self.groupIds;
                var itemIds =  self.itemIds;
                var groupIdsWithNames = self.groupIdsWithNames;
                var idx = 0 ;

                this.errors= {};
                this.isBusy = true;
                const url = `/feature/features`;
                axios.get(url,{
                    params:{
                        productId: self.id
                    }
                })
                .then(function(res){

                      self.searchResult = res.data; 
                      for(const feature of self.searchResult){

                        if(!groupIds.includes(feature.groupId)){
                          if(feature.groupId)
                            groupIds.push(feature.groupId);
                            groupIdsWithNames.push({gid:feature.groupId,gname:feature.groupName,gitems:[]});
                        }

                        if(!itemIds.includes(feature.itemId)){
                          if(feature.itemId){
                            itemIds.push(feature.itemId);

                            for(const [i,g] of groupIdsWithNames.entries()){
                              if(g.gid===feature.groupId){
                                  groupIdsWithNames[i].gitems.push({itemid:feature.itemId,itemname:feature.itemName,itemvalues:[]});
                                  
                                  //start of my block
                                  if(feature.itemsId){
                                    if(groupIdsWithNames[i].gitems)
                                    for(idx=0;idx<groupIdsWithNames[i].gitems.length;idx++){
                                        if(feature.itemId===groupIdsWithNames[i].gitems[idx].itemid){
                                            //console.log(idx +" , " + groupIdsWithNames[i].gitems[idx]) ;
                                            groupIdsWithNames[i].gitems[idx].itemvalues.push({itemid:feature.itemsId,itemvalue:feature.itemsName});
                                        }                                          
                                    }                                    
                                  }//end of my block
                              }                                
                            }                            
                          }                        
                        }
                        


                      }

                      //console.log(groupIdsWithNames);
                      self.isBusy=false;
                })
                .catch(function(error){
                    console.log(error)    ;
                });
          }
    },mounted(){
        this.onSearchResult();
    }      
}
</script>

<style scoped>

</style>