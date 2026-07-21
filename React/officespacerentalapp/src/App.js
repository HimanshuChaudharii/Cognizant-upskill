import React from "react";

function App() {
  const offices = [
    {
      id: 1,
      name: "Tech Park Office",
      rent: 55000,
      address: "Bangalore",
      image:
        "https://images.unsplash.com/photo-1497366754035-f200968a6e72?w=800"
    },
    {
      id: 2,
      name: "Business Hub",
      rent: 75000,
      address: "Hyderabad",
      image:
        "https://images.unsplash.com/photo-1497366412874-3415097a27e7?w=800"
    },
    {
      id: 3,
      name: "Corporate Tower",
      rent: 90000,
      address: "Pune",
      image:
        "https://images.unsplash.com/photo-1524758631624-e2822e304c36?w=800"
    }
  ];

  return (
    <div style={{ margin: "20px", fontFamily: "Arial" }}>
      <h1>Office Space Rental Application</h1>

      {offices.map((office) => (
        <div
          key={office.id}
          style={{
            border: "1px solid gray",
            borderRadius: "10px",
            padding: "15px",
            marginBottom: "20px",
            width: "400px"
          }}
        >
          <img
            src={office.image}
            alt={office.name}
            width="350"
            height="200"
          />

          <h2>{office.name}</h2>

          <p>
            <b>Address:</b> {office.address}
          </p>

          <p>
            <b>Rent:</b>{" "}
            <span
              style={{
                color: office.rent < 60000 ? "red" : "green",
                fontWeight: "bold"
              }}
            >
              ₹{office.rent}
            </span>
          </p>
        </div>
      ))}
    </div>
  );
}

export default App;