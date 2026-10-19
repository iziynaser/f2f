<template>
  <div>
    <div v-if="$route.fullPath.length > 1"></div>
    <div v-else>
      <b-container fluid>
        <b-row class="my-1">


          <b-col sm="6">
<!--            <FSearchBar />-->
          </b-col>

          <b-col sm="4">
            <b-row class="my-1">
              <b-col>
<!--                <b-button type="button" variant="danger" size="sm" class="btn bg-light btn-outline-dark">-->
<!--&lt;!&ndash;                  <router-link to="back/BackEnd">back End</router-link>&ndash;&gt;-->
<!--                </b-button>-->
              </b-col>
              <b-col>
                <b-button type="button" size="sm" class="btn bg-light btn-outline-dark">
                  <router-link to="/signUp">e/sign in</router-link>
                </b-button>
              </b-col>
              <b-col>
<!--                <shoppingList />-->
              </b-col>
              <b-col>
<!--                <shoppingCart />-->
              </b-col>
            </b-row>

          </b-col>

          <b-col sm="2">
            <Logo />
          </b-col>
        </b-row>
      </b-container>
    </div>
  </div>
</template>
  
<script>
//import navBars from '../components/navBars'
//import shoppingList from '../components/shoppingList'
//import shoppingCart from '../components/shoppingCart'
import Logo from './Logo.vue';
//import FSearchBar from './fSearchBar.vue';

export default {
  name: 'HeaderSite',
  components: {
    //shoppingList,
    //shoppingCart,
    Logo,
    // FSearchBar
  }
}
</script>
  
<style scoped></style>
  