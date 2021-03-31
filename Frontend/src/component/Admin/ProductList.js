import React, { Component } from 'react'
import ProductService from "../../Service/ValidationService";
import './ProductList.css';
//import Img from '../assets/images/Mojri.jpg';



class ListProduct extends Component {

    constructor(props) {
        super(props)
        this.state = {
            products: [],
            message: null
        }
        this.deleteProduct = this.deleteProduct.bind(this);
        this.editProduct = this.editProduct.bind(this);
        this.addProduct = this.addProduct.bind(this);
        this.reloadProductList = this.reloadProductList.bind(this);
    }

    componentDidMount() {
         this.reloadProductList();
    }

    reloadProductList() {
        ProductService.fetchProducts()
            .then((res) => {
                this.setState({products: res.data.result})
                console.log(this.state.products);
            });
    }

    deleteProduct(productId) {
        ProductService.deleteProduct(productId)
           .then(res => {
               this.setState({message : 'Product deleted successfully.'});
               this.setState({products: this.state.products.filter(product => product.productId !== productId)});
           })

    }

    editProduct(id) {
        ProductService.editProduct(ProductService.fetchProductById(id))
            .then(res => {
                this.setState({product: res.data.result})
                console.log(this.state.product)
            });
        window.localStorage.setItem("productId", id);
        this.props.history.push('/supplier/edit-product');
    }

    addProduct() {
        window.localStorage.removeItem("productId");
        this.props.history.push('/supplier/add-product');
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
                                        
                                    </tr>
                            )
                        }
                    </tbody>
                </table>
            </div>
        );
    }

}

export default ListProduct;