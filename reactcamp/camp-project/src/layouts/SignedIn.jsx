import React from 'react'
import { Dropdown, Menu,Image } from 'semantic-ui-react'

export default function SignedIn(props) { // props: Navideki if koşulunun icindeki signOut={handleSignOut} bunlara denir
  return (
    <div>
        <Menu.Item>
            <Image avatar spaced="right" src="https://pbs.twimg.com/profile_images/1625171571286368257/trR83qG0_400x400.jpg"/>
            <Dropdown pointing="top left" text="Furkan">
                <Dropdown.Menu>
                    <Dropdown.Item text="Bilgilerim" icon="info"/>
                    <Dropdown.Item onClick={props.signOut} text="Çıkış Yap" icon="sign-out"/>

                </Dropdown.Menu>
            </Dropdown>
        </Menu.Item>
    </div>
  )
}

