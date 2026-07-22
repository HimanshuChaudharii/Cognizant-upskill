import React from "react";
import BookDetails from "./BookDetails";
import BlogDetails from "./BlogDetails";
import CourseDetails from "./CourseDetails";

function App() {

  const showBooks = true;
  const showBlogs = true;
  const showCourses = true;

  return (
    <div style={{ padding: "20px" }}>
      <h1>Blogger Application</h1>

      {/* Method 1 : if condition using element variable */}
      {showBooks ? <BookDetails /> : null}

      {/* Method 2 : Logical AND */}
      {showBlogs && <BlogDetails />}

      {/* Method 3 : Ternary Operator */}
      {showCourses ? <CourseDetails /> : <h3>No Courses Available</h3>}
    </div>
  );
}

export default App;