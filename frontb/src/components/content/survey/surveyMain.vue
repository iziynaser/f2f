<template>
    <div>
        survey
        <b-card no-body>
            <b-tabs pills card>
                <b-tab :title="this.$t('survey_mtab_search')">
                    action : activate , deactived , fixed , delete
                </b-tab>
                <b-tab :title="this.$t('survey_mtab_create')">
                    <surveyCreate />
                </b-tab>
                <b-tab :title="this.$t('survey_mtab_survey')">
                    {{ this.$t('survey_d_delete_survey') }}

                </b-tab>
            </b-tabs>
        </b-card>
    </div>
</template>

<script>

import surveyCreate from './surveyCreate'

export default {
    name: 'surveyMain',
    props: {

    },
    data() {
        return {

        }
    },
    methods: {

    },
    components: {
        surveyCreate
    }
}
</script>

<style scoped></style>