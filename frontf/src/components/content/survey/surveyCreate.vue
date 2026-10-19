<template>
    <div>
        <b-container fluid>
            <!-- <cProductMain :id="id" :title="title"/> -->
            <label>{{ this.$t('survey_c_assign_to') }}</label>
            <b-row class="my-1">
                <b-col>
                    <b-form-checkbox>{{ this.$t('survey_c_content') }}</b-form-checkbox>
                    <b-form-checkbox>{{ this.$t('survey_c_product') }}</b-form-checkbox>
                </b-col>
                <b-col>
                    <b-form-group label="Filter" label-cols-sm="3" label-align-sm="right" label-size="sm"
                        label-for="filterInput" class="mb-0">
                        <b-input-group size="sm">
                            <b-form-input v-model="filter" type="search" id="filterInput"
                                placeholder="type to search"></b-form-input>
                            <b-input-group-prepend>
                                <b-button disabled="!filter" @click="filter = ''">clear</b-button>
                            </b-input-group-prepend>
                        </b-input-group>
                    </b-form-group>
                </b-col>
            </b-row>
            <b-row class="my-1">
                <b-col sm="3">
                    <label for="name">{{ this.$t('') }}</label>
                </b-col>
                <b-col sm="9">
                    <b-input id="name" type="text"></b-input>
                </b-col>
            </b-row>
            <b-row class="my-1">
                <b-col sm="3">
                    <label for="status">{{ this.$t('survey_c_status') }}</label>
                </b-col>
                <b-col sm="9">
                    <b-input id="status" type="text"></b-input>
                </b-col>
            </b-row>
            <b-row class="my-1">
                <b-col sm="3">
                    <label for="caption">{{ this.$t('survey_c_caption') }}</label>
                </b-col>
                <b-col sm="9">
                    <b-input id="caption" type="text"></b-input>
                </b-col>
            </b-row>
            <b-row class="my-1">
                <b-col sm="3">
                    <label for="description">{{ this.$t('survey_c_description') }}</label>
                </b-col>
                <b-col sm="9">
                    <b-input id="description" type="text"></b-input>
                </b-col>
            </b-row>
            <b-row class="my-1">
                <b-col sm="3">
                    <label for="description">{{ this.$t('survey_c_options') }}</label>
                </b-col>
                <b-col sm="9">
                    <b-form-checkbox name="instacheckButton" switch>allow user update his comment </b-form-checkbox>
                    <b-form-checkbox name="instacheckButton" switch>allow user insert multiple comment</b-form-checkbox>
                    <b-form-checkbox name="instacheckButton" switch>allow anonymous user insert comment</b-form-checkbox>
                </b-col>
            </b-row>
            <b-row class="my-1">
                <b-col>
                    <b-button size="small" variant="primary" v-on:click="saveSurvey">{{ this.$t('') }}</b-button>
                </b-col>
            </b-row>


        </b-container>
    </div>
</template>

<script>
export default {
    name: 'surveyCreate',
    props: {
    },
    data() {
        return {

        }
    },
    methods: {

    }
}
</script>

<style scoped></style>