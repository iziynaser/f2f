import Vue from 'vue'
import Router from 'vue-router'
//import Home from './views/Home.vue'
import user from './components/user'
import contact from './components/contact'
import aboutUs from './components/aboutUs'
import details from './components/details'
import AuthHandler from './components/AuthHandler'
import humanres from './components/backEnd/hr/humanres'

//import login from './components/login'
import signUp from './components/signUp'
//import profile from './components/profile'
import signInC from './components/signInC'

import invoice from './components/backEnd/invoice/invoice'
import invoiceItems from './components/backEnd/invoice/invoiceItems'
import findInvoice from './components/backEnd/invoice/findInvoice'
import invoiceOverview from './components/backEnd/invoice/invoiceOverview'
import invoiceHeader from './components/backEnd/invoice/invoiceHeader'

import product from './components/backEnd/product/product'
import findProduct from './components/backEnd/product/findProduct'
import createProduct from './components/backEnd/product/createProduct'
import cProductBase from './components/backEnd/product/cproduct/cProductBase'

import skillType from './components/backEnd/hr/skillType'
import employees from './components/backEnd/hr/employees'
import newEmployee from './components/backEnd/hr/newEmployee'
import signUpC from './components/signUpC.vue'

import payment from './components/bucket/payment'
import delivery from './components/bucket/delivery'
import bucketView from './components/bucket/bucketView'

import createPromotion from './components/backEnd/product/promotion/createPromotion'
import createCatalog from './components/backEnd/product/catalog/createCatalog'
import createCategories from './components/backEnd/product/categories/createCategories'
import createContent from './components/content/createContent'

import Adress from './components/bucket/adress/AdressMain.vue'
import registerOrder from './components/bucket/registerOrder.vue'

import surveyMain from './components/content/survey/surveyMain'
import blogMain from './components/content/blog/blogMain'
import forumMain from './components/content/forum/forumMain'
import qaMain from './components/content/qa/qaMain'

import createBrands from './components/backEnd/product/brand/createBrands'
import createProfiles from './components/profile/createProfiles'
import contentMain from './components/content/contnt/contentMain'
import myOrders from './components/order/myOrders'

import publicQa from './components/content/qa/publicQa'

import articleMain from './components/backEnd/article/articleMain'

import categoriesPage from './components/backEnd/product/categories/categoriesPage'

import contentC from './components/content/contnt/contentC.vue'


import userMain from './components/backEnd/user/userMain.vue'

import FrontEnd from './front/FrontEnd.vue'
import BackEnd from './back/BackEnd.vue'

import createPayment from './components/backEnd/payment/createPayment.vue'


import FinAccountMain from './components/backEnd/acc/fin/FinAccountMain'

import transRoutes from "@/components/backEnd/acc/transactions/transRoutes";

Vue.use(Router)

export default new Router({
  mode: 'history',
  base: process.env.BASE_URL,
  routes: [
      ...transRoutes,
    {
      path: '/front/FrontEnd',
      name: 'FrontEnd',
      component: FrontEnd
    },
    {
      path: '/back/BackEnd',
      name: 'BackEnd',
      component: BackEnd
    },
    {
      path: '/',
      name: 'home',
      component: BackEnd
    },
    {
      path: '/invoice',
      component: invoice
    },
    {
      path: '/invoiceItems',
      component: invoiceItems
    },
    {
      path: '/findInvoice',
      component: findInvoice
    },
    {
      path: '/invoiceOverview',
      component: invoiceOverview
    },
    {
      path: '/invoiceHeader',
      component: invoiceHeader
    },
    {
      path: '/login',
      name: 'login',
      component: signInC
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
      path: '/aboutus',
      name: 'aboutUs',
      component: aboutUs
    },
    {
      path: '/humanres',
      component: humanres
    },
    {
      path: '/details/:pid',
      name: 'details',
      component: details
    }, {
      path: '/product/:id',
      name: 'product',
      component: product,
      props: true
    },
    {
      path: '/findProduct',
      name: findProduct,
      component: findProduct
    },
    {
      path: '/skillType',
      name: 'skillType',
      component: skillType
    },
    {
      path: '/employees',
      name: 'employees',
      component: employees
    },
    {
      path: '/newEmployee',
      name: 'newEmployee',
      component: newEmployee
    },
    {
      path: '/signUpC',
      name: 'signUpC',
      component: signUpC
    },
    {
      path: '/oauth2/callback',
      component: AuthHandler,
    },
    {
      path: "/createProduct/:id/:title",
      name: "createProduct",
      component: createProduct,
      props: true
    },
    {
      path: '/payment',
      name: 'payment',
      component: payment,
    },
    {
      path: '/delivery',
      name: 'delivery',
      component: delivery
    },
    {
      path: '/cProductBase',
      name: 'cProductBase',
      component: cProductBase
    },
    {
      path: '/bucketView',
      name: 'bucketView',
      component: bucketView,
    },
    {
      path: '/createPromotion',
      name: 'createPromotion',
      component: createPromotion
    },
    {
      path: '/createCatalog',
      name: 'createCatalog',
      component: createCatalog
    },
    {
      path: '/createCategories',
      name: 'createCategories',
      component: createCategories
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
      path: '/registerOrder',
      name: 'registerOrder',
      component: registerOrder
    },
    {
      path: '/surveyMain',
      name: 'surveyMain',
      component: surveyMain
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
      path: '/createBrands',
      name: 'createBrands',
      component: createBrands
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
    }, {
      path: '/articleMain',
      name: 'articleMain',
      component: articleMain
    },
    {
      path: '/categoriesPage',
      name: 'categoriesPage',
      component: categoriesPage
    },
    {
      path: '/contentC',
      name: 'contentC',
      component: contentC
    },
    {
      path: '/userMain',
      name: 'userMain',
      component: userMain
    }
    ,
    {
      path: '/createPayment',
      name: 'createPayment',
      component: createPayment
    }
    , {
      path: '/FinAccountMain',
      name: 'FinAccountMain',
      component: FinAccountMain
    },
    {
      path: '/about',
      name: 'about',
      // route level code-splitting
      // this generates a separate chunk (about.[hash].js) for this route
      // which is lazy-loaded when the route is visited.
      component: () => import(/* webpackChunkName: "about" */ './views/About.vue')
    }
  ]
})

