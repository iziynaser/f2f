<template>
    <div>
        <b-nav-item-dropdown :text="$t('LANG_SITE')" right>

            <!-- <b-dropdown-item href="#" @click="changeLocale('en')" >{{$t('LANG_en')}}</b-dropdown-item>
            <b-dropdown-item href="#" @click="changeLocale('fa')">{{$t('LANG_fa')}}</b-dropdown-item> -->

            <b-dropdown-item href="#" @click="sMethod('en')" >{{$t('LANG_en')}}</b-dropdown-item>
            <b-dropdown-item href="#" @click="sMethod('fa')">{{$t('LANG_fa')}}</b-dropdown-item>

        </b-nav-item-dropdown>
    </div>
</template>

<script>

// import i18next from 'i18next'
// import {loadAsset,removeAsset} from '../../api/util'


import { f2fChangeLocale } from '../../f2fUtils';

export default {
    name:'langMenu',
    props:{
          } ,
    data(){
      return {
        
      }
    } ,
    methods:{

            sMethod(str){
              f2fChangeLocale(str);
            },

        //     changeLocale:function(str){       
        //         console.log(str);
        //         //i18next.changeLanguage(str);
        //         i18next.on('languageChanged',function(lng){
        //           console.log(lng);
        //           window.document.documentElement.lang = lng;
        //           let dir = i18next.dir(lng);                  
        //           window.document.documentElement.dir = dir
        //           if (dir === 'rtl') {
        //             console.log('rtl');
        //             loadAsset('static/style/rtl.css','css')
        //             loadAsset('static/style/vendor/GhalamborM/bootstrap4-rtl.css','css')
        //           }else{
        //             console.log('ltr');
        //             removeAsset('static/style/rtl.css','css')
        //             removeAsset('static/style/vendor/GhalamborM/bootstrap4-rtl.css','css')
        //           }

        //         });
        //         i18next.changeLanguage(str);
        // }

    }      
}
</script>

<style scoped>

</style>