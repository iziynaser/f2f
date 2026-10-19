<template>
  <div >      
        <!-- <b-img :src="icons[en]" />
        <b-img :src="icons[fa]" /> -->
  </div>
</template>

<script>
import usIcon from 'svg-country-flags/svg/us.svg'
import faIcon from 'svg-country-flags/svg/ir.svg'
//import {locales} from '../config/i18n'

export default {
  name: 'localeswitcher',
  components: {

  },
  data () {
    return {
        icons:{
            en:usIcon,
            fa:faIcon
            }  ,
            //locales
    }
  }
}
</script>

<style scoped>

</style>
