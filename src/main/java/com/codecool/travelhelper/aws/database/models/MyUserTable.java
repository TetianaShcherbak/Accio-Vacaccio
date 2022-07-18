package com.codecool.travelhelper.aws.database.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "MyUserTable")
@Getter
@ToString
@NoArgsConstructor
public class MyUserTable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    private String fullName;
    private String nickName;
    private String birthday;
    private String userEMail;
    private String password;
    private String avatar;
    private String instagram;
    private String facebook;
    private String aboutMe;
    private String role;
    private boolean privateAccount;


//----------------------------------------------------------------------

    // comments to user
    @OneToMany(mappedBy = "myUserTable")
    private List<CommentsTable> comments;

//---------------------------------------------------

    // post to user
    @OneToMany(mappedBy = "myUserTable")
    private List<PostTable> posts;

//---------------------------------------------------

    //note to user
    @OneToOne(mappedBy = "myUserTable")
    private NoteTable noteTable;

//---------------------------------------------------

    // albums to user
    @OneToMany(mappedBy = "myUserTable")
    List<AlbumFromTripsTable> albumsFromTripsTable;

//---------------------------------------------------

    // placesWantToGo to user
    @OneToMany(mappedBy = "myUserTable")
    List<PlacesWantToGoTable> placesWantToGoTable;

//---------------------------------------------------

    // visitedPlaces to user
    @OneToMany(mappedBy = "myUserTable")
    List<VisitedPlaceTable> visitedPlacesTable;

//---------------------------------------------------

    // trips to user
    @OneToMany(mappedBy = "myUserTable")
    List<TripTable> tripsTable;

//---------------------------------------------------
    // answers to user
    @ManyToMany(mappedBy = "usersList")
    @JsonIgnore
    List<SurveyAnswersTable> chosenAnswers = new ArrayList<>();


//---------------------------------------------------

    public MyUserTable(String fullName, String nickName, String birthday, String userEMail, String password) {
        this.fullName = fullName;
        this.nickName = nickName;
        this.birthday = birthday;
        this.userEMail = userEMail;
        this.password = password;
        this.avatar = "";
        this.instagram = "";
        this.facebook = "";
        this.aboutMe = "";
        this.privateAccount = false;
        this.role = "User";
    }
}
