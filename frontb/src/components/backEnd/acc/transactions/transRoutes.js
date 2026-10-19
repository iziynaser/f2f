export default [
    {
        path: '/transactions',
        name: 'transactions.list',
        component: () => import('@/components/backEnd/acc/transactions/TransactionList.vue'),
    },
    {
        path: '/transactions/create',
        name: 'transactions.create',
        component: () => import('@/components/backEnd/acc/transactions/TransactionForm.vue'),
    },
    {
        path: '/transactions/:id',
        name: 'transactions.detail',
        component: () => import('@/components/backEnd/acc/transactions/TransactionForm.vue'),
        props: true,
    },
]
