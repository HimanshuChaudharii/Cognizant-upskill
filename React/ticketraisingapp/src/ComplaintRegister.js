import React, { useState } from "react";

function ComplaintRegister() {
  const [employeeName, setEmployeeName] = useState("");
  const [complaint, setComplaint] = useState("");

  const handleSubmit = (event) => {
    event.preventDefault();

    const referenceNo = Math.floor(Math.random() * 100000);

    alert(
      `Thanks ${employeeName}!\nYour complaint has been submitted successfully.\nReference Number: ${referenceNo}`
    );

    setEmployeeName("");
    setComplaint("");
  };

  return (
    <div style={{ margin: "30px" }}>
      <h2>Complaint Register</h2>

      <form onSubmit={handleSubmit}>
        <div>
          <label>Employee Name :</label>
          <br />
          <input
            type="text"
            value={employeeName}
            onChange={(e) => setEmployeeName(e.target.value)}
            required
          />
        </div>

        <br />

        <div>
          <label>Complaint :</label>
          <br />
          <textarea
            rows="5"
            cols="40"
            value={complaint}
            onChange={(e) => setComplaint(e.target.value)}
            required
          ></textarea>
        </div>

        <br />

        <button type="submit">Submit Complaint</button>
      </form>
    </div>
  );
}

export default ComplaintRegister;