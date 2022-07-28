import React, {useContext, useState} from 'react';
import './Header.css';
import {Button, Container, Nav, Navbar} from 'react-bootstrap';
import LoginModal from '../modals/loginModal/LoginModal';
import RegistrationModal from '../modals/registrationModal/RegistrationModal';
import axios from "axios";
import {Link} from "react-router-dom";
import { LoginContext } from "../../Context";

const Header = () => {
    const [loginModalOpen, setLoginModalOpen] = useState(false);
    const [registrationModalOpen, setRegistrationModalOpen] = useState(false);

    const {loggedIn, setLoggedIn} = useContext(LoginContext)

    const sendLogoutRequest = () => {
        const url = "http://localhost:8080/logout";
        axios.post(url,{})
            .then(res=>{
                console.log(res);
        axios.post(url, {})
            .then(()=> {
                deletionOfSessions()
            })
    })}

    const deletionOfSessions =()=>{
        localStorage.removeItem("userId")
        sessionStorage.removeItem("userId")
        window.location.reload();
    }




    return (
        <div id="top" >
            <Navbar bg="dark" variant="dark">
                <Container fluid>
                    <Link style={{textDecoration: "none"}} to="/">
                    <Navbar.Brand
                        style={{ cursor: 'pointer' }}
                    >
                        Travel Helper
                    </Navbar.Brand>
                    </Link>
                    <Navbar.Toggle aria-controls="navbarScroll"/>
                    <Navbar.Collapse id="navbarScroll">
                        <Nav className="me-auto my-2 my-lg-0" style={{ maxHeight: '100px' }} navbarScroll>
                            <Link to="/userpage">
                                <Button
                                    variant="outline-warning"
                                    style={{marginLeft: '5px'}}
                                >
                                    My Profile
                                </Button>
                            </Link>
                            <Link to="/forum">
                                <Button
                                    variant="outline-warning"
                                    style={{marginLeft: '5px'}}
                                >
                                    Forum
                                </Button>
                            </Link>
                            <Link to="/SearchBox">
                                <Button
                                    variant="outline-warning"
                                    style={{marginLeft: '5px'}}
                                >
                                    Search City
                                </Button>
                            </Link>
                        </Nav>

                        {sessionStorage.getItem("userId") !== null ? (
                            <Link to="/"><Button onClick={sendLogoutRequest} variant="outline-warning">Logout</Button></Link>
                        ) : (
                            <span>
								<Button
                                    variant="outline-warning"
                                    onClick={() => {
                                        setLoginModalOpen(true);
                                    }}
                                >
									Log In
								</Button>
								<Button
                                    variant="outline-warning"
                                    style={{marginLeft: '5px'}}
                                    onClick={() => {
                                        setRegistrationModalOpen(true);
                                    }}
                                >
									Registration
								</Button>
							</span>
                        )}
                    </Navbar.Collapse>
                </Container>
            </Navbar>
            {loginModalOpen && <LoginModal close={setLoginModalOpen}/>}
            {registrationModalOpen && <RegistrationModal close={setRegistrationModalOpen}/>}
        </div>
    );
};
export default Header;
