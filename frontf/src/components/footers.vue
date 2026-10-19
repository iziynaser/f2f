<template>
  <div>
    <div v-if="$route.fullPath.length > 1">
      <!-- Empty footer -->
    </div>
    <div>
      <!-- لینک عمومی -->
      <b-row class="g-1 py-1">
        <b-col></b-col>
        <b-col></b-col>
        <b-col></b-col>
        <b-col class="text-end">
          <router-link to="/publicQa">{{ $t('answer_public_questions') }}</router-link>
        </b-col>
      </b-row>

      <hr />

      <div class="text-center small text-muted py-1">
        {{ $t('browse_to_top') }}
      </div>

      <hr />

      <!-- بخش‌های راهنما و قوانین -->
      <b-row class="g-2 py-1">
        <b-col>
          <b-list-group horizontal="md" flush>
            <b-list-group-item>
              <router-link to="/contact">{{ $t('C_FOOTER_CONTACT_US') }}</router-link>
            </b-list-group-item>
            <b-list-group-item></b-list-group-item>
            <b-list-group-item></b-list-group-item>
            <b-list-group-item>
              <router-link to="/PaymentType">{{ $t('C_FOOTER_PAYMENT_METHODS') }}</router-link>
            </b-list-group-item>
          </b-list-group>
        </b-col>
        <b-col>
          <ul class="list-unstyled mb-0">
            <li></li>
            <li>
              <router-link to="/ReturnType">{{ $t('C_FOOTER_RETURN_PRODUCT') }}</router-link>
            </li>
          </ul>
        </b-col>
        <b-col>
          <ul class="list-unstyled mb-0">
            <li>
              <router-link to="/aboutUs">درباره ما</router-link>
            </li>
          </ul>
        </b-col>

        <!-- عضویت در خبرنامه -->
        <b-col>
          <div class="newsletter-box">
            <p class="small mb-1">اطلاع از تخفیف ها</p>
            <b-input size="sm" placeholder="ایمیل یا شماره موبایل" class="w-70" />
          </div>
        </b-col>
      </b-row>

      <hr />

      <!-- شبکه‌های اجتماعی -->
      <div class="footer-banner text-white">
        <b-row class="align-items-center">
          <b-col>
<!--            <span class="me-2">{{ $t('C_FOOTER_FOLLOW_US') }}</span>-->
<!--            <b-link :href="form.instagramUrl">-->
<!--              <b-img :src="urlI('/images/footer/instagram.png')" class="footer-icon" />-->
<!--            </b-link>-->
<!--            <b-link :href="form.twitterUrl">-->
<!--              <b-img :src="urlI('/images/footer/twitter.png')" class="footer-icon" />-->
<!--            </b-link>-->
<!--            <b-link :href="form.aparatUrl">-->
<!--              <b-img :src="urlI('/images/footer/aparat.png')" class="footer-icon" />-->
<!--            </b-link>-->
<!--            <b-link :href="form.linkedInUrl">-->
<!--              <b-img :src="urlI('/images/footer/linkedin.png')" class="footer-icon" />-->
<!--            </b-link>-->
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
hr {
  margin: 0.5rem 0;
}

::v-deep .list-group-item {
  padding: 0.25rem 0.5rem;
  font-size: 0.85rem;
  border: none;
}

::v-deep li {
  margin-bottom: 0.25rem;
  font-size: 0.85rem;
}

.footer-banner {
  background-image: url('/images/header-bg.png');
  background-size: cover;
  background-position: center;
  padding: 0.75rem;
  font-size: 0.9rem;
  height: 50px;
}

.footer-icon {
  width: 28px;
  height: 28px;
  margin-left: 6px;
  border-radius: 50%;
  padding: 2px;
  background-color: white;
}

.newsletter-box p {
  margin-bottom: 0.3rem;
  font-size: 0.85rem;
}
</style>
