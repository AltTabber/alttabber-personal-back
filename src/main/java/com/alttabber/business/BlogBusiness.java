package com.alttabber.business;

import com.alttabber.business.exception.BlogNotFoundException;
import com.alttabber.data.BlogDto;
import com.alttabber.data.BlogType;
import com.alttabber.data.TextType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
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

    public BlogDto createBlog(BlogDto blog) throws BlogNotFoundException {
        if(blog.getId() != null){
            BlogDto oldBlog = blogsRepository.findById(blog.getId()).orElseThrow(BlogNotFoundException::new);
            blog.setId(oldBlog.getId());
            blog.setCreateDate(oldBlog.getCreateDate());

        }else{
            blog.setId(UUID.randomUUID().toString());
        }
        return blogsRepository.save(blog);
    }

    public List<BlogDto> getBlogsByDate(Date before, Date after) {
        return blogsRepository.findByDate(before, after);
    }

    public List<BlogDto> getAllBlogs() {
        return blogsRepository.findAll(Sort.by("createDate"));
    }

//    public List<BlogDto> getBlogsByType(){
//        List<BlogDto> blogs = blogsRepository.findBlogsByDate();
//
//        return blogs;
//    }

}
