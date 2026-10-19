<template>
  <div>
    <b-navbar toggleable="sm" type="dark" variant="dark">

      <b-navbar-toggle target="nav-collapse"></b-navbar-toggle>

      <b-collapse id="nav-collapse" is-nav>

        <b-navbar-nav class="ml-auto">

          <categoriesMenu @createAppTab="createAppTab" />

          <orderMenu @createAppTab="createAppTab" />

          <userMenu @createAppTab="createAppTab" />

          <catalogMenu @createAppTab="createAppTab" />

          <contentMenu @createAppTab="createAppTab" />

          <langMenu />

        </b-navbar-nav>
      </b-collapse>
    </b-navbar>
    <div style="margin-top:20px;"></div>
  </div>
</template>

<script>

import categoriesMenu from './categories/categoriesMenu'
import orderMenu from './menus/orderMenu'
import catalogMenu from './menus/catalogMenu'
import langMenu from './menus/langMenu'
import contentMenu from './menus/contentMenu'
import userMenu from './menus/userMenu'
import { baseUrl } from '../api/util'

export default {
  name: 'navBars',
  data() {
    return {
      cp: [
        appInfo
      ]
    }
  },
  components: {
    //appInfo,
    categoriesMenu,
    orderMenu,
    humanResMenu,
    catalogMenu,
    langMenu,
    contentMenu,
    reportMenu,
    userMenu,
  },
  methods: {
    createAppInfoTab(idParam, nameParam) {
      let atab = {
        id: idParam,
        name: nameParam,
        content: this.cp[0]
      }
      atab.id = (atab.id + 1001);
      //console.log(atab);
      this.$emit('createAppTab', atab);
    },
    createAppTab(atab) {
      //console.log('navbars:'+atab);
      this.$emit('createAppTab', atab);
    },
    urlI(u) {
      return baseUrl(u)
    }

  }
}
</script>