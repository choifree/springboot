package com.example.demo.repository.post.custom;

import com.example.demo.entity.post.PostEntity;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class PostCustomRepositoryImpl implements PostCustomRepository {

    private final EntityManager entityManager;

    @Override
    public List<PostEntity> findUsingPost(String useYn) {
        return entityManager
                .createQuery("SELECT p FROM post p WHERE p.useYn = :useYn", PostEntity.class)
                .setParameter("useYn", useYn)
                .getResultList();
    }
}
