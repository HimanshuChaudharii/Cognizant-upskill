import React from "react";

function Guest() {
  return (
    <div>
      <h2>Welcome Guest</h2>

      <h3>Flight Details</h3>

      <table border="1" cellPadding="10">
        <thead>
          <tr>
            <th>Flight</th>
            <th>From</th>
            <th>To</th>
            <th>Fare</th>
          </tr>
        </thead>

        <tbody>
          <tr>
            <td>AI101</td>
            <td>Delhi</td>
            <td>Mumbai</td>
            <td>₹5500</td>
          </tr>

          <tr>
            <td>AI202</td>
            <td>Chennai</td>
            <td>Bangalore</td>
            <td>₹3500</td>
          </tr>

          <tr>
            <td>AI303</td>
            <td>Kolkata</td>
            <td>Hyderabad</td>
            <td>₹4500</td>
          </tr>
        </tbody>
      </table>

      <p><b>Please Login to Book Tickets.</b></p>
    </div>
  );
}

export default Guest;