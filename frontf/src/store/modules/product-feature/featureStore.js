import { fetchProductFeatures } from './featureApi';

export default {
    namespaced: true,
    mutations: {
        SET_BUSY(state, payload) {
            state.isBusy = payload;
        },
        SET_FEATURES(state, payload) {
            state.featuresGrouped = payload;
        },
        SET_LOADED_PRODUCT_ID(state, productId) {
            state.loadedProductId = productId;
        }
    },
    state: () => ({
        isBusy: false,
        featuresGrouped: [],
        loadedProductId: null
    }),
    actions: {
        async loadFeatures({ state, commit }, productId) {
            // اگر قبلاً داده همین محصول لود شده، دوباره درخواست نفرست
            if (state.featuresGrouped.length && state.loadedProductId === productId) {
                return;
            }

            commit('SET_BUSY', true);
            commit('SET_LOADED_PRODUCT_ID', productId);

            try {
                const response = await fetchProductFeatures(productId);
                const rawData = response.data;
                const groupedMap = new Map();

                rawData.forEach(feature => {
                    if (!groupedMap.has(feature.groupId)) {
                        groupedMap.set(feature.groupId, {
                            groupId: feature.groupId,
                            groupName: feature.groupName,
                            items: []
                        });
                    }

                    const group = groupedMap.get(feature.groupId);

                    let item = group.items.find(i => i.itemId === feature.itemId);
                    if (!item) {
                        item = {
                            itemId: feature.itemId,
                            itemName: feature.itemName,
                            values: []
                        };
                        group.items.push(item);
                    }

                    if (feature.itemsValue && !item.values.includes(feature.itemsValue)) {
                        item.values.push(feature.itemsValue);
                    }
                });

                commit('SET_FEATURES', Array.from(groupedMap.values()));
            } catch (error) {
                console.error('خطا در بارگذاری ویژگی‌ها:', error);
            } finally {
                commit('SET_BUSY', false);
            }
        }
    }
};
