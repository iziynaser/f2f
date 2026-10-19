//store/modules/brandService.js
import axiosInstance from '@/api/axiosInstance';

const brandCache = {};

export async function getBrandsByCategory(categoryId) {
    if (!categoryId) {
        return [];
    }

    // اگر کش وجود دارد از آن استفاده کن
    if (brandCache[categoryId]) {
        return brandCache[categoryId];
    }

    try {
        const { data } = await axiosInstance.get('/brand/byCategoryId', {
            params: { categoryId }
        });

        brandCache[categoryId] = data; // ذخیره در کش
        return data;
    } catch (error) {
        console.error("Error fetching brands:", error);
        throw error; // بذار Vuex هندل کنه
    }
}
