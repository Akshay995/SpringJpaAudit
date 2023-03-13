package com.codeusingjava.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codeusingjava.model.Items;

//spring annotation
@Repository
public interface ItemsRepository extends JpaRepository<Items, Integer> {
}
