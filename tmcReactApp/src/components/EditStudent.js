import React, {useState} from "react";
import { useNavigate, useLocation } from "react-router-dom";
import { useStudentsCrud } from "../context/StudentCrudContext";

const EditStudent = () => {
  const location = useLocation();
  const navigate = useNavigate();
  const student = location.state.student;
  console.log(student);
  const { updateStudentHandler } = useStudentsCrud();
  
  
  const newStudent = {
    id: "",
    grNo: "",
    name: "",
    motherName: "",
    uid: "",
    nationality: "",
    motherTongue: "",
    religion: "",
    caste: "",
    subCaste: "",
    birthPlace: "",
    taluka: "",
    district: "",
    state: "",
    country: "",
    dob: "",
    dob_letters: "",
    previousSchool: "",
    standard: "",
    dateAdmission: "",
    studyProgress: "",
    dateOfLeaving: "",
    standardAtLeaving: "",
    reasonOfLeaving: "",
  };
  const [state, setState] = useState(student);

  const edit = (e) => {
    e.preventDefault();
    if (state.name === "" || state.grNo === "") {
      alert("All the fields are mandatory!");
      return;
    }

    updateStudentHandler(state);
    setState(newStudent);
      
    navigate("/");
    //props.history.push("/");
  };
  
    return (
      <div className="ui main">
        <h4 className="ui dividing header">Student Information</h4>

        <form className="ui form" onSubmit={edit}>
          <div className="field">
            <label>Name</label>
            <div className="fields">
              <div className="eight wide field">
                <input
                  type="text"
                  name="name"
                  placeholder="Name"
                  value={state.name}
                  onChange={(e) => setState({...state,...state, name: e.target.value })}
                />
              </div>
              <div className="eight wide field">
                <input
                  type="text"
                  name="motherName"
                  placeholder="Mother Name"
                  value={state.motherName}
                  onChange={(e) => setState({...state, motherName: e.target.value })}
                />
              </div>
            </div>
          </div>
          <div className="field">
            <label>Unique Identifiers</label>
            <div className="fields">
              <div className="four wide field">
                <input
                  type="text"
                  name="grNo"
                  placeholder="GR No"
                  value={state.grNo}
                  onChange={(e) => setState({...state, grNo: e.target.value })}
                />
              </div>
              <div className="four wide field">
                <input
                  type="text"
                  name="uid"
                  placeholder="UID / Aadhar Card No"
                  value={state.uid}
                  onChange={(e) => setState({...state, uid: e.target.value })}
                />
              </div>

              <div className="four wide field">
                <input
                  type="text"
                  name="nationality"
                  placeholder="Nationality"
                  value={state.nationality}
                  onChange={(e) => setState({...state, nationality: e.target.value })}
                />
              </div>
              <div className="four wide field">
                <input
                  type="text"
                  name="motherTongue"
                  placeholder="motherTongue"
                  value={state.motherTongue}
                  onChange={(e) => setState({...state, motherTongue: e.target.value })}
                />
              </div>
            </div>
          </div>

          <div className="field">
            <label>Religion Details</label>
            <div className="fields">
              <div className="six wide field">
                <input
                  type="text"
                  name="religion"
                  placeholder="Religion"
                  value={state.religion}
                  onChange={(e) => setState({...state, religion: e.target.value })}
                />
              </div>
              <div className="six wide field">
                <input
                  type="text"
                  name="caste"
                  placeholder="Caste"
                  value={state.caste}
                  onChange={(e) => setState({...state, caste: e.target.value })}
                />
              </div>
              <div className="four wide field">
                <input
                  type="text"
                  name="subcast"
                  placeholder="Sub Caste"
                  value={state.subCaste}
                  onChange={(e) => setState({...state, subCaste: e.target.value })}
                />
              </div>
            </div>
          </div>
          <div className="field">
            <label>Birth Details</label>
            <div className="fields">
              <div className="six wide field">
                <input
                  type="text"
                  name="birthPlace"
                  placeholder="Birth Place"
                  value={state.birthPlace}
                  onChange={(e) => setState({...state, birthPlace: e.target.value })}
                />
              </div>
              <div className="four wide field">
                <input
                  type="text"
                  name="dob"
                  placeholder="Date of Birth (DD/MM/YYYY)"
                  value={state.dob}
                  onChange={(e) => setState({...state, dob: e.target.value })}
                />
              </div>
              <div className="six wide field">
                <input
                  type="text"
                  name="dob_letters"
                  placeholder="Date of Birth (In Letters)"
                  value={state.dob_letters}
                  onChange={(e) => setState({...state, dob_letters: e.target.value })}
                />
              </div>
            </div>
          </div>
          <div className="field">
            <label>Address Details</label>
            <div className="fields">
              <div className="four wide field">
                <input
                  type="text"
                  name="taluka"
                  placeholder="Taluka"
                  value={state.taluka}
                  onChange={(e) => setState({...state, taluka: e.target.value })}
                />
              </div>
              <div className="four wide field">
                <input
                  type="text"
                  name="district"
                  placeholder="District"
                  value={state.district}
                  onChange={(e) => setState({...state, district: e.target.value })}
                />
              </div>
              <div className="four wide field">
                <input
                  type="text"
                  name="state"
                  placeholder="State"
                  value={state.state}
                  onChange={(e) => setState({...state, state: e.target.value })}
                />
              </div>
              <div className="four wide field">
                <input
                  type="text"
                  name="country"
                  placeholder="Country"
                  value={state.country}
                  onChange={(e) => setState({...state, country: e.target.value })}
                />
              </div>
            </div>
          </div>
          <div className="field">
            <label>Class Details</label>
            <div className="fields">
              <div className="four wide field">
                <input
                  type="text"
                  name="standard"
                  placeholder="Standard"
                  value={state.standard}
                  onChange={(e) => setState({...state, standard: e.target.value })}
                />
              </div>
              <div className="four wide field">
                <input
                  type="text"
                  name="dateAdmission"
                  placeholder="Date Of Admission"
                  value={state.dateAdmission}
                  onChange={(e) => setState({...state, dateAdmission: e.target.value })}
                />
              </div>

              <div className="eight wide field">
                <input
                  type="text"
                  name="studyProgress"
                  placeholder="Study Progress"
                  value={state.studyProgress}
                  onChange={(e) => setState({...state, studyProgress: e.target.value })}
                />
              </div>
            </div>
          </div>
          <div className="field">
            <label>Previous School</label>
            <div className="sixteen wide field">
              <input
                type="text"
                name="previousSchool"
                placeholder="Previous School"
                value={state.previousSchool}
                onChange={(e) => setState({...state, previousSchool: e.target.value })}
              />
            </div>
          </div>
          <div className="field">
            <label>Previous School Details</label>
            <div className="fields">
              <div className="four wide field">
                <input
                  type="text"
                  name="dateOfLeaving"
                  placeholder="Date Of Leaving"
                  value={state.dateOfLeaving}
                  onChange={(e) => setState({...state, dateOfLeaving: e.target.value })}
                />
              </div>
              <div className="four wide field">
                <input
                  type="text"
                  name="standardAtLeaving"
                  placeholder="Standard At Leaving"
                  value={state.standardAtLeaving}
                  onChange={(e) => setState({...state, standardAtLeaving: e.target.value })}
                />
              </div>
              <div className="eight wide field">
                <input
                  type="text"
                  name="reasonOfLeaving"
                  placeholder="Reason Of Leaving"
                  value={state.reasonOfLeaving}
                  onChange={(e) => setState({...state, reasonOfLeaving: e.target.value })}
                />
              </div>
            </div>
          </div>
          <button className="ui button blue" tabIndex={0}>
            Edit
          </button>
        </form>
      </div>
    );
  }


export default EditStudent;
