<template>
    <div class="p-2 my-2 border">
        
        <div v-b-toggle.ynCollapse>
            <b-row>
                <b-col sm="9">
                    <span >{{yesNoLabel}}</span>
                </b-col>
                <b-col sm="3">
                    <span class="when-closed">
                        <p class="h4 mb-2">
                            <b-icon-arrow-down variant="danger" aria-hidden="true"></b-icon-arrow-down>
                        </p>    
                    </span>
                    <span class="when-opened">
                        <p class="h4 mb-2">
                            <b-icon-arrow-up variant="danger" aria-hidden="true"></b-icon-arrow-up>
                        </p>                
                    </span>            
                </b-col>
            </b-row>                        
        </div>

        <b-collapse visible id="ynCollapse">
        <hr/>
        <div class="input-group mb-3">
                <div class="input-group-prepend">
                        <span class="input-group-text" id="basic-addon1">
                        <b-icon-search/>
                </span>
            </div>
            <input type="text" class="form-control" ref="searchText"
                   placeholder="Search" 
                   aria-label="Search" 
                   aria-describedby="basic-addon1"
                   v-on:keydown="filterResult(searchText)"
                   >
        </div>
        <hr/>
        <div>
            <b-form-checkbox-group stacked
                v-model="value" 
                :options="options"
                name="checkButton">              
            </b-form-checkbox-group>
        </div>
        </b-collapse>

        
    </div>
</template>

<script>
export default {
    name:'filteri',
    props:{
          } ,
    data(){
      return {
        yesNoLabel:'is it ok???',
        defaultSearchText : 'filter result...',
        value:[],
        oriOptions:[],
        options:[
            {text:'yes',value:'yes'},
            {text:'no1',value:'no1'},
            {text:'no2',value:'no2'},
            {text:'no3',value:'no3'},
            {text:'no4',value:'no4'},
            {text:'no5',value:'no5'},
            {text:'no6',value:'no6'},
            {text:'no7',value:'no7'},
            {text:'no8',value:'no8'},
            {text:'no9',value:'no9'},
            {text:'no39',value:'no39'},
            {text:'no29',value:'no49'},
            {text:'no19',value:'no59'},
            {text:'no10',value:'no10'}
        ]
      }
    } ,
    methods:{
        filterResult(){
            //var self = this;
            if(this.oriOptions.length===0)
               this.oriOptions = this.options.slice(0);

            if(this.$refs.searchText.value.length==0)
                this.options = this.oriOptions.slice(0);

            // this.options =this.oriOptions.slice(0).filter(function(el){
            //     let c = el;
            //     console.log(c.name);
            //     return c.name.includes(self.$refs.searchText.value);
            // });
            //this.options.shift();
            console.log(this.options);

        },
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