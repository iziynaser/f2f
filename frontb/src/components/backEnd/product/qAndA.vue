<template>
    <div>

      <div>
        list of question and answers
        <b-row>
          sort by
        </b-row>
        <b-row>
          <b-col>
              date
          </b-col>          
          <b-col>
            my questions
          </b-col>          
          <b-col>
            most answeres
          </b-col>          
        </b-row>
      </div> 

      <div> 
        block of qAndA
      <div>
          <div>
            picture
          </div>
          <div>
            question or answer
          </div>
      </div>
      <div>
          <div>
              content of question and aswer
          </div>
          <div>
            <b-row>
              <b-col>date of qAndA</b-col>
              <b-col>action to this qAndA</b-col>
            </b-row>
          </div>
      </div>
      </div>

    </div>
</template>

<script>
export default {
    name:'qAndA',
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