import React from "react";

function BlogDetails() {
  const blogs = [
    { id: 1, title: "React Hooks", author: "John" },
    { id: 2, title: "JavaScript ES6", author: "David" },
    { id: 3, title: "Node JS", author: "Alex" }
  ];

  return (
    <div>
      <h2>Blog Details</h2>

      <ul>
        {blogs.map((blog) => (
          <li key={blog.id}>
            {blog.title} - {blog.author}
          </li>
        ))}
      </ul>
    </div>
  );
}

export default BlogDetails;