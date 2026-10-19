<template>
    <div>
        <b-row class="my-1">
            <b-col>
                <label for="question"> {{ $t('qa_c_question') }} </label>
            </b-col>
            <b-col>
                <b-input id="question" />
            </b-col>
        </b-row>
        <b-row class="my-1">
            <b-col>
                <label for="briefanswer">{{ $t('qa_c_breif') }}</label>
            </b-col>
            <b-col>
                <b-input id="briefanswer" />
            </b-col>
        </b-row>
        <b-row class="my-1">
            <b-col>
                <label for="additionalanswer">{{ $t('qa_c_addition') }}</label>
            </b-col>
            <b-col>
                <b-input id="additionalanswer" />
            </b-col>
        </b-row>
        <b-row class="my-1">
            <b-col></b-col>
            <b-col></b-col>
        </b-row>
        <b-row class="my-1">
            <b-col>
                <label for="selectcategory">{{ $t('qa_c_selecCat') }}</label>
            </b-col>
            <b-col>
                <b-input id="selectcategory" />
            </b-col>
        </b-row>
        <b-row class="my-1">
            <b-col>
                <label id="selectcontent">{{ $t('qa_c_selectCon') }}</label>
            </b-col>
            <b-col>
                <b-input id="selectcontent" />
            </b-col>
        </b-row>
        <b-row class="my-1">
            <b-col>
                <label for="selectproduct"> {{ $t('qa_c_selectProd') }}</label>
            </b-col>
            <b-col>
                <b-input id="selectproduct" />
            </b-col>
        </b-row>
        <b-row class="my-1">
            <b-col>{{ $t('qa_c_status') }}</b-col>
            <b-col>
                <b-form-select>
                    <b-form-select-option value="approved">{{ this.$t('qa_c_approved') }}</b-form-select-option>
                    <b-form-select-option value="published">{{ this.$t('content_s_published') }}</b-form-select-option>
                    <b-form-select-option value="deactive">{{ this.$t('qa_c_deactive') }}</b-form-select-option>
                    <b-form-select-option value="active">{{ this.$t('qa_c_active') }}</b-form-select-option>
                    <b-form-select-option value="declined">declined</b-form-select-option>
                </b-form-select>
            </b-col>
        </b-row>
    </div>
</template>

<script>
export default {
    name: 'qaContent',
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