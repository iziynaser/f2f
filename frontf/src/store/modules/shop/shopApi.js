import axiosInstance from '@/api/axiosInstance';

export default{
    getProducts:(params = {})=>{
        return new Promise((resolve,reject)=>{
            setTimeout(()=>{
                axiosInstance({
                    method:'GET',
                    url:'/products/list',
                    params: params,
                })
                .then(function(res){
                      resolve(res.data);
                })
                .catch(function(error){
                    console.log(error);
                    reject(error);// propage
                });
            },500);
            console.log(reject);
        });
    }
}