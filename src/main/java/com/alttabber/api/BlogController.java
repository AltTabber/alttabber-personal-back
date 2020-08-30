package com.alttabber.api;

import com.alttabber.business.BlogBusiness;
import com.alttabber.business.exception.BlogNotFoundException;
import com.alttabber.data.BlogDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BlogController {

    @Autowired
    private BlogBusiness blogBusiness;

    @GetMapping("/blog/{id}")
    public BlogDto getBlogById(@PathVariable String id) throws BlogNotFoundException {
        BlogDto blog = blogBusiness.getBlog(id);

        return blog;
    }

    @GetMapping("/blog")
    public BlogDto createBlog(){
        return blogBusiness.createBlog();
    }

}
