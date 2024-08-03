package org.g9project4.board.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

@Data
@Builder
@NoArgsConstructor @AllArgsConstructor
@Getter @Setter
@Entity
public class BoardData {
    @Id @GeneratedValue
    private Long id;

    @Column(length = 65, nullable = false)
    private String title;

    @Column(length = 200, nullable = false)
    private String content;

    @Column(length = 65, nullable = false)
    private String author;
}
