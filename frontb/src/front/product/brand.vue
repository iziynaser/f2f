<template>
    <div>
          <b-form inline>
              
              <label class="sr-only" for="inline-form-name" >name:</label>
              <b-input
                      id="inline-form-name"
                      class="mb-2 mr-sm mb-sm-0"
                      placeholder="name"
              ></b-input>                      

              <label class="sr-only" for="inline-form-value">value:</label>
              <b-input
                      id="inline-form-value"
                      class="mb-2 mr-sm mb-sm-0"
                      placeholder="value"
              ></b-input>                      

              <b-button variant="primary">save</b-button>
          </b-form>
    </div>

</template>

<script>
export default {
    name:'brand',
    props:{
          } ,
    data(){
      return {
        
      }
    } ,      
}
</script>

<style scoped>


</style>
