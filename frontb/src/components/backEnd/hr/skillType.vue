<template>
    <div>
        <div>skill types</div>
        <b-card>
            <div>
                <b-form-group>
                    <b-row class="my-1">
                        <b-col>
                            skill name
                        </b-col>
                        <b-col>
                            <b-input />
                        </b-col>
                    </b-row>
                    <b-row class="my-1">
                        <b-col>skill rate</b-col>
                        <b-col>
                            <b-input />
                        </b-col>
                    </b-row>
                    <b-row>
                        <b-button class="alert-primary">{{ this.$t('save') }}</b-button>
                    </b-row>
                </b-form-group>
            </div>
            <f2fTable :searchResult="searchResult" :searchFields="searchFields" :caption="this.$t('searchResults')"
                :busy="isBusy" />
        </b-card>
    </div>
</template>

<script>


import axios from 'axios'
import f2fTable from '../../base/f2fTable'

export default {
    name: 'skillType',
    props: {
    },
    data() {
        return {
            id: '',
            name: '',
            rate: '',
            isBusy: false,
            errors: {},
            searchResult: [],
            searchFields: [
                { key: 'id', label: 'شناسه' },
                { key: 'name', label: 'نام' },
                { key: 'rate', label: 'درجه مهارت' },
            ],
        }
    },
    methods: {
        onSearchResult() {
            var self = this;
            this.errors = {};
            this.isBusy = true;
            axios({
                method: 'GET',
                url: '/skillType/list',
            })
                .then(function (res) {
                    self.searchResult = res.data;
                    console.log(res.data);
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
    }
}
</script>

<style scoped></style>