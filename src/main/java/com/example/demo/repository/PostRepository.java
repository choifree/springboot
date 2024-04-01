package com.example.demo.repository;

import com.example.demo.entity.PostEntity;
import com.example.demo.repository.custom.PostCustomRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface PostRepository extends JpaRepository<PostEntity, Long>, PostCustomRepository {

}
