package org.example.entity.onetomany;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Intructor {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    private String name;

    private String department;

    @OneToMany(
            fetch = FetchType.EAGER,
            cascade = {CascadeType.DETACH,CascadeType.MERGE}
    )
    private List<Course> courses;
}
