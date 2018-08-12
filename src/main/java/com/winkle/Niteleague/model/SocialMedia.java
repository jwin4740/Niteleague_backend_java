package com.winkle.Niteleague.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Entity
@Table(name = "SocialMedia")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"},
        allowGetters = true)
public class SocialMedia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "username")
    private User user;

    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @UpdateTimestamp
    private Date updatedAt;

    //type will be either user, team, or league
    @NotBlank
    private String type;

    private String twitter;

    private String facebook;

    private String epicGames;

    private String PSN;

    private String xbox;

    private String youtube;

    private String instagram;

    private String stream;

    public SocialMedia() {
    }

    public SocialMedia(User user, Date updatedAt, @NotBlank String type, String twitter, String facebook, String epicGames, String PSN, String xbox, String youtube, String instagram, String stream) {
        this.user = user;
        this.updatedAt = updatedAt;
        this.type = type;
        this.twitter = twitter;
        this.facebook = facebook;
        this.epicGames = epicGames;
        this.PSN = PSN;
        this.xbox = xbox;
        this.youtube = youtube;
        this.instagram = instagram;
        this.stream = stream;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
}

