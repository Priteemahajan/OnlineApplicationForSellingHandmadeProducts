import { BrowserRouter as Router, Switch, Route, Link } from "react-router-dom";
import React from 'react';
import './MainPage.css'
import Login from '../component/user/Login';
import Register from '../component/user/Register';
import Home from '../component/user/Home';
import About from '../component/user/About';
import Contact from '../component/user/Contact';
import 'bootstrap/dist/css/bootstrap.min.css';
import Header from './Header';
function MainPage() {
  return (
    
    <div>
      <Header/>
      <Router>
        
        <div>
          <div className="new">
            <h1><b>Online Aplication For Selling Handmade Product</b></h1>
            <div className="text-right text-capitalize ">
              <b><Link to="/">Home</Link>|<Link to="/about">About</Link> |<Link to="/contact">Contact us</Link> |<Link to="/login">Login</Link></b>
            </div>
            <hr />
          </div>         
        </div>
        <div >
            <Switch>
              <Route exact path="/" component={Home} />
              <Route exact path="/about" component={About} />
              <Route exact path="/contact" component={Contact} />
              <Route exact path="/login" component={Login} />
              <Route exact path="/register" component={Register} />
            </Switch>

          </div>
      </Router>
    </div>
  );
}

export default MainPage;