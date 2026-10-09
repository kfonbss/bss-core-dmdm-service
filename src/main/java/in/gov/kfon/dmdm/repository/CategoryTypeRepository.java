package in.gov.kfon.dmdm.repository;

import in.gov.kfon.dmdm.model.CategoryType;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryTypeRepository extends JpaRepository<CategoryType, UUID> {

  List<CategoryType> findAllByOrderByCategoryTypeIdAsc();
}
