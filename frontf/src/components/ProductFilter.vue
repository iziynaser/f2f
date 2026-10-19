<template>
  <div>
    <!-- انتخاب دسته‌بندی -->
    <f2f-brand
        :category-id="filters.categoryId"
        @category-changed="onCategoryChanged"
    />

    <!-- بازه قیمت -->
    <f2-f-range v-model="filters.priceRange"
                label="محدوده قیمت" :min="0" :max="1000000"
                @update:modelValue="onPriceRangeChanged"/>


    <!-- فیلترهای Yes/No -->
    <yes-no
        label="ارسال سریع"
        mode="switch"
        v-model="filters.fastDelivery"
        @update:modelValue="val => onYesNoChanged('fastDelivery', val)"
    />
    <yes-no
        label="فقط کالای موجود"
        mode="switch"
        v-model="filters.inStock"
        @update:modelValue="val => onYesNoChanged('inStock', val)"
    />
    <yes-no
        label="پرداخت در محل"
        mode="switch"
        v-model="filters.cod"
        @update:modelValue="val => onYesNoChanged('cod', val)"
    />
    <yes-no
        label="اصالت کالا"
        mode="switch"
        v-model="filters.original"
        @update:modelValue="val => onYesNoChanged('original', val)"
    />

    <!-- انتخاب رنگ -->
    <f2-f-colori
        v-model="filters.colors"
        :colors="availableColors"
        @update:modelValue="onColorsChanged"
    />

    <!-- انتخاب برند -->
    <f2f-brands
        :category-id="filters.categoryId"
        :selected-brands="filters.brands"
        @filter-changed="onBrandFilterChanged"
    />


  </div>
</template>

<script>
import F2fBrand from "./base/f2fBrand.vue";
import F2FRange from "./base/f2fRange.vue";
import YesNo from "./base/yesNo.vue";
import F2FColori from "./base/f2fColori.vue";
import F2fBrands from "./base/F2fBrands.vue";
import debounce from 'lodash/debounce';

export default {
  name: 'ProductFilter',
  components: {
    F2fBrand,
    F2FRange,
    YesNo,
    F2FColori,
    F2fBrands
  },

  // ← اضافه شده: پذیرش categoryId از والد (مثلاً from route)
  props: {
    categoryId: {
      type: [String, Number],
      default: null
    }
  },

  data() {
    return {
      filters: {
        brands: [],
        categoryId: 0,
        searchText: '',
        fastDelivery: false,
        inStock: false,
        cod: false,
        original: false,
        colors: [],
        priceRange: [0, 1000000]
      },
      availableColors: [
        {
          name: 'Basic',
          items: [
            { text: 'Red', value: 'red' },
            { text: 'Blue', value: 'blue' },
            { text: 'Green', value: 'green' }
          ]
        },
        {
          name: 'Special',
          items: [
            { text: 'Gold', value: 'gold' },
            { text: 'Silver', value: 'silver' }
          ]
        }
      ]
    };
  },

  created() {
    // اگر والد categoryId ارسال کرده باشه، همون اول همگام کن و درخواست سرور رو بزن (immediate)
    if (this.categoryId !== null && this.categoryId !== undefined) {
      this.filters.categoryId = this.categoryId;
      // فراخوانی مستقیم بدون debounce و با فلگ immediate تا از سرور لود بشه
      this.$store.dispatch('filter/updateFilter', { mutation: 'setCategory', value: this.categoryId, immediate: true });
    }
  },

  watch: {
    // اگر والد categoryId تغییر کرد (مثلاً route تغییر کرد) — همگام کن
    categoryId(newVal) {
      if (newVal === undefined || newVal === null) return;
      this.onCategoryChanged(newVal);
    }
  },

  methods: {
    /** دسته‌بندی تغییر کرد */
    onCategoryChanged(categoryId) {
      this.filters.categoryId = categoryId;
      this.filters.brands = [];
      this.filters.colors = [];

      //console.log('return products with new categoryId',categoryId);
      // برای category می‌خواهیم فوری به سرور بزنیم (بدون debounce)
      this.updateFilter('setCategory', categoryId);
    },

    /** برندها تغییر کردند */
    onBrandFilterChanged(selectedBrands) {
      this.filters.brands = selectedBrands;
      this.updateFilter('setBrandIds', selectedBrands);
    },

    /** بازه قیمت تغییر کرد */
    onPriceRangeChanged(range) {
      this.filters.priceRange = range;
      this.updateFilter('setPriceRange', range);
    },

    /** رنگ‌ها تغییر کردند */
    onColorsChanged(colors) {
      this.filters.colors = colors;
      this.updateFilter('setColors', colors);
    },

    /** فیلترهای Yes/No تغییر کردند */
    onYesNoChanged(field, value) {
      this.filters[field] = value === 'yes';
      switch (field) {
        case 'inStock':
          this.updateFilter('setInStockOnly', this.filters.inStock);
          break;
        case 'fastDelivery':
          this.updateFilter('setFastDelivery', this.filters.fastDelivery);
          break;
        case 'cod':
          this.updateFilter('setCod', this.filters.cod);
          break;
        case 'original':
          this.updateFilter('setOriginal', this.filters.original);
          break;
      }
    },

    // ← جدید: debounce wrapper جدا برای فیلترهای معمولی
    debouncedUpdate: debounce(function (mutation, value) {
      this.$store.dispatch('filter/updateFilter', { mutation, value });
    }, 200),

    /**
     * updateFilter:
     * اگر mutation مربوط به category باشه => dispatch فوری با immediate:true
     * در غیر اینصورت => از debouncedUpdate استفاده کن
     */
    updateFilter(mutation, value) {
      if (mutation === 'setCategory') {
        // فراخوانی فوری به ماژول filter (که خودش applyServerFilter رو اجرا می‌کنه)
        this.$store.dispatch('filter/updateFilter', { mutation, value, immediate: true });
        return;
      }
      // برای بقیه فیلترها از debounce استفاده کن
      this.debouncedUpdate(mutation, value);
    }
  }
};
</script>

<style scoped>
/* فاصله و border برای فیلترها */
div {
  margin-bottom: 1rem;
}
</style>
