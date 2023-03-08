package mx.edu.utez.market.models.person;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.edu.utez.market.models.user.User;

@Entity
@Table(name = "people")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, length = 150)
    private String name;
    @Column(name = "surname", nullable = false)
    private String surname;
    @Column(name = "lastname")
    private String lastname;
    @Column(name = "birthday", nullable = false)
    private String birthday;
    @Column(name = "curp", nullable = false, unique = true)
    private String curp;
    @Column(name = "status", nullable = false, columnDefinition = "tinyint default 1")
    private Boolean status;
    @Column(name = "gender", nullable = false)
    private String gender;

    @OneToOne(mappedBy = "person", cascade = CascadeType.PERSIST)
    @PrimaryKeyJoinColumn
    private User user;
}
