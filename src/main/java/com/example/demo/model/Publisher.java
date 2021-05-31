package com.example.demo.model;


import lombok.Data;

import javax.persistence.*;

@Data //Equivalent to @Getter @Setter
   // @RequiredArgsConstructor @ToString @EqualsAndHashCode.
@Entity  //Specifies that the class is an entity
@Table(name = "publisher")
public class Publisher {

    @Column(name = "publisher_id")
    @Id //pk임
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long no;

    @Column(name = "publisher_name")
    private String name;

}
