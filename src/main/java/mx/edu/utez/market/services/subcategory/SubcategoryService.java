package mx.edu.utez.market.services.subcategory;

import mx.edu.utez.market.models.subcategory.Subcategory;
import mx.edu.utez.market.models.subcategory.SubcategoryRepository;
import mx.edu.utez.market.utils.CustomResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

@Service
@Transactional
public class SubcategoryService {

    @Autowired
    private SubcategoryRepository repository;

    @Transactional(readOnly = true)
    public CustomResponse<List<Subcategory>> getAll(){
        return new CustomResponse<List<Subcategory>>(this.repository.findAll(), false, 200, "OK");
    }

    @Transactional(readOnly = true)
    public CustomResponse<List<Subcategory>> getAllByCategory(Long id){
        return new CustomResponse<List<Subcategory>>(this.repository.findAllByCategory(id), false, 200, "OK");
    }

    @Transactional(readOnly = true)
    public CustomResponse<Subcategory> getOne(Long id){
        return new CustomResponse<Subcategory>(this.repository.findById(id).get(), false, 200, "OK");
    }

    @Transactional(rollbackFor = {SQLException.class})
    public CustomResponse<Subcategory> insert(Subcategory subcategory){
        if(this.repository.existsByName(subcategory.getName())){
            return new CustomResponse<Subcategory>(null, true, 400, "La subcategoria ya se ha registrado");
        }
        return new CustomResponse<Subcategory>(this.repository.saveAndFlush(subcategory), false, 200, "La subcategoria fue registrada correctamente");
    }

    @Transactional(rollbackFor = {SQLException.class})
    public CustomResponse<Subcategory> update(Subcategory subcategory){
        if(this.repository.existsById(subcategory.getId())){
            return new CustomResponse<Subcategory>(null, true, 400, "La subcategoria no existe");
        }
        return new CustomResponse<Subcategory>(this.repository.saveAndFlush(subcategory), false, 200, "La subcategoria fue modificada correctamente");
    }

    @Transactional(rollbackFor = {SQLException.class})
    public CustomResponse<Boolean> changeStatus(Subcategory subcategory){
        if (!this.repository.existsById(subcategory.getId()))
            return new CustomResponse<>(
                    null, true,400,
                    "La subcategoría no existe"
            );
        return new CustomResponse<>(
                this.repository.updateStatusById(subcategory.getStatus(), subcategory.getId()),
                false, 200,
                "Subcategoría modificadda con éxito"

        );
    }

}
