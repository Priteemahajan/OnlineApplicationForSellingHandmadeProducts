import React from 'react';
import { BrowserRouter as Router, Switch, Route, Link } from "react-router-dom";
import Dashboard from '../component/supplier/Dashboard';
import AddProduct from '../component/supplier/AddProduct'
import ShowProduct from '../component/supplier/ProductList'
import UpdateProduct from '../component/supplier/ProductUpdate'
import Header from './Header';
function Supplier(){
  let supplier=JSON.parse(localStorage.getItem("supplier_details"));
  console.warn(supplier);
  return (
      <div>
      <Header/>
      <Router>
        <div>
          <div className="new">
              <h1><b>Online Aplication For Selling Handmade Product</b></h1>
              <div className="text-right text-capitalize ">
              <h4 className="text-left text-danger">Welcome {supplier && supplier.userName}</h4>
                <b><Link to="/supplier/">DashBoard</Link> | <Link to="/supplier/add_product">Add Product</Link> |
              <Link to="/supplier/show_product">Show Product</Link> | <Link to="/" onClick={() => localStorage.clear()}>Log Out</Link> </b>
              </div>
              <hr />
            </div>   
          <div>
            <Switch>
              <Route exact path="/supplier/" component={Dashboard} />
              <Route exact path="/supplier/add_product" component={AddProduct} />
              <Route exact path="/supplier/show_product" component={ShowProduct} />
              <Route exact path="/supplier/edit_product" component={UpdateProduct}/>
            </Switch>

          </div>
        </div>
      </Router>
    </div>
  )
}

export default Supplier;