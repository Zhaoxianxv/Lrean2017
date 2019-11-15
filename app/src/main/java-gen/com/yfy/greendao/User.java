package com.yfy.greendao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 
/**
 * Entity mapped to table "USER".
 */
public class User {

    private Long id;
    /** Not-null value. */
    private String name;
    /** Not-null value. */
    private String type;
    /** Not-null value. */
    private String pass;

    public User() {
    }

    public User(Long id) {
        this.id = id;
    }

    public User(Long id, String name, String type, String pass) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.pass = pass;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /** Not-null value. */
    public String getName() {
        return name;
    }

    /** Not-null value; ensure this value is available before it is saved to the database. */
    public void setName(String name) {
        this.name = name;
    }

    /** Not-null value. */
    public String getType() {
        return type;
    }

    /** Not-null value; ensure this value is available before it is saved to the database. */
    public void setType(String type) {
        this.type = type;
    }

    /** Not-null value. */
    public String getPass() {
        return pass;
    }

    /** Not-null value; ensure this value is available before it is saved to the database. */
    public void setPass(String pass) {
        this.pass = pass;
    }

}