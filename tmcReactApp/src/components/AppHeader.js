import React, { Component } from "react";
import { Link, NavLink } from "react-router-dom";
import "./AppHeader.css";

const AppHeader = (props) => {
    
    return (
      <header className="app-header">
        <div className="container">
          <div className="app-branding">
            <Link to="/" >
              React Login
            </Link>
          </div>
          <div className="app-options">
            <nav className="app-nav">
              {props.authenticated ? (
                <ul>
                  <li>
                    <button onClick={props.onLogout}>Logout</button>
                  </li>
                </ul>
              ) : (
                <ul>
                  <li>
                    <Link to="/login" >Login</Link>
                  </li>
                </ul>
              )}
            </nav>
          </div>
        </div>
      </header>
    );
  }


export default AppHeader;
