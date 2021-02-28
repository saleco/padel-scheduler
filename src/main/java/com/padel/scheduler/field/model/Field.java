package com.padel.scheduler.field.model;

import com.padel.scheduler.location.model.Location;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Field {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private boolean isCovered;
    private String name;
    private LocalDateTime createTime;

    @ManyToOne
    private Location location;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Field )) return false;
        return id != null && id.equals(((Field) o).getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

}
