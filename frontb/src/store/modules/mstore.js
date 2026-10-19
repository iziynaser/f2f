import myapi from './myapi'

const state ={
    //products:null,
    products:[],
    cart:[],
    toast:{
        text:'',
        show: false
    }
};

const getters={
    cartSize:(state)=>{
        return state.cart.length;
    },
    cartTotalAmount:(state)=>{
        return state.cart.reduce((total,product)=>{
            return total + (product.price * product.quantity);
        },0);
    },
    toast:(state)=>{
        return state.toast;
    },
    productSize:(state)=>{
        return state.products.length;
    },
    listOfProducts:(state)=>{
        return state.products;
    },
    listOfCarts:()=>{
        return state.cart;
    }

};

const actions={
    fetchProducts:({commit})=>{        
        //simulating a fake ajax request to fetch products from database
        myapi.getProducts().then((products)=>{
            //passing the products received from response as a payload to the mutation
            commit("setUpProducts",products);
            commit("showToast","product loaded");    
        });
    },
    addToCart:({commit},productId)=>{
        myapi.products("add",productId).then((productId)=>{
            commit("addToCart",productId);
            commit("showToast","added to basket");    
        });
    },
    removeFromCart:({commit},productId)=>{
        myapi.products("remove",productId).then((productId)=>{
            commit("removeFromCart",productId);
            commit("showToast","remove from basket");    
        });
    },
    deleteFromCart:({commit},productId)=>{
        myapi.products("delete",productId).then(()=>{
            commit("deleteFormCart",productId);
            commit("showToast","deleted from basket");    
        });
    }
};

const mutations={
    setUpProducts:(state,ProductPayload)=>{
        state.products = ProductPayload;
    },
    addToCart:(state,productId)=>{
        let product = state.products.find((product)=>product.id===productId);
        let cartProduct = state.cart.find((product)=>product.id===productId);
        if(cartProduct){
            cartProduct.quantity ++ ;
        }else{
            state.cart.push({
                ...product,
                stock:product.quantity,
                quantity:1,
            });
        }
        product.quantity--;
    },
    removeFromCart:(state,productId)=>{
        let product = state.products.find((product)=>product.id===productId);
        let cartProduct = state.cart.find((product)=>product.id===productId);
        cartProduct.quantity--;
        product.quantity++;
    },
    deleteFromCart:(state,productId)=>{
        let product = state.products.find((product)=>product.id===productId);
        let cartProductIndex = state.cart.findIndex((product)=>product.id===productId);
        product.quantity = state.cart[cartProductIndex].stock;
        state.cart.splice(cartProductIndex,1);
    },
    showToast:(state,toastText)=>{
        state.toast.show = true;
        state.toast.text = toastText;
    },
    hideToast:(state)=>{
        state.toast.show = false;
        state.toast.text = "";
    }
};

export default{
    state:state,
    getters:getters,
    mutations:mutations,
    actions:actions
}