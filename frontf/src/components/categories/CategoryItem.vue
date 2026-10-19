<template>
  <li>
    <div
        class="category-link d-flex align-items-center justify-content-between"
        @click="$emit('toggle', category.id)"
        style="cursor: pointer;"
    >
      <router-link
          :to="{ name: 'categoriesPage', params: { id: category.id, title: category.name } }"
          class="flex-grow-1 text-decoration-none text-primary"
          @click.stop
      >
        <i class="bi bi-folder2 me-1"></i>
        {{ category.name }}
      </router-link>

      <i
          v-if="category.subCategories && category.subCategories.length"
          class="bi"
          :class="expandedCategoryIds.has(category.id) ? 'bi-caret-down-fill ms-2' : 'bi-caret-right-fill ms-2'"
      ></i>
    </div>

    <ul
        v-if="category.subCategories && category.subCategories.length && expandedCategoryIds.has(category.id)"
        class="list-unstyled ps-3"
    >
      <category-item
          v-for="sub in category.subCategories"
          :key="sub.id"
          :category="sub"
          :expanded-category-ids="expandedCategoryIds"
          @toggle="$emit('toggle', $event)"
      />
    </ul>
  </li>
</template>

<script>
export default {
  name: 'CategoryItem',
  props: {
    category: {
      type: Object,
      required: true,
    },
    expandedCategoryIds: {
      type: Set,
      required: true,
    },
  },
};
</script>

<style scoped>
.category-link {
  font-weight: 500;
  font-size: 1rem;
  padding: 4px 8px;
  border-radius: 6px;
  transition: background-color 0.2s ease;
  color: #0d6efd;
}

.category-link:hover {
  background-color: #e7f1ff;
  color: #0a58ca;
}
</style>
