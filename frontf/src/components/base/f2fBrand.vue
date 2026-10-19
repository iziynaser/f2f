<template>
  <div>
    <b-form-input
        v-model="searchTerm"
        placeholder="جست‌وجوی برند..."
        debounce="300"
        class="mb-2"
    />

    <b-form-checkbox-group
        v-model="selectedBrands"
        :options="filteredBrandOptions"
        @change="onChange"
        stacked
        size="sm"
    />
  </div>
</template>

<script>
import axiosInstance from '@/api/axiosInstance';

export default {
  name: 'f2fBrand',
  props: {
    categoryId: {
      type: [String, Number],
      required: true
    }
  },
  data() {
    return {
      brands: [],
      searchTerm: '',
      selectedBrands: []
    };
  },
  watch: {
    categoryId: {
      immediate: true,
      handler(newVal) {
        if (newVal) {
          this.fetchBrandsByCategory(newVal);
          this.selectedBrands = []; // اگر لازم باشه ریست کن
        }
      }
    }
  },
  computed: {
    filteredBrandOptions() {
      let filtered = this.brands;
      if (this.searchTerm.trim() !== '') {
        const term = this.searchTerm.trim().toLowerCase();
        filtered = filtered.filter(b =>
            b.name.toLowerCase().includes(term)
        );
      }
      return filtered.map(b => ({
        text: b.name,
        value: b.id
      }));
    }
  },
  methods: {
    fetchBrandsByCategory(categoryId) {
      axiosInstance.get('/brand/byCategoryId', { params: { categoryId } })
          .then(res => {
            this.brands = res.data;
          })
          .catch(err => {
            console.error('خطا در دریافت برندها:', err);
            this.brands = [];
          });
    },
    onChange() {
      this.$store.dispatch('filter/updateFilter', {
        mutation: 'setBrandIds',
        value: this.selectedBrands,
        immediate: true
      });
    }
  }
};
</script>
