import Vue from 'vue'
import Router from 'vue-router'
import user from './components/user'
import contact from './components/contact'
import aboutUs from './components/aboutUs'
import PaymentType from "./components/PaymentType.vue";
import details from './components/details'
import AuthHandler from './components/AuthHandler'

import signUp from './components/signUp'
import product from './components/product/product'

import signUpC from './components/signUpC.vue'

import delivery from './components/bucket/delivery'
import bucketView from './components/bucket/bucketView'

import createContent from './components/content/createContent'

import Adress from './components/adress/AdressMain.vue'

import surveyMain from './components/content/survey/surveyMain'
import blogMain from './components/content/blog/blogMain'
import forumMain from './components/content/forum/forumMain'
import qaMain from './components/content/qa/qaMain'
import ReturnType from './components/ReturnType.vue'
import createProfiles from './components/profile/createProfiles'
import contentMain from './components/content/contnt/contentMain'
import myOrders from './components/order/myOrders'
import categoriesPage from './components/product/categories/categoriesPage'
import publicQa from './components/content/qa/publicQa'

import contentC from './components/content/contnt/contentC.vue'

import AdressMain from '@/components/adress/AdressMain.vue';

import FrontEnd from './components/front/FrontEnd.vue'

import OrderSuccess from './components/order/OrderSuccess.vue'

import ProductFilter from "./components/ProductFilter.vue";

import ComparePage from './components/product/ComparePage.vue';

import Login from './components/login.vue'

Vue.use(Router)

export default new Router({
  mode: 'history',
  base: process.env.BASE_URL,
  routes: [
      {
          path: '/compare',
          name: 'Compare',
          component: ComparePage
      },
      {
      path: '/product-filter',
      name: 'ProductFilter',
      component:ProductFilter,
      props: route => ({filters : route.query})
      }
      ,
      {
          path: '/payment/gateways',
          name: 'GatewaySelect',
          component: () => import('./components/payment/PaymentGatewaySelect.vue')
      },
{
  path: '/payment-result',
  name: 'PaymentResult',
  component: () => import('./components/payment/PaymentResult.vue')
},
{
  path: '/registerOrder',
  name: 'registerOrder',
  component: () => import('./components/bucket/registerOrder.vue')
}
,
      {
          path:'/ReturnType',
          name:'ReturnType',
          component:ReturnType
      },
  
 {
  path: '/address',
  name: 'AddressMain',
  component: AdressMain
},{
          path: '/login',
          name: 'login',
          component: Login
      },
    {
  path: '/selectAddress',
  component: AdressMain,
  name: 'SelectAddress'
},
      {
          path: '/payment',
          name: 'PaymentPage',
          component: () => import('./components/payment/PaymentMethodSelect.vue')
      },
  {
  path: '/payment-result',
  component: () => import('./components/payment/PaymentResult.vue')
}
,
{
    path: '/adressMain', // ترجیحاً با حروف کوچک برای URL
    name: 'AdressMain',
    component: AdressMain,
    //meta: { requiresAuth: true } // اگر نیاز به احراز هویت دارد
  },
    {
      path: '/front/FrontEnd',
      name: 'FrontEnd',
      component: FrontEnd
    },
    {
      path: '/',
      name: 'home',
      component: FrontEnd
    }, {
      path: '/signUp',
      name: 'signUp',
      component: signUp
    },
    // {
    //   path:'/profile',
    //   name:'profile',
    //   component:profile
    // },
    {
      path: '/users',
      name: 'users',
      component: user
    },
    {
      path: '/contact',
      name: 'contact',
      component: contact
    },
    {
      path: '/aboutUs',
      name: 'aboutUs',
      component: aboutUs
    },
{
      path: '/product/:id',
      name: 'product',
      component: product,
      props: true
    },
    {
      path: '/details/:pid',
      name: 'details',
      component: details
    },
    {
      path: '/signUpC',
      name: signUpC,
      component: signUpC
    },
    {
      path: '/oauth2/callback',
      component: AuthHandler,
    },
    {
      path: '/delivery',
      name: 'delivery',
      component: delivery
    },
    {
      path: '/bucketView',
      name: 'bucketView',
      component: bucketView,
    },
    {
      path: '/createContent',
      name: 'createContent',
      component: createContent
    }
    , {
      path: '/Adress',
      name: 'Adress',
      component: Adress
    },
    {
      path: '/surveyMain',
      name: 'surveyMain',
      component: surveyMain
    },
      {
        path:'/PaymentType',
        name:'PaymentType',
        component:PaymentType
      },
    {
      path: '/blogMain',
      name: 'blogMain',
      component: blogMain
    },
    {
      path: '/forumMain',
      name: 'forumMain',
      component: forumMain
    },
    {
      path: '/qaMain',
      name: 'qaMain',
      component: qaMain
    },
    {
      path: '/createProfiles',
      name: 'createProfiles',
      component: createProfiles
    },
    {
      path: '/myOrders',
      name: 'myOrders',
      component: myOrders
    },
    {
      path: '/contentMain',
      name: 'contentMain',
      component: contentMain
    },
    {
      path: '/publicQa',
      name: 'publicQa',
      component: publicQa
    }, 
        {
      path: '/categoriesPage/:id/:title?',
      name: 'categoriesPage',
      component: categoriesPage,
      props: true
    },
    {
      path: '/contentC',
      name: 'contentC',
      component: contentC
    },
    {
      path: '/order-success/:orderId',
      name: 'OrderSuccess',
      component: OrderSuccess,
      props: true//route => ({orderId:Number(route.params.orderId)})
    }
  ]
})

