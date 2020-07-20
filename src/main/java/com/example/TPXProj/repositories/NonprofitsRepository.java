package com.example.TPXProj.repositories;

import org.springframework.data.repository.CrudRepository;
import com.example.TPXProj.models.DatabaseNonprofit;

public interface NonprofitsRepository
    extends CrudRepository<DatabaseNonprofit, Integer> {
}
