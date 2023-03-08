package mx.edu.utez.market.models.role;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.edu.utez.market.models.user.User;

import java.util.Set;

@Entity
@Table(name = "roles")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 200)
    private String description;
    @Column(name = "status", nullable = false, columnDefinition = "tinyint default 1")
    private Boolean status;

    @ManyToMany(mappedBy = "roles")
    @JsonIgnore
    private Set<User> users;

}
