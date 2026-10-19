import f2fApi from '../../api/f2f'
import router from '../../router'

const state ={
    access_token: window.localStorage.getItem('access_token'),
    token_type: null,
    refresh_token:null,
    expires_in:null,
    scope:null,
    client_id:null,
    authorities:null,
    user_name:null,
    actives:null
};

const getters={
    isLoggedIn:(state)=>{
        let access_token_str = '';
        if(state.access_token)
            access_token_str= state.access_token.toString();            
        access_token_str.length>0 ? true : false;
        return access_token_str;
    },
    getAccessToken:(state)=>{
        return state.access_token;
    }
};

const actions={
    login:()=>{
        f2fApi.login();
    },
    logout:({commit})=>{
        commit('setToken',null);
        window.localStorage.removeItem('access_token');
        window.localStorage.removeItem('refresh_token');
        window.localStorage.removeItem('expires_in');
        window.localStorage.removeItem('scope');
        window.localStorage.removeItem('token_type');
        router.push('/');
    },
    finalizeLogin:({commit},datas)=>{
        var a_t = datas.access_token;
        var r_t = datas.refresh_token;
        var e_i = datas.expires_in;
        var t_t = '';
        var s_c = datas.scope;
        commit('setToken',a_t);
        commit('setRefreshToken',r_t);
        commit('setExpireIn',e_i);
        commit('setScope',s_c);
        commit('setTokenType',t_t);
        window.localStorage.setItem('access_token',a_t);
        window.localStorage.setItem('refresh_token',r_t);
        window.localStorage.setItem('expires_in',e_i);
        window.localStorage.setItem('scope',s_c);
        window.localStorage.setItem('token_type',t_t);
        //router.push('/');
        router.push({name:'BackEnd'});
    }
};

const mutations={
    setToken:(state,token)=>{
        state.access_token = token;
    }
    ,setRefreshToken:(state,d)=>{
        state.refresh_token = d ;
    }
    ,setExpireIn:(state,d)=>{
        state.expires_in = d ;
    }
    ,setScope:(state,d)=>{
        state.scope = d;
    }
    ,setTokenType:(state,d)=>{
        state.token_type = d;
    }
};

export default{
    state:state,
    getters:getters,
    mutations:mutations,
    actions:actions
}