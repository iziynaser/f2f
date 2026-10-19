<template>
    <div class="p-2 my-2 border">
        <b-button v-b-toggle.ynCollapse variant="light" class="block">
            <span class="when-closed">
                <b-icon-arrow-down aria-hidden="true"></b-icon-arrow-down>
            </span>
            <span class="when-opened">
                <b-icon-arrow-up aria-hidden="true"></b-icon-arrow-up>
            </span>
            {{yesNoLabel}}
        </b-button>
        <b-collapse visible id="ynCollapse">
            <b-form-checkbox-group stacked
                v-model="value" 
                :options="options"
                name="checkButton">              
            </b-form-checkbox-group>
        </b-collapse>
    </div>
</template>

<script>
export default {
    name:'yesNo',
    props:{
          } ,
    data(){
      return {
        yesNoLabel:'is it ok???',
        value:[],
        options:[
            {text:'yes',value:'yes'},
            {text:'no',value:'no'}
        ]
      }
    } ,
    methods:{
    } ,
    computed:{
    }     
}
</script>

<style scoped>
.collapsed > .when-opened,
:not(.collapsed) > .when-closed{
    display:none
}
</style>