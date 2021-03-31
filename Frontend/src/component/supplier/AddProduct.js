import React, { Component } from 'react'
import ProductService from "../../Service/ValidationService";

class AddProduct extends Component{

    constructor(props){
        super(props);
        this.state ={
            productName: '',
            description: '',
            price: '',
            productState: '',
            imageurl: '',
            message: null
        }
        this.saveProduct = this.saveProduct.bind(this);
    }

    saveProduct = (e) => {
        e.preventDefault();
        let product = {productName: this.state.productName, description: this.state.description, price: this.state.price, productState: this.state.productState, imageurl: this.state.imageurl};
        ProductService.addProduct(product)
            .then(res => {
                this.setState({message : 'Product added successfully.'});
                alert("Product Added successfully");
                this.props.history.push('/supplier/add_product');
            });
    }

    onChange = (e) =>
        this.setState({ [e.target.name]: e.target.value });

    render() {
        return(
            <div>
                <h2 className="text-center">Add Product</h2>
                <form>
                <div className="form-group">
                    <label>Product Name:</label>
                    <input type="text" placeholder="Product Name" name="productName" className="form-control" value={this.state.productName} onChange={this.onChange}/>
                </div>

                <div className="form-group">
                    <label>Description:</label>
                    <input type="text" placeholder="description" name="description" className="form-control" value={this.state.description} onChange={this.onChange}/>
                </div>

                <div className="form-group">
                    <label>Price:</label>
                    <input type="number" placeholder="price" name="price" className="form-control" value={this.state.price} onChange={this.onChange}/>
                </div>

                <div className="form-group">
                    <label>Product State:</label>
                    <input placeholder="Product State" name="productState" className="form-control" value={this.state.productState} onChange={this.onChange}/>
                </div>

                <div className="form-group">
                    <label>ImageURL:</label>
                    <input type="text" placeholder="imageurl" name="imageurl" className="form-control" value={this.state.imageurl} onChange={this.onChange}/>
                </div>

                <button className="btn btn-success" onClick={this.saveProduct}>Save</button>
            </form>
    </div>
        );
    }
}

export default AddProduct;