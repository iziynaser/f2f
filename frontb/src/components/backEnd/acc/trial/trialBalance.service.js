import axios from 'axios';

const API_BASE = '/api';

export default {
    getTrialBalance(periodId) {
        return axios.get(`${API_BASE}/trial-balance/${periodId}`);
    },

    // اگر API دوره‌ها دارید:
    getAccountingPeriods() {
        return axios.get(`${API_BASE}/accounting-periods`);
    }
};
