package com.tts.skepticmoon.repository;

import java.util.List;

import com.tts.skepticmoon.models.BlogPost;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogPostRepository extends CrudRepository<BlogPost, Long>{
}
