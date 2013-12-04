package com.feedient.service;

import com.feedient.models.Post;
import com.feedient.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.HashMap;

/**
 * Created by xaviergeerinck on 21/11/13.
 */
@Component("BlogService")
public class BlogService implements IBlogService {
    private String name;
    private int counter;
    private HashMap<Integer, Post> map = new HashMap<Integer, Post>();

    @Autowired
    public BlogService(@Value("name") String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


    public int addBlogPost(User user, String omschrijving, String url) {
        synchronized (this) {
            this.counter++;
            Post post = new Post(this.counter, user, omschrijving, url);
            this.map.put(this.counter, post);
        }
        return this.counter;

    }

    public int addBlogPost(String username, String specialisatie, String jaar, String omschrijving, String url) {
        synchronized (this) {
            this.counter++;
            User user = new User(username, specialisatie, jaar);
            Post post = new Post(this.counter, user, omschrijving, url);
            this.map.put(this.counter, post);
        }
        return this.counter;

    }


    public HashMap<Integer, Post> getMap() {
        return map;
    }
}
