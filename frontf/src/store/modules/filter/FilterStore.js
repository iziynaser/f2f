let applyTimer = null;
const DEBOUNCE_MS = 450;

export default {
    namespaced: true,
    state: () => ({
        category: null,
        brandIds: [],          // array of ids
        priceRange: [0, 1000000000],
        colors: [],            // array of color codes/ids
        searchTerm: '',
        inStockOnly: false,
        sortBy: null,
        page: 1,
        pageSize: 24,
        original: false,
        cod : false,
        fastDelivery: false,
    }),
    getters: {
        params(state) {
            return {
                category: state.category,
                brands: state.brandIds.length ? state.brandIds.join(',') : undefined,
                minPrice: state.priceRange[0],
                maxPrice: state.priceRange[1],
                colors: state.colors.length ? state.colors.join(',') : undefined,
                search: state.searchTerm || undefined,
                inStock: state.inStockOnly ? true : undefined,
                sortBy: state.sortBy || undefined,
                page: state.page,
                pageSize: state.pageSize,
                original: state.original || false,
                cod: state.cod  || false,
                fastDelivery: state.fastDelivery || false,
            };
        }
    },
    mutations: {
        setCategory(state, id) { state.category = id; state.page = 1; },
        setBrandIds(state, ids) { state.brandIds = ids; state.page = 1; },
        setPriceRange(state, range) { state.priceRange = range; state.page = 1; },
        setColors(state, colors) { state.colors = colors; state.page = 1; },
        setSearchTerm(state, term) { state.searchTerm = term; state.page = 1; },
        setInStockOnly(state, v) { state.inStockOnly = v; state.page = 1; },
        setSortBy(state, s) { state.sortBy = s; state.page = 1; },
        setPage(state, p) { state.page = p; },
        setOriginal(state,v){state.original = v ; state.page = 1; },
        setCod(state,v){ state.cod = v ; state.page = 1;},
        setFastDelivery(state,v){state.fastDelivery = v ; state.page = 1; },
    },
    actions: {
        /**
         * updateFilter:
         *  - mutation: string name of mutation, e.g. 'setCategory'
         *  - value: new value
         *  - immediate: if true => dispatch applyFilters immediately (no debounce)
         */
        updateFilter({ commit, dispatch }, { mutation, value, immediate = false }) {
            commit(mutation, value);

            if(mutation==='setCategory'){
                console.log('applyServerFilter');
                dispatch('applyServerFilter');
                return;
            }

            if (immediate) {
                console.log('applyLocalFilters');
                dispatch('applyLocalFilters');
                return;
            }
            // debounce applyFilters
            clearTimeout(applyTimer);
            applyTimer = setTimeout(() => {
                dispatch('applyFilters');
            }, DEBOUNCE_MS);
        },

        /**
         * applyFilters:
         * dispatch می‌کند به shop/fetchProducts با پارامترهای ساخته شده
         */
        applyFilters({ getters, dispatch }) {
            // dispatch به shop module (root) با پارامترهای حاضر
            console.log('apply filter called...')
            dispatch('shop/fetchProducts', getters.params, { root: true });
        },

        // برای load صفحه بعد (infinite scroll)
        loadNextPage({ state, commit, getters, dispatch }) {
            commit('setPage', state.page + 1);
            dispatch('shop/fetchProducts', getters.params, { root: true });
        },

        applyServerFilter({ getters, dispatch }) {
           // console.log('fetching products from server by category id ....');
            dispatch('shop/fetchProducts',getters.params,{ root: true});
        },
        applyLocalFilter({ dispatch }) {
            console.log('applying local filters like brand , price , ...');
            dispatch('shop/applyLocalFilters',null,{root : true});
        }
    }
};
