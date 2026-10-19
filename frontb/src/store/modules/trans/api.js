import axios from "axios"

const API="/transactions"

export function searchTransactions(filter){

    return axios.post(API+"/search",filter)

}

export function getTransaction(id){

    return axios.get(API+"/"+id)

}

export function getTransactions(params) {
        console.log('call getTransactions');
        return axios.get("/transactions", { params });
    }

// export function getTransaction(id) {
//         return axios.get(`/transactions/${id}`);
//     }

export function createTransaction(payload) {
        return axios.post("/transactions", payload);
    }
export function updateTransaction(id, payload) {
        // اگر بک‌اند PUT/PATCH ندارد، فعلاً می‌توانید همین را حذف کنید
        return axios.put(`/transactions/${id}`, payload);
    }
export function deleteTransaction(id) {
        return axios.delete(`/transactions/${id}`);
    }

    // Lifecycle actions
export function postTransaction(id) {
        return axios.post(`/transactions/${id}/post`);
    }
export function lockTransaction(id) {
        return axios.post(`/transactions/${id}/lock`);
    }
export function cancelTransaction(id) {
        return axios.post(`/transactions/${id}/cancel`);
    }

export function reverseTransaction(id, reason) {
        return axios.post(`/transactions/${id}/reverse`, null, {
            params: { reason },
        });
    }

    // Master data
export function getAccounts() {
        return axios.get("/accounts");
    }