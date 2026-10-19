<template>
    <div>
        <span v-if="Number(id) !== 0">
            edit product with
            <span v-if="id">id : {{ id }}</span>
            and
            <span v-if="title">title : {{ title }}</span>
        </span>
        <span v-else>
            create product view
        </span>

        <b-card no-body>
            <b-tabs pills card>
                <b-tab :title="this.$t('CPRODUCT_CREATE_main')">
                    <cProductMain :id=Number(id) :title="title" />
                </b-tab>
                <b-tab :title="this.$t('C_PRODUCT_MEASURE_TITLE')">
                    <cProductMeasure :id=Number(id) :title="title" />
                </b-tab>
                <b-tab :title="this.$t('CPRODUCT_CREATE_price')">
                    <cProductPrice :id=Number(id) :title="title" />
                </b-tab>
                <b-tab :title="this.$t('CPRODUCT_CREATE_category')">
                    <cProductCategory :id=Number(id) :title="title" />
                </b-tab>
                <b-tab :title="this.$t('CPRODUCT_CREATE_features')">
                    <cProductFeature :id=Number(id) :title="title" />
                </b-tab>
                <!-- <b-tab :title="this.$t('CPRODUCT_CREATE_cost')">
                        
                        </b-tab>  -->
                <b-tab :title="this.$t('CPRODUCT_CREATE_keywords')">
                    <cProductKeyword :id=Number(id) :title="title" />
                </b-tab>
                <!-- <b-tab :title="this.$t('CPRODUCT_CREATE_inventory')">                              
                              <cProductInventory/>                              
                        </b-tab> -->
                <!-- <b-tab :title="this.$t('CPRODUCT_CREATE_supplier')">
                            <cProductSupplier/>
                        </b-tab>    -->
                <b-tab title="pics">
                    <cProductContent :id=Number(id) :title="title" />
                </b-tab>
                <b-tab :title="this.$t('CPRODUCT_CREATE_content')">
                    <!-- <cProductPics/>                -->
                </b-tab>
                <b-tab :title="otherSellers">
                    other sellers
                </b-tab>
            </b-tabs>
        </b-card>
    </div>
</template>

<script>

import cProductMain from './cproduct/cProductMain'
import cProductContent from './cproduct/cProductContent'
import cProductPrice from './cproduct/cProductPrice'
import cProductCategory from './cproduct/cProductCategory'
import cProductKeyword from './cproduct/cProductKeyword'
//import cProductSupplier from './cproduct/cProductSupplier'
import cProductMeasure from './cproduct/cProductMeasure'
import cProductFeature from './cproduct/cProductFeature'
//import cProductInventory from './cproduct/cProductInventory'
//import cProductPics from './cproduct/cProductPics'

export default {
    name: 'createProduct',
    props: {
        id: [Number, String],
        title: String
    },
    data() {
        return {

        }
    },
    methods: {

    },
    components: {
        cProductMain,
        cProductContent,
        cProductPrice,
        cProductCategory,
        cProductKeyword,
        //cProductSupplier,
        cProductMeasure,
        cProductFeature,
        //cProductInventory,
        //cProductPics        
    }
}
</script>

<style scoped></style>