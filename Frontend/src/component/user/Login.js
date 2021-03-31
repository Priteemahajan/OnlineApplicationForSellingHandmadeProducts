import React, { Component } from "react";
import { Link } from "react-router-dom";
import AuthService from "../../Service/AuthService";
const required = value => {
  if (!value) {
    return (
      <div className="alert alert-danger" role="alert">
        This field is required!
      </div>
    );
  }
};
class Login extends Component {
  constructor(props) {
    super(props);
    this.state = {
      id: "",
      userName: "",
      email: "",
      password: "",
      contactNo: "",
      address: "",
      city: "",
      district: "",
      state: "",
      dateOfBirth: "",
      gender: "",
      role: "",
    }
    this.loginHandle = this.loginHandle.bind(this);
  }

  onChange = (e) => this.setState({ [e.target.name]: e.target.value });

  loginHandle = (e) => {
    e.preventDefault();
    let loginRequest = {
      email: this.state.email,
      password: this.state.password,
    };
    AuthService.login(loginRequest).then((res) => 
    {
      let user = res.data;
      console.log(user);
      
      this.setState({
        id: user.id,
        userName: user.userName,
        email: user.email,
        password: user.password,
        contactNo: user.contactNo,
        address: user.address,
        city: user.city,
        district: user.district,
        state: user.state,
        dateOfBirth: user.dateOfBirth,
        gender: user.gender,
        role: user.role,
      });
     // alert("User Login successfully.");
      //this.props.history.push("/");
      if (this.state.role === "CUSTOMER"){
        user != null && alert("Customer Login successfully");
        user != null && window.localStorage.setItem("customer_details", JSON.stringify(this.state));
        this.props.history.push("/customer");
      }
      else if(this.state.role === "SUPPLIER"){
        user != null && alert("Supplier Login successfully");
        user != null && window.localStorage.setItem("supplier_details", JSON.stringify(this.state));
        this.props.history.push('/supplier');
      }
      else if(this.state.role === "ADMIN"){
        user != null && alert("Admin Login successfully");
        user != null && window.localStorage.setItem("admin_details", JSON.stringify(this.state));
        this.props.history.push("/admin");
      }

    })

  }
  render() {
    return (
      <div>

        <div className="main">
          <h2>Sign In </h2>
          <img
            src="//ssl.gstatic.com/accounts/ui/avatar_2x.png"
            alt="profile-img"
            className="profile-img-card"
          />
          <div className="form">
            <div className="mb-3">
              <label className="form-label">Email</label>
              <input
                type="email "
                className="form-control mb-6"
                name="email"
                value={this.state.email}
                onChange={this.onChange}
                required={{required}}
              />
            </div>
            <div className="mb-3">
              <label className="form-label">Password</label>
              <input
                type="password"
                className="form-control"
                placeholder="********"
                name="password"
                value={this.state.password}
                onChange={this.onChange}
                required={{required}}
              ></input>
            </div>
            <div className="mb-3">
              <button
                className="btn btn-success float-start"
                onClick={this.loginHandle}

              >
                Login
              </button>
              <div className="float-end">
                New User? <Link to="/register">Create Account here</Link>
              </div>
              <br></br>
            </div>
          </div>
        </div>

      </div >
    );
  }
}
export default Login;
/*import React, { Component } from "react";
import { Link } from "react-router-dom";
import AuthService from "../../Service/AuthService";
import ValidationService from "../../Service/ValidationService";
const required = value => {
  if (!value) {
    return (
      <div className="alert alert-danger" role="alert">
        This field is required!
      </div>
    );
  }
};
class Login extends Component {
  constructor(props) {
    super(props);
    this.state = {
      id: "",
      userName: "",
      email: "",
      password: "",
      contactNo: "",
      address: "",
      city: "",
      district: "",
      state: "",
      dateOfBirth: "",
      gender: "",
      role: "",
    }
    this.loginHandle = this.loginHandle.bind(this);
  }

  onChange = (e) => this.setState({ [e.target.name]: e.target.value });

  getCartSize() {
    setTimeout(() => {
      ValidationService.getCartByUserId(JSON.parse(window.localStorage.getItem("user_id")))
        .then((res) => {
          JSON.stringify(window.localStorage.setItem("cart_size", res.data.result.length));
        });
    }, 1000);

  }

  updateUserCart() {
    let cartUserId = JSON.parse(window.localStorage.getItem("user_id"));
    let cartSize = JSON.parse(window.localStorage.getItem("cart_size"));
    if (cartSize > 0) {
      ValidationService.updateCartUserId(cartUserId);
    }
    this.getCartSize();
  }

  loginHandle = (e) => {
    e.preventDefault();
    let loginRequest = {
      email: this.state.email,
      password: this.state.password,
    };
    AuthService.login(loginRequest).then((res) => {
      let user = res.data;
      console.log(user);

      this.setState({
        id: user.id,
        userName: user.userName,
        email: user.email,
        password: user.password,
        contactNo: user.contactNo,
        address: user.address,
        city: user.city,
        district: user.district,
        state: user.state,
        dateOfBirth: user.dateOfBirth,
        gender: user.gender,
        role: user.role,
        cart:[],
      });
      // alert("User Login successfully.");
      //this.props.history.push("/");
      if (this.state.role === "CUSTOMER") {
        user != null && alert("Customer Login successfully");
        user != null && this.updateUserCart();
        user != null && window.localStorage.setItem("customer_details", JSON.stringify(this.state));
        this.props.history.push("/customer");
      }
      else if (this.state.role === "SUPPLIER") {
        user != null && alert("Supplier Login successfully");
        user != null && window.localStorage.setItem("supplier_details", JSON.stringify(this.state));
        this.props.history.push('/supplier');
      }

    })
  }
  render() {
    return (
      <div>

        <div className="main">
          <h2>Sign In </h2>
          <img
            src="//ssl.gstatic.com/accounts/ui/avatar_2x.png"
            alt="profile-img"
            className="profile-img-card"
          />
          <div className="form">
            <div className="mb-3">
              <label className="form-label">Email</label>
              <input
                type="email "
                className="form-control mb-6"
                name="email"
                value={this.state.email}
                onChange={this.onChange}
                required={{ required }}
              />
            </div>
            <div className="mb-3">
              <label className="form-label">Password</label>
              <input
                type="password"
                className="form-control"
                placeholder="********"
                name="password"
                value={this.state.password}
                onChange={this.onChange}
                required={{ required }}
              ></input>
            </div>
            <div className="mb-3">
              <button
                className="btn btn-success float-start"
                onClick={this.loginHandle}

              >
                Login
              </button>
              <div className="float-end">
                New User? <Link to="/register">Create Account here</Link>
              </div>
              <br></br>
            </div>
          </div>
        </div>

      </div >
    );
  }
}
export default Login;*/


/*
import React, { Component } from "react";
import { Link } from "react-router-dom";
import AuthService from "../../Service/AuthService";
const required = value => {
  if (!value) {
    return (
      <div className="alert alert-danger" role="alert">
        This field is required!
      </div>
    );
  }
};
class Login extends Component {
  constructor(props) {
    super(props);
    this.state = {
      id: "",
      userName: "",
      email: "",
      password: "",
      contactNo: "",
      address: "",
      city: "",
      district: "",
      state: "",
      dateOfBirth: "",
      gender: "",
      role: "",
    }
    this.loginHandle = this.loginHandle.bind(this);
  }

  onChange = (e) => this.setState({ [e.target.name]: e.target.value });

  loginHandle = (e) => {
    e.preventDefault();
    let loginRequest = {
      email: this.state.email,
      password: this.state.password,
    };
    AuthService.login(loginRequest).then((res) => 
    {
      let user = res.data;
      console.log(user);
      
      this.setState({
        id: user.id,
        userName: user.userName,
        email: user.email,
        password: user.password,
        contactNo: user.contactNo,
        address: user.address,
        city: user.city,
        district: user.district,
        state: user.state,
        dateOfBirth: user.dateOfBirth,
        gender: user.gender,
        role: user.role,
      });
     // alert("User Login successfully.");
      //this.props.history.push("/");
      if (this.state.role === "CUSTOMER"){
        user != null && alert("Customer Login successfully");
        user != null && window.localStorage.setItem("customer_details", JSON.stringify(this.state));
        this.props.history.push("/customer");
      }
      else if(this.state.role === "SUPPLIER"){
        user != null && alert("Supplier Login successfully");
        user != null && window.localStorage.setItem("supplier_details", JSON.stringify(this.state));
        this.props.history.push('/supplier');
      }

    })
  }
  render() {
    return (
      <div>

        <div className="main">
          <h2>Sign In </h2>
          <img
            src="//ssl.gstatic.com/accounts/ui/avatar_2x.png"
            alt="profile-img"
            className="profile-img-card"
          />
          <div className="form">
            <div className="mb-3">
              <label className="form-label">Email</label>
              <input
                type="email "
                className="form-control mb-6"
                name="email"
                value={this.state.email}
                onChange={this.onChange}
                required={{required}}
              />
            </div>
            <div className="mb-3">
              <label className="form-label">Password</label>
              <input
                type="password"
                className="form-control"
                placeholder="********"
                name="password"
                value={this.state.password}
                onChange={this.onChange}
                required={{required}}
              ></input>
            </div>
            <div className="mb-3">
              <button
                className="btn btn-success float-start"
                onClick={this.loginHandle}

              >
                Login
              </button>
              <div className="float-end">
                New User? <Link to="/register">Create Account here</Link>
              </div>
              <br></br>
            </div>
          </div>
        </div>

      </div >
    );
  }
}
export default Login;
*/