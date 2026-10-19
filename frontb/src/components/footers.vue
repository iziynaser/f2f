<template>
  <div>
    <div v-if="$route.fullPath.length > 1">
      <!--
      empty footer
     -->
    </div>
    <div v-else>
      <b-row>
        <b-col></b-col>
        <b-col></b-col>
        <b-col></b-col>
        <b-col>
          <router-link to="/publicQa">{{ $t('answer_public_questions') }}</router-link>
        </b-col>
      </b-row>
      <hr />
      <div>{{ $t('browse_to_top') }}</div>
      <hr />
      <div>
        <b-row>
          <b-col>
            <b-list-group horizontal="md" flush>
              <b-list-group-item></b-list-group-item>
              <b-list-group-item></b-list-group-item>
              <b-list-group-item></b-list-group-item>
            </b-list-group>
          </b-col>
          <b-col>
            <b-list-group horizontal="md" flush>
              <li></li>
              <li></li>
              <li></li>
            </b-list-group>
          </b-col>
          <b-col></b-col>
          <b-col>
            <b-row></b-row>
            <b-row>
              <b-col>
                <b-row>
                  inform from pormotions
                  <b-input type="text" />
                </b-row>
              </b-col>
            </b-row>
          </b-col>
        </b-row>
      </div>
      <hr />
      <div>
        <b-row>
          <b-col>
            <span></span>
            <b-link :href="form.instagramUrl">
<!--              <b-img :src="urlI('/images/footer/instagram.png')" class="p-2 w-20 img-rounded" />-->
            </b-link>
            <b-link :href="form.twitterUrl">
<!--              <b-img :src="urlI('/images/footer/twitter.png')" class="p-2 w-20 img-rounded" />-->
            </b-link>
            <b-link :href="form.aparatUrl">
<!--              <b-img :src="urlI('/images/footer/aparat.png')" class="p-2 w-20 img-rounded" />-->
            </b-link>
            <b-link :href="form.linkedInUrl">
<!--              <b-img :src="urlI('/images/footer/linkedin.png')" class="p-2 w-20 img-rounded" />-->
            </b-link>
          </b-col>
        </b-row>
      </div>
    </div>
  </div>
</template>

<script>

import { baseUrl } from '../api/util'

export default {
  name: 'footers',
  data() {
    return {
      errorMessage: '',
      form: {
        linkedInUrl: '',
        twitterUrl: '',
        aparatUrl: '',
        instagramUrl: ''
      }
    }
  },
  methods: {
    urlI(u) {
      return baseUrl(u)
    }
  }
}
</script>

<style scoped>
.navbar {
  position: fixed;
  left: 0;
  bottom: 0;
  width: 100%;
  height: 10px;
  overflow: hidden;
  background-color: red;
  color: white;
  text-align: center;
}
</style>
