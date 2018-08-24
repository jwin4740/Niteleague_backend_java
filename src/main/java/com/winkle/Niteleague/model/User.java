package com.winkle.Niteleague.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.ManyToAny;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.text.DateFormat;
import java.util.Date;
import java.util.Set;

/**
 * Created by rajeevkumarsingh on 27/06/17.
 */
@Entity
@Table(name = "users")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"},
        allowGetters = true)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_id;

    @NotBlank
    private String name;


    private String username;

    @Column(name = "DOB")
    private String DOB;

    @Column(name = "password")
    private String password;

    @Column(name = "email", nullable = false, unique = true)
    @Email(message = "Please provide a valid e-mail")
    @NotEmpty(message = "Please provide an e-mail")
    private String emailAddress;

    @Column(name = "avatar")
    private String avatar;

    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createdAt;

    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @UpdateTimestamp
    private Date updatedAt;
    private String twitter;

    private String facebook;

    private String epicGames;

    private String PSN;

    private String xbox;

    private String youtube;

    private String instagram;

    public User() {
    }

    public User(@NotBlank String name, @NotBlank String username, String DOB, String password, @Email(message = "Please provide a valid e-mail") @NotEmpty(message = "Please provide an e-mail") String emailAddress, String avatar, Date createdAt, Date updatedAt, String twitter, String facebook, String epicGames, String PSN, String xbox, String youtube, String instagram, String stream) {
        this.name = name;
        this.username = username;
        this.DOB = DOB;
        this.password = password;
        this.emailAddress = emailAddress;
        this.avatar = avatar;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.twitter = twitter;
        this.facebook = facebook;
        this.epicGames = epicGames;
        this.PSN = PSN;
        this.xbox = xbox;
        this.youtube = youtube;
        this.instagram = instagram;
        this.stream = stream;
    }

    public String getTwitter() {
        return twitter;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public String getEpicGames() {
        return epicGames;
    }

    public void setEpicGames(String epicGames) {
        this.epicGames = epicGames;
    }

    public String getPSN() {
        return PSN;
    }

    public void setPSN(String PSN) {
        this.PSN = PSN;
    }

    public String getXbox() {
        return xbox;
    }

    public void setXbox(String xbox) {
        this.xbox = xbox;
    }

    public String getYoutube() {
        return youtube;
    }

    public void setYoutube(String youtube) {
        this.youtube = youtube;
    }

    public String getInstagram() {
        return instagram;
    }

    public void setInstagram(String instagram) {
        this.instagram = instagram;
    }

    public String getStream() {
        return stream;
    }

    public void setStream(String stream) {
        this.stream = stream;
    }

    private String stream;


    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getPassword() {
        return password;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getAvatar() {
        return avatar;
    }

    public String getDOB() {
        return DOB;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public Long getId() {
        return user_id;
    }

    public void setId(Long user_id) {
        this.user_id = user_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

}