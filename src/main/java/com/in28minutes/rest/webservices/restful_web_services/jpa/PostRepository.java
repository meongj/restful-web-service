package com.in28minutes.rest.webservices.restful_web_services.jpa;

import com.in28minutes.rest.webservices.restful_web_services.Post;
import com.in28minutes.rest.webservices.restful_web_services.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Integer> {

}
