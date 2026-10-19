<template>
    <div>
                         <!-- <span v-if="id">id : {{id}}</span>
                 and <span v-if="title">title : {{title}}</span> -->

          <b-container fluid>
              <b-row  class="my-1">
                  <b-col>
                      <b-row>
                          <b-col>{{$t('C_PRODUCT_MEASURE_WIDTH')}}:</b-col>
                          <b-col><b-input v-model="form.width" type="text"  size="sm"></b-input></b-col>
                      </b-row>
                  </b-col>
                  <b-col>
                        <f2fInvoiceType id="widthType" 
                                        v-model="form.widthType"
                                        fetchUrl="/MeasureType/list"
                                        :selectOptionLabel="this.$t('C_PRODUCT_MEASURE_TYPE')"/>
                  </b-col>
              </b-row>
              <b-row  class="my-1">
                  <b-col>
                      <b-row>
                          <b-col>{{$t('C_PRODUCT_MEASURE_HIGHT')}}:</b-col>
                          <b-col><b-input v-model="form.hight" type="text" size="sm"></b-input></b-col>
                      </b-row>                      
                  </b-col>
                  <b-col>
                        <f2fInvoiceType id="hightType" 
                                        v-model="form.hightType"
                                        fetchUrl="/MeasureType/list"
                                        :selectOptionLabel="this.$t('C_PRODUCT_MEASURE_TYPE')"/>
                  </b-col>

              </b-row>
              <b-row  class="my-1">
                  <b-col>
                      <b-row>
                          <b-col>{{$t('C_PRODUCT_MEASURE_DEPTH')}}:</b-col>
                          <b-col><b-input v-model="form.depth" type="text"  size="sm"></b-input></b-col>
                      </b-row>
                  </b-col>
                  <b-col>
                        <f2fInvoiceType id="depthType"  
                                        v-model="form.depthType"
                                        fetchUrl="/MeasureType/list"
                                        :selectOptionLabel="this.$t('C_PRODUCT_MEASURE_TYPE')"/>
                  </b-col>
              </b-row>
              <b-row  class="my-1">
                  <b-col>
                      <b-row>
                          <b-col>{{$t('C_PRODUCT_MEASURE_WEIGHT')}}:</b-col>
                          <b-col><b-input v-model="form.weight" type="text"  size="sm"></b-input></b-col>
                      </b-row>       
                  </b-col>
                  <b-col>
                        <f2fInvoiceType id="weightType" 
                                        v-model="form.weightType"
                                        fetchUrl="/MeasureType/list"
                                        :selectOptionLabel="this.$t('C_PRODUCT_MEASURE_TYPE')"/>
                  </b-col>
              </b-row>
              <b-row  class="my-1">
                  <b-col>
                      <b-button v-on:click="save()">{{$t('C_MEASURE_SAVE')}}</b-button>
                  </b-col>
              </b-row>
          </b-container>
    </div>
</template>

<script>
import * as axios from 'axios';

export default {
    name:'cProductMeasure',
    props:{
            id:Number,
            title:String
          } ,
    data(){
      return {
          form :{
                width:"",
                widthType:0,
                hight:"",
                hightType:0,
                depth:"",
                depthType:0,
                weight:"",
                weightType:0,
                product:this.id
          }
      }
    } ,
    methods:{
        clear(){
            this.form.width="";
            this.form.hight="";
            this.form.depth="";
            this.form.weight="";
            this.form.widthType=0;
            this.form.hightType=0;
            this.form.depthType=0;
            this.form.weightType=0;
        },
        save(){
            var self = this;
            const url = `/productMeasure/save`;
            axios.post(url,self.form,
            {
            }).then((res)=>{
                // if(res.data.id)
                //     self.setProductId(res.data.id);
                    self.$store.commit("showToast","the product Measure Saved....");
                    console.log(res.id);
            }).catch((err) => {
                console.log(err);
            });
        },
        loadMeasure(){
            var self = this;
            const url='/productMeasure/load'
            axios.get(url,
            {
                params:{
                    productId:self.id
                }
            })
            .then((res)=>{
                self.form = res.data
            })
            .catch((err) => {
                console.log(err);
            })
        }
    },created() {
            if(this.id){
                //console.log('load measure called...');
                this.loadMeasure();
            }
        },      
}
</script>

<style scoped>

</style>