<template>
  <div class="brand-filter p-2 border rounded shadow-sm">
    <h6 class="mb-2">برندها</h6>

    <!-- حالت لودینگ -->
    <div v-if="isLoading" class="text-secondary small">در حال بارگذاری...</div>

    <!-- خطا -->
    <div v-else-if="error" class="text-danger small">{{ error }}</div>

    <!-- لیست برندها -->
    <div v-else>
      <div v-if="brands.length > 0">
        <b-form-checkbox-group
            v-model="localSelectedBrands"
            :options="brandOptions"
            stacked
            @change="onBrandsChanged"
        />
      </div>
      <div v-else class="text-muted small">هیچ برندی یافت نشد</div>
    </div>
  </div>
</template>

<script>
import { mapGetters } from "vuex";

export default {
  name: "F2fBrands",
  props: {
    categoryId: {
      type: Number,
      required: true
    },
    selectedBrands: {
      type: Array,
      default: () => []
    }
  },
  data() {
    return {
      localSelectedBrands: [] // نگهداری انتخاب کاربر
    };
  },
  computed: {
    ...mapGetters("brand", ["allBrands", "isLoading", "error"]),
    brands() {
      return this.allBrands;
    },
    brandOptions() {
      return this.brands.map(b => ({
        text: b.name,
        value: b.id
      }));
    }
  },
  watch: {
    categoryId: {
      immediate: true,
      handler(newVal) {
        if (newVal) {
          this.$store.dispatch("brand/fetchBrandsByCategory", newVal);
        } else {
          this.$store.commit("brand/setBrands", []);
        }
      }
    },
    selectedBrands: {
      immediate: true,
      handler(newVal) {
        this.localSelectedBrands = [...newVal];
      }
    }
  },
  methods: {
    onBrandsChanged(val) {
      this.$emit("filter-changed", val);
    }
  }
};
</script>

<style scoped>
.brand-filter {
  background: #fff;
}
</style>
