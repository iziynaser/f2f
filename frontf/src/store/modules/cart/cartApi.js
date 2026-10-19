import axiosInstance from '@/api/axiosInstance';

export default{
    getProducts:()=>{
        return new Promise((resolve,reject)=>{
            setTimeout(()=>{                
                axios({
                    method:'GET',
                    url:'/products/list',
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