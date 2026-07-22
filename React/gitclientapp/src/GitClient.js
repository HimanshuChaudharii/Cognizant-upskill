import axios from "axios";

class GitClient {
  getRepositories(username) {
    return axios.get(`https://api.github.com/users/${username}/repos`);
  }
}

export default new GitClient();