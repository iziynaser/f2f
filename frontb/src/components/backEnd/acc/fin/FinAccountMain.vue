<template>
    <div>
        <b-card no-body>
            <b-tabs pills card>
                <b-tab title="list">
                    <finAccountList />
                </b-tab>
                <b-tab title="create fin account">
                    <finAccount />
                </b-tab>
            </b-tabs>
        </b-card>
    </div>
</template>

<script>

import finAccountList from './FinAccountList'
import finAccount from './FinAccount'

export default {
    name: 'FinAccountMain',
    props: {
    },
    data() {
        return {

        }
    },
    methods: {

    },
    components: {
        finAccountList,
        finAccount
    }
}
</script>

<style scoped></style>