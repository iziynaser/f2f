

const state ={
    productId: null,
};

const getters={
    getProductId:(state)=>{
        //console.log('map getters: getProductId is called...');
        return state.productId;
    }
};

const actions={
    setProductId:({commit},datas)=>{
        //console.log('map actions :setProductId is called...');
        commit('setProductId',datas);
    }
};

const mutations={
    setProductId:(state,productId)=>{
        state.productId = productId;
    }
};

export default{
    state:state,
    getters:getters,
    mutations:mutations,
    actions:actions
}