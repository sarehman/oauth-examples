import React from "react";
import { Link, useLocation } from "react-router-dom";
import user from "../images/user.png";

const StudentDetails = (props) => {
  const location = useLocation();

  const { test } = location.state;
  //const {id, name, email} = test;

  const student = JSON.parse(test);

  //const { id, name, email } = props.student;
  return (
    <div className="main">
      <div className="ui card centered">
        <div className="image">
          <img src={user} alt="user" />
        </div>
        <div className="content">
          <div className="header">{student.name}</div>
          <div className="description">{student.email}</div>
        </div>
      </div>
      <div className="ui card centered">
        <Link to="/">
          <button className="ui button blue center">
            Back to Student List
          </button>
        </Link>
      </div>
    </div>
  );
};

export default StudentDetails;
