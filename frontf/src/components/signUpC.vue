<template>
  <div class="text-center mt-4">
    <h4 class="mb-3">F2F App</h4>

    <b-card
        :img-src="urlI('/images/icon/userProfile.png')"
        img-alt="Registration Successful"
        img-right
        class="shadow-sm p-3"
    >
      <b-card-title class="text-success">
        {{ $t('signup_success_title') }}
      </b-card-title>

      <b-card-text>
        {{ $t('signup_success_message') }}
      </b-card-text>

      <div class="mt-3 d-flex justify-content-around">
        <b-button variant="primary" :to="'/'">
          {{ $t('go_to_main') }}
        </b-button>

        <b-button variant="success" :to="'/signIn'">
          {{ $t('go_to_login') }}
        </b-button>
      </div>

    </b-card>
  </div>
</template>

<script>
import { baseUrl } from "@/api/util";

export default {
  name: "signUpC",
  methods: {
    urlI(u) {
      return baseUrl(u);
    }
  }
};
</script>

<style scoped>
</style>
