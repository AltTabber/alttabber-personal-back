package com.alttabber.business;

import com.alttabber.business.exception.BlogNotFoundException;
import com.alttabber.data.BlogDto;
import com.alttabber.data.BlogType;
import com.alttabber.data.TextType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.alttabber.repository.BlogsRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class BlogBusiness {

    @Autowired
    BlogsRepository blogsRepository;


    public BlogDto getBlog(String id) throws BlogNotFoundException {
        Optional<BlogDto> blogOptional = blogsRepository.findById(id);
        return blogOptional.orElseThrow(BlogNotFoundException::new);
    }

    public BlogDto createBlog(){
        BlogDto blog = new BlogDto();
        blog.setId(UUID.randomUUID().toString());
        blog.setHeader("Проверка");
        blog.setBlogType(BlogType.ART);
        blog.setText("Ghjdthdfgsfdgf");
        blog.setTextType(TextType.TEXT);
        blog.setCreateDate(new Date());
        return blogsRepository.insert(blog);
    }

//    public List<BlogDto> getBlogsByType(){
//        List<BlogDto> blogs = blogsRepository.findBlogsByDate();
//
//        return blogs;
//    }

}
