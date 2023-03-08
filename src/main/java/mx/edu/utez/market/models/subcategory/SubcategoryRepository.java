package mx.edu.utez.market.models.subcategory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface SubcategoryRepository extends JpaRepository<Subcategory, Long> {

    @Query(
            value = "UPDATE subcategories SET status = :status WHERE id = :id",nativeQuery = true
    )

    boolean updateStatusById(@Param("status") Boolean status, @Param("id") Long id);

    List<Subcategory> findAllByCategory(Long id);
    boolean existsById(Long id);
    boolean existsByName(String name);

    Optional<Subcategory> findById(Long id);
//    List<Subcategory> findAllByDescription(String description);
}
