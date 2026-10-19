<template>
  <div>
    <b-button-group>
      <b-dropdown>
        <template v-slot:button-content>
          {{ isLoggedIn ? userName : $t('LOGIN') }}
        </template>

        <div>
          <!-- اگر کاربر لاگین نکرده است -->
          <b-dropdown-item v-if="!isLoggedIn">
            <router-link to="/login">ورود</router-link>
          </b-dropdown-item>

          <b-dropdown-item v-if="!isLoggedIn">
            <router-link to="/signUp">ثبت نام</router-link>
          </b-dropdown-item>

          <!-- اگر کاربر لاگین کرده است -->
          <div v-else>
            <b-dropdown-item>
              <router-link to="/createProfiles">{{ $t('profile') }}</router-link>
            </b-dropdown-item>

            <b-dropdown-divider />

            <b-dropdown-item>
              <router-link to="/myOrders">{{ $t('myorders') }}</router-link>
            </b-dropdown-item>

            <b-dropdown-divider />

            <b-dropdown-item :to="{ name: 'AdressMain' }">
              {{ $t('addresses') }}
            </b-dropdown-item>

            <b-dropdown-item @click="logout">
              {{ $t('logout') }}
            </b-dropdown-item>
          </div>
        </div>
      </b-dropdown>
    </b-button-group>
  </div>
</template>

<script>
import { mapActions, mapGetters } from 'vuex'
import { BDropdown, BDropdownItem, BDropdownDivider } from 'bootstrap-vue'

export default {
  name: 'shoppingList',

  computed: {
    ...mapGetters('authstore', {
      isLoggedIn: 'isLoggedIn',
      userName: 'getUserName'
    })
  },

  components: {
    BDropdown,
    BDropdownItem,
    BDropdownDivider
  },

  methods: {
    ...mapActions('authstore', ['logout'])
  }
}
</script>
