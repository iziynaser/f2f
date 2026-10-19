<template>
    <div>
      <carousels/>
       <Products/>
    </div>
  </template>
  
  <script>
    
  import carousels from './carousels.vue';
  import Products from '../Products.vue';

    export default {
    name: "FrontEnd",
    components: {
    carousels,
    Products
}
}
  </script>
  
  <style>
  
  </style>
  