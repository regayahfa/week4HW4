package com.example.week4hw34.Repostry;

import com.example.week4hw34.Model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogRepostry extends JpaRepository<Blog,Integer>{
    Blog getBlogById(Integer id);

    @Query("SELECT  S FROM Blog S WHERE S.id=?1")
    Blog pleaseGetById(Integer id);

    List<Blog> findBlogByTitle(String title);

    List<Blog> findBlogByCategory(String catogry);
    @Query("SELECT T FROM Blog T WHERE T.isPublished=TRUE ")
Blog getBlogByIsPublished(Boolean ispublished);
}

