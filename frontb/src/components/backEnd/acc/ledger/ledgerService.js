import axios from 'axios'

const API_URL = '/ledger'

export default {

    getAccountLedger(accountId, periodId) {
        return axios.get(`${API_URL}/account`, {
            params: {
                accountId,
                periodId
            }
        })
    },

    getGeneralLedger(periodId) {
        return axios.get(`${API_URL}/general`, {
            params: {
                periodId
            }
        })
    }

}
