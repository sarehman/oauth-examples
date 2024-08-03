import React, { Component } from "react";
import {  Route, Routes } from "react-router-dom";
import AppHeader from "./AppHeader";
import Home from "./Home";
import Login from "./Login";
import Profile from "./Profile";
import OAuth2RedirectHandler from "./OAuth2RedirectHandler";
import NotFound from "./NotFound";
import LoadingIndicator from "./LoadingIndicator";
import { getCurrentUser } from "./APIUtils";
import { ACCESS_TOKEN } from ".";
import PrivateRoute from "./PrivateRoute";
//import Alert from "react-s-alert";
// import "react-s-alert/dist/s-alert-default.css";
// import "react-s-alert/dist/s-alert-css-effects/slide.css";
import "./App.css";

class App extends Component {
  constructor(props) {
    super(props);
    this.state = {
      authenticated: false,
      currentUser: null,
      loading: false,
    };

    this.loadCurrentlyLoggedInUser = this.loadCurrentlyLoggedInUser.bind(this);
    this.handleLogout = this.handleLogout.bind(this);
  }

  loadCurrentlyLoggedInUser() {
    this.setState({
      loading: true,
    });

    getCurrentUser()
      .then((response) => {
        console.log(response);
        this.setState({
          currentUser: response,
          authenticated: true,
          loading: false,
        });
      })
      .catch((error) => {
        this.setState({
          loading: false,
        });
      });
  }

  handleLogout() {
    localStorage.removeItem(ACCESS_TOKEN);
    this.setState({
      authenticated: false,
      currentUser: null,
    });
    //Alert.success("You're safely logged out!");
  }

  componentDidMount() {
    this.loadCurrentlyLoggedInUser();
  }

  render() {
    if (this.state.loading) {
      return <LoadingIndicator />;
    }
    console.log(this.state.authenticated);
    return (
      <div className="app">
        <div className="app-top-box">
          <AppHeader
            authenticated={this.state.authenticated}
            onLogout={this.handleLogout}
          />
        </div>
        <div className="app-body">
       
          <Routes>
            <Route path="/*" element={<Home />}></Route>

            <Route
              path="/profile"
              element={
                <PrivateRoute
                  authenticated={this.state.authenticated}
                  currentUser={this.state.currentUser}
                />
              }
            />

            <Route
              path="/login"
              element={<Login authenticated={this.state.authenticated} />}
            />

            <Route
              path="/oauth2/redirect"
              element={<OAuth2RedirectHandler />}
            ></Route>
            <Route element={NotFound}></Route>
          </Routes>
        </div>
        {/* <Alert stack={{ limit: 3 }} timeout={3000} position="top-right" effect="slide" offset={65} /> */}
      </div>
    );
  }
}

export default App;
