import React from "react";
import { Link } from "react-router-dom";
import { useStudentsCrud } from "../context/StudentCrudContext";

const StudentCard = (props) => {
  const student = props.student;

  console.log("from student card .. props.student: ");
  console.log(JSON.stringify(student));

  const { removeStudentHandler } = useStudentsCrud();

  const deleteStudent = (id) => {
    removeStudentHandler(id);
  };

  return (
    <tr key={student.id}>
      <td className="left aligned">{student.grNo}</td>
      <td className="left aligned">{student.name}</td>
      <td className="left aligned">{student.motherName}</td>
      <td className="left aligned">{student.dob}</td>
      <td className="left aligned">{student.standard}</td>
      <td className="center aligned">
        <Link to="/edit" state={{ student: student }}>
          <i
            className="edit alternate outline icon"
            style={{ color: "blue" }}
          ></i>
        </Link>
      </td>
      <td className="center aligned">
        <i
          className="trash alternate outline icon"
          style={{ color: "red" }}
          onClick={() => deleteStudent(student.id)}
        ></i>
      </td>
    </tr>
  );
};

export default StudentCard;
