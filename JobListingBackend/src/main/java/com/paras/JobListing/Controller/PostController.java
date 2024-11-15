package com.paras.JobListing.Controller;

import com.paras.JobListing.Post.Post;
import com.paras.JobListing.PostRepository.PostRepository;
import com.paras.JobListing.PostRepository.SearchRepository;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
//import springfox.documentation.annotations.ApiIgnore;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class PostController {

    @Autowired
    private PostRepository repo;

    @Autowired
    private SearchRepository srepo;
   // @ApiIgnore
    @RequestMapping(value = "/")
    public void redirect(HttpServletResponse response) throws IOException {
        response.sendRedirect("/swagger-ui/index.html"); // Updated redirect path
    }

    @GetMapping("/allPosts")
    @CrossOrigin
    public List<Post> getallpost()
    {
        return repo.findAll();

    }

    @GetMapping("/posts/{text}")
    @CrossOrigin
    public List<Post> search(@PathVariable String text)
    {
        return srepo.findByText(text);
    }

    @PostMapping("/post")
    public Post addpost(@RequestBody Post post)
    {
        return repo.save(post);
    }






}
