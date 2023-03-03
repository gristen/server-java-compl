package ru.biponline.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "author")
public class AuthorEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    private String name;
    private String lastname;
    private String surname;
    @JsonIgnore
    @OneToMany(cascade =  CascadeType.ALL,mappedBy = "author")
    private List<BookEntity> book;
}
