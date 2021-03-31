import React, { Component } from 'react';
import ProductService from "../../Service/ValidationService";

class Gallery extends Component {
    constructor(props) {
        super(props);
        this.state = {
            productName: '',
            description: '',
            price: '',
            productState: '',
            imageurl: '',
            message: null
        }
        this.searchHandle = this.searchHandle.bind(this);
    }

    onChange = (e) => this.setState({ [e.target.name]: e.target.value });

    searchHandle = (e) => {
        e.preventDefault();
        let searchRequest = {
            productState: this.state.productState,
        };
        console.warn(searchRequest);
        ProductService.fetchProductByState(this.state.productState)
            .then(res => {
                this.setState({ product: res.data.result })
                console.log(JSON.stringify(this.state.product))
            });
        this.state.productState !== null && window.localStorage.setItem("productState", this.state.productState);
        this.props.history.push('/customer/show_products');
    }

    render() {
        return (
            <div>
                <div className="text-center my-1">
                    <h2>Product List</h2>
                </div>

                <div className="text-center my-5">
                    <div class="form-group">
                        <label className="col-sm-1">State</label>
                        <input name="productState" type="text" placeholder="Search" value={this.state.productState} onChange={this.onChange} />
                        <button type="submit" className="btn btn-success " onClick={this.searchHandle}>Search</button>
                    </div>
                </div>


            </div>
        )
    }
}

export default Gallery;