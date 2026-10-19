<template>
    <div>
        <b-container fluid>

            <div v-if="errors.length">
                <b>please correct this error(s):</b>
                <ul>
                    <li v-bind="error in errors">{{ error }}</li>
                </ul>
            </div>

            <b-form @submit="onSubmit" @reset="onReset" v-if="visible">

                <b-row class="my-1">
                    <b-col sm="3">skill type id</b-col>
                    <b-col sm="9">
                        <b-form-select v-model="form.title" :options="form.titleoptions" />
                    </b-col>
                </b-row>

                <b-row class="my-1">
                    <b-col sm="3">{{ this.$t('year_experience') }}</b-col>
                    <b-col sm="9">
                        <b-form-input id="name" v-model="form.name" required placeholder="enter your name" />
                    </b-col>
                </b-row>

                <b-row class="my-1">
                    <b-col sm="3">rating</b-col>
                    <b-col sm="9">
                        <b-form-input id="lastname" v-model="form.lastname" required placeholder="enter your lastname" />
                    </b-col>
                </b-row>

                <b-row>
                    <b-col sm="3">{{ this.$t('skill_level') }}</b-col>
                    <b-col sm="9">
                        <b-form-input id="address" v-model="form.address" required placeholder="enter your adress" />
                    </b-col>
                </b-row>

                <b-row>
                    <b-col sm="9">
                        <b-button type="submit" variant="primary">{{ this.$t('submit') }}</b-button>
                        <b-button type="reset" variant="danger">{{ this.$t('reset') }}</b-button>
                    </b-col>
                </b-row>
            </b-form>

        </b-container>

    </div>
</template>

<script>



export default {
    name: 'skill',
    props: {

    },
    data() {
        return {
            visible: true,
            errors: [],
            form: {}
        }
    },
    methods: {
        validateForm: function (event) {
            console.log(event);
        },
        onSubmit: function (event) {
            console.log(event);
        },
        onReset: function (event) {
            console.log(event);
        }
    },
    components: {

    }
}
</script>

<style scoped></style>