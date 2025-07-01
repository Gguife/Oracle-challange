package com.oracle.demo.controller;


import com.oracle.demo.domain.forum.Forum;
import com.oracle.demo.domain.forum.ForumData;
import com.oracle.demo.domain.forum.ForumDetailsData;
import com.oracle.demo.domain.forum.ForumRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/forum")
public class ForumController {

    @Autowired
    private ForumRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity register(@RequestBody @Valid ForumData data, UriComponentsBuilder uriBuilder) {
        var post = new Forum(data);
        repository.save(post);

        var uri = uriBuilder.path("/forum/{id}").buildAndExpand(post.getId()).toUri();
        return ResponseEntity.created(uri).body(new ForumDetailsData(post));
    }

    @GetMapping
    public ResponseEntity<List<Forum>> allPost() {
        List<Forum> posts = repository.findAllPostForum();
        return ResponseEntity.ok(posts);
    }

    @DeleteMapping("/{id}")
    @org.springframework.transaction.annotation.Transactional
    public ResponseEntity remove(@PathVariable Long id) {
        var post = repository.getReferenceById(id);
        post.delete();

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity postById(@PathVariable Long id) {
        var post = repository.getReferenceById(id);
        return ResponseEntity.ok(new ForumDetailsData(post));
    }

}
