import { ADD_TO_CART, REMOVE_FROM_CART } from "../actions/cartActions";
import { cartItems } from "../initialValues/cartItems";

const initialState ={
    cartItems : cartItems
}

export default function cartReducer(state=initialState, {type,payload}){ // gönderdiğimiz aksiyona göre sepetin son halini tuttuğumuz yer
    switch(type){

        case ADD_TO_CART: 
            let product = state.cartItems.find(c=>c.product.id===payload.id)
            if (product) { // mevcut sepette o product varsa (yani aynı urunden bir tane daha varsa)
                product.quantity++; // aynı olan o ürünün miktarını arttırdık
                return {
                    ...state // spread operasyonu yepyeni bir obje oluşturduk (javadaki new gibi) cartItems 'ı spread ile ayırdık
                }
            } else {
                return{
                    ...state, // öncekileri korudum
                    cartItems:[...state.cartItems,{quantity:1, product: payload }] // gelen arraydaki ürünleri spread yaparak(objelerine ayırdım) ,üzerine yazdım 
                };
            }

        case REMOVE_FROM_CART:
            return{
                ...state, // sepetin  kopyasını aldık
                cartItems: state.cartItems.filter(c=>c.product.id===payload.id)// üzerinden silicez şimdi (yeni dizimiz filtreleme ile gönderilen idsi ne ise onu çıkardık ve geriye kalan ürünlerle yeni bir filtrelenmiş dizimiz oluştu)
            };
        default: 
            return state;    
            
    }
}