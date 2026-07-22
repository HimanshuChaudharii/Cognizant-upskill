import React, { Component } from "react";

class Getuser extends Component {
  constructor(props) {
    super(props);

    this.state = {
      title: "",
      firstName: "",
      image: ""
    };
  }

  async componentDidMount() {
    const response = await fetch("https://api.randomuser.me/");
    const data = await response.json();

    const user = data.results[0];

    this.setState({
      title: user.name.title,
      firstName: user.name.first,
      image: user.picture.large
    });
  }

  render() {
    return (
      <div style={{ textAlign: "center", marginTop: "30px" }}>
        <h1>Random User Details</h1>

        <img
          src={this.state.image}
          alt="User"
          width="200"
          height="200"
        />

        <h2>
          {this.state.title} {this.state.firstName}
        </h2>
      </div>
    );
  }
}

export default Getuser;