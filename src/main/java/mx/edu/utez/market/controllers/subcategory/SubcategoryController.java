package mx.edu.utez.market.controllers.subcategory;

import jakarta.validation.Valid;
import mx.edu.utez.market.controllers.subcategory.dtos.SubcategoryDto;
import mx.edu.utez.market.models.subcategory.Subcategory;
import mx.edu.utez.market.services.subcategory.SubcategoryService;
import mx.edu.utez.market.utils.CustomResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("./api-market/subcategory")
@CrossOrigin(origins = {"*"})
public class SubcategoryController {
    @Autowired
    private SubcategoryService service;

    @GetMapping("/")
    public ResponseEntity<CustomResponse<List<Subcategory>>> getAll(){
        return new ResponseEntity<>(
                this.service.getAll(),
                HttpStatus.OK
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomResponse<Subcategory>> getById(@PathVariable Long id){
        return new ResponseEntity<>(
                this.service.getOne(id),
                HttpStatus.OK
        );
    }

    @GetMapping("/category/{id}")
    public ResponseEntity<CustomResponse<List<Subcategory>>> getByCategory(@PathVariable Long id){
        return new ResponseEntity<>(
                this.service.getAllByCategory(id),
                HttpStatus.OK
        );
    }

    @PostMapping("/")
    public ResponseEntity<CustomResponse<Subcategory>> insert(@Valid @RequestBody SubcategoryDto subcategory) {
        return new ResponseEntity<>(this.service.insert(subcategory.castToSubcategory()), HttpStatus.CREATED);
    }

    @PutMapping("/")
    public ResponseEntity<CustomResponse<Subcategory>> update(@Valid @RequestBody SubcategoryDto subcategory){
        return new ResponseEntity<>(this.service.update(subcategory.castToSubcategory()), HttpStatus.CREATED);
    }

    @PatchMapping("/")
    public ResponseEntity<CustomResponse<Boolean>> enableOrDisable(@RequestBody SubcategoryDto subcategory){
        return new ResponseEntity<>(this.service.changeStatus(subcategory.castToSubcategory()), HttpStatus.OK);
    }

}
