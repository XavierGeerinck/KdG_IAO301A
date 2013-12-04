package com.feedient.service;

import com.feedient.models.Post;
import com.feedient.models.User;

import java.util.HashMap;

/**
 * Created by xaviergeerinck on 21/11/13.
 */
public interface IBlogService {
    public String getName();

    public int addBlogPost(User user, String omschrijving, String url);

    public int addBlogPost(String username, String specialisatie, String jaar, String omschrijving, String url);

    public HashMap<Integer, Post> getMap();
}
