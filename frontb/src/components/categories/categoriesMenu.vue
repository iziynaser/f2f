<template>
    <div>
      <div>
        <b-dropdown size="lg"  variant="link" toggle-class="text-decoration-none" no-caret>
              <template v-slot:button-content>
                  &#x1f50d;<span class="sr-only">Search</span>
                  categories
              </template>

              <b-dropdown-item-button>

            <router-link :to="{
                        name:'categoriesPage',
                        params:{id:0,title:'product.name'}
                    }">
               c page    
            </router-link>

              </b-dropdown-item-button>


              <b-dropdown-divider></b-dropdown-divider>
              <b-dropdown-group id="dropdown-group-1" header="Group 1">
                  <b-dropdown-item-button>First Grouped item</b-dropdown-item-button>
                  <b-dropdown-item-button>Second Grouped Item</b-dropdown-item-button>
              </b-dropdown-group>
              <b-dropdown-group id="dropdown-group-2" header="Group 2">
                  <b-dropdown-item-button>First Grouped item</b-dropdown-item-button>
                  <b-dropdown-item-button>Second Grouped Item</b-dropdown-item-button>
              </b-dropdown-group>
              <b-dropdown-divider></b-dropdown-divider>

              <b-dropdown-item-button>
                  Another Non-grouped Item
              </b-dropdown-item-button>
      </b-dropdown>
      
    </div>
  </div>
</template>

<script>

//import categoriesPage from ''
//import categoriesPage from '../../components/backEnd/product/categories/categoriesPage'

export default {
    name:'categoriesMenu',
    components:{
      //categoriesPage
    },
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