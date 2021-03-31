import React, { Component } from 'react'
import ProductService from "../../Service/ValidationService";

class ProductUpdate extends Component {

    constructor(props){
        super(props);
        this.state ={
            productId: '',
            productName: '',
            description: '',
            price: '',
            productState: '',
            imageurl: '',
        }
        this.saveProduct = this.saveProduct.bind(this);
        this.loadProduct = this.loadProduct.bind(this);
    }

    componentDidMount() {
        this.loadProduct();
    }

    loadProduct() {
        ProductService.fetchProductById(window.localStorage.getItem("productId"))
            .then((res) => {
                let product = res.data.result;
                this.setState({
                productId: product.productId,
                productName: product.productName,
                description: product.description,
                price: product.price,
                productState: product.productState,
                imageurl: product.imageurl,
                })
            });
    }

    onChange = (e) =>
        this.setState({ [e.target.name]: e.target.value });

    saveProduct = (e) => {
        e.preventDefault();
        let product = {productId: this.state.productId, productName: this.state.productName, description: this.state.description, price: this.state.price, productState: this.state.productState, imageurl: this.state.imageurl};
        ProductService.editProduct(product)
            .then(res => {
                this.setState({message : 'Product added successfully.'});
                this.props.history.push('/supplier/show_product');
            });
    }

    render() {
        let product=JSON.parse(localStorage.getItem("product_details"));
        console.warn(product);
        return (
            <div>
                <h2 className="text-center">Update Product</h2>
                <form>

                    <div className="form-group">
                        <label>Product Name:</label>
                        <input type="text" placeholder="productName" name="productName" className="form-control" defaultValue={this.state.productName}/>
                    </div>

                    <div className="form-group">
                        <label>Description:</label>
                        <input placeholder="description" name="description" className="form-control" value={this.state.description} onChange={this.onChange}/>
                    </div>

                    <div className="form-group">
                        <label>Price:</label>
                        <input type="number" placeholder="price" name="price" className="form-control" value={this.state.price} onChange={this.onChange}/>
                    </div>

                    <div className="form-group">
                        <label>Product State:</label>
                        <input placeholder="productState" name="productState" className="form-control" value={this.state.productState} onChange={this.onChange}/>
                    </div>

                    <div className="form-group">
                        <label>ImageURL:</label>
                        <input placeholder="imageurl" name="imageurl" className="form-control" value={this.state.imageurl} onChange={this.onChange}/>
                    </div>

                    <button className="btn btn-success" onClick={this.saveProduct}>Save</button>
                </form>
            </div>
        );
    }
}

export default ProductUpdate;