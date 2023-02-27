package ru.biponline.demo.entity;

import lombok.*;
import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Table (name = "boks")
public class BookEntity {
    @Column (name = "book_id")
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String author;
    private String publishing;
    private int year;
    private String kind;
}
