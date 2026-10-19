<template>
  <b-row>
    <b-col sm="3">
      <product-filter
          :categoryId="categoryCode"
          :categoryTitle="categoryTitle"
          @filter-updated="onFilterUpdated"
      />
    </b-col>
    <b-col sm="9">
      <products
          :categoryCode="categoryCode"
          :categoryTitle="categoryTitle"
          :filters="filters"
      />
    </b-col>
  </b-row>
</template>

<script>
import ProductFilter from '../../ProductFilter.vue'
import Products from '../../Products.vue'

export default {
  name: 'CategoriesPage',
  components: { ProductFilter, Products },

  data() {
    return {
      filters: {}   // ← اضافه شد: فیلترهای جاری
    }
  },

  computed: {
    categoryCode() { return this.$route.params.id },
    categoryTitle() { return this.$route.params.title }
  },

  methods: {
    // ← اضافه شد: بروزرسانی فیلترهای لوکال از ProductFilter
    onFilterUpdated(newFilters) {
      this.filters = newFilters
    }
  }
}
</script>
