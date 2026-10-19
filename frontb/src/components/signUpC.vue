<template>
        
  <div>
    <h4>F2F App</h4>
      <b-card img-src="/images/icon/userProfile.png" img-alt="Card image" img-right>
        <b-card-title>registration was successfully done..</b-card-title>
        <b-card-text>
          Some quick example text to build on the card and make up the bulk of the card's content.
        </b-card-text>
        
          <b-button  to="/">
            go to main page
          </b-button>
          ////
          <b-button to="/login">
            go to login page
          </b-button>

      </b-card>
  </div>
  
</template>

<script>
export default {
    name:'signUpC',
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