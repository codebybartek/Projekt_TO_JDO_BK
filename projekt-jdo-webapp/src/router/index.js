import Vue from 'vue'
import Router from 'vue-router'
import Model from '@/components/Model'

import Start from '@/components/Start'
import Menu from '@/components/Menu'



Vue.use(Router)

export default new Router({
	mode: 'history',
  routes: [
  	{
      path: '/',
      name: 'start',
      component: Start
    },
    {
      path: '/start',
      name: 'start',
      component: Start
    },
    {
      path: '/menu',
      name: 'menu',
      component: Menu
    },
    {
      path: '/model/:model',
      name: 'model',
      component: Model
    }
  ]
})
