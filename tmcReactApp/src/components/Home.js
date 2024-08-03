import React, { useEffect, useState } from "react";
import {  Routes, Route } from "react-router-dom";
import "./App.css";
import Header from "./Header";
import AddStudent from "./AddStudent";
import EditStudent from "./EditStudent";
import StudentList from "./StudentList";
import StudentDetails from "./StudentDetails";
import { StudentsCrudContextProvider } from "../context/StudentCrudContext";


function Home() {
   


  return (
    <div className="ui container">
      
        <Header />
        <StudentsCrudContextProvider >
        <Routes>
          <Route path="/" element=
            {<StudentList  />} />
          <Route path='/add' element={<AddStudent />} />
          <Route path="/edit"  element={<EditStudent  />} />
          <Route path="/students/:id" element={<StudentDetails />} />
        </Routes>
        </StudentsCrudContextProvider>
    </div>
  );
}

export default Home;
