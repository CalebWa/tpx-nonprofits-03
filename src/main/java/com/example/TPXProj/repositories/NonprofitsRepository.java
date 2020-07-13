package com.example.TPXProj.repositories;

import org.springframework.data.repository.CrudRepository;
import com.example.TPXProj.models.Nonprofits;

public interface NonprofitsRepository
    extends CrudRepository<Nonprofits, Integer> {
}
