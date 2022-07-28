import './App.css';
import React, {useState} from 'react';
import Header from './components/header/Header';
import 'bootstrap/dist/css/bootstrap.min.css';
import {Outlet} from "react-router-dom";

import { LoginContext } from "./Context";

function App() {
    const [loggedIn, setLoggedIn] = useState(false);
    return (
        //style={{ textAlign: 'center' }}
        <LoginContext.Provider  value={{loggedIn, setLoggedIn}}>
            <Header />
            <Outlet />
        </LoginContext.Provider>
    );
}
export default App;
