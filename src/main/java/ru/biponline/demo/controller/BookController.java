package ru.biponline.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.biponline.demo.entity.BookEntity;
import ru.biponline.demo.response.BaseResponse;
import ru.biponline.demo.response.BookListResponse;
import ru.biponline.demo.response.BookResponse;
import ru.biponline.demo.service.BookService;

import javax.validation.Valid;
import javax.validation.executable.ValidateOnExecution;

@RestController
@RequestMapping("api/v1/book")
public class BookController {
    private BookService service;


    private BookController(BookService service){ this.service = service; }

    @GetMapping("/all")
    public ResponseEntity<BaseResponse> getAll(){
        return ResponseEntity.ok(new BookListResponse(service.getAll()));
    }


    @ValidateOnExecution
    @PostMapping("/add")
    public ResponseEntity <BaseResponse> registration (@Valid @RequestBody BookEntity data) {
        try {
            BookEntity temp = service.save(data);
            return ResponseEntity.ok(new BookResponse(true, "Книга добавлена", temp));
        } catch (Exception e){
            return ResponseEntity.badRequest().body(new BookResponse(false, e.getMessage(), null));
        }
    }


    @PostMapping("/update")
    public ResponseEntity <BaseResponse> update(@RequestBody BookEntity data){
        try {
            service.save(data);
            return ResponseEntity.ok(new BaseResponse(true, "В книгу внесене изменения"));
        } catch (Exception e) {
            return ResponseEntity. badRequest().body(new BaseResponse(false,e.getMessage()));
        }
    }


    @DeleteMapping("/delete")
    public ResponseEntity <BaseResponse> delete(@RequestParam Long id){
        try {
            service.delete(id);
            return ResponseEntity.ok(new BaseResponse(true, "Книга успешно удалена"));
        } catch (Exception e) {
            return ResponseEntity. badRequest().body(new BaseResponse(false, e.getMessage()));
        }
    }
}
