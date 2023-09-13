// APP.JS = ANA COMPONENT GOREVI GORECEK VE BUNA HIZMET EDECEK APP.CSS KODLARI DA YANDA BULUNMAKTA.
import { Container } from 'semantic-ui-react';
import './App.css';
import Dashboard from './layouts/Dashboard';
import Navi from './layouts/Navi'
import 'semantic-ui-css/semantic.min.css'


function App() {
  return ( // HTML GORUNUMLU JS KODLARIDIR BUNLAR
    <div className="App">
      <Navi/>
      <Container className='main'>
         <Dashboard/>
      </Container>

    </div>
  );
}

export default App;
