import "./LoginModal.css";
import {Button, Modal, Form} from "react-bootstrap";
import axios from "axios";
import React, {useState} from "react";
import ErrorModal from "../errorModals/ErrorModal";
import ReCAPTCHA from "react-google-recaptcha";
import GoogleSignIn from "./Google.SignIn";


const LoginModal = (props) => {
    const [disabledBtn, setDisabledBtn] = useState(false)

    const [email, setEmail] = useState("")
    const [password, setPassword] = useState("")

    const [showLoginModal, setShowLoginModal] = useState(true);
    const handleCloseLoginModal = () =>{
        setToPropsModalClose();
        setShowLoginModal(false);
    } ;
    const [errorModalOpen, setErrorModalOpen] = useState(false);
    const [errorText, setErrorText]= useState("");


    function showErrorModal(data){
        setErrorText(data);
        setErrorModalOpen(true);
    }

    const sendDataToServer = () => {
            const url = "http://localhost:8080/login";
            axios.post(url,{
                email: email,
                password: password,
            })
                .then(res=>{
                    if (res.data ===""){
                        fetchUserId();
                    }else {
                        showErrorModal(res.data);
                    }
                })
    }

    const setToPropsModalClose = () => {
        props.close(false)
    }

    const fetchUserId = () => {
        axios.get("http://localhost:8080/login")
            .then(res=> {
                if (res.data !== ""){
                    localStorage.setItem('userId', res.data)
                    sessionStorage.setItem("userId", res.data)
                    window.location.reload();
                }
            })
        .catch(err => {console.log(err)});
    }

    return (
        <Modal show={showLoginModal} onHide={handleCloseLoginModal} style={{background: "rgba(0, 0, 0, 0.6)", color: "orange"}}>
            <Modal.Header closeButton style={{background: "rgb(40,40,40)"}}>
                <Modal.Title>Log In</Modal.Title>
            </Modal.Header>
            <Modal.Body style={{background: "rgb(20,20,20)"}}>
                <div style={{display: "block", textAlign: "center", justifyContent: "center"}}>
                <GoogleSignIn/>
                <h5 style={{margin: 10}}>Or type manually:</h5>
                </div>
                <Form style={{background: "rgb(20,20,20)"}}>
                    <Form.Group className="mb-3" controlId="exampleForm.ControlInput1">
                        <Form.Label style={{color: "orange"}}>Email address</Form.Label>
                        <Form.Control
                            value={email}
                            onChange={e=> setEmail(e.target.value)}
                            type="email"
                            placeholder="name@example.com"
                            autoFocus
                        />
                    </Form.Group>
                    <Form.Group
                        className="mb-3"
                        controlId="exampleForm.ControlTextarea1"
                    >
                        <Form.Label style={{color: "orange"}}>Password</Form.Label>
                        <Form.Control
                            value={password}
                            onChange={e=> setPassword(e.target.value)}
                            type="password"
                            placeholder="*******"/>
                    </Form.Group>
                </Form>
            </Modal.Body>
            <Modal.Footer  style={{background: "rgb(40,40,40)"}} >
                {/*<ReCAPTCHA*/}
                {/*    size="normal"*/}
                {/*    sitekey={process.env.REACT_APP_RECAPTCHA_API_KEY}*/}
                {/*    onChange={() => setDisabledBtn(false)}*/}
                {/*/>*/}
                <Button variant="outline-secondary" onClick={handleCloseLoginModal}>
                    Close
                </Button>
                <Button disabled={disabledBtn} variant="outline-warning" onClick={sendDataToServer}>
                    Login
                </Button>
            </Modal.Footer>
            {errorModalOpen && <ErrorModal errorText={errorText} visible={errorModalOpen} close={setErrorModalOpen}/>}
        </Modal>
    );
};

export default LoginModal;