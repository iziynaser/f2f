import axios from 'axios'

export default {

    reverseTransaction(id, reason) {
        return axios.post(`/api/accounting/transactions/${id}/reverse`, {
            reason
        })
    }

}
