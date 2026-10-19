<template>
  <div>

    <b-row class="my-1">
      <b-col>
        <b-button-group size="sm">
          <b-button variant="danger" @click="pressedBtn('n')">
            {{ $t('categories_new') }}
          </b-button>
          <b-button variant="success" @click="pressedBtn('a')">
            {{ $t('categories_available') }}
          </b-button>
        </b-button-group>
      </b-col>
    </b-row>

    <b-row v-if="pressed == 'n'" class="my-3">
      <b-col sm="3">
        <!-- attribute name -->
      </b-col>
      <b-col sm="6">
        {{ $t('categories_attributeName') }}<b-input v-model="value"></b-input>
      </b-col>
    </b-row>
    <div v-else>
      <b-row class="my-3">
        <b-col sm="3">
          <!-- name -->
        </b-col>
        <b-col sm="6">
          {{ $t('categories_attributeName') }}
          <b-form-select v-model="idx" :options="typeNames" size="sm" class="mt-3">
          </b-form-select>
        </b-col>
      </b-row>
      <b-row class="my-3">
        <b-col sm="3">
          <!-- name -->
        </b-col>
        <b-col sm="6">
          {{ $t('categories_attributeValue') }} <b-input v-model="name" />
        </b-col>
      </b-row>

    </div>
    <b-row>
      <b-button @click="addValueForTypeName">{{ this.$t('save') }}</b-button>
    </b-row>
    <hr />
    <b-row class="my-1">
      <b-col sm="6" v-for="type in typeNames" :key="type">
        <b-card class="my-1">
          <b-card-header @dblclick="removeType(type)">{{ type }}</b-card-header>
          <b-card-body>
            <li v-for="value in filterTypeValuesByName(type)" :key="value">
              <span class="ql-align-right">{{ value.v }}</span>
            </li>
          </b-card-body>
        </b-card>
      </b-col>
    </b-row>
  </div>
</template>

<script>
export default {
  name: 'categoriesType',
  props: {
  },
  data() {
    return {
      pressed: "n",
      idx: 0,
      name: "",
      value: "",
      typeNames: [],
      typeValues: [],
    }
  },
  methods: {
    pressedBtn(sta) {
      if (this.pressed !== sta) {
        this.pressed = sta;
      }
    },
    addValueForTypeName() {
      if (this.name.length > 0) {
        if (this.typeNames.indexOf(this.name) == -1) {
          this.typeNames.push(this.name);
          this.name = '';
        }
      } else if (this.value.length > 0 && this.idx.length > 0) {
        //console.log(this.idx);
        console.log(this.typeValues.indexOf({ name: this.idx, v: this.value }));
        if (this.typeValues.indexOf({ name: this.idx, v: this.value } == -1))
          this.typeValues.push({ name: this.idx, v: this.value });
        console.log(this.typeValues);
        this.value = '';
      }
    },
    filterTypeValuesByName(name) {
      let filteredArr = this.typeValues.filter(element => element.name == name);
      return filteredArr;
    },
    removeType(type) {
      console.log(type);
      this.typeValues = this.typeValues.filter(element => element.name !== type);
      this.typeNames = this.typeNames.filter(element => element !== type);
      console.log(this.typeNames);
    }
  }
}
</script>


<style scoped></style>