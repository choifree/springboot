package com.example.demo.entity;

import com.example.demo.dto.ResponsePostDto;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;

import java.util.Date;

@DynamicInsert
@SuperBuilder
@NoArgsConstructor
@Setter
@Getter
@Entity(name = "post")
@Table(name = "post")
public class PostEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id", columnDefinition = "INT UNSIGNED NOT NULL")
    private long postId;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String content;

    @Column(name = "use_yn", columnDefinition = "CHAR")
    private String useYn;

    @Temporal(TemporalType.TIMESTAMP)
    private Date created;

    @Temporal(TemporalType.TIMESTAMP)
    private Date modified;

    public ResponsePostDto toResponsePostDto() {
        return ResponsePostDto.builder()
                .postId(postId)
                .title(title)
                .content(content)
                .useYn(useYn)
                .created(created)
                .modified(modified)
                .build();
    }
}
