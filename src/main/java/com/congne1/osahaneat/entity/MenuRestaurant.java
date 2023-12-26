package com.congne1.osahaneat.entity;

import com.congne1.osahaneat.entity.keys.keyMenuRestaurant;
import jakarta.persistence.*;

import java.util.Date;

@Entity(name = "menu_restaurant")
public class MenuRestaurant {
    @EmbeddedId
    keyMenuRestaurant keys;


    @ManyToOne
    @JoinColumn(name = "cate_id",insertable = false,updatable = false)
    private Category category;
    @ManyToOne
    @JoinColumn(name = "res_id",insertable = false,updatable = false)
    private Restaurant restaurant;

    @Column(name = "create_date")
    private Date createDate;

    public keyMenuRestaurant getKeys() {
        return keys;
    }

    public void setKeys(keyMenuRestaurant keys) {
        this.keys = keys;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
