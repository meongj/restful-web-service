package com.in28minutes.rest.webservices.restful_web_services.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.in28minutes.rest.webservices.restful_web_services.Post;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.util.List;


@Entity(name = "user_details")
public class User {

    @Id
    @GeneratedValue
    private Integer id;
    @Size(min = 2, message = "name should hava at leadt 2 characters")
//    @JsonProperty("user_name")
    private String name;
    @Past(message = "Birth date should be in the past")
//    @JsonProperty("birth_date")
    private LocalDate birthDate;
    @OneToMany(mappedBy = "user") // 유저 1명당 여러개의 post 맺음
    @JsonIgnore
    private List<Post> posts;

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public User(Integer id, String name, LocalDate birthDate) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
    }

    protected User() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
