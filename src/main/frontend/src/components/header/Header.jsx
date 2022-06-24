import React, {useState} from 'react';
import './Header.css';
import {Button, Container, Nav, Navbar} from 'react-bootstrap';
import LoginModal from '../modals/loginModal/LoginModal';
import RegistrationModal from '../modals/registrationModal/RegistrationModal';
import ErrorModal from '../modals/errorModals/ErrorModal';
import {availiablePages} from '../../types/index';

const Header = (props) => {
    const [loginModalOpen, setLoginModalOpen] = useState(false);
    const [registrationModalOpen, setRegistrationModalOpen] = useState(false);
    const [errorModalOpen, setErrorModalOpen] = useState(false);

    return (
        <div>
            <Navbar bg="dark" variant="dark">
                <Container fluid>
                    <Navbar.Brand
                        style={{ cursor: 'pointer' }}
                        onClick={() => props.setPage(availiablePages.travelHelper)}
                    >
                        Travel Helper
                    </Navbar.Brand>
                    <Navbar.Toggle aria-controls="navbarScroll" />
                    <Navbar.Collapse id="navbarScroll">
                        <Nav className="me-auto my-2 my-lg-0" style={{ maxHeight: '100px' }} navbarScroll>
                            <Button variant="outline-warning" onClick={() => props.setPage(availiablePages.myProfile)}>
                                My Profile
                            </Button>
                            <Button
                                variant="outline-warning"
                                onClick={() => props.setPage(availiablePages.forum)}
                                style={{ marginLeft: '5px' }}
                            >
                                Forum
                            </Button>
                            <Button
                                variant="outline-warning"
                                onClick={() => props.setPage(availiablePages.searchBox)}
                                style={{ marginLeft: '5px' }}
                            >
                                Search City
                            </Button>
                        </Nav>

                        {props.inSession === true ? (
                            <Button variant="outline-warning">Logout</Button>
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
                                    style={{ marginLeft: '5px' }}
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
            {loginModalOpen && <LoginModal open={loginModalOpen} />}
            {registrationModalOpen && <RegistrationModal open={registrationModalOpen} />}
            {errorModalOpen && <ErrorModal error={'tekst pomylki'} />}
        </div>
    );
};

export default Header;
