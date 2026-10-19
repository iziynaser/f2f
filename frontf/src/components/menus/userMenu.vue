<template>
    <div>
        <b-nav-item-dropdown :text="$t('USER_MENU')" right>
            <b-dropdown-item href="#">
                 <b-button  size="sm" variant="link" @click="createUserTabs(0,$t('user_main'))">{{ $t('user_main') }}</b-button>
            </b-dropdown-item>
            <b-dropdown-item>
                 <b-button  size="sm" variant="link" @click="createUserTabs(1,$t('roles'))">{{ $t('roles') }}</b-button>
            </b-dropdown-item>
        </b-nav-item-dropdown>
    </div>
</template>

<script>


export default {

    name: 'userMenu',
    props: {
    },
    data() {
        return {
            cp: [
                userMain,
                userRoles
           ]
        }
    },
  methods: {
    createUserTabs(idParam, nameParam) {
      let atab = {
        id: idParam ,
        name: nameParam,
        contnt : this.cp[idParam]
      }
      atab.id = (atab.id + 20);
      //console.log(atab);
      this.$emit('createAppTab',atab);
    }
  },
}
</script>

<style scoped></style>