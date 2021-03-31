import React, { Component } from 'react';
import AuthService from "../../Service/AuthService";

class UserList extends Component {
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
        this.searchHandle = this.searchHandle.bind(this);
    }

    onChange = (e) => this.setState({ [e.target.name]: e.target.value });

    searchHandle = (e) => {
        e.preventDefault();
        let searchRequest = {
            role: this.state.role,
        };
        console.warn(searchRequest);
        AuthService.fetchUserByRole(this.state.role)
            .then(res => {
                this.setState({ users : res.data.result })
                console.log(JSON.stringify(this.state.users))
            });
        this.state.user !== null && window.localStorage.setItem("user_role", this.state.role);
        this.props.history.push('/admin/show_users');
    }

    render() {
        return (
            <div>
                <div className="text-center my-1">
                    <h2>User List</h2>
                </div>

                <div className="text-center my-5">
                    <div class="form-group">
                        <label className="col-sm-1">User Role</label>
                        <input name="role" type="text" placeholder="Search" value={this.state.role} onChange={this.onChange} />
                        <button type="submit" className="btn btn-success " onClick={this.searchHandle}>Search</button>
                    </div>
                </div>


            </div>
        )
    }
}

export default UserList;