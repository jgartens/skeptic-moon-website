package com.tts.skepticmoon.repository;

import com.tts.skepticmoon.models.BlogPost;

import org.springframework.data.repository.CrudRepository;

public interface BlogPostRepository extends CrudRepository<BlogPost, Long>{
    
}
