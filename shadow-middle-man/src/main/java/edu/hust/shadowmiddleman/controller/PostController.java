package edu.hust.shadowmiddleman.controller;

import edu.hust.shadowmiddleman.common.Constant;
import edu.hust.shadowmiddleman.dto.common.ResponseDTO;
import edu.hust.shadowmiddleman.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/post")
public class PostController {
    @Autowired
    PostService postService;

    @PostMapping("/getAll")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<ResponseDTO> getAll() {
        return ResponseEntity.ok()
                .body(
                        ResponseDTO.builder()
                                .code(Constant.HTTP_OK)
                                .message(Constant.RESPONSE.MESSAGE.OK)
                                .data(postService.getAll())
                                .build());
    }
}
