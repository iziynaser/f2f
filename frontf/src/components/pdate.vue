<template>
    <div id="dd" class="w-2 mb-2">
            <date-picker type="date" append-to="dd" v-model="date"></date-picker>
    </div>
</template>

<script>

import VuePersianDateTimePicker from 'vue-persian-datetime-picker'

export default {
    name:'pdate',
    data(){
        return{
            date:''
        }
    },
    components:{
        datePicker:VuePersianDateTimePicker
    }
}
</script>

<style scoped >

</style>
