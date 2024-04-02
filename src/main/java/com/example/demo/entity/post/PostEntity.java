package com.example.demo.entity.post;

import com.example.demo.dto.post.ResponsePostDto;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.Where;

import java.util.Date;

@DynamicInsert
@SuperBuilder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Setter
@Getter
@Where(clause = "use_yn = 'Y'")
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
