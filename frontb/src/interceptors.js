import axios from 'axios'

export default function setup(){
    const token = window.localStorage.getItem('access_token');
    axios.defaults.headers.common['Authorization'] = `Bearer ${token}` ;
    axios.interceptors.request.use(function(config){    
        if(token){
          config.headers.Authorization = `Bearer ${token}`;
          config.headers.post['Authorization'] = `Bearer ${token}`;
          config.headers.get['Authorization'] = `Bearer ${token}`;
          config.headers['Authorization'] = `Bearer ${token}`;
          config.headers.common['Authorization'] = `Bearer ${token}`;
        }
        return config;
      },function(err){
        console.log('eeeerrrrroooorrrr:'+err);
        return Promise.reject(err);
      });    
}
