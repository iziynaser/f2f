<template>
    <div>
        <b-container fluid>
            <b-row  class="my-1">
                <b-col sm="3">
                    <label for="contentId">{{$t('lookup_content_id')}}</label> 
                </b-col>
                <b-col sm="9">
                    <b-form-input id="contentId"  size="sm" type="text"></b-form-input> 
                </b-col>
            </b-row>
            <b-row  class="my-1">
                <b-col sm="3">
                    <label>{{$t('product_categroy_type')}}</label> 
                </b-col>
                <b-col sm="9">
                    <b-form-input  size="sm" type="text"></b-form-input> 
                product_category_type: image, video,header, footer , description, keyword, url,
                </b-col>
            </b-row>
            <!-- <b-row  class="my-1">
                <b-col sm="3">
                    <label>from date</label> 
                </b-col>
                <b-col sm="9">
                    <b-form-input  size="sm" type="text"></b-form-input> 
                </b-col>
            </b-row> -->
            <!-- <b-row  class="my-1">
                <b-col sm="3">
                    <label>to date</label> 
                </b-col>
                <b-col sm="9">
                    <b-form-input  size="sm" type="text"></b-form-input> 
                </b-col>
            </b-row>
            <b-row  class="my-1">
                <b-col sm="3">
                    <label>use days limit</label> 
                </b-col>
                <b-col sm="9">
                    <b-form-input  size="sm" type="text"></b-form-input> 
                </b-col>
            </b-row> -->
            <b-row  class="my-1">
                <b-col sm="3">
                    <label for="purchaceFdate">{{$t('categories_purchaceFdate')}}</label> 
                </b-col>
                <b-col sm="9">
                    <b-form-input id="purchaceFdate" size="sm" type="text"></b-form-input> 
                </b-col>
            </b-row>

            <b-row  class="my-1">
                <b-col sm="3">
                    <label for="purchaceTdate">{{$t('categories_purchaceTdate')}}</label> 
                </b-col>
                <b-col sm="9">
                    <b-form-input id="purchaceTdate" size="sm" type="text"></b-form-input> 
                </b-col>
            </b-row>
        </b-container>                          
    </div>
</template>

<script>
export default {
    name:'categoriesContent',
    props:{
          } ,
    data(){
      return {
        
      }
    } ,
    methods:{

    }      
}
</script>

<style scoped>

</style>