// tüm stateleri topladığım yer , boylece istedigimiz zaman bunları gondericez abonelere

import cartReducer from "./reducers/cartReducer";
import { combineReducers } from 'redux'
const rootReducer = combineReducers({ 
    cart : cartReducer // sepete cartReducer'ı atadım
})

export default rootReducer; // default olarak çıkalım