import React, { Component } from "react";
import "./Profile.css";


const Profile = (props) => {
  console.log(props.currentUser.name);
  
  return (
    <div>
      <p>{props.currentUser.name}</p>
      <p>{props.currentUser.imageUrl}</p>
      <p>{props.currentUser.name}</p>
    </div>
  );
}

export default Profile;