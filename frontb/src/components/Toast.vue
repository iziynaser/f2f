<template>
    <div>
          <div class="alert" v-show="isActive">
              <b-spinner type="grow"></b-spinner>
              <strong>{{text}}</strong>
          </div>
    </div>
</template>

<script>
export default {
    name:'Toast',
    props:["show","text"] ,
    data(){
      return {
        isActive: !!this.show,
        activeTimeout:{}
      };
    } ,
    mounted(){
        this.setTimeout();
    },
    watch:{
        show(newVal){
            this.isActive = !!newVal;
        },
        isActive(newVal){
            if(this.show !== !!newVal){
                this.$emit("hide-toast",newVal)
            }
            this.setTimeout();
        }
    },
    methods:{
        showToast(){
            console.log('show toast called........');
        },
        setTimeout(){
            clearTimeout(this.activeTimeout);
            if(this.isActive){
                this.activeTimeout = setTimeout(()=>{
                    this.isActive = false;
                },2000);
            }
        }
    }      
}
</script>

<style scoped>

</style>