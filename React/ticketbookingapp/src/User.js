import React from "react";

function User() {
  return (
    <div>
      <h2>Welcome User</h2>

      <h3>Ticket Booking</h3>

      <table border="1" cellPadding="10">
        <thead>
          <tr>
            <th>Flight</th>
            <th>From</th>
            <th>To</th>
            <th>Fare</th>
            <th>Action</th>
          </tr>
        </thead>

        <tbody>
          <tr>
            <td>AI101</td>
            <td>Delhi</td>
            <td>Mumbai</td>
            <td>₹5500</td>
            <td>
              <button>Book Now</button>
            </td>
          </tr>

          <tr>
            <td>AI202</td>
            <td>Chennai</td>
            <td>Bangalore</td>
            <td>₹3500</td>
            <td>
              <button>Book Now</button>
            </td>
          </tr>

          <tr>
            <td>AI303</td>
            <td>Kolkata</td>
            <td>Hyderabad</td>
            <td>₹4500</td>
            <td>
              <button>Book Now</button>
            </td>
          </tr>
        </tbody>
      </table>
    </div>
  );
}

export default User;