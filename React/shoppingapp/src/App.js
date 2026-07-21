import React, { Component } from "react";
import Cart from "./Cart";

class OnlineShopping extends Component {
  constructor(props) {
    super(props);

    this.items = [
      { itemname: "Laptop", price: 55000 },
      { itemname: "Mobile", price: 25000 },
      { itemname: "Headphones", price: 3000 },
      { itemname: "Keyboard", price: 1500 },
      { itemname: "Mouse", price: 800 }
    ];
  }

  render() {
    return (
      <div style={{ padding: "20px" }}>
        <h1>Online Shopping Cart</h1>

        <table border="1" cellPadding="10">
          <thead>
            <tr>
              <th>Item Name</th>
              <th>Price</th>
            </tr>
          </thead>

          <tbody>
            {this.items.map((item, index) => (
              <Cart
                key={index}
                itemname={item.itemname}
                price={item.price}
              />
            ))}
          </tbody>
        </table>
      </div>
    );
  }
}

export default OnlineShopping;