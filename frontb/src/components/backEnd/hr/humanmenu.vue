<template>
  <div>
    human res
    <b-card no-body>
      <b-tabs id="tabs" pills card v-model="step">
        <b-tab :title="this.$t('hr_menu_main')">
          <personinsert />
        </b-tab>
        <b-tab :title="this.$t('hr_menu_employee')">
          employee
        </b-tab>
        <b-tab :title="this.$t('hr_menu_employment')">
          employment
        </b-tab>
        <b-tab :title="this.$t('hr_menu_employPosition')">
          employeePosition
        </b-tab>
        <b-tab :title="this.$t('hr_menu_skills')">
          <skill />
        </b-tab>
        <b-tab :title="this.$t('hr_menu_training')">
          training
        </b-tab>
        <b-tab :title="this.$t('hr_menu_resume')">
          <resume />
        </b-tab>
        <b-tab :title="this.$t('hr_menu_leave')">
          <leave />
        </b-tab>
      </b-tabs>
    </b-card>
  </div>
</template>

<script>

// import training from  './training'
import personinsert from './personinsert'
import skill from './skill'
import resume from './resume'
import leave from './leave'

export default {
  name: 'humanmenu',
  props: {
  },
  data() {
    return {
      step: 0,
    }
  },
  methods: {

  },
  components: {
    resume,
    skill,
    personinsert,
    leave
    // training,
  }
}
</script>

<style scoped></style>