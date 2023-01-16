package com.company.socialmediaapp.controller;

import com.company.socialmediaapp.dto.MwordDto;
import com.company.socialmediaapp.service.MwordService;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author mehul jain
 */

@RestController
@RequestMapping("/api/mword")
@AllArgsConstructor
@Slf4j
public class MwordController {
    
    private final MwordService mwordService;

    @PostMapping
    public ResponseEntity<MwordDto> createMword(@RequestBody MwordDto mwordDto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(mwordService.save(mwordDto));
    }

    @GetMapping
    public ResponseEntity<List<MwordDto>> getAllMwords() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(mwordService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MwordDto> getMword(@PathVariable Long id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(mwordService.getMword(id));
    }
}
