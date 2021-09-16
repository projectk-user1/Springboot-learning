package com.maheshb.springbootkafkaintro.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.maheshb.springbootkafkaintro.entities.TagEntity;

@Repository
public interface TagRepo extends JpaRepository<TagEntity, Long> {

}
