<template>
    <div>

    <div>
        <b-row>
        <b-col sm="3">
            <div>
              <filtered/>
              <f2fCategory/>
              <searchInRes/>
              <f2fSwitch/>
              <yesNo/> 
              <filteri/> 
              <f2fRange/> 
              <f2fColori/>
            </div>
        </b-col>
        <b-col sm="9">
          <div class="border-2">
            <products/>
          </div>
        </b-col>
      </b-row>
  </div>
 

    </div>
</template>

<script>

import yesNo from '../../../../components/base/yesNo'
import f2fRange from '../../../../components/base/f2fRange'
import filteri from '../../../../components/base/filteri'
import products from '../../../../components/Products'
import f2fSwitch from '../../../../components/base/f2fSwitch'
import filtered from  '../../../../components/base/filtered'
import searchInRes from  '../../../../components/base/searchInRes'
import f2fCategory from  '../../../../components/base/f2fCategory'
import f2fColori from '../../../../components/base/f2fColori'

export default {
    name:'categoriesPage',
    props:{
          } ,
    data(){
      return {
        
      }
    } ,
    methods:{

    },
    components:{      
       yesNo,
       filteri,
       f2fRange,
       products,
       f2fSwitch,
       filtered,
       searchInRes,
       f2fCategory,
       f2fColori
    },
      
}
</script>

<style scoped>

</style>