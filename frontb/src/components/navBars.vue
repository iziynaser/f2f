<template>
  <div>
    <!-- <Logo/> -->

    <!-- main menu -->
    <b-navbar toggleable="sm" type="dark" variant="dark">

      <b-navbar-toggle target="nav-collapse"></b-navbar-toggle>

      <b-collapse id="nav-collapse" is-nav>

        <!-- Right aligned nav items -->
        <b-navbar-nav class="ml-auto">

<!--          <categoriesMenu @createAppTab="createAppTab"/>-->

          <orderMenu @createAppTab="createAppTab"/>

          <portalMenu />

          <humanResMenu @createAppTab="createAppTab"/>

          <accountingMenu @createAppTab="createAppTab"/>

          <reportMenu @createAppTab="createAppTab"/>

          <userMenu @createAppTab="createAppTab"/>

          <catalogMenu  @createAppTab="createAppTab"/>

          <contentMenu  @createAppTab="createAppTab"/>

          <langMenu />

          <b-dropdown-item href="#">
              <b-button fill rounded size="sm" variant="link" @click="createAppInfoTab(1001,$t('appInfo'))">{{ $t('appInfo') }}</b-button>
          </b-dropdown-item>
                    <!-- <customMenus /> -->

          <!-- <cmsMenu /> -->

                    <!-- <b-nav-item-dropdown :text="$t('PARTY_SITE')" right>
          <b-dropdown-item href="#" >
              <router-link to="/humanres">WebSite</router-link>
          </b-dropdown-item>
        </b-nav-item-dropdown> -->

          <!-- <b-nav-item-dropdown :text="$t('POS_SITE')" right>
          <b-dropdown-item href="#" >
              <router-link to="/humanres">WebSite</router-link>
          </b-dropdown-item>
        </b-nav-item-dropdown> -->
                    <!-- <b-nav-item-dropdown text="CONTENT" right>
            <b-dropdown-item href="#">
              <router-link to="/contentC">Content</router-link>
            </b-dropdown-item>
          </b-nav-item-dropdown> -->

          <!-- <div class="dropdown">
          <button class="btn btn-outline-info dropdown-toggle" 
                  aria-haspopup="true"
                  aria-expanded="false"
                  data-toggle="dropdown"
                  type="button" 
                  id="catButton" >cat
          </button>
        </div>
        <div class="dropdown-menu">
            <a class="dropddown-item">c1</a>
            <a  class="dropddown-item">c2</a>
            <a  class="dropddown-item">c3</a>            
        </div> -->

        </b-navbar-nav>
      </b-collapse>
    </b-navbar>
    <div style="margin-top:20px;"></div>
  </div>
</template>

<script>

//import categoriesMenu from './categories/categoriesMenu'
import orderMenu from './menus/orderMenu'
import portalMenu from './menus/portalMenu'
import humanResMenu from './menus/humanResMenu'
import catalogMenu from './menus/catalogMenu'
import langMenu from './menus/langMenu'
import contentMenu from './menus/contentMenu'
import accountingMenu from './menus/accountingMenu'
import reportMenu from './menus/reportMenu'
//import customMenus from './menus/customMenus'
import userMenu from './menus/userMenu'
//import cmsMenu from './menus/cmsMenu'
import appInfo from '../back/appInfo.vue';
import { baseUrl } from '../api/util'
// import Logo from '../front/Logo.vue'

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
    //categoriesMenu,
    orderMenu,
    portalMenu,
    humanResMenu,
    catalogMenu,
    langMenu,
    contentMenu,
    accountingMenu,
    reportMenu,
    //customMenus,
    userMenu,
    //cmsMenu,
    // Logo
  },
  methods: {
        createAppInfoTab(idParam, nameParam) {
          let atab = {
            id: idParam ,
            name: nameParam,
            content : this.cp[0]
          }
          atab.id = (atab.id + 1001);
          //console.log(atab);
          this.$emit('createAppTab',atab);
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