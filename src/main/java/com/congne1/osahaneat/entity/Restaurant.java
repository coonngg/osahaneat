package com.congne1.osahaneat.entity;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Set;

@Entity(name = "restaurant")
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "title")
    private String title;
    @Column(name = "subtitle")
    private String subtitle;
    @Column(name = "description")
    private String desc;
    @Column(name = "image")
    private String image;
    @Column(name = "is_freedhip")
    private boolean isFreeship;
    @Column(name = "address")
    private String address;
    @Column(name = "open_date")
    private Date openDate;


    @OneToMany(mappedBy = "restaurant")
    private Set<RatingRestaurant> lisRatingRestaurant;
    @OneToMany(mappedBy = "restaurant")
    private Set<Orders> lisOrder;
    @OneToMany(mappedBy = "restaurant")
    private Set<MenuRestaurant> lisMenuRestaurant;

    @OneToMany(mappedBy = "restaurant")
    private Set<Promo> lisPromo;

    public Set<Promo> getLisPromo() {
        return lisPromo;
    }

    public void setLisPromo(Set<Promo> lisPromo) {
        this.lisPromo = lisPromo;
    }

    public Set<MenuRestaurant> getLisMenuRestaurant() {
        return lisMenuRestaurant;
    }

    public void setLisMenuRestaurant(Set<MenuRestaurant> lisMenuRestaurant) {
        this.lisMenuRestaurant = lisMenuRestaurant;
    }

    public Set<Orders> getLisOrder() {
        return lisOrder;
    }

    public void setLisOrder(Set<Orders> lisOrder) {
        this.lisOrder = lisOrder;
    }

    public Set<RatingRestaurant> getLisRatingRestaurant() {
        return lisRatingRestaurant;
    }

    public void setLisRatingRestaurant(Set<RatingRestaurant> lisRatingRestaurant) {
        this.lisRatingRestaurant = lisRatingRestaurant;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public boolean isFreeship() {
        return isFreeship;
    }

    public void setFreeship(boolean freeship) {
        isFreeship = freeship;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getOpenDate() {
        return openDate;
    }

    public void setOpenDate(Date openDate) {
        this.openDate = openDate;
    }
}
