<template>
  <div class="container py-3">
    <h4 class="mb-3">انتخاب آدرس و زمان ارسال</h4>

    <!-- نمایش آدرس انتخاب‌شده -->
    <b-card v-if="isAddressValid" class="mb-3">
      <b-card-header>
        آدرس انتخاب شده
        <b-button size="sm" variant="link" class="float-right" @click="$router.push('/adress')">
          تغییر
        </b-button>
      </b-card-header>
      <b-card-body>
        <p>{{ fullAddress }}</p>
        <p>موبایل: {{ address.mobileNo1 }}</p>
        <p>تحویل‌گیرنده: {{ address.deliverName }} {{ address.deliverFamily }}</p>
        <p>کد پستی: {{ address.postalCode }}</p>
      </b-card-body>
    </b-card>

    <!-- انتخاب تاریخ شمسی -->
    <b-form-group label="تاریخ تحویل">
      <date-picker v-model="selectedJalaliDate" format="jYYYY/jMM/jDD" display-format="dddd jD jMMMM"
        placeholder="تاریخ مورد نظر را انتخاب کنید" color="blue" />
    </b-form-group>

    <!-- انتخاب بازه زمانی -->
    <b-form-group label="بازه زمانی تحویل">
      <b-button-group class="flex-wrap">
        <b-button v-for="slot in timeSlots" :key="slot"
          :variant="selectedTime === slot ? 'success' : 'outline-secondary'" @click="selectTime(slot)" class="mb-2">
          <b-icon icon="clock" class="ml-1" />
          {{ slot }}
        </b-button>
      </b-button-group>
    </b-form-group>

    <!-- یادداشت اختیاری -->
    <b-form-group label="توضیحات سفارش (اختیاری)">
      <b-form-textarea v-model="note" rows="3" placeholder="اگر نکته‌ای دارید وارد کنید" />
    </b-form-group>

    <!-- دکمه ذخیره و ادامه -->
    <b-button variant="primary" block @click="submitDelivery" :disabled="!canSubmit || isSubmitting">
      <b-spinner small v-if="isSubmitting" class="ml-2" />
      {{ isSubmitting ? 'در حال ذخیره...' : 'ذخیره و ادامه' }}
    </b-button>

    <!-- پیام خطا -->
    <b-alert variant="danger" v-if="errorMsg" class="mt-3" dismissible @dismissed="errorMsg = ''">
      {{ errorMsg }}
    </b-alert>
  </div>
</template>

<script>
import moment from 'moment-jalaali';
import DatePicker from 'vue-persian-datetime-picker';
import { mapGetters, mapActions } from 'vuex';

export default {
  name: 'Delivery',
  components: { DatePicker },
  data() {
    return {
      selectedJalaliDate: '',
      selectedTime: '',
      note: '',
      errorMsg: '',
      isSubmitting: false,
      timeSlots: [
        '08:00 - 10:00',
        '10:00 - 12:00',
        '12:00 - 14:00',
        '14:00 - 16:00',
        '16:00 - 18:00'
      ]
    };
  },
  computed: {
    ...mapGetters('delivery', ['defaultDelivery']),
    address() {
      return this.defaultDelivery || {};
    },
    isAddressValid() {
      //console.log('is address valid:,', this.address);
      //const a = this.address;
      //console.log('is address valid :', a);
      return true;//a && a.id && a.ostan && a.ostan.name && a.shahr && a.shahr.name;
    },
    fullAddress() {
      const a = this.address;
      const ostanName = a && a.ostanName ? a.ostanName : '';
      const shahrName = a && a.shahrName ? a.shahrName : '';
      const postalAddress = a.postalAddress ? a.postalAddress : '';
      const unit = a.unit ? a.unit : '';
      const pelak = a.pelak ? a.pelak : '';
      const fullAddr = `${ostanName}، ${shahrName}، ${postalAddress}، واحد: ${unit}، پلاک: ${pelak}`;
      //console.log('full addr :', fullAddr);
      return fullAddr;
    },
    canSubmit() {
      //console.log('selectedJalaliDate,', this.selectedJalaliDate);
      //console.log('selectedTime,', this.selectedTime);
      //console.log('isAddressValid,', this.isAddressValid);
      const sb = this.selectedJalaliDate && this.selectedTime && this.isAddressValid;
      //console.log('can submit :', sb);
      return sb;
    }
  },
  methods: {
    ...mapActions('delivery', ['saveDeliveryInfo']),
    selectTime(slot) {
      this.selectedTime = slot;
    },
    async submitDelivery() {
      if (!this.canSubmit) {
        this.errorMsg = 'لطفاً همه فیلدهای مورد نیاز را تکمیل کنید.';
        return;
      }

      this.isSubmitting = true;

      try {
        const gregorianDate = moment(this.selectedJalaliDate, 'jYYYY/jMM/jDD').format('YYYY-MM-DD');
        const startTime = this.selectedTime.split(' - ')[0];

        const deliveryInfo = {
          //addressId: this.address.id,
          ...this.address,
          deliveryDay: gregorianDate,
          deliveryTime: startTime,
          note: this.note
        };

        await this.saveDeliveryInfo(deliveryInfo);
        this.$router.push('/registerOrder');
      } catch (error) {
        this.errorMsg = 'خطا در ذخیره اطلاعات ارسال';
        console.error(error);
      } finally {
        this.isSubmitting = false;
      }
    }
  },
  created() {
    if (!this.address || !this.address.id) {
      this.$router.push('/adress');
    }
  }
};
</script>

<style scoped>
.container {
  max-width: 600px;
  margin: auto;
}
</style>
