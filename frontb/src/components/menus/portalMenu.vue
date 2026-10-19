<template>
  <div>
    <b-nav-item-dropdown :text="$t('PORTAL_SITE')" right>

      <b-dropdown-item href="#">
        <router-link to="/contact"></router-link>
        <b-button  size="sm" variant="link" @click="createPortalTabs(0,$t('PORTAL_timesheet'))">{{ $t('PORTAL_timesheet') }}</b-button>
      </b-dropdown-item>

      <b-dropdown-item href="#">
        <router-link to="/contact"></router-link>
        <b-button  size="sm" variant="link" @click="createPortalTabs(1,$t('PORTAL_mytask'))">{{ $t('PORTAL_mytask') }}</b-button>
      </b-dropdown-item>

      <b-dropdown-item href="#">
        <router-link to="/contact"></router-link>
        <b-button  size="sm" variant="link" @click="createPortalTabs(2,$t('PORTAL_myleave'))">{{ $t('PORTAL_myleave') }}</b-button>
      </b-dropdown-item>

      <b-dropdown-item href="#">
        <router-link to="/contact"></router-link>
        <b-button  size="sm" variant="link" @click="createPortalTabs(3,$t('PORTAL_mytraining'))">{{ $t('PORTAL_mytraining') }}</b-button>
      </b-dropdown-item>

      <b-dropdown-item href="#">
        <router-link to="/contact"></router-link>
        <b-button  size="sm" variant="link" @click="createPortalTabs(4,$t('PORTAL_mytraining'))">{{ $t('PORTAL_mytraining') }}</b-button>
      </b-dropdown-item>

      <b-dropdown-item href="#">
        <router-link to="/contact"></router-link>
        <b-button  size="sm" variant="link" @click="createPortalTabs(5,$t('charts'))">{{ $t('charts') }}</b-button>
      </b-dropdown-item>

      <b-dropdown-item href="#">
        <router-link to="/contact"></router-link>
        <b-button  size="sm" variant="link" @click="createPortalTabs(6,$t('links'))">{{ $t('links') }}</b-button>
      </b-dropdown-item>

      <b-dropdown-item href="#">
        <router-link to="/contact"></router-link>
        <b-button  size="sm" variant="link" @click="createPortalTabs(7,$t('calendar'))">{{ $t('calendar') }}</b-button>
      </b-dropdown-item>

      <b-dropdown-item href="#">
        <router-link to="/contact"></router-link>
        <b-button  size="sm" variant="link" @click="createPortalTabs(8,$t('notes'))">{{ $t('notes') }}</b-button>
      </b-dropdown-item>

      <b-dropdown-item href="#">
        <router-link to="/contact"></router-link>
        <b-button  size="sm" variant="link" @click="createPortalTabs(9,$t('phone'))">{{ $t('phone')}}</b-button>
      </b-dropdown-item>

      <b-dropdown-item href="#">
        <router-link to="/contact"></router-link>
        <b-button  size="sm" variant="link" @click="createPortalTabs(10,$t('softwares'))">{{ $t('softwares') }}</b-button>
      </b-dropdown-item>
    </b-nav-item-dropdown>
  </div>
</template>

<script>
import charts from '../portal/charts.vue';
import links from '../portal/links.vue';
import calendar from '../portal/calendar.vue';
import notes from '../portal/notes.vue';
import phone from '../portal/phone.vue';
import appInfo from '../../back/appInfo.vue'
import softwares from '../portal/softwares.vue'

export default {
  name: 'portalMenu',
  props: {
  },
    data() {
        return {
          cp: [
            appInfo,
            charts,
            links,
            calendar,
            notes,
            phone,
            softwares
           ]
        }
    },
  methods: {
    createPortalTabs(idParam, nameParam) {
      let atab = {
        id: idParam ,
        name: nameParam,
        contnt : this.cp[idParam]
      }
      atab.id = (atab.id + 40);
      //console.log('catalog :'+atab);
      this.$emit('createHelpDeskTab',atab);
    }
  },
}
</script>

<style scoped></style>