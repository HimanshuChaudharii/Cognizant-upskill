import React, { useState } from "react";

function Register() {
  const [form, setForm] = useState({
    name: "",
    email: "",
    password: "",
  });

  const [errors, setErrors] = useState({});

  const handleChange = (event) => {
    const { name, value } = event.target;

    setForm({
      ...form,
      [name]: value,
    });
  };

  const validate = () => {
    let error = {};

    if (form.name.length < 5) {
      error.name = "Name must contain at least 5 characters.";
    }

    if (!(form.email.includes("@") && form.email.includes("."))) {
      error.email = "Enter a valid email address.";
    }

    if (form.password.length < 8) {
      error.password = "Password must contain at least 8 characters.";
    }

    setErrors(error);

    return Object.keys(error).length === 0;
  };

  const handleSubmit = (event) => {
    event.preventDefault();

    if (validate()) {
      alert("Registration Successful!");
    }
  };

  return (
    <div style={{ width: "400px", margin: "30px auto" }}>
      <h2>Mail Registration Form</h2>

      <form onSubmit={handleSubmit}>

        <label>Name</label><br />
        <input
          type="text"
          name="name"
          value={form.name}
          onChange={handleChange}
        />
        <br />
        <span style={{ color: "red" }}>{errors.name}</span>

        <br /><br />

        <label>Email</label><br />
        <input
          type="text"
          name="email"
          value={form.email}
          onChange={handleChange}
        />
        <br />
        <span style={{ color: "red" }}>{errors.email}</span>

        <br /><br />

        <label>Password</label><br />
        <input
          type="password"
          name="password"
          value={form.password}
          onChange={handleChange}
        />
        <br />
        <span style={{ color: "red" }}>{errors.password}</span>

        <br /><br />

        <button type="submit">
          Register
        </button>

      </form>
    </div>
  );
}

export default Register;