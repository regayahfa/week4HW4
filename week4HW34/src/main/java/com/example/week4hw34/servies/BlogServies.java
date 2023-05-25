package com.example.week4hw34.servies;

import com.example.week4hw34.ApiException.ApiExcption;
import com.example.week4hw34.Model.Blog;
import com.example.week4hw34.Repostry.BlogRepostry;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BlogServies {
    private final BlogRepostry blogRepostry;

    public List<Blog> getAllBlog() {
        return blogRepostry.findAll();
    }

    public void addBlog(Blog blog) {
        blogRepostry.save(blog);
    }

    public Boolean updateBlog(Blog blog, Integer id) {
        Blog oldBlog = blogRepostry.getBlogById(id);
        if (oldBlog == null) {
            throw new ApiExcption("not fuond");
        }
        oldBlog.setTitle(blog.getTitle());
        oldBlog.setBody(blog.getBody());
        blogRepostry.save(oldBlog);
        return true;
    }

    public Blog deleteCoffee(Integer id) {
        Blog oldBlog = blogRepostry.getBlogById(id);
        if (oldBlog == null) {
            throw new ApiExcption("NOT fuond");
        }
        return oldBlog;
    }

    public Blog getBlogById(Integer id) {
        Blog blog = blogRepostry.pleaseGetById(id);
        if (blog == null) {
            throw new ApiExcption("not found");
        }
        return blog;

    }

    public List<Blog> getBlogByTitle(String title) {
        List<Blog> blog = blogRepostry.findBlogByTitle(title);
        if (blog == null) {
            throw new ApiExcption("not found");
        }
        return blog;
    }

    public List<Blog> getBlogByCatogry(String catogry) {
        List<Blog> blogList = blogRepostry.findBlogByCategory(catogry);
        if (catogry == null) {
            throw new ApiExcption("come later");
        }
        return blogList;
    }
    public Blog getBlogByIsPublishes(boolean ispublishes){
        Blog blog=blogRepostry.getBlogByIsPublished(ispublishes);
        if (ispublishes==true){
            throw new ApiExcption("try");
        }
        return getBlogByIsPublishes(ispublishes);
    }
}