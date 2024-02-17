package com.workintech.project18g2.entity;

import jakarta.persistence.*;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
@Data
@Entity
@Table(name="fruit", schema = "fsweb")
public class Fruit {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private Integer price;

    @Column(name= "name")
   // not null , Sİze
    private String name;

    @Enumerated(EnumType.STRING)
    private FruitType fruitType;

}
