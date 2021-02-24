package com.padel.scheduler.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Field {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private boolean isCovered;
    private int number;
    private LocalDateTime createTime;

    @ManyToOne
    @JoinColumn(name = "club_id", referencedColumnName = "id")
    private Club club;
}
