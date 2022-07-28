import './App.css';
import React, {useState} from 'react';
import Header from './components/header/Header';
import 'bootstrap/dist/css/bootstrap.min.css';
import {Outlet} from "react-router-dom";

import { LoginContext } from "./Context";

function App() {
    const [loggedIn, setLoggedIn] = useState(false);
    return (

            <LoginContext.Provider  value={{loggedIn, setLoggedIn}}>
                <div style={{ textAlign: 'center' }}>
                <Header />
                <Outlet />
                </div>
            </LoginContext.Provider>


    );
}
export default App;
