<template>
  <div>
    <b-form @submit.prevent="doSignUp">

      <b-form-group id="logoF2f">
        <b-img :src="urlI('/images/logo/logo.png')"></b-img>
        <label v-if="signUpmessage" class="text-danger">
          {{ signUpmessage }}
        </label>
      </b-form-group>

      <b-form-group
          id="userNameGroup"
          label-for="username"
          :label="$t('SIGNUPFORM_userName')"
      >
        <b-form-input
            id="username"
            v-model.trim="form.username"
            type="text"
            required
        />
      </b-form-group>

      <b-form-group
          id="passwordGroup"
          label-for="password"
          :label="$t('SIGNUPFORM_password')"
      >
        <b-form-input
            id="password"
            v-model.trim="form.password"
            type="password"
            required
        />
      </b-form-group>

      <b-form-group
          id="confirmPassGroup"
          label-for="confirmPassword"
          :label="$t('SIGNUPFORM_confirmPassword')"
      >
        <b-form-input
            id="confirmPassword"
            v-model.trim="confirmPassword"
            type="password"
            required
        />
        <small v-if="passwordMismatch" class="text-danger">
          {{ $t("passwords_do_not_match") }}
        </small>
      </b-form-group>

      <b-form-group id="buttonGroups">
        <b-button
            type="submit"
            variant="primary"
            :disabled="loading"
        >
          {{ loading ? $t('loading') : $t('SIGNUPFORM_submit') }}
        </b-button>
      </b-form-group>

    </b-form>
  </div>
</template>

<script>
import { baseUrl } from '../api/util'
import axiosInstance from '@/api/axiosInstance'
import router from '../router'

export default {
  name: 'signUp',
  data() {
    return {
      loading: false,
      signUpmessage: "",
      confirmPassword: "",
      form: {
        username: '',
        password: '',
      }
    }
  },
  computed: {
    passwordMismatch() {
      return this.confirmPassword && this.form.password !== this.confirmPassword
    }
  },
  methods: {
    urlI(u) {
      return baseUrl(u)
    },

    async doSignUp() {
      if (this.passwordMismatch) {
        this.signUpmessage = this.$t("passwords_do_not_match")
        return
      }

      this.loading = true
      this.signUpmessage = ""

      try {
        const response = await axiosInstance.post('/auth/signUp', this.form)

        if (response.data.status === 1) {
          router.push('/signUpC')
        } else {
          this.signUpmessage = response.data.message
        }
      } catch (err) {
        console.error(err)
        this.signUpmessage = this.$t("error_general")
      }

      this.loading = false
    }
  }
}
</script>
