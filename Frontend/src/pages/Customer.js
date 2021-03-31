import React from 'react';
import { BrowserRouter as Router, Switch, Route, Link, } from "react-router-dom";
import Dashboard from '../component/customer/Dashboard';
import Gallery from '../component/customer/Gallery';
import MyOrders from '../component/customer/MyOrders';
import Cart from '../component/customer/Cart';
import ProductList from '../component/customer/ListOfProduct';
import './Customer.css'
import Header from './Header';


function Customer() {
  let user=JSON.parse(localStorage.getItem("customer_details"));
  console.warn(user);
    return (
      <div>
        <Header/>
        <Router>
          <div>
            
            <div className="new">
              <h1><b>Online Aplication For Selling Handmade Product</b></h1>
              <div className="text-right text-capitalize ">
                <h4 className="text-left text-danger">Welcome {user && user.userName}</h4>
                <b><Link to="/customer/">DashBoard</Link> | <Link to="/customer/gallery">Gallery</Link> | 
                  <Link to="/customer/order">My Orders</Link> | <Link to="/customer/cart">Cart</Link> | 
                  <Link to="/" onClick={() => localStorage.clear()}>Log Out</Link> </b>
              </div>
              <hr />
            </div>         
        
            <div>
              <Switch>
                <Route exact path="/customer/" component={Dashboard} />
                <Route exact path="/customer/gallery" component={Gallery} />
                <Route exact path="/customer/order" component={MyOrders} />
                <Route exact path="/customer/cart" component={Cart} />
                <Route exact path="/customer/show_products" component={ProductList} />
              </Switch>
  
            </div>
          </div>
        </Router>
      </div>
    );
  }
  
  export default Customer;