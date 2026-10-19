<template>
  <div>
    <b-row>
      <b-col sm="3">title</b-col>
      <b-col sm="6"><b-input ref="titlleComponent" v-model="form.title"></b-input></b-col>
    </b-row>
    <dynaList ref="benefComponent" :labelforList="$t('PRODUCT_COMMENT_LIST_OF_BEN')"
      v-on:updatelist="updateListOfBenefits($event)" />
    <dynaList ref="upsetComponent" :labelforList="$t('PRODUCT_COMMENT_LIST_OF_UPS')"
      v-on:updatelist="updateListOfUpsets($event)" />
    <rEditor ref="editorComponent" v-on:editorContentChanged="editorContentChanged($event)" />
    <b-row class="my-1">
      <b-button v-on:click="saveCommentClick()">{{ this.$t('save') }}</b-button>
    </b-row>
  </div>
</template>

<script>

import dynaList from '../dynaList'
import rEditor from '../rEditor'
import * as axios from 'axios';

export default {
  name: 'commentCreate',
  props: {
    id: Number
  },
  data() {
    return {
      form: {
        benefits: [],
        upsets: [],
        content: "",
        title: '',
        productId: 0
      }
    }
  },
  methods: {
    editorContentChanged(c) {
      this.form.content = c;
      //console.log(this.form.content);
    },
    updateListOfBenefits(benifitsArray) {
      this.form.benefits = benifitsArray
    },
    updateListOfUpsets(upsetArray) {
      this.form.upsets = upsetArray;
    },
    clear() {
      this.$refs.titleComponent = '';
      this.$refs.editorComponent.clear();
      this.$refs.benefComponent.clear();
      this.$refs.upsetComponent.clear();
    },
    saveCommentClick() {
      //this.comments.push({title:this.title,benefits:this.benefits,upsets:this.upsets,content:this.content});
      var self = this;
      const url = `/comments/save`;
      self.form.productId = self.id;
      axios.post(url, self.form)
        .then((res) => {
          //self.loadKeyowrds();
          self.clear();
          console.log(res);
        })
        .catch((err) => {
          console.log(err);
        })
      //self.clear();
    }
  },
  components: {
    dynaList,
    rEditor
  }
}
</script>

<style scoped></style>