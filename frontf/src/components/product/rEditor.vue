<template>
    <div>
        <div>
            <b-row class="my-1">
                    <b-col>
                        <p class="font-weight-italic ">{{desciption}}</p>
                    </b-col> 
            </b-row>
        </div>
        <div>
            <vue-editor v-model="content"  :editorToolbar="customToolbar" ref="content" @text-change="contentChanged()"></vue-editor>        
        </div> 
    </div>
</template>

<script>

import { VueEditor } from 'vue2-editor'

export default {
    name:'rEditor',
    props:{
            // title :{
            //     type:String,
            //     default: "sdfsdfdsdsfs"
            // },
            desciption:{
                type:String,
                default: "dfsdfsf"
            },
            editorContent:{type:String}
          } ,
    data(){
      return {
          hasPreview : true,
          content : "enter your text here" ,
          customToolbar : [
            //   ["bold","italic","underline","strike"],
              [{list:"ordered"},
              {list:"bullet"},
                            {align:"center"},
                            {align:"justify"},
                            {align:"right"},
                            // {color:[]}
                          ]]          
      }
    } ,
    methods:{
        contentChanged(){
            //console.log(this.content);
            this.$emit("editorContentChanged",this.content);
        },
        clear(){
            this.content = '';
        }
    },
    components:{
        VueEditor
    },
    mounted(){
        // this.title = this.$t('REDITOR_TITLE');
        this.desciption = this.$t('REDITOR_DESCRIPTION');
    },
    // beforeDestroy(){

    // }
}
</script>

<style scoped>

</style>