package com.tts.skepticmoon.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@Entity
public class BlogPost {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty
    private String title;

    @NotEmpty
    private String author;

    @NotEmpty
    private String blogEntry;

    public BlogPost() {
    }

    public BlogPost(@NotEmpty String title, @NotEmpty String author, @NotEmpty String blogEntry) {
        this.title = title;
        this.author = author;
        this.blogEntry = blogEntry;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getBlogEntry() {
        return blogEntry;
    }

    public void setBlogEntry(String blogEntry) {
        this.blogEntry = blogEntry;
    }

    @Override
    public String toString() {
        return "BlogPost [author=" + author + ", blogEntry=" + blogEntry + ", id=" + id + ", title=" + title + "]";
    }

    
}
