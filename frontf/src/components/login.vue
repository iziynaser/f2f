<template>
  <div>
    <b-form @submit.prevent="doLogin">

      <b-form-group>
        <b-row>
          <b-col cols="2">{{ $t('LOGIN_username') }}</b-col>
          <b-col cols="4">
            <b-form-input
                id="username"
                v-model.trim="form.username"
                :placeholder="$t('LOGIN_usernamePlaceHolder')"
                required
            />
          </b-col>
        </b-row>
      </b-form-group>

      <b-form-group>
        <b-row>
          <b-col cols="2">{{ $t('LOGIN_password') }}</b-col>
          <b-col cols="4">
            <b-form-input
                id="password"
                type="password"
                v-model.trim="form.password"
                :placeholder="$t('LOGIN_passwordPlaceHolder')"
                required
            />
          </b-col>
        </b-row>
      </b-form-group>

      <b-form-group>
        <b-button
            type="submit"
            variant="primary"
            :disabled="loading"
        >
          {{ loading ? $t('loading') : $t('LOGIN_loginButton') }}
        </b-button>
      </b-form-group>

    </b-form>
  </div>
</template>

<script>
import { mapActions } from 'vuex'

export default {
  name: 'Login',

  data() {
    return {
      loading: false,
      form: {
        username: '',
        password: ''
      }
    }
  },

  methods: {
    ...mapActions('auth', ['login']),

    async doLogin() {
      this.loading = true

      try {
        // فراخوانی action login از authstore
        await this.login({
          username: this.form.username,
          password: this.form.password
        })

        // پیام موفق
        this.$store.dispatch(
            'toast/triggerToast',
            {
              text: this.$t('LOGIN_success'),
              title: this.$t('SUCCESS'),
              variant: 'success'
            },
            { root: true }
        )

      } catch (error) {
        // مدیریت خطای مستقیم بدون optional chaining
        let msg = this.$t('LOGIN_INVALID_USERNAME_PASSWORD')
        if (error.response && error.response.data && error.response.data.error_description) {
          msg = error.response.data.error_description
        }

        this.$store.dispatch(
            'toast/triggerToast',
            {
              text: msg,
              title: this.$t('ERROR'),
              variant: 'danger'
            },
            { root: true }
        )

      } finally {
        this.loading = false
      }
    }
  }
}
</script>
