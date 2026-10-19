<template>
    <div>          
        <ul class="list-unstyled">
                <li>
                    <b-form-checkbox v-model="promotionProduct" name="promotionProductCheckButton" switch>
                        {{$t('categories_promotion')}}
                    </b-form-checkbox>
                  </li>
                <li>
                    <b-form-checkbox v-model="availableProduct" name="availableProductCheckButton" switch>
                        {{$t('categoriesKalaye_mojood')}}
                    </b-form-checkbox>                  
                </li>
                <li>
                    <b-form-checkbox v-model="originalProduct" name="originalProductCheckButton" switch>
                        {{$t('categories_kalayeAsl')}}
                    </b-form-checkbox>                                    
                </li>
                <!-- <li>foroshande</li> - rasmi , bargozide , mystore ,  -->
        </ul>        
    </div>
</template>

<script>
export default {
    name:'categoriesOther',
    props:{
          } ,
    data(){
      return {
        originalProduct : '' ,
        availableProduct : '',
        promotionProduct : ''
      }
    } ,
    methods:{

    }      
}
</script>

<style scoped>

</style>