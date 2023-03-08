package mx.edu.utez.market.models.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.edu.utez.market.models.person.Person;
import mx.edu.utez.market.models.role.Role;

import java.util.Set;

@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "passowrd",nullable = false)
    private String password;
    @Column(name = "status", nullable = false, columnDefinition = "tinyint default 1")
    private Boolean status;
    @Column(name =  "lastAccess",nullable = false)
    private String lastAccess;
    @Column(name = "blocked", nullable = false)
    private Boolean blocked;
    @Column(name = "token",nullable = false)
    private String token;

    @OneToOne
    @MapsId
    @JoinColumn(name = "person_id", referencedColumnName = "id", unique = true)
    private Person person;

    @ManyToMany
    @JsonIgnore
    private Set<Role> roles;
}
