package com.empmng.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.empmng.entities.Complaint;

@Repository
public interface ComplaintRepo extends JpaRepository<Complaint, Integer> {

}
