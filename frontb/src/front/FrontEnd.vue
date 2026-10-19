<template>
    <div>
       <carousels/>
       <CategoriesMenu/>
       <Products/>
    </div>
  </template>
  
  <script>
    
  import carousels from './carousels.vue';
  import Products from '../components/Products.vue';
  import CategoriesMenu from '../components/categories/categoriesMenu.vue';


    export default {
    name: "FrontEnd",
    components: {
    carousels,
    Products,
    CategoriesMenu,
}
}
  </script>
  
  <style>
  
  </style>
  