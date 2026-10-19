<template>
    <div>
        <b-container fluid>
            <b-row class="my-1">
                <b-col sm="3">coverImage</b-col>
                <b-col sm="9">b + -</b-col>
            </b-row>
            <b-row class="my-1">
                <label for="title">{{ this.$t('title') }}</label>
                <b-input id="title" />
            </b-row>
            <b-row class="my-1">
                <label id="urlPath">urlPath</label>
                <b-input id="urlPath" />
            </b-row>
            <b-row class="my-1">
                <label id="content">{{ this.$t('content') }}</label>
                <b-input id="content" />
            </b-row>
            <b-row class="my-1">
                <b-button>{{ this.$t('article_save') }}</b-button>
                <b-button>{{ this.$t('article_assign_to') }}</b-button>
                <b-button>{{ this.$t('article_draft') }}</b-button>
                <b-button>{{ this.$t('article_preview') }}</b-button>
                <b-button>{{ this.$t('article_publish') }}</b-button>
            </b-row>
        </b-container>
    </div>
</template>

<script>
export default {
    name: 'articleCreate',
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