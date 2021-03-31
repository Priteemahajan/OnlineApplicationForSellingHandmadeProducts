import { BrowserRouter as Router, Switch, Route} from "react-router-dom";
import React from 'react';
import './App.css';
import MainPage from './pages/MainPage';
import Customer from './pages/Customer';
import Supplier from './pages/Supplier';
import Admin from './pages/Admin';
function App(){
  return(
    <div>
      <Router>
        <Switch>
          <Route exact path="/" component={MainPage}/>
          <Route exact path="/customer/" component={Customer}/>
          <Route exact path="/supplier/" component={Supplier}/>
          <Route exact path="/admin/" component={Admin}/>
        </Switch>
      </Router>
    </div>
  );
}

export default App;



