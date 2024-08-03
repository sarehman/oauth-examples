import React, { useEffect } from "react";
import { Link } from "react-router-dom";
import StudentCard from "./StudentCard";
import ReactPaginate from "react-paginate";
import { useStudentsCrud } from "../context/StudentCrudContext";

const StudentList = (props) => {
  //const pageCount = props.pageCount;
  //const handlePageClick = props.handlePageClick;
  const searchTextRef = React.createRef();

  const {
    students,
    pageCount,
    handlePageClick,
    retrieveStudents,
    getAllStudents,
    searchHandler,
    searchText,
    searchResults,
  } = useStudentsCrud();
  console.log(students);

  useEffect(() => {
    getAllStudents();
  }, []);

  const renderStudentList = (searchText.length < 1 ? students : searchResults ).map((student) => {
    return <StudentCard student={student} key={student.id} />;
  });

  const onStudentSearch = (e) => {
    var searchText = searchTextRef.current.value;
    console.log(searchText);
    searchHandler(searchText);
  }

  return (
    <div className="main">
      <h2>
        Student List
        <Link to="/add">
          <button className="ui button blue right">Add Student</button>
        </Link>
      </h2>
      <div className="ui search">
        <div className="ui icon input">
          <input
            type="text"
            placeholder="Search Students"
            className="prompt"
            ref={searchTextRef}
            name="searchText"
          />
          <i className="search icon" />
          <button className="ui search button" onClick={ (e) => {onStudentSearch(e)}}>Search</button>
        </div>
      </div>
      <div>
        <table className="ui celled padded table">
          <thead>
            <tr>
              <th className="single line">Gr. No.</th>
              <th>Name</th>
              <th>Mother Name</th>
              <th>Date Of Birth</th>
              <th>Standard</th>
              <th>Edit</th>
              <th>Delete</th>
            </tr>
          </thead>
          <tbody>{renderStudentList}</tbody>
        </table>
      </div>
      <ReactPaginate
        previousLabel={"<<"}
        nextLabel={">>"}
        breakLabel={"..."}
        pageCount={pageCount}
        marginPagesDisplayed={2}
        pageRangeDisplayed={3}
        onPageChange={handlePageClick}
        containerClassName={"ui pagination menu"}
        pageClassName={"pageItem item"}
        pageLinkClassName={"pageItem item"}
        previousClassName={"prevItem item"}
        previousLinkClassName={"prevItem item"}
        nextClassName={"nextItem item"}
        nextLinkClassName={"nextItem item"}
        breakClassName={"ellipsisItem item"}
        breakLinkClassName={"ellipsisItem item"}
        activeClassName={"active item"}
      />
    </div>
  );
};

export default StudentList;
