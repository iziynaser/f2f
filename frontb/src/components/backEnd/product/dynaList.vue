<template>
    <div>

          <b-container fluid>
            <b-row class="my-1">
              <b-col sm="3">
                <label>{{labelforList}}:</label>    
              </b-col>
              <b-col sm="6">
                <b-input size="20" v-model="benefitName" placeholder="benefit" ref="benefitName" ></b-input>  
              </b-col>
              <b-col sm="3">
                  <b-button variant="success" @click="addToBenefits">+</b-button>                      
              </b-col>
            </b-row>                          
          </b-container>

          <div class="container">
          
            <b-list-group horizontal>
                <!-- <b-list-group-item v-for="(benef,idx) in listOfBenefits" :key="idx"> -->
                <b-list-group-item v-for="benef in listOfBenefits" :key="benef">
                    {{benef}}
                </b-list-group-item>
            </b-list-group>
          
          </div>

    </div>
</template>

<script>
export default {
    name:'dynaList',
    props:{
            labelforList:{
                type:String,
                defult: 'benefits'
            }
          } ,
    data(){
      return {
        benefitName:'',
        listOfBenefits:[],        
      }
    } ,
    methods:{
        addToBenefits(){
          this.listOfBenefits.push(this.$refs.benefitName.value);
          this.benefitName = '';
          this.$emit("updatelist",this.listOfBenefits);
          //this.$refs.benefitName.value = '';
        },
        clear(){
          this.benefitName = '';
          this.listOfBenefits = [];
        }

    }      
}
</script>

<style scoped>

</style>