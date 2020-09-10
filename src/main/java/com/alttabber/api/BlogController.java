package com.alttabber.api;

import com.alttabber.business.BlogBusiness;
import com.alttabber.business.exception.BlogNotFoundException;
import com.alttabber.data.BlogDto;
import com.alttabber.data.BlogType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class BlogController {

    @Autowired
    private BlogBusiness blogBusiness;

    @GetMapping("/blog/{id}")
    public BlogDto getBlogById(@PathVariable String id) throws BlogNotFoundException {
        BlogDto blog = blogBusiness.getBlog(id);

        return blog;
    }

    @GetMapping("/admin/blog/create")
    public BlogDto createBlog(){
        return blogBusiness.createBlog();
    }

    @PostMapping("/admin/blog/create")
    public BlogDto createBlog(@RequestBody BlogDto blog) throws BlogNotFoundException {
        return blogBusiness.createBlog(blog);
    }

    @GetMapping("/blog/list")
    public List<BlogDto> getBlogsList(@RequestParam(name = "dateBetween", required = false)
                                          @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) Date dateBetween,
                                      @RequestParam(name = "dateAfter", required = false)
                                        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) Date dateAfter,
                                      @RequestParam(name = "blogType", required = false) String blogType) {
        List<BlogDto> blogs;
        if(dateBetween != null && dateAfter != null){
            blogs = blogBusiness.getBlogsByDate(dateBetween, dateAfter);
        }else if(blogType != null){
            blogs = blogBusiness.getBlogsByBlogType(BlogType.valueOf(blogType));
        }else{
            blogs = blogBusiness.getAllBlogs();
        }

        return blogs;
    }

}
