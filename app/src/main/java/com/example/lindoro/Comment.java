package com.example.lindoro;

import com.google.gson.annotations.SerializedName;

public class Comment {

    private int postId;
    private int id;
    private String name;
    private String email;

    @SerializedName("body")
    private String text;


    public int getPostId() {
        return postId;
    }
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getEmail() {
        return email;
    }
    public String getText() {
        return text;
    }

//    public void setPostId(int postId) {
//        this.postId = postId;
//    }
//
//
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//
//
//    public void setEmail(String email) {
//        this.email = email;
//    }

}
