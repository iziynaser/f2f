import { CONSTANTS } from '../../../api/constants'

export default {

    login: function(username, password) {
        const body = {
            username: username,
            password: password
        }
        // مستقیم فراخوانی axios از فرم لاگین انجام می‌شود
        return body
    },

    url: function(address) {
        return CONSTANTS.ROOT_URL + '/' + address
    }
}
