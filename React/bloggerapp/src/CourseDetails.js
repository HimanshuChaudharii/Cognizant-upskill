import React from "react";

function CourseDetails() {
  const courses = [
    { id: 1, name: "React", duration: "2 Months" },
    { id: 2, name: "Java Full Stack", duration: "4 Months" },
    { id: 3, name: "Python", duration: "3 Months" }
  ];

  return (
    <div>
      <h2>Course Details</h2>

      <ul>
        {courses.map((course) => (
          <li key={course.id}>
            {course.name} - {course.duration}
          </li>
        ))}
      </ul>
    </div>
  );
}

export default CourseDetails;