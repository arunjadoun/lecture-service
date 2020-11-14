/*
package com.learning.repository;

import com.due.dots.entity.News;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NewsRepository extends JpaRepository<News, Long> {

    List<News> findByCategory(String category);
    Page<News> findByCategoryContaining(String category, Pageable pageable);
}*/
