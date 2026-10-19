
import i18next from 'i18next'
import {loadAsset,removeAsset} from './api/util'

function f2fChangeLocale(lng){           
    window.document.documentElement.lang = lng;
    let dir = i18next.dir(lng);                  
    window.document.documentElement.dir = dir
    if (dir === 'rtl') {
        loadAsset('static/style/rtl.css','css')
        loadAsset('static/style/vendor/GhalamborM/bootstrap4-rtl.css','css')
    }else{
        removeAsset('static/style/rtl.css','css')
        removeAsset('static/style/vendor/GhalamborM/bootstrap4-rtl.css','css')
    }
}

export { f2fChangeLocale }

