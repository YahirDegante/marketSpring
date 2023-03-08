package mx.edu.utez.market.controllers.subcategory.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.edu.utez.market.models.category.Category;
import mx.edu.utez.market.models.subcategory.Subcategory;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SubcategoryDto {
    private Long id;
    private String name;
    private Boolean status;
    private Category category;
    public Subcategory castToSubcategory() {
        return new Subcategory(getId(), getName(), getStatus(), getCategory());
    }
}
