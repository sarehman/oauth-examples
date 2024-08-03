import React, { Component } from "react";
import "./Login.css";
import { GOOGLE_AUTH_URL } from ".";
import { useLocation, useNavigate } from "react-router-dom";
import googleLogo from "../images/google-logo.png";
import { toast } from "react-toastify";

//import Alert from "react-s-alert";
const Login = () => {
  let location = useLocation();
  let navigate = useNavigate();

  console.log(location);
  console.log(location.state);

  if(location.state && location.state.error){
    setTimeout(() => {
      toast.error(location.state.error, {
        autoClose: true,
        position: toast.POSITION.TOP_RIGHT
      });
      navigate({to: location.pathname, 
        replace: true,
        state: []
      });

    }, 100);
  }

  

  const SampleLogin = () => {
    return (
      <div className="social-login">
        <a className="btn btn-block social-btn google" href={GOOGLE_AUTH_URL}>
          <img src={googleLogo} alt="Google" /> Log in with Google
        </a>
      </div>
    );
  };

  return (
    <div className="login-container">
      <div className="login-content">
        <h1 className="login-title">Login</h1>
        <SampleLogin />
      </div>
    </div>
  );
};

export default Login;