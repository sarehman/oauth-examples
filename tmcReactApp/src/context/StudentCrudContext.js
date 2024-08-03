import { createContext, useContext, useState } from "react";
import api from "../api/students";
import { ACCESS_TOKEN } from "../components/index";
//import { uuid } from "uuidv4";

const studentsCrudContext = createContext();

export function StudentsCrudContextProvider({children}) {
    const [students, setStudents] = useState([]);
    const [student, setStudent] = useState([]);
    const [text, setText] = useState("");
    const [searchResults, setSearchResults] = useState([]);
    const [pageCount, setpageCount] = useState(0);
    const [currentPage, setCurrentPage] = useState(0);
    const [searchText, setSearchText] = useState('');
    let limit = 10;

    //RetrieveStudents
    const retrieveStudents = async () => {
        const response = await api.get(`/students/get?page=1&size=${limit}&searchText=`);
        return response.data;
    };

  const searchStudents = async (searchText, currentPage) => {
    const response = await api.get(`/students/get?page=${currentPage}&size=${limit}&searchText=${searchText}`);
    return response.data;
  };

  const handlePageClick = async (data) => {
    console.log(data.selected);

    let currentPage = data.selected + 1;
    setCurrentPage(currentPage);

    const studentFromServer = await searchStudents('', currentPage);
    
    setStudents(studentFromServer.content);
    setpageCount(studentFromServer.totalPages);
    // scroll to the top
    //window.scrollTo(0, 0)
  };

  const getAllStudents = async () => {
    const data = await retrieveStudents();
    if(data.content) setStudents(data.content);
    setpageCount(data.totalPages);
  };

  const addStudentHandler = async (student) => {
    const request = student;
    console.log("in add student Handler "+request);
    const token = localStorage.getItem(ACCESS_TOKEN);

    const response = await api.post("/students/"
                     ,{ headers: {"Authorization" : `Bearer ${token}`} }
                      , request);
    console.log(response.data);
    setStudents([...students, response.data]);
  };

  const removeStudentHandler = async (id) => {
    await api.delete(`/students/${id}`);
    const newStudentList = students.filter((student) => {
      return student.id !== id;
    });

    setStudents(newStudentList);
  };

  

  const updateStudentHandler = async (student) => {
    const response = await api.put(`/students/${student.id}`, student);
    console.log(response);
    const { id } = response.data;
    setStudents(
      students.map((student) => {
        return student.id === id ? { ...response.data.content } : student;
      })
    );
  };

  const searchHandler = async (searchTerm) => {
    setSearchText(searchTerm);
    if (searchTerm !== "" ) {
       
      const data = await searchStudents(searchTerm, currentPage+1 );
      console.log('searchResults...');
      console.log(data);
      setSearchResults(data.content);
      setpageCount(data.totalPages);
    }else {
      setSearchResults(students);
    }
  };

  const value = {
    student,
    students,
    pageCount,
    limit,
    searchText,
    getAllStudents,
    handlePageClick,
    retrieveStudents,
    addStudentHandler,
    removeStudentHandler,
    updateStudentHandler,
    searchHandler,
    text,
    searchResults
  }

    return (
        <studentsCrudContext.Provider value={ value }>
            {children}
        </studentsCrudContext.Provider>
    )
}

export function useStudentsCrud() {
    return useContext(studentsCrudContext)
}