package mx.edu.utez.market.models.subcategory;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.edu.utez.market.models.category.Category;

@Entity
@Table(name = "subcategories")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Subcategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", unique = true, nullable = false, length = 150)
    private String name;

    @Column(name = "status", nullable = false, columnDefinition = "TINYINT DEFAULT 1")
    private Boolean status;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

}
