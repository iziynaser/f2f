<template>
    <div>
      <b-nav-item-dropdown text="Order" right>

          <b-dropdown-item href="#" >
            <router-link to="/contact">{{$t('ORDER_main')}}</router-link>
          </b-dropdown-item>

          <b-dropdown-item href="#" >
            <router-link to="/contact">{{$t('ORDER_request')}}</router-link>
          </b-dropdown-item>

          <b-dropdown-item href="#" >
            <router-link to="/contact">{{$t('ORDER_orderList')}}</router-link>
          </b-dropdown-item>

          <b-dropdown-item href="#" >
            <router-link to="/contact">{{$t('ORDER_findOrders')}}</router-link>
          </b-dropdown-item>

          <b-dropdown-item href="#" >
            <router-link to="/contact">{{$t('ORDER_reports')}}</router-link>
          </b-dropdown-item>

      </b-nav-item-dropdown>  
    </div>
</template>

<script>
export default {
    name:'orderMenu',
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