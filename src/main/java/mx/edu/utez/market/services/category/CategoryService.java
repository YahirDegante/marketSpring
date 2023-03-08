package mx.edu.utez.market.models.services.category;

import mx.edu.utez.market.models.category.Category;
import mx.edu.utez.market.models.category.CategoryRepository;
import mx.edu.utez.market.utils.CustomResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

@Service
@Transactional
public class CategoryService {
    @Autowired
    private CategoryRepository repository;
    @Transactional(readOnly = true)
    public CustomResponse<List<Category>> getAll(){
        return new CustomResponse<List<Category>>(this.repository.findAll(), false, 200, "OK");
    }

    @Transactional(readOnly = true)
    public CustomResponse<Category> getOne(Long id){
        return new CustomResponse<Category>(this.repository.findById(id).get(), false, 200, "OK");
    }

    @Transactional(rollbackFor = {SQLException.class})
    public CustomResponse<Category> insert(Category category){
        if(this.repository.existsByName(category.getName())){
            return new CustomResponse<Category>(null, true, 400, "La categoria ya se ha registrado");
        }
        return new CustomResponse<Category>(this.repository.saveAndFlush(category), false, 200, "La categoria fue registrada correctamente");
    }

    @Transactional(rollbackFor = {SQLException.class})
    public CustomResponse<Category> update(Category category){
        if(this.repository.existsById(category.getId())){
            return new CustomResponse<Category>(null, true, 400, "La categoria no existe");
        }
        return new CustomResponse<Category>(this.repository.saveAndFlush(category), false, 200, "La categoria fue modificada correctamente");
    }

    @Transactional(rollbackFor = {SQLException.class})
    public CustomResponse<Boolean> changeStatus(Category category){
        ///nombre de la categoría no se repite
        if (!this.repository.existsById(category.getId()))
            return new CustomResponse<>(
                    null, true,400,
                    "La categoría no existe"
            );
        return new CustomResponse<>(
                this.repository.updateStatusById(category.getStatus(), category.getId()),
                false, 200,
                "Categoría registrada con éxito"

        );
    }

}
