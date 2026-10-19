<template>
  <nav aria-label="categories-menu" class="my-3">
    <ul class="categories-list">
      <li
          v-for="category in categories"
          :key="category.id"
          class="category-item"
      >
        <category-item
            :category="category"
            :expanded-category-ids="expandedCategoryIds"
            @toggle="onCategorySelect"
        />
      </li>
    </ul>

    <div v-if="isLoading" class="text-center text-secondary mt-2">
      در حال بارگذاری دسته‌بندی‌ها...
    </div>
    <div v-if="getError" class="text-danger mt-2">
      {{ getError }}
    </div>
  </nav>
</template>

<script>
import { mapGetters, mapActions } from 'vuex';
import CategoryItem from './CategoryItem.vue';

export default {
  name: 'CategoriesMenu',
  components: { CategoryItem },
  data() {
    return {
      expandedCategoryIds: new Set(),
    };
  },
  computed: {
    ...mapGetters('categories', ['getCategories', 'isLoading', 'getError']),
    categories() {
      return this.getCategories;
    },
  },
  created() {
    this.fetchCategories();
  },
  methods: {
    ...mapActions('categories', ['fetchCategories']),
    ...mapActions('filter', ['updateFilter']),
    toggleCategory(id) {
      if (this.expandedCategoryIds.has(id)) {
        this.expandedCategoryIds.delete(id);
      } else {
        this.expandedCategoryIds.add(id);
      }
      this.expandedCategoryIds = new Set(this.expandedCategoryIds);
    },
    onCategorySelect(categoryId) {
      this.toggleCategory(categoryId);
      this.updateFilter({
        mutation: 'setCategory',
        value: categoryId,
        immediate: true
      });
    }
  },
};
</script>

<style scoped>
.categories-list {
  display: flex;
  flex-wrap: nowrap; /* نذار بره خط بعد */
  overflow-x: auto;  /* اسکرول افقی */
  gap: 1rem;
  list-style: none;
  padding: 0;
  margin: 0;
  scrollbar-width: thin; /* برای فایرفاکس */
}

.categories-list::-webkit-scrollbar {
  height: 6px;
}

.categories-list::-webkit-scrollbar-thumb {
  background: #ccc;
  border-radius: 3px;
}

.category-item {
  flex: 0 0 auto; /* جلوگیری از کشیده‌شدن آیتم‌ها */
}
</style>
