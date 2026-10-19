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
                    <b-col sm="3">{{ $t('personId') }}</b-col>
                    <b-col sm="9">
                        <b-form-select v-model="form.title" :options="form.titleoptions" />
                    </b-col>
                </b-row>

                <b-row class="my-1">
                    <b-col sm="3">{{ $t('leave_id') }}</b-col>
                    <b-col sm="9">
                        <b-form-select v-model="form.title" :options="form.titleoptions" />
                    </b-col>
                </b-row>

                <b-row class="my-1">
                    <b-col sm="3">{{ this.$t('fromDate') }}</b-col>
                    <b-col sm="9">
                        <date-picker v-model="form.fromDate" type="date"></date-picker>
                    </b-col>
                </b-row>
                <b-row class="my-1">
                    <b-col sm="3">{{ this.$t('toDate') }}</b-col>
                    <b-col sm="9">
                        <date-picker v-model="form.toDate" type="date"></date-picker>
                    </b-col>
                </b-row>

                <b-row>
                    <b-col sm="3">{{ this.$t('appover_person') }}</b-col>
                    <b-col sm="9">
                        <b-form-input id="address" v-model="form.address" required placeholder="enter your adress" />
                    </b-col>
                </b-row>

                <b-row class="my-1">
                    <b-col sm="3">{{ this.$t('leave_status') }}</b-col>
                    <b-col sm="9">
                        <b-form-select v-model="form.title" :options="form.titleoptions" />
                    </b-col>
                </b-row>

                <b-row>
                    <b-col sm="9">
                        <b-button type="submit" variant="primary">{{ this.$t('submit') }}</b-button>
                    </b-col>
                </b-row>
            </b-form>

        </b-container>

    </div>
</template>

<script>
import VuePersianDateTimePicker from 'vue-persian-datetime-picker'


export default {
    name: 'leave',
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
        datePicker: VuePersianDateTimePicker
    }
}
</script>

<style scoped></style>