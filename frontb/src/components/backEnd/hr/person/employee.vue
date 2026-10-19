<template>
    <b-container fluid>
        <b-row class="my-1">
            <b-col sm="3">
                <label for="categoryCode">{{ $t('CATEGORIES_MAIN_categoryCode') }}</label>
            </b-col>
            <b-col sm="9">
                <b-form-input id="categoryCode" size="sm" type="text"></b-form-input>
            </b-col>
        </b-row>
        <b-row>
            <b-button>{{ this.$t('find') }}</b-button>
        </b-row>
        <f2fTable :searchResult="items" :searchFields="fields" :caption="list_of_persons" @rowSelected="rowSelected" />
    </b-container>
</template>

<script>

import f2fTable from '../../../base/f2fTable'
import axios from 'axios'

export default {
    name: 'employee',
    props: {
        lkdata: [],
        id: String
    },
    data() {
        return {
            items: [],
            isBusy: false,
            errors: {},
            fields: [
                { key: "personId", label: this.$t('id') },
                { key: "firstName", label: this.$t('firstName') },
                { key: "lastName", label: this.$t('lastName') },
                { key: "personCode", label: this.$t('personCode') }
            ],
        }
    },
    methods: {
        rowSelected(item) {
            this.$bvModal.hide(this.id);
            this.$emit("bClicked", item);
        },
        onSearchResult() {
            var self = this;
            this.errors = {};
            this.isBusy = true;
            axios({
                method: 'GET',
                url: '/persons/list',
            })
                .then(function (res) {
                    self.items = res.data;
                    self.isBusy = false;
                })
                .catch(function (error) {
                    console.log(error);
                });
        }
    },
    mounted() {
        this.onSearchResult();
    },
    components: {
        f2fTable
    },
}
</script>

<style scoped></style>