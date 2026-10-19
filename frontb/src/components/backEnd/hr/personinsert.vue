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
                    <b-col sm="3">{{ this.$t('hr_i_title') }}</b-col>
                    <b-col sm="9">
                        <b-form-select v-model="form.title" :options="form.titleoptions" />
                    </b-col>
                </b-row>

                <b-row class="my-1">
                    <b-col sm="3">{{ this.$t('hr_i_name') }}</b-col>
                    <b-col sm="9">
                        <b-form-input id="name" v-model="form.name" required placeholder="enter your name" />
                    </b-col>
                </b-row>

                <b-row class="my-1">
                    <b-col sm="3">{{ this.$t('hr_i_lastname') }}</b-col>
                    <b-col sm="9">
                        <b-form-input id="lastname" v-model="form.lastname" required placeholder="enter your lastname" />
                    </b-col>
                </b-row>

                <b-row>
                    <b-col sm="3">{{ this.$t('hr_i_address') }}</b-col>
                    <b-col sm="9">
                        <b-form-input id="address" v-model="form.address" required placeholder="enter your adress" />
                    </b-col>
                </b-row>

                <b-row class="my-1">
                    <b-col sm="3">{{ this.$t('hr_i_description') }}</b-col>
                    <b-col sm="9">
                        <b-form-textarea id="description" v-model="form.description" placeholder="description" rows="3"
                            max-rows="6" />
                    </b-col>
                </b-row>

                <b-row class="my-1">
                    <b-col sm="3">{{ this.$t('hr_i_date_of_birth') }}</b-col>
                    <b-col sm="9">
                        <pdate />
                    </b-col>
                </b-row>

                <b-button type="submit" variant="primary">{{ this.$t('submit') }}</b-button>
                <b-button type="reset" variant="danger">{{ this.$t('reset') }}</b-button>
            </b-form>

        </b-container>

    </div>
</template>

<script>

import pdate from '../../../components/pdate'

export default {
    name: 'personinsert',
    props: {

    },
    data() {
        return {
            visible: true,
            errors: [],
            form: {
                title: '',
                name: '',
                address: '',
                description: '',
                titleoptions: [
                    { value: 'male', text: 'male' },
                    { value: 'female', text: 'female' }
                ]
            }
        }
    },
    methods: {
        validateForm: function (event) {
            console.log(event);
        },
        onSubmit: function (event) {
            event.preventDefault();
            this.axios.post('/person/', {
                person: this.$data
            }).then(function (response) {
                console.log(response.data);
            }).catch(function (error) {
                console.log(error.data);
            });
            console.log('submit person insert');
        },
        onReset: function (event) {
            event.preventDefault()
            this.form.name = ''
        }
    },
    components: {
        pdate
    }
}
</script>

<style scoped></style>