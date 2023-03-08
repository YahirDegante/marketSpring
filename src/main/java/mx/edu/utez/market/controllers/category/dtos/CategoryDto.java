package mx.edu.utez.market.controllers.category.dtos;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.edu.utez.market.models.category.Category;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class CategoryDto {
    private Long id;

    @NotEmpty(message = "Campo obligatorio")
    @Size(min = 4, max = 50, message = "El nombre debe tener entre 3 y 50 caracteres")
    private String name;
    private Boolean status;

    public Category castToCategory() {
        return new Category(getId(), getName(), getStatus(), null);
    }

}
