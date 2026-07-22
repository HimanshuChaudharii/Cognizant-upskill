import React from "react";

function BookDetails() {
  const books = [
    { id: 1, name: "React Basics", author: "Jordan Walke", price: 450 },
    { id: 2, name: "Java Programming", author: "James Gosling", price: 600 },
    { id: 3, name: "Python", author: "Guido van Rossum", price: 500 }
  ];

  return (
    <div>
      <h2>Book Details</h2>

      <ul>
        {books.map((book) => (
          <li key={book.id}>
            {book.name} | {book.author} | ₹{book.price}
          </li>
        ))}
      </ul>
    </div>
  );
}

export default BookDetails;