import axios from 'axios';

const USER_API_BASE_URL = 'http://localhost:8080/product';

class ValidationService {

    fetchProducts() {
        return axios.get(USER_API_BASE_URL);
    }

    fetchProductById(productId) {
        return axios.get(USER_API_BASE_URL + '/' + productId);
    }

    fetchProductByState(productState) {
        return axios.get(USER_API_BASE_URL + '/state/' + productState);
    }

    deleteProduct(productId) {
        return axios.delete(USER_API_BASE_URL + '/' + productId);
    }

    addProduct(product) {
        return axios.post(""+USER_API_BASE_URL, product);
    }

    editProduct(product) {
        return axios.put(USER_API_BASE_URL + '/' + product.productId, product);
    }

}

export default new ValidationService();