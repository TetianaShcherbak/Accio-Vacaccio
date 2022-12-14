import React from 'react';
import ImageBingSearch from "../imagesAsApiResponse/ImageBingSearch";
import location from "../../../images/location.png"

const TouristSingleAttractionCard = (props) => {

    const locationName = props.attractions.locationName;
    const locationAddress = props.attractions.locationAddress;
    const distanceToLocation = props.attractions.distanceToLocation;
    const website = props.attractions.website;

    return (
        <div className="wrapper">
            <div className="blog_post">
                <div className="img_pod">
                    <img src={location} alt="random image"
                    style={{maxWidth: "60px", maxHeight:"60px"}}/>
                </div>
                <div className="minus-margin" style={{width: "49%", flex: "50%"}}>
                    <h2>{locationName}</h2>
                    <br/><div>Address: <em>{locationAddress}</em></div>
                    <br/><div>Only in <strong>{distanceToLocation}</strong> meters from center</div>
                </div>
                <ImageBingSearch key={props.index} attractions={props.attractions} website={{website}}/>
            </div>
        </div>
    );
};

export default TouristSingleAttractionCard;