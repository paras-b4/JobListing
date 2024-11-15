package com.paras.JobListing.Post;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Arrays;

@Document(collection = "Joblisting")
public class Post {

    private String profile;
    private String desc;
    private String techs[];
    private int exp;

    public Post() {
    }

    public Post(String profile, String[] techs, String desc, int exp) {
        this.profile = profile;
        this.techs = techs;
        this.desc = desc;
        this.exp = exp;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String[] getTechs() {
        return techs;
    }

    public void setTechs(String[] techs) {
        this.techs = techs;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    @Override
    public String toString() {
        return "Post{" +
                "profile='" + profile + '\'' +
                ", desc='" + desc + '\'' +
                ", techs=" + Arrays.toString(techs) +
                ", exp=" + exp +
                '}';
    }
}