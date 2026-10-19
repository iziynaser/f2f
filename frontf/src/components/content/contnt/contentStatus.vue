<template>
    <div>
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
            <b-col>{{ $t('CONTENT_CREATE_tite') }}</b-col>
            <b-col>
                <b-input type="text" />
            </b-col>
        </b-row>
    </div>
</template>

<script>
export default {
    name: 'contentStatus',
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