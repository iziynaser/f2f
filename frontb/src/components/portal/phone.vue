<template>
    <div>
        <b-container fluid>
            <b-card>
                <b-collapse id="searchCollapse" visible @hide="hideCollapse" @show="showCollapse">
                    dfgsdfgsdfg
                </b-collapse>
            </b-card>
            <b-card>
                <b-card>
                    <b-row class="my-1">phone book</b-row>
                    <b-row class="my-1">

                        <b-col sm="9">
                            <!-- <label for="sfield">enter the name , family , group , role , ... </label>
                            <b-form-input id="sfield" v-model="sfield" size="sm" type="text"></b-form-input> -->
                        </b-col>
                        <b-col sm="3"><b-button>search</b-button></b-col>
                    </b-row>
                </b-card>
                <f2fTable :searchResult="searchResult" :searchFields="searchFields" :busy="isBusy"
                    :caption="this.$t('searchResults')" />
            </b-card>
        </b-container>
    </div>
</template>

<script>

import axios from 'axios'
import f2fTable from '../base/f2fTable'

export default {
    name: 'phone',
    props: {
    },
    data() {
        return {
                    isBusy: false,
            iconName: 'caret-down',
            searchResult: [],
            searchFields: [
                { key: "id", label: this.$t('id') },
                { key: "pic", label: this.$t('pic') },
                { key: "firstName", label: this.$t('firstNamr') },
                { key: "lastName", label: this.$t('lastName') },
                { key: "group", label: this.$t('group') },
                { key: "role", label: this.$t('role') },
                { key: "company", label: this.$t('company') },
                { key: "semat", label: this.$t('semat') },
                { key: "+", label: '+' },
            ],
        }
    },
    components: {
        f2fTable,
    },
    methods: {
        hideCollapse() {
            this.iconName = 'caret-right';
        },
        showCollapse() {
            this.iconName = 'caret-down';
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
                    self.searchResult = res.data;
                    self.isBusy = false;
                })
                .catch(function (error) {
                    console.log(error);
                });
        }
    },
    mounted() {
        this.onSearchResult();
    }
}
</script>

<style scoped></style>