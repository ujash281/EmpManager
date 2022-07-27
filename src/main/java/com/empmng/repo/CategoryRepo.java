package com.empmng.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.empmng.entities.Category;

@Repository
public interface CategoryRepo extends JpaRepository<Category, Integer> {

}
