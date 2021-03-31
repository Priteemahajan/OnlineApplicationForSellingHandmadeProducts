import axios from "axios";

const API_URL = "http://localhost:8080";

class AuthService {
  login(loginRequest) {
    return axios.post(API_URL + "/auth/login", loginRequest)
  }

  logout() {
    localStorage.removeItem("user");
  }

  registerUser(user) {
    return axios.post(API_URL + "/auth/register", user);
  }

  fetchUserByRole(role) {
    return axios.get(API_URL + '/admin/role/' + role);
  }
}

export default new AuthService();
