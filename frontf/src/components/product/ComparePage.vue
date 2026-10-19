<template>
  <div class="compare-page container my-4">
    <h2 class="mb-4">مقایسه محصولات</h2>

    <div v-if="compareList.length === 0" class="alert alert-info">
      لیست مقایسه خالی است.
    </div>

    <div v-else>
      <table class="table table-bordered table-striped text-center">
        <thead>
        <tr>
          <th>ویژگی‌ها / محصولات</th>
          <th v-for="product in compareList" :key="product.id">
            محصول {{ product.id }}
            <button class="btn btn-sm btn-danger ms-2" @click="removeProduct(product.id)">
              حذف
            </button>
          </th>
        </tr>
        </thead>
        <tbody>
        <template v-for="featureGroup in groupedFeatures">
          <tr class="table-primary" :key="featureGroup.groupId">
            <td colspan="100%" class="text-start fw-bold">{{ featureGroup.groupName }}</td>
          </tr>
          <tr
              v-for="item in featureGroupItems(featureGroup)"
              :key="featureGroup.groupId + '-' + item.itemId"
          >
            <td class="text-start">{{ item.itemName }}</td>
            <td v-for="product in compareList" :key="product.id + '-' + item.itemId">
              {{ featureValue(product, item.itemId) }}
            </td>
          </tr>
        </template>
        </tbody>
      </table>

      <button class="btn btn-warning mt-3" @click="clearCompareList">
        پاک کردن همه
      </button>
    </div>
  </div>
</template>

<script>
import { mapGetters, mapActions } from "vuex";

export default {
  name: "ComparePage",
  computed: {
    ...mapGetters("compare", ["getCompareList"]),
    compareList() {
      return this.getCompareList;
    },
    groupedFeatures() {
      const groups = new Map();
      this.compareList.forEach(function (product) {
        if (!product.features) return;
        product.features.forEach(function (f) {
          if (!groups.has(f.groupId)) {
            groups.set(f.groupId, {
              groupId: f.groupId,
              groupName: f.groupName,
              itemsMap: new Map(),
            });
          }
          const group = groups.get(f.groupId);
          if (!group.itemsMap.has(f.itemId)) {
            group.itemsMap.set(f.itemId, {
              itemId: f.itemId,
              itemName: f.itemName,
            });
          }
        });
      });
      return Array.from(groups.values()).map(function (g) {
        return {
          groupId: g.groupId,
          groupName: g.groupName,
          items: Array.from(g.itemsMap.values()),
        };
      });
    },
  },
  methods: {
    ...mapActions("compare", ["removeProductFromCompare", "clearCompareList"]),
    removeProduct: function (productId) {
      this.removeProductFromCompare(productId);
    },
    featureGroupItems: function (group) {
      return group.items;
    },
    featureValue: function (product, itemId) {
      if (!product.features) {
        return "-";
      }
      var feature = null;
      for (var i = 0; i < product.features.length; i++) {
        if (product.features[i].itemId === itemId) {
          feature = product.features[i];
          break;
        }
      }
      if (!feature) return "-";
      if (feature.itemsValue !== undefined && feature.itemsValue !== null) {
        return feature.itemsValue;
      }
      return "-";
    },
  },
};
</script>

<style scoped>
.compare-page table th,
.compare-page table td {
  vertical-align: middle;
}
</style>
