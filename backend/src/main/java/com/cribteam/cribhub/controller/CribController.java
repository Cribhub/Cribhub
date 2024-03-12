package com.cribteam.cribhub.controller;

import com.cribteam.cribhub.domain.Crib;
import com.cribteam.cribhub.DTO.CribDTO;
import com.cribteam.cribhub.services.CribService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cribs")
public class CribController {
    private final CribService cribService;

    public CribController(CribService cribService) {
        this.cribService = cribService;
    }

    @PostMapping
    public ResponseEntity<CribDTO> createCrib(@RequestBody Crib crib) {
        crib = cribService.saveCrib(crib);
        return ResponseEntity.ok(CribDTO.ConvertToCribDTO(crib));
    }

    @GetMapping("/{cribId}")
    public ResponseEntity<CribDTO> getCribById(@PathVariable Long cribId) {
        Crib crib = cribService.getCribById(cribId);
        if (crib == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(CribDTO.ConvertToCribDTO(crib));
    }

    @DeleteMapping("/{cribId}")
    public ResponseEntity<Void> deleteCrib(@PathVariable Long cribId) {
        cribService.deleteCrib(cribId);
        return ResponseEntity.noContent().build();
    }

    // Other methods...

}