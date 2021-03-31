import React from 'react';
import { BrowserRouter as Router, Switch, Route, Link, } from "react-router-dom";
import Dashboard from '../component/Admin/Dashboard';
import ProductList from '../component/Admin/ProductList';
import User from '../component/Admin/UserList';
//import UserList from '../component/Admin/ListOfUsers'

import './Admin.css'
import Header from './Header';


function Admin() {
  let admin=JSON.parse(localStorage.getItem("admin_details"));
  console.warn(admin);
    return (
      <div>
        <Header/>
        <Router>
          <div>
            
            <div className="new">
              <h1><b>Online Aplication For Selling Handmade Product</b></h1>
              <div className="text-right text-capitalize ">
                <h4 className="text-left text-danger">Welcome {admin && admin.userName}</h4>
                <b><Link to="/admin/">DashBoard</Link> | <Link to="/admin/product_list">product_list</Link> |
                <Link to="/admin/users">User</Link> |<Link to="/" onClick={() => localStorage.clear()}>Log Out</Link> </b>
              </div>
              <hr />
            </div>         
        
            <div>
              <Switch>
                <Route exact path="/admin/" component={Dashboard} />
                <Route exact path="/admin/product_list" component={ProductList} />
                <Route exact path="/admin/users" component={User}/>
                {/*<Route exact path="/admin/show_users" component={UserList} />*/}
              </Switch>
  
            </div>
          </div>
        </Router>
      </div>
    );
  }
  
  export default Admin;