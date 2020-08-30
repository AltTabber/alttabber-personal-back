package api;

import data.Blog;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BlogController {

    public List<Blog> getBlogsForDate(){
        List<Blog> list = new ArrayList<>();

        return list;
    }

}
