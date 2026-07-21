import React, { Component } from "react";

class Cart extends Component {
  render() {
    return (
      <tr>
        <td>{this.props.itemname}</td>
        <td>₹{this.props.price}</td>
      </tr>
    );
  }
}

export default Cart;