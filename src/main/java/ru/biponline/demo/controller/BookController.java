package ru.biponline.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.biponline.demo.entity.BookEntity;
import ru.biponline.demo.exception.ValidationException;
import ru.biponline.demo.response.BaseResponse;
import ru.biponline.demo.response.BookListResponse;
import ru.biponline.demo.service.BookService;

@RestController
@RequestMapping("api/v1/book")
public class BookController {
    private BookService service;
    private BookController(BookService service) {this.service=service;}

    @GetMapping("/all")
    public ResponseEntity <BaseResponse> getAll(){
        return ResponseEntity.ok(new BookListResponse(service.getAll()));
    }

    @PostMapping("/add")
    public ResponseEntity <BaseResponse> registration(@RequestBody BookEntity data) {
        try {
            service.save(data);
            return ResponseEntity.ok(new BaseResponse(true, "Книга добавлена."));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new BaseResponse(false, e.getMessage()));
        }
    }

    @PostMapping("/update")
    public ResponseEntity <BaseResponse> update(@RequestBody BookEntity data) {
        try {
            service.save(data);
            return ResponseEntity.ok(new BaseResponse(true,"В книгу внесены изменения."));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new BaseResponse(false, e.getMessage()));
        }
    }

    @DeleteMapping("{book_id}")
    public ResponseEntity<?> delete(@PathVariable long book_id) {
        try {
            service.delete(book_id);
            return ResponseEntity.ok(new BaseResponse(true,"Книга удалена."));
        } catch (Exception e) {
            return ResponseEntity.ok((new BaseResponse(false, e.getMessage())));
        }
    }
}


