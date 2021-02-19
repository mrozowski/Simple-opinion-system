package com.mrozowski.OpinionSystem.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "product")
public class Product {
    @Id
    private long id;

    @Column(name = "p_name")
    private  String name;

    @Column(name = "p_description")
    private  String description;

    @Column
    private  double avg_rating;

    public Product() {
    }

    public Product(@JsonProperty("id") long id,
                   @JsonProperty("name") String name,
                   @JsonProperty("description") String description,
                   @JsonProperty("score") double avg_rating)
    {
        this.id = id;
        this.name = name;
        this.avg_rating = avg_rating;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getAvg_rating() {
        return avg_rating;
    }

    public String getDescription() {
        return description;
    }
}
