<template>
    <div>
        <b-row class="my-1">
            <b-col sm="3">                
                <ul class="list-unstyled">
                    <li v-for="size in sizes" :key="size.id" @dblclick="addToSelectedsizes(size)">                                        
                        <span class="ql-align-right">{{size.name}}</span>
                    </li>
                </ul>

                <b-row>
                  <b-col>
                    <b-input id="spInput" v-model="spInput" ></b-input>
                  </b-col>
                  <b-col ><b-button>ok</b-button></b-col>
                </b-row>
            </b-col>
            <b-col sm="9">
                <b-list-group class="list-group-item-info">
                    <b-list-group-item v-for="size in selectedSizes" :key="size.id" @dblclick="removeFromSelectedSize(size)">
                        <span class="ql-align-right">{{size.name}}</span>
                    </b-list-group-item>
                </b-list-group>
            </b-col>
        </b-row>
    </div>
</template>

<script>
export default {
    name:'categoriesSuitablFor',
    props:{
          } ,
    data(){
      return {
        idx:0,
        sizes:[
          {id:"1",name:this.$t('tak size'),value:""},
          {id:"2",name:this.$t('M'),value:"M"},
          {id:"3",name:this.$t('L'),value:"L"},
          {id:"4",name:this.$t('s'),value:"s"},
          {id:"5",name:this.$t('xl'),value:"xl"},
          {id:"6",name:this.$t('freeSize'),value:"free Size"},      
        ],
        selectedSizes:[],
        spInput:10,
      }
    } ,
    methods:{
      addToSelectedsizes(size){
        if(this.selectedSizes.indexOf(size)==-1)
          this.selectedSizes.push(size);
      },
      removeFromSelectedSize(size){
        this.selectedSizes = this.selectedSizes.filter(element=>element.name!==size.name);
        console.log(this.selectedSizes);      
      }
    }      
}
</script>

<style scoped>

</style>