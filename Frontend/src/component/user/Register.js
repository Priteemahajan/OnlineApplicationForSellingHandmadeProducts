
import { Link } from "react-router-dom";
import UserService from "../../Service/AuthService";
import React, { Component } from "react";

const required = value => {
  if (!value) {
    return (
      <div className="alert alert-danger" role="alert">
        This field is required!
      </div>
    );
  }
};

class Register extends Component {
  constructor(props) {
    super(props);
    this.state = {
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
      successful: false,
      message: "",
      errors: {
        userName: "",
        email: "",
        password: "",
        confirmPassword: "",
        contactNo: "",
        address: "",
        city: "",
        district: "",
        state: "",
        dateOfBirth: "",
        gender: "",
        role: "",
        successful: false,
        message: "",
      }
    };
    this.registerUser = this.registerUser.bind(this);
    this.onClickRadio = this.onClickRadio.bind(this);
  }

  onChange = (event) => {
    this.setState({ [event.target.name]: event.target.value });
  }
  onClickRadio = (event) => {
    this.setState({ [event.target.name]: event.target.value });
  }

  registerUser = (e) => {
    e.preventDefault();

    let user = {
      userName: this.state.userName,
      email: this.state.email,
      password: this.state.password,
      confirmPassword: this.state.confirmPassword,
      contactNo: this.state.contactNo,
      address: this.state.address,
      city: this.state.city,
      district: this.state.district,
      state: this.state.state,
      dateOfBirth: this.state.dateOfBirth,
      gender: this.state.gender,
      role: this.state.role,
    };
    UserService.registerUser(user).then((res) => {
      res.data.result != null && alert("SignUp successfully");
      if (res.data.result === null) {
        alert("SignUp Failed...............");
        this.setState({
          userName: "",
          email: "",
          password: "",
          confirmPassword: "",
          contactNo: "",
          address: "",
          city: "",
          district: "",
          state: "",
          dateOfBirth: "",
          gender: "",
          role: "",
        });
        console.log(user);
        this.props.history.push("/register");
      } else {
        // this.setState({ message: "SignUp successfully." });
        alert("SignUp successfully");
        this.props.history.push("/login");
      }
    })/*.catch(error => {
          this.setState ({firstName:"",lastName:"", dateOfBirth: "", phoneNumber: "",email: "", password: "",
          confirmPassword: ""});
          console.log(error)
        alert();
        
        return error;
      });*/

  };


  cancel() {
    this.props.history.push('/')
  }
  render() {
    return (

      <div className="register">

        <div className="main" >
          <h1 className="text-center">Register User </h1>
          <div className="card-body ">
            <div className="form">
              <div class="row-cols-1" >
                <label className="col-sm-3 col-form-label ">Full  Name</label>
                <div className="col-sm-9">
                  <input
                    type="text"
                    className="form-control"
                    name="userName"
                    value={this.state.userName}
                    onChange={this.onChange}
                    required={[required]}
                  />

                </div>
              </div>

              <div class="row-cols-1">
                <label className="col-sm-3 col-form-label">City</label>
                <div className="col-sm-9">
                  <input
                    type="text"
                    className="form-control"
                    name="city"
                    value={this.state.city}
                    onChange={this.onChange}
                    required={[required]}
                  />

                </div>
              </div>

              <div class="row-cols-1">
                <label className="col-sm-3 col-form-label">Address</label>
                <div className="col-sm-9">
                  <input
                    type="text"
                    className="form-control"
                    name="address"
                    value={this.state.address}
                    onChange={this.onChange}
                    required={[required]}
                  />

                </div>
              </div>

              <div class="row-cols-1">
                <label className="col-sm-3 col-form-label">District</label>
                <div className="col-sm-9">
                  <input
                    type="text"
                    className="form-control"
                    name="district"
                    value={this.state.district}
                    onChange={this.onChange}
                    required={[required]}
                  />

                </div>
              </div>

              <div class="row-cols-1">
                <label className="col-sm-3 col-form-label">State</label>
                <div className="col-sm-9">
                  <input
                    type="text"
                    className="form-control"
                    name="state"
                    value={this.state.state}
                    onChange={this.onChange}
                    required={[required]}
                  />

                </div>
              </div>

              <div class="row-cols-1">
                <label className="col-sm-3 col-form-label">Gender</label>
                <div className="col-sm-9" >
                  <input type="radio" value="Male" name="gender" onClick={this.onClickRadio} /> Male
                  <input type="radio" value="Female" name="gender" onClick={this.onClickRadio} /> Female
                  <input type="radio" value="Other" name="gender" onClick={this.onClickRadio} /> Other
                </div>
              </div>

              <div class="row-cols-1">
                <label className="col-sm-3 col-form-label">Role</label>
                <div className="col-sm-9" >
                  <select type="text" name="role" onChange={this.onChange}>
                    <option value="CUSTOMER">Customer</option>
                    <option value="SUPPLIER">Supplier</option>
                    <option value="ADMIN">Admin</option>
                  </select>
                </div>
              </div>

              <div class="row-cols-1">
                <label className="col-sm-3 col-form-label">Date Of Birth</label>
                <div className="col-sm-9">
                  <input
                    type="date"
                    className="form-control"
                    name="dateOfBirth"
                    value={this.state.dateOfBirth}
                    onChange={this.onChange}
                    required={[required]}
                  />
                </div>
              </div>
              <div class="row-cols-1">
                <label className="col-sm-3 col-form-label">Contact Number</label>
                <div className="col-sm-9">
                  <input
                    type="text"
                    className="form-control"
                    name="contactNo"
                    value={this.state.contactNo}
                    onChange={this.onChange}
                    required={[required]}
                  />

                </div>
              </div>

              <div class="row-cols-1">
                <label className="col-sm-3 col-form-label">Email</label>
                <div className="col-sm-9">
                  <input
                    type="email"
                    className="form-control"
                    name="email"
                    value={this.state.email}
                    onChange={this.onChange}
                    required={[required]}
                  />

                </div>
              </div>

              <div class="row-cols-1">
                <label className="col-sm-3 col-form-label">Password</label>
                <div className="col-sm-9">
                  <input
                    type="password"
                    className="form-control"
                    name="password"
                    value={this.state.password}
                    onChange={this.onChange}
                    required={[required]}
                  />
                </div>
              </div>

              <div class="row-cols-1">
                <label className="col-sm-3 col-form-label">Confirm Password</label>
                <div className="col-sm-9">
                  <input
                    type="password"
                    className="form-control"
                    name="confirmPassword"
                    value={this.state.confirmPassword}
                    onChange={this.onChange}
                    required={[required]}
                  />
                </div>
              </div>
              <div className="mb-3">
                <button
                  className="btn btn-success float-start"
                  onClick={this.registerUser}
                >
                  Register
              </button>
                <button className=" btn-danger btn" onClick={this.cancel.bind(this)} style={{ marginLeft: "10px", backgroundColor: "red" }}>Cancel</button>
                <div className="float-end">
                  Existing User? <Link to="/login">Login here </Link>
                </div>
                <br></br>


              </div>
            </div>
          </div>
        </div>

      </div>
    );
  }
}
export default Register;