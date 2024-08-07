import React, { Component } from "react";
import { ACCESS_TOKEN } from ".";
import { Navigate, useLocation } from "react-router-dom";

const OAuth2RedirectHandler = () => {
  let location = useLocation();

  const getUrlParameter = (name) => {
    name = name.replace(/[\[]/, "\\[").replace(/[\]]/, "\\]");
    var regex = new RegExp("[\\?&]" + name + "=([^&#]*)");

    var results = regex.exec(location.search);
    return results === null
      ? ""
      : decodeURIComponent(results[1].replace(/\+/g, " "));
  };

  const token = getUrlParameter("token");
  const error = getUrlParameter("error");

  if (token) {
    localStorage.setItem(ACCESS_TOKEN, token);
    return (
      <Navigate
        to={{
          pathname: "/profile",
          state: { from: location },
        }}
      />
    );
  }
  return (
    <Navigate
      to={{
        pathname: "/login",
        state: {
          from: location,
          error: error,
        },
      }}
    />
  );
};

export default OAuth2RedirectHandler;
