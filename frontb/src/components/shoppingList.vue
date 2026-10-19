<template>
<div >

      <b-button-group>
            <b-dropdown>
                  <div v-if="!isLoggedIn">
                        <BDropdownItem>
                              <router-link to="/login">signIn</router-link>
                        </BDropdownItem>
                        <!-- <b-dropdwon-item>
                              <router-link to="/login">signIn</router-link>
                        </b-dropdwon-item> -->
                  </div>
                  <div v-else>
                        <b-dropdown-item >
                              <router-link to="/createProfiles">{{$t('profile')}} </router-link>
                        </b-dropdown-item>                  

                        <b-dropdown-divider/>

                        <b-dropdown-item>
                              <router-link to="/myOrders">{{$t('myorders')}}</router-link>                              
                        </b-dropdown-item>   

                        <b-dropdown-divider/>

                        <b-dropdown-item v-on:click="logout">
                              {{$t('logout')}}
                        </b-dropdown-item>   
                  </div>
            </b-dropdown>
      </b-button-group> 
 
</div>
</template>

<script>

import {mapActions,mapGetters} from 'vuex'
import { BDropdown } from 'bootstrap-vue';
import { BDropdownItem } from 'bootstrap-vue';

export default {
      name:'shoppingList',
      data:function(){
            return {

            }
      },
      computed: {
            ...mapGetters(["isLoggedIn"])
      },
      components:{  
            BDropdown,BDropdownItem      
      },
      methods:{
            ...mapActions(['logout']),
      },
      mounted(){
      }

}          
</script>