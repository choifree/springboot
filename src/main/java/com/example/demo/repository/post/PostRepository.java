package com.example.demo.repository.post;

import com.example.demo.entity.post.PostEntity;
import com.example.demo.repository.post.custom.PostCustomRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<PostEntity, Long>, PostCustomRepository {

}
