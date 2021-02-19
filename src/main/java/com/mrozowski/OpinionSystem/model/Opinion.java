package com.mrozowski.OpinionSystem.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "opinion")
public class Opinion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "product_id")
    private long product_id;
    @Column
    private String author;
    @Column(name = "opinion")
    private String content;
    @Column(name = "rating")
    private double score;

    public Opinion() {
    }

    public Opinion(@JsonProperty("id") long id,
                   @JsonProperty("product_id") long product_id,
                   @JsonProperty("author") String author,
                   @JsonProperty("content") String content,
                   @JsonProperty("score") double score)
    {
        this.id = id;
        this.product_id = product_id;
        this.author = author;
        this.content = content;
        this.score = score;
    }

    public long getId() {
        return id;
    }

    public String getAuthor() {
        return author;
    }

    public String getContent() {
        return content;
    }

    public double getScore() {
        return score;
    }

    public long getProductId() {
        return product_id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
