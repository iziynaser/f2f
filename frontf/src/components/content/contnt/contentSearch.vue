<template>
    <div>
        <!-- content search -->
        <b-row>
            <b-col>
                <b-row class="my-1">
                    <b-col>
                        {{ $t('CONTENT_SEARCH_name') }}
                    </b-col>
                    <b-col>
                        <b-input type="text" />
                    </b-col>
                </b-row>
                <b-row class="my-1">
                    <b-col>
                        {{ $t('CONTENT_SEARCH_title') }}
                    </b-col>
                    <b-col>
                        <b-input type="text" />
                    </b-col>
                </b-row>
                <b-row class="my-1">
                    <b-col>
                        {{ $t('CONTENT_SEARCH_purpose') }}
                    </b-col>
                    <b-col>
                        <b-form-select>
                            <template v-slot:first>
                                <b-form-select-option :value="null" disabled>select a purpose</b-form-select-option>
                            </template>
                            <b-form-select-option value="company info">{{ $t('content_s_company_info')
                            }}</b-form-select-option>
                            <b-form-select-option value="general Info">{{ $t('content_s_general_Info')
                            }}</b-form-select-option>
                            <b-form-select-option value="product Info">{{ $t('content_s_product_Info')
                            }}</b-form-select-option>
                            <b-form-select-option value="project Info">{{ $t('content_s_project_Info')
                            }}</b-form-select-option>
                            <b-form-select-option value="sub content">{{ $t('content_s_sub_content')
                            }}</b-form-select-option>
                            <b-form-select-option value="topic">{{ $t('content_s_topic') }}</b-form-select-option>
                            <b-form-select-option value="feedback">{{ $t('content_s_feedback') }}</b-form-select-option>
                            <b-form-select-option value="advertisement">{{ $t('content_s_advertisement')
                            }}</b-form-select-option>
                            <b-form-select-option value="main content">{{ $t('content_s_main_content')
                            }}</b-form-select-option>
                            <b-form-select-option value="article">{{ $t('content_s_article') }}</b-form-select-option>
                            <b-form-select-option value="comment">{{ $t('content_s_comment') }}</b-form-select-option>
                            <b-form-select-option value="description">{{ $t('content_s_description')
                            }}</b-form-select-option>
                            <b-form-select-option value="ledgal info"> {{ $t('content_s_ledgal_info')
                            }}</b-form-select-option>
                            <b-form-select-option value="response">{{ $t('content_s_response') }}</b-form-select-option>
                            <b-form-select-option value="faq">{{ $t('content_s_faq') }}</b-form-select-option>
                            <b-form-select-option value="owner">{{ $t('content_s_owner') }}</b-form-select-option>
                            <b-form-select-option value="user">{{ $t('content_s_user') }}</b-form-select-option>
                            <b-form-select-option value="personal info"> {{
                                $t('content_s_personal_info') }}</b-form-select-option>
                        </b-form-select>
                    </b-col>
                </b-row>

                <b-row class="my-1">
                    <b-col>
                        {{ $t('CONTENT_SEARCH_fromDate') }}
                    </b-col>
                    <b-col>
                        <b-input type="date"></b-input>
                    </b-col>
                </b-row>

                <b-row class="my-1">
                    <b-col>
                        {{ $t('CONTENT_SEARCH_isPublic') }}
                    </b-col>
                    <b-col>
                        <b-form-select>
                            <b-form-select-option value="yes">{{ $t('content_s_yes') }}</b-form-select-option>
                            <b-form-select-option value="no">{{ $t('content_s_no') }}</b-form-select-option>
                        </b-form-select>
                    </b-col>
                </b-row>

            </b-col>
            <b-col>
                <!-- start col2 -->
                <b-row class="my-1">
                    <b-col>
                        {{ $t('CONTENT_SEARCH_status') }}
                    </b-col>
                    <b-col>
                        <b-button-group>
                            <b-dropdown right :text="this.$t('change_state_to')">
                                <b-dropdown-item>{{ $t('content_s_inProgress') }}</b-dropdown-item>
                                <b-dropdown-item>{{ $t('content_s_initial_draft') }}</b-dropdown-item>
                                <b-dropdown-item>{{ $t('content_s_revised_draft') }}</b-dropdown-item>
                                <b-dropdown-item>{{ $t('content_s_final_draft') }}</b-dropdown-item>
                                <b-dropdown-item>{{ $t('content_s_available') }}</b-dropdown-item>
                                <b-dropdown-item>{{ $t('content_s_deactivated') }}</b-dropdown-item>
                                <b-dropdown-item>{{ $t('content_s_published') }}</b-dropdown-item>
                            </b-dropdown>
                        </b-button-group>
                    </b-col>
                </b-row>

                <b-row class="my-1">
                    <b-col>
                        {{ $t('CONTENT_SEARCH_description') }}
                    </b-col>
                    <b-col>
                        <b-input type="text" />
                    </b-col>
                </b-row>
                <b-row class="my-1">
                    <b-col>
                        {{ $t('CONTENT_SEARCH_seqNum') }}
                    </b-col>
                    <b-col>
                        <b-input type="text" />
                    </b-col>
                </b-row>
                <b-row>
                    <b-col>
                        {{ $t('CONTENT_SEARCH_toDate') }}
                    </b-col>
                    <b-col>
                        <b-input type="date"></b-input>
                    </b-col>
                </b-row>
                <b-row class="my-1">
                    <b-col>
                        {{ $t('CONTENT_SEARCH_contentType') }}
                    </b-col>
                    <b-col>
                        <b-form-select>
                            <b-form-select-option>error root</b-form-select-option>
                            <b-form-select-option>forum root</b-form-select-option>
                            <b-form-select-option>maintance</b-form-select-option>
                            <b-form-select-option>menu root</b-form-select-option>
                            <b-form-select-option>web page</b-form-select-option>
                            <b-form-select-option>blog root</b-form-select-option>
                            <b-form-select-option>alert</b-form-select-option>
                            <b-form-select-option>info</b-form-select-option>
                        </b-form-select>
                    </b-col>
                </b-row>

            </b-col>
        </b-row>
        <!-- <b-row class="my-1">
              <b-col></b-col>
              <b-col>
                            content status : 
              </b-col>
          </b-row> -->
        <b-button size="sm" variant="success" ref="saveBtn" @click="searchForm()">{{ $t('search') }}</b-button>

        <b-row>
            <f2fTable :searchResult="datas.content" :searchFields="fields" />
        </b-row>

    </div>
</template>

<script>

import axiosInstance from '@/api/axiosInstance';
import f2fTable from '../../base/f2fTable'

export default {
    name: 'contentSearch',
    components: {
        f2fTable
    },
    props: {
    },
    data() {
        return {
            datas: Object,
            fields: [
                { key: 'id', label: 'شناسه' },
                { key: 'code', label: 'کد' },
                { key: 'title', label: 'عنوان' },
                { key: 'name', label: 'نام' },
                { key: 'seq', label: 'ترتیب' },
                { key: 'description', label: 'شرح' },
                { key: 'purpose', label: 'هدف انتشار' },
                { key: 'contentType', label: 'نوع محتوا' },
            ],
            form: {
            }
        }
    },
    methods: {
        searchForm() {
            var self = this;
            const url = "/content/search";
            axiosInstance.post(url, self.form)
                .then((res) => {
                    //console.log(res);
                    self.datas = res.data;
                    //console.log(self.datas);
                })
                .catch((err) => {
                    console.log(err);
                })

        }
    }
}
</script>

<style scoped></style>