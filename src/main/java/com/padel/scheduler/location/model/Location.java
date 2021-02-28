package com.padel.scheduler.location.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String latitude;
    private String longitude;
    private LocalDateTime createTime;

//    @ToString.Exclude
//    @OneToMany(mappedBy = "location", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<Field> fields = new ArrayList<>();
//
//    public void addField(Field field){
//        this.fields.add(field);
//        field.setLocation(this);
//    }
//
//    public void removeField(Field field) {
//        fields.remove(field);
//        field.setLocation(null);
//    }
}
