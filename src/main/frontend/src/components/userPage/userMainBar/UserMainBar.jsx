import React from 'react';
import InformationAboutUser from "./userMainBarComponents/informationAboutUser/InformationAboutUser";
import CountryCounter from "./userMainBarComponents/countryCounter/CountryCounter";
import {Card} from "react-bootstrap";
import "./UserMainBar.css"
import TravelerSurvey from "./userMainBarComponents/travelerSurvey/TravelerSurvey";

const UserMainBar = () => {
    return (
        <Card
            bg={"dark"}
            key={"dark"}
            text={'white'}
            className="mb-2 bg-opacity"
        >
            <Card.Body>
                <Card.Text>
                    <InformationAboutUser/>
                    <CountryCounter/>
                    <TravelerSurvey />
                </Card.Text>
            </Card.Body>
        </Card>
    );
};

export default UserMainBar;