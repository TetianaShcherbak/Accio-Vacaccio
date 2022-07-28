import React, {useContext} from 'react';
import UserLeftBar from "./userLeftBar/UserLeftBar";
import UserMainBar from "./userMainBar/UserMainBar";
import MustBeLogIn from "../mustBeLogIn/MustBeLogIn";
import {LoginContext} from "../../Context";

const UserPage = () => {
    const {loggedIn, setLoggedIn} = useContext(LoginContext)
    const jo = () => {
        setLoggedIn(true);
        console.log(loggedIn)
    }


    if (sessionStorage.getItem("userId") === null){
        return <MustBeLogIn/>;
    } else {
        return (
            <div>
                <div>
                    {loggedIn ? <h1>Jesteś zalogowany</h1> : <h1>Wcale nie jesteś in</h1>}
                </div>
                <button onClick={jo}>Login zią</button>
                <UserLeftBar/>
                <UserMainBar/>
            </div>
        );
    }

};

export default UserPage;