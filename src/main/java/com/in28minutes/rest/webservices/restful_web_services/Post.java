package com.in28minutes.rest.webservices.restful_web_services;

import com.in28minutes.rest.webservices.restful_web_services.user.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import net.minidev.json.annotate.JsonIgnore;

@Entity
public class Post {

    @Id
    @GeneratedValue
    private Integer id;

    @Size(min = 10)
    private String description;
    @ManyToOne(fetch = FetchType.LAZY) // FetchType.LAZY : 엔티티를 처음 조회할 때는 연관된 엔티티를 가져오지 않고, 해당 필드에 접근하는 순간에야 쿼리를 실행해 로딩
    @JsonIgnore
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
