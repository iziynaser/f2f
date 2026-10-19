import axiosInstance from '@/api/axiosInstance';

export function fetchProductFeatures(productId) {
    return axiosInstance.get('/product-feature-group/features', {
        params: { productId }
    });
}
