import React, { Component } from "react";
import GitClient from "./GitClient";

class App extends Component {
  constructor(props) {
    super(props);

    this.state = {
      repos: []
    };
  }

  componentDidMount() {
    GitClient.getRepositories("techiesyed")
      .then((response) => {
        this.setState({
          repos: response.data
        });
      })
      .catch((error) => {
        console.log(error);
      });
  }

  render() {
    return (
      <div style={{ textAlign: "center" }}>
        <h1>Git repositories of User - TechieSyed</h1>

        {this.state.repos.map((repo) => (
          <p key={repo.id}>{repo.name}</p>
        ))}
      </div>
    );
  }
}

export default App;
