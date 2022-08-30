## **About App**

This is a **RESTful** Web application written for travelers.

Accio Vacaccio offers services as:
- representing informations about chosen city in real time (API were chosen as a solution);
- forum, which gives ability to as for some help or find info about another user's experience;
- adding to followings and having chat with app users;
- storing photos in cloud (**AWS S3 bucket**);
- storing some useful for travellers datas (**AWS RDS**).


## **Technical characteristics - backend**

The application is based on **Java** language on **Spring** framework in **Spring Boot** tool.

As RDBMS was chosen **AWS RDS** with **PostgreSQL** engine.

As ORM solution was chosen **Hibernate** library.

Implemented user authentication and authorization using **Spring security** module and **JWT token**.

As an alternative for user, implemented integration with **Google Sign-in API**.

App uses **API**s for rendering data gotten in real time for user request:

- https://weatherapi-com.p.rapidapi.com/current.json; // weather (1 000 000 requests / month)
- https://newscatcher.p.rapidapi.com/v1/search_free; // last news (21 requests / hour)
- https://cost-of-living-and-prices.p.rapidapi.com/prices; // living costs (1 000 requests / day)
- https://world-airports-directory.p.rapidapi.com/v1/airports/; // airports info (unlimited)
- https://airport-info.p.rapidapi.com/airport; // second airports info (unlimited)
- https://api.travelpayouts.com/data/en/cities.json; // third airports info (unlimited)
- https://best-booking-com-hotel.p.rapidapi.com/booking/best-accommodation; // booking (10 requests / day)
- https://ranked-crime-cities.p.rapidapi.com/Kc4Qth/ranked_crime_cities; // crime rating (unlimited)
- https://trueway-places.p.rapidapi.com/FindPlacesNearby; // atractive places (500 requests / month)
- https://bing-image-search1.p.rapidapi.com/images/search; // images from Bing  (1 000 requests / month)
- https://google-maps-autocomplete-plus.p.rapidapi.com/autocomplete; // google coordinates API (1 000 000 requests / month)
- https://emergencynumberapi.com/api/country/; // emergency numbers (unlimited)
- https://v6.exchangerate-api.com/v6/; // exchange currency (unlimited)
- https://recaptchaenterprise.googleapis.com/$discovery/rest?version=v1; // Google reCAPTCHA (unlimited)

Implemented **Forum**, where users can find needed info for travelers about cities or ask about help.

Implemented **Chat** also, where users can text to each other.

User has access to features as:
 - making own self notes;
 - saving places user want to visit;
 - storing photos in cloud (implemented using **AWS S3**).
 
 
 ## **Technical characteristics - frontend**
 
As a frontend solution was chosen **React** library based on **JavaScript** language.

As a CSS framework was chosen **React Bootstrap** solution.


## **How to run App**

1. In case appeared message about enable **Lombok** (in IDE), please, do it.
2. Open the terminal (cmd) window in src/main/frontend root.
3. Provide: 
 - ```npm i react```;
 - ``` npm start```.


## **In case something went wrong, see here ...**

In any case, please, mail as to *shcherbak.tet@gmail.com* about problem appired.

1. You tried to run an App and appered Error "Cannot configure hibernate EntityManager configuration" =>

   We can fix it! The couse it apeared is AWS accout expired and we should restore it.
2. You chose a city and some info didn't render and in console appered message with "HTTP code 429" => 

   It means, that given amount of requests already used.
   There a two possible couses: 
    - Expired amount of requests per day for some API;
    - Expired amount of requests at all for some API and we will be needed to change an account.
