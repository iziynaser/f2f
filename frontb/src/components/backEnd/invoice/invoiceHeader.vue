<template>
  <div>
    <!-- <div>invoice header</div> -->
    <!-- <div v-if="isDebugEnabled">
      isDebugEnabled: {{ isDebugEnabled }},
      global error message :{{ globalErrorMessage }},
    </div> -->
    <!-- <div>params: {{this.form}}</div> -->

    <b-form>

      <b-form-group>
        <b-row>
          <b-col class="col-2">{{ $t('INVOICE_HEADER_creatorPerson') }}</b-col>
          <b-col class="col-4">
            <!-- <b-form-input id="creattor" v-model="invoice.creator" readonly required
              :placeholder="this.$t('INVOICE_HEADER_creatorPersonPlaceHolder')" /> -->
          </b-col>
        </b-row>
      </b-form-group>

      <b-form-group>
        <b-row>

          <!-- <b-col class="col-2">person</b-col>
          <b-col class="col-4">
            <tPerson @click="showModalForm" :lkdata="lookupdata" modalFormName="personModal"
              :key="rerenderThisComponent" />
           
          </b-col> -->
        </b-row>
      </b-form-group>

      <b-form-group>
        <b-row>
          <b-col class="col-2">{{ $t('INVOICE_HEADER_date') }}</b-col>
          <b-col class="col-4">
            <pdate />
          </b-col>
        </b-row>
      </b-form-group>

      <b-form-group>
        <b-row>
          <b-col class="col-2">{{ $t('INVOICE_HEADER_title') }}</b-col>
          <b-col class="col-4">
            <b-form-input id="title" v-model="invoice.title" required=""
              :placeholder="this.$t('INVOICE_HEADER_titlePlaceHolder')" />
          </b-col>
          <b-col class="col-2">{{ $t('INVOICE_HEADER_message') }}</b-col>
          <b-col class="col-4">
            <b-form-input id="message" v-model="invoice.message" required=""
              :placeholder="this.$t('INVOICE_HEADER_messagePlaceHolder')" />
          </b-col>
        </b-row>
      </b-form-group>

      <b-form-group>
        <b-row>
          <b-col class="col-2">{{ $t('INVOICE_HEADER_creatorPerson') }}</b-col>
          <b-col class="col-4">
            <b-form-input id="creattor" v-model="invoice.creator" required=""
              :placeholder="this.$t('INVOICE_HEADER_creatorPersonPlaceHolder')" />
          </b-col>
          <b-col class="col-2">{{ $t('INVOICE_HEADER_fromPerson') }}</b-col>
          <b-col class="col-4">
            <personModal id="modalFromPerson" :title="this.$t('lookup_from_person')" @bClicked="showLkFromPerson" />
            <tPerson @click="showModalForm" id="modalFromPerson" :lkdata="lookupFromPerson" modalFormName="personModal"
              :key="rerenderFromComponent" />
          </b-col>
        </b-row>
      </b-form-group>

      <b-form-group>
        <b-row>
          <b-col class="col-2">{{ $t('INVOICE_HEADER_toPerson') }}</b-col>
          <b-col class="col-4">
            <personModal id="modalToPerson" :title="this.$t('list_of_persons')" @bClicked="showLkToPerson" />
            <tPerson @click="showModalForm" id="modalToPerson" :lkdata="lookupToPerson" modalFormName="personModal"
              :key="rerenderToComponent" />
          </b-col>
          <b-col class="col-2">{{ $t('INVOICE_HEADER_invoiceType') }}</b-col>
          <b-col class="col-4">
            <b-form-input id="invoiceType" v-model="invoice.invoiceType" required=""
              :placeholder="this.$t('INVOICE_HEADER_invoiceTypePlaceHolder')" />
          </b-col>
        </b-row>

      </b-form-group>

      <b-form-group>
        <b-row>
          <b-col class="col-2">{{ $t('INVOICE_HEADER_description') }}</b-col>
          <b-col class="col-10">
            <b-form-textarea id="description" v-model="invoice.description" required=""
              :placeholder="this.$t('INVOICE_HEADER_descriptionPlaceHolder')" />
          </b-col>
        </b-row>
      </b-form-group>

      <b-form-group>
        <b-button variant="success" @click="saveinvoice">{{ $t('INVOICE_HEADER_save') }}</b-button>
      </b-form-group>


    </b-form>
  </div>
</template>

<script>

import axios from 'axios'
import tPerson from '../hr/person/tPerson.vue';
import personModal from '../hr/person/personModal.vue';

export default {
  name: 'invoiceHeader',
  components: {
    tPerson
    ,
    personModal
  },
  props: {

  },
  data() {
    return {
      rerenderFromComponent: 0,
      rerenderToComponent: 0,
      lookupFromPerson: [],
      lookupToPerson: [],
      invoice: {
        invoiceId: 0,
        invoiceCode: 0,
        date: '',
        title: '',
        message: '',
        description: '',
        creatorPerson: { person: { personCode: 1 } },
        fromPerson: { person: { peronCode: 2 } },
        toPerson: { person: { personCode: 3 } },
        invoiceItems: [],
        invoiceStatuses: [],
        invoiceType: 1
      },
      errors: [],
      visible: true,
      isDebugEnabled: true,
      globalErrorMessage: ''
    }
  },
  methods: {
    showLkToPerson(lkdata) {
      this.lookupToPerson = [];
      this.lookupToPerson = lkdata;
      this.rerenderToComponent = this.rerenderToComponent + 1;
      console.log("lkdata = " + this.lookupToPerson);
    },
    showLkFromPerson(lkdata) {
      //this.lookupFromPerson = [];
      //this.lookupFromPerson = lkdata;
      this.lookupFromPerson=[...lkdata];
      this.rerenderFromComponent = this.rerenderFromComponent + 1;
      console.log("lkdata = " + this.lookupFromPerson);
    },
    showModalForm() {
      this.$bvModal.show("personModal");
    },
    resetInvoice() {
      this.invoice.currentDate = '45646';
      this.invoice.date = '45646';
      this.invoice.title = '';
      this.invoice.description = '';
      this.invoice.creator = 1;
      this.invoice.fromPerson = 1;
      this.invoice.toPerson = 1;
      this.invoice.invoiceType = 1;
    },
    saveinvoice() {
      var self = this;
      axios.post('/invoice/save', self.invoice).then(function (res) {
        console.log(res);
      }).catch(function (err) {
        console.log("err :" + err);
        console.log("err response:" + err.response);
        self.globalErrorMessage = err;
      });

      //this.resetInvoice();
    }
  }
}
</script>

<style scoped></style>