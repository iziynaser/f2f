//import products from './products'
import axios from 'axios'


export default{
    // getProducts:()=>{
    //     return new Promise((resolve,reject)=>{
    //         setTimeout(()=>{                
    //             resolve(products);
    //         },5000);
    //         console.log(reject);
    //     });
    // },
    // products:(action,productId)=>{
    //     return new Promise((resolve,reject)=>{
    //         setTimeout(()=>{
    //             resolve(productId);
    //         },1000);
    //         console.log(reject);
    //     });
    // }


    getProducts:()=>{
        return new Promise((resolve,reject)=>{
            setTimeout(()=>{                
                //resolve(products);
                //var self = this;
                //this.errors= {};
                //this.isBusy = true;
                axios({
                    method:'GET',
                    url:'/products/list',
                    // params:{
                    //     'access_token' : localStorage.getItem('access_token')                            
                    // }
                })
                .then(function(res){
                      //self.searchResult = res.data; 
                      //self.isBusy=false;
                      resolve(res.data);
                })
                .catch(function(error){
                    console.log(error)    ;
                });
            },500);
            console.log(reject);
        });
    },
    products:(action,productId)=>{
        return new Promise((resolve,reject)=>{
            setTimeout(()=>{
                resolve(productId);
            },1000);
            console.log(reject);
        });
    }



}