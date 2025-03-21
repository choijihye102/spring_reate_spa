package com.example.jennie.semiprojectv2.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="boards")
@Data @Builder
@AllArgsConstructor
@NoArgsConstructor
public class Board {

    @Id
    // IDENTITY, AUTO = mysql, mariadb
    // SEQUENCE = oracle
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bno;

    @Column(nullable = false)
    private String userid;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String contents;

   // @Column(columnDefinition = "BIGINT default 0")
    private int thumbs = 0;

   // @Column(columnDefinition = "BIGINT default 0")
    private int views = 0;

    // insert, update시 해당 컬럼 제외
    @CreationTimestamp
    //@Column(insertable = false, updatable = false)
    private LocalDateTime regdate;

}
