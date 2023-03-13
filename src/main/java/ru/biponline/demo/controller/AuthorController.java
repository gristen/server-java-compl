package ru.biponline.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.biponline.demo.entity.AuthorEntity;
import ru.biponline.demo.response.AuthorListResponse;
import ru.biponline.demo.response.BaseResponse;
import ru.biponline.demo.service.AuthorService;
import ru.biponline.demo.service.PublisherService;
@RestController
@RequestMapping("api/v1/author")
public class AuthorController {
    private final AuthorService service;
    public AuthorController(AuthorService service) {this.service = service;}

    @PostMapping("/add")
    public ResponseEntity<BaseResponse> add(@RequestBody AuthorEntity data){
        try {


            service.save(data);
            return ResponseEntity.ok(new BaseResponse(true,"автор добавлен"));
        } catch (Exception e){
            return ResponseEntity. badRequest().body(new BaseResponse(false,e.getMessage()));
        }
    }

    @GetMapping("/all")
    public ResponseEntity<BaseResponse> getAll(){return ResponseEntity.ok(new AuthorListResponse(service.getAll())); }





}