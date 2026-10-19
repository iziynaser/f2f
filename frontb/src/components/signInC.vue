<template>
  <div>
    <b-form>

      <b-form-group id="logoF2f">
        <b-img src="/images/logo/logo.png"></b-img>
        <label v-if="signUpmessage">
          {{ signUpmessage }}
        </label>
      </b-form-group>

      <b-form-group id="userNameGroup" label-for="username" :label="this.$t('SIGNUPFORM_userName')">
        <b-form-input id="username" v-model="form.username" type="text" required />
      </b-form-group>

      <b-form-group id="passwordGroup" label-for="password" :label="this.$t('SIGNUPFORM_password')">
        <b-form-input id="password" v-model="form.password" type="password" required />
      </b-form-group>

      <b-form-group id="captchaGroup" label-for="captchaImg" :label="this.$t('SIGNUPFORM_captcha')">
        <b-img :src="captchaImg" id="captchaImg" fluid @click="doRefreshCaptcha" :alt="$t('captcha_Image')"></b-img>
      </b-form-group>

      <b-form-group>
        <label>{{ $t('verification_Code') }}</label>
        <b-form-input id="verificationCode" v-model="form.verificationCode" type="text" required />
      </b-form-group>

      <b-form-group id="buttonGroups" label-for="buttons">
        <b-button type="button" variant="primary" @click="doSignUp">{{ $t('SIGNUPFORM_submit') }}</b-button>
      </b-form-group>

    </b-form>

  </div>
</template>

<script>

import axios from 'axios'
//import qs from 'querystring'
//import router from 'vue-router'
//import signUpC from './signUpC'
import router from '../router'

export default {
  name: 'signInC',
  data() {
    return {
      visible: true,
      captchaImg: "",
      confirmPassword: "",
      errors: [],
      signUpmessage: "",
      form: {
        verificationCode: '',
        graphId: '',
        username: '',
        password: '',
      }
    }
  },
  methods: {
    doSignUp: function () {
      var self = this;
      axios({
        method: 'GET',
        url: '/oauth/signIn',
        headers: {
          'Content-Type': 'x-www-form-urlencoded'
        },
        params: self.form,
        withCredentials: true
      })
        .then(function (response) {
          console.log("success", response);
          if (response.data.status == 1) {
            //go to main page
            //router.push("signUpC");
            //this.$router.push({name:'/'});
            //this.$router.push({name:'details',params:{pid:1}})
            router.push('/signUpC');
          } else if (response.data.status == -1) {
            self.signUpmessage = response.data.message;
          }

        }).catch(function (error) {
          console.log("error", error);
        });
      //evt.preventDefault();
    },
    doReset: function (evt) {
      evt.preventDefault();
    },
    doRefreshCaptcha: function () {
      //var welcome = this.$i18n.getLocaleMessage('welcome');
      //console.log(welcome);

      var self = this;
      axios.get('/captcha/graph')
        .then(function (response) {
          self.form.graphId = response.data.graphId;
          self.captchaImg = 'http://localhost:8080' + response.data.graphUrl;
        })
        .catch(function (error) {
          console.log(error)
        });
    }
  },
  components: {
    //signUpC
  },
  mounted() {
    this.doRefreshCaptcha();
  }

}
</script>
