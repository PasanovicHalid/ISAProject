package com.example.BloodBank.controller;

import com.example.BloodBank.model.News;
import com.example.BloodBank.service.NewsService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "api/news")
@CrossOrigin(origins = "http://localhost:4200")
public class NewsController {
    private final NewsService newsService;
    public NewsController(NewsService newsService) {
        this.newsService = newsService;
    }
    @GetMapping()
    public ResponseEntity<Iterable<News>> getAllNews(){
        try {
            return new ResponseEntity<>(newsService.GetAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @PostMapping(
            value = "/create", consumes = "application/json",
            produces = "application/json"
    )
    public ResponseEntity<Object> createNews(@Valid @RequestBody News newNews){
        try {
            newsService.CreateAndSendNews(newNews);
        }catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
