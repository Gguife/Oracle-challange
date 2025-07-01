package com.oracle.demo.domain.forum;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface ForumRepository extends JpaRepository<Forum, Long> {

    @Query(value = "SELECT * from Forum WHERE active = 1 ORDER BY RAND() limit 1", nativeQuery = true)
    List<Forum> findAllPostForum();

    @Query(value = "SELECT active FROM Forum f WHERE f.id = :id", nativeQuery = true)
    Boolean findActiveByID(@Param("id") Long id);
}
