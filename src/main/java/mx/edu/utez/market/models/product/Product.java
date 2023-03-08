package mx.edu.utez.market.models.product;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.edu.utez.market.models.subcategory.Subcategory;

@Entity
@Table(name = "products")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name", unique = true, nullable = false, length = 150)
    private String name;
    @Column(name = "description", nullable = false, length = 200)
    private String description;
    @Column(name = "cuantity", nullable = false)
    private Integer cuantity;
    @Column(name = "price", nullable = false)
    private Double price;
    @Column(name = "status", nullable = false, columnDefinition = "tinyint default 1")
    private Boolean status;
    @ManyToOne
    @JoinColumn(name = "subcategory_id", nullable = false)
    private Subcategory subcategory;
}
