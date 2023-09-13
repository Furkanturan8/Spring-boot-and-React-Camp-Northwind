import rootReducer from "./rootReducer";
import {legacy_createStore as createStore} from "redux" 
import {devToolsEnhancer} from "redux-devtools-extension"

export function configureStore(){
    return createStore(rootReducer,devToolsEnhancer())
}