import React, { Component } from 'react'
import ProductService from "../../Service/ValidationService";
//import Img from '../assets/images/Mojri.jpg';
import './ListOfProduct.css'

class ListOfProduct extends Component {

    constructor(props) {
        super(props)
        this.state = {
            products: [],
            message: null
        }
        this.reloadProductList = this.reloadProductList.bind(this);
    }

    addToCart()
    {
        
    }
    componentDidMount() {
        this.reloadProductList();
    }

    reloadProductList() {
        let product=localStorage.getItem("productState");
        console.warn(product);
        ProductService.fetchProductByState(window.localStorage.getItem("productState"))
            .then((res) => {
                this.setState({products: res.data.result})
                console.log(this.state.products);
            });
    }
    
    render() {
        return (
            <div>
                <h2 className="text-center">Product Details</h2>
                
                <table className="table table-striped">
                    <thead>
                        <tr>
                            <th >Id</th>
                            <th>ProductName</th>
                            <th>Description</th>
                            <th>Price</th>
                            <th>ProductState</th>
                            <th>ImageURL</th>
                        </tr>
                    </thead>
                    <tbody>
                        {
                            this.state.products.map(
                        product =>
                                    <tr key={product.productId}>
                                        <td>{product.productId}</td>
                                        <td>{product.productName}</td>
                                        <td>{product.description}</td>
                                        <td>{product.price}</td>
                                        <td>{product.productState}</td>
                                        <td><img src={'/images/' + product.productName + '.jpg'} className="d-block w-40 product-image " alt="image" height="250px" width="150px" /></td>
                                        <td>
                                            <button className="btn btn-info" onClick={() => this.addToCart(product.productId)}> Add to Cart</button>
                                        </td>
                                    </tr>
                            )
                        }
                    </tbody>
                </table>
            </div>
        );
    }
}

export default ListOfProduct;