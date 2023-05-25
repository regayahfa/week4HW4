package com.example.week4hw34.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message = "title not be Empty")
    @Column(columnDefinition ="varchar(20) not null")
    private String title;
    @NotEmpty(message = "title not be Empty")
    @Column(columnDefinition = "check(category='health' or category='education' or category='programming'")
    private String category;
    @NotEmpty(message = "title not be Empty")
    @Column(columnDefinition ="varchar(300) not null")
    private String body;
    @NotEmpty(message = "title not be Empty")
    @Column(columnDefinition = " 'false'")
    private boolean isPublished;
}
