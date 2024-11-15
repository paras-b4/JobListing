package com.paras.JobListing.PostRepository;

import com.paras.JobListing.Post.Post;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface SearchRepository {

    List<Post> findByText(String text);



}
