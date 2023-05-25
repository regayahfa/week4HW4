package com.example.week4hw34.controller;

import com.example.week4hw34.Model.Blog;
import com.example.week4hw34.servies.BlogServies;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/api/v1/Blog")
@RestController
public class BlogController {
    private final BlogServies blogServies;

    @GetMapping("/get")
    public ResponseEntity getAllBlog(){
        List<Blog>blogList=blogServies.getAllBlog();
        return ResponseEntity.status(200).body("blogs");
    }
    @PostMapping("/add")
    public ResponseEntity addblog(@Valid @RequestBody Blog blog){
        blogServies.addBlog(blog);
        return ResponseEntity.status(200).body("blog added");
    }
    @PostMapping("/update")
public ResponseEntity<String> updateBlog(@Valid @RequestBody Blog blog , @PathVariable Integer id){
       boolean isupdate=blogServies.updateBlog(blog, id);
       return ResponseEntity.status(200).body("Saccess");
}
@PostMapping("/DELETE")
    public ResponseEntity<String> deleteBlog(@PathVariable Integer id) {
        Blog coffee =blogServies.deleteCoffee(id);
        return ResponseEntity.status(200).body("can't deleted sorry..");
    }
    @GetMapping("/get-title")
public ResponseEntity getByTitle(String title){
        List<Blog>blogList=blogServies.getBlogByTitle(title);
        return ResponseEntity.status(200).body(title);
}
    @GetMapping("/GET-id")
    public ResponseEntity getById(@PathVariable Integer id){
        Blog blog=blogServies.getBlogById(id);
        return ResponseEntity.status(200).body(blog);
    }
    @GetMapping("/get-catgory")
    public ResponseEntity getByCatogry( String Catogry){
        List<Blog> blogList=blogServies.getBlogByCatogry(Catogry);
        return ResponseEntity.status(200).body(Catogry);
    }


}
