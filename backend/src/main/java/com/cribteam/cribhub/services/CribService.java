package com.cribteam.cribhub.services;

import com.cribteam.cribhub.domain.Crib;

import java.util.List;

public interface CribService {
    Crib saveCrib(Crib crib);
    Crib getCribById(Long cribId);
    List<Crib> getAllCribs();
    void deleteCrib(Long cribId);
}