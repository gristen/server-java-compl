package ru.biponline.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class PublisherEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long publisher_id;
    private String publisher;
}
