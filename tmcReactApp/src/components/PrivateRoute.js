import React from "react";
import { Navigate } from "react-router-dom";

// const PrivateRoute = ({ component: Component, authenticated, ...rest }) => (
//   <Route
//     {...rest}
//     render={props =>
//       authenticated ? (
//         <Component {...rest} {...props} />
//       ) : (
//         <Navigate
//           to={{
//             pathname: "/login",
//             state: { from: props.location }
//           }}
//         />
//       )
//     }
//   />
// );

const PrivateRoute = ({children}, authenticated, props ) => {
  console.log(authenticated);
  console.log(props);
  return authenticated ? children : <Navigate
             to={{
               pathname: "/login",
               state: { from: props.location }
             }}
           />;
}

export default PrivateRoute;