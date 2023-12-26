package com.congne1.osahaneat.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Date;
import java.util.Set;

@Entity(name = "users")

public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "password")
    private String password;
    @Column(name = "fullname")
    private String fullName;
    @Column(name = "create_date")
    private Date createDate;
    @ManyToOne
    @JoinColumn(name = "role_id")
    private Roles roles;

    @OneToMany(mappedBy = "users")
    private Set<RatingFood> ListRatingFood;


    @OneToMany(mappedBy = "users")
    private Set<RatingRestaurant> lisRatingRestaurant;


    @OneToMany(mappedBy = "users")
    private Set<Orders> lisOrder;

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

    public Set<RatingFood> getListRatingFood() {
        return ListRatingFood;
    }

    public void setListRatingFood(Set<RatingFood> listRatingFood) {
        ListRatingFood = listRatingFood;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Roles getRoles() {
        return roles;
    }

    public void setRoles(Roles roles) {
        this.roles = roles;
    }
}
