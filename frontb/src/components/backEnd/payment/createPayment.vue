<template>
    <div>
        create payment view dgdgdgdfgdfgdfgdfgdfgdfgdfg
        <b-card no-body>
            <b-row>
                <b-button>status to received</b-button>
                <b-button>status to cancelled</b-button>
                <b-button>print </b-button>
                <b-button>status to void </b-button>
            </b-row>
            <b-tabs pills card>
                <b-tab :title="this.$t('CPRODUCT_CREATE_main')">
                    <!-- <cProductMain/> -->
                </b-tab>
                <b-tab :title="this.$t('CPRODUCT_CREATE_content')">
                    <!-- <cProductContent/>  -->
                </b-tab>
                <b-tab :title="this.$t('CPRODUCT_CREATE_features')">
                    <!-- <cProductFeature/> -->
                </b-tab>
            </b-tabs>
        </b-card>
    </div>
</template>

<script>

// import cProductMain from './cproduct/cProductMain'
// import cProductContent from './cproduct/cProductContent'
// import cProductFeature from './cproduct/cProductFeature'

export default {
    name: 'createPayment',
    props: {
    },
    data() {
        return {

        }
    },
    methods: {

    },
    components: {
        // cProductMain,
        // cProductContent,
        // cProductFeature,        
    }
}
</script>

<style scoped></style>