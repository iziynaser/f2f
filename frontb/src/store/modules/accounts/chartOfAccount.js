import axios from "axios"

const API = "/accounts"

export const getAccountTree = () => {
    return axios.get(`${API}/tree`)
}

export const createAccount = (data) => {
    return axios.post(API, data)
}

export const updateAccount = (id, data) => {
    return axios.put(`${API}/${id}`, data)
}

export const getAccount = (id) => {
    return axios.get(`${API}/${id}`)
}

export const deleteAccount = (id) => {
    return axios.delete(`${API}/${id}`)
}
