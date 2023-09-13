import React,{useState} from 'react'
import CartSummary from './CartSummary'
import {Container, Menu } from 'semantic-ui-react'
import SignedOut from './SignedOut'
import SignedIn from './SignedIn'
import {useNavigate} from 'react-router-dom'
import { useSelector } from 'react-redux'

export default function Navi() { // reactta bir şarta göre bir şey yapman(data tutmak mesela) gerekiyorsa aklına state gelicek.
   
    const {cartItems} = useSelector(state=> state.cart) 
    let history = useNavigate()
    const [isAuthenticated, setIsAuthenticated] = useState(true)
    // mesela çıkıs yap dediginde setIsAuthenticated ile useState deki durumu degistirebilirsin true veya false olarak
    function handleSignOut() { // çıkış yap butonu
        setIsAuthenticated(false)
        history('/') // çıkış yap dediginde ana sayfaya gider
    }
    function handleSignIn(){
        setIsAuthenticated(true)
    }
        return (
        <div>
            <Menu inverted fixed="top">
                <Container>
                    <Menu.Item name='home'/>
                    <Menu.Item name='messages'/>

                    <Menu.Menu position='right'>
                        {cartItems.length>0&&<CartSummary/>} 
                        {isAuthenticated?<SignedIn signOut={handleSignOut} /> : <SignedOut  signIn={handleSignIn}/>}
                        
                    </Menu.Menu>
                
                </Container>
            </Menu>
        </div>
    )
}
