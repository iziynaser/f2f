<template>
    <div>
          <b-card>
              <b-card-header>personal information</b-card-header>
              <b-card-body>
                  <b-form>
                    <b-form-group>
                      <b-row>
                        <b-col class="col-2">email</b-col>
                        <b-col class="col-4">
                          <b-form-input id="email" v-model="emailAddress.email" placeholder="enter an valid email"/>
                        </b-col>
                      </b-row>
                    </b-form-group>
                    <b-form-group>
                                  <f2fInvoiceType :id="invoiceType"
                                                  :labell="this.$t('PROFILE_emailType')" 
                                                  fetchUrl="/InvoiceType/list"
                                                  :selectOptionLabel="this.$t('PROFILE_selectEmailType')"/>
                    </b-form-group>
                    <b-form-group>
                      <!-- <b-button variant="success" @click="addNewEmailAddressToUser" >
                        save
                      </b-button> -->
                    </b-form-group>
                  </b-form>
              </b-card-body>
          </b-card>          
      <!-- </b-collapse> -->

        <!-- <b-button v-b-toggle.personalInfo>Email address</b-button>
        <b-collapse id="personalInfo"> -->

          <b-card>
              <b-card-header>list of email address</b-card-header>
              <b-card-body>
                  <b-form>
                    <b-form-group>
                      <b-row>
                        <b-col class="col-2">email</b-col>
                        <b-col class="col-4">
                          <b-form-input id="email" v-model="emailAddress.email" placeholder="enter an valid email"/>
                        </b-col>
                      </b-row>
                    </b-form-group>
                    <b-form-group>
                                  <f2fInvoiceType id="invoiceType"
                                                  :labell="this.$t('PROFILE_emailType')" 
                                                  fetchUrl="/InvoiceType/list"
                                                  :selectOptionLabel="this.$t('PROFILE_selectEmailType')"/>
                    </b-form-group>
                    <b-form-group>
                      <!-- <b-button variant="success" @click="addNewEmailAddressToUser" >
                        save
                      </b-button> -->
                    </b-form-group>
                  </b-form>
              </b-card-body>
          </b-card>          
      <!-- </b-collapse> -->
          
    </div>
</template>

<script>
export default {
    name:'emails',
    props:{
          } ,
    data(){
      return {
          emailAddress:{
            emailType:'',
            email:'',
            personId:''
          },
      }
    } ,
    methods:{

    }      
}
</script>

<style scoped>

</style>