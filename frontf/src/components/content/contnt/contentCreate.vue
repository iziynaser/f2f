<template>
    <div>
        <!-- <b-container fluid> -->
        <!-- <b-row class="my-1">
                <b-col sm="3">{{$t('C_PRODUCT_KEY_KEYNAME')}}</b-col>
                <b-col sm="9"><b-form-input v-model="form.keyName" type="text"/>
                </b-col>
            </b-row> -->
        <!-- </b-container>                    -->

        <b-row class="my-1">
            <b-col>{{ $t('CONTENT_CREATE_name') }}</b-col>
            <b-col>
                <b-input type="text" />
            </b-col>
        </b-row>
        <b-row class="my-1">
            <b-col>{{ $t('CONTENT_CREATE_tite') }}</b-col>
            <b-col>
                <b-input type="text" />
            </b-col>
        </b-row>
        <b-row class="my-1">
            <b-col>{{ $t('CONTENT_CREATE_description') }}</b-col>
            <b-col>
                <b-input type="text" />
            </b-col>
        </b-row>
        <b-row class="my-1">
            <b-col>
                {{ $t('CONTENT_CREATE_seqNum') }}
            </b-col>
            <b-col>
                <b-input type="text" />
            </b-col>
        </b-row>
        <b-row class="my-1">
            <b-col>
                {{ $t('CONTENT_CREATE_purpose') }}
            </b-col>
            <b-col>
                <b-form-select v-model="form.purposeType" :options="purposeTypeOptions">
                </b-form-select>
            </b-col>
        </b-row>
        <b-row class="my-1">
            <b-col>{{ $t('CONTENT_CREATE_isPublic') }}</b-col>
            <b-col>
                <b-form-select>
                    <b-form-select-option value="yes">yes</b-form-select-option>
                    <b-form-select-option value="no">no</b-form-select-option>
                </b-form-select>
            </b-col>
        </b-row>
        <b-row class="my-1">
            <b-col>
                {{ $t('CONTENT_CREATE_contentType') }}
            </b-col>
            <b-col>
                <b-form-select v-model="form.contentType" :options="contentTypeOptions"></b-form-select>
            </b-col>
        </b-row>
        <b-row class="my-1">
            <b-col>
                {{ $t('CONTENT_CREATE_status') }}
            </b-col>
            <b-col>
                <b-button-group>
                    <b-dropdown right :text="this.$t('change_state_to')">
                        <b-dropdown-item>{{ this.$t('content_s_inProgress') }}</b-dropdown-item>
                        <b-dropdown-item>{{ this.$t('content_s_initial_draft') }}</b-dropdown-item>
                        <b-dropdown-item>revised draft</b-dropdown-item>
                        <b-dropdown-item>{{ this.$t('content_s_final_draft') }}</b-dropdown-item>
                        <b-dropdown-item>{{ this.$t('content_s_available') }}</b-dropdown-item>
                        <b-dropdown-item>{{ this.$t('content_s_deactivated') }}</b-dropdown-item>
                        <b-dropdown-item>{{ this.$t('content_s_published') }}</b-dropdown-item>
                    </b-dropdown>
                </b-button-group>
            </b-col>
        </b-row>
        <b-row class="my-1">
            <b-col>
                {{ $t('CONTENT_CREATE_fromDate') }}
            </b-col>
            <b-col>
                <b-input v-model="form.fromDate" type="date"></b-input>
            </b-col>
        </b-row>
        <b-row>
            <b-col>
                {{ $t('CONTENT_CREATE_toDate') }}
            </b-col>
            <b-col>
                <b-input v-model="form.toDate" type="date"></b-input>
            </b-col>
        </b-row>
        <b-button>
            {{ this.$t('save') }}
        </b-button>
    </div>
</template>

<script>
export default {
    name: 'contentCreate',
    props: {
    },
    data() {
        return {
            purposeTypeOptions: [
                { value: 0, text: 'select a purpose' },
                { value: 0, text: 'company info' },
                { value: 0, text: 'general Info' },
                { value: 0, text: 'product Info' },
                { value: 0, text: 'project Info' },
                { value: 0, text: 'sub content' },
                { value: 0, text: 'topic' },
                { value: 0, text: 'feedback' },
                { value: 0, text: 'advertisement' },
                { value: 0, text: 'main content' },
                { value: 0, text: 'article' },
                { value: 0, text: 'comment' },
                { value: 0, text: 'description' },
                { value: 0, text: 'ledgal info' },
                { value: 0, text: 'response' },
                { value: 0, text: 'faq' },
                { value: 0, text: 'owner' },
                { value: 0, text: 'user' },
                { value: 0, text: 'personal info' },
            ],
            contentTypeOptions: [
                { value: 0, text: 'error root' },
                { value: 1, text: 'forum root' },
                { value: 2, text: 'maintance' },
                { value: 3, text: 'menu root' },
                { value: 4, text: 'web page' },
                { value: 5, text: 'blog root' },
                { value: 6, text: 'alert' },
                { value: 7, text: 'info' },
            ],
            form: {
                name: '',
                title: '',
                description: '',
                seq: '',
                fromDate: '',
                toDate: '',
                contentType: '',
                purposeType: '',
                isPublic: '',
            }
        }
    },
    methods: {

    }
}
</script>

<style scoped></style>