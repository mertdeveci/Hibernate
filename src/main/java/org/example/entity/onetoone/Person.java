package org.example.entity.onetoone;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    private String name;

    private String surname;

    @OneToOne(
            fetch = FetchType.EAGER,
            cascade = {CascadeType.ALL}
    )
    private Vehicle vehicle;
}
