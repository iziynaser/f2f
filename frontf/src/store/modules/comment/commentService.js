import axiosInstance from '@/api/axiosInstance';

const baseUrl = '/comments';

export default {
    fetchComments(productId) {
        return axiosInstance.get(`${baseUrl}/list`, { params: { productId } });
    },

    saveComment(commentData) {
        return axiosInstance.post(`${baseUrl}/save`, commentData);
    },

    voteComment(commentId, type) {
        return axiosInstance.post(`${baseUrl}/vote`, { commentId, type });
    }
};
