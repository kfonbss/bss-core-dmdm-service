package in.gov.kfon.dmdm.repository;

import in.gov.kfon.dmdm.constant.FieldCategory;
import in.gov.kfon.dmdm.model.FormFieldMaster;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FormFieldMasterRepository extends JpaRepository<FormFieldMaster, UUID> {

  List<FormFieldMaster> findByIsActive(boolean isActive);

  List<FormFieldMaster> findByFieldCategoryAndIsActive(FieldCategory fieldCategory, boolean isActive);

  Optional<FormFieldMaster> findByFieldKey(String fieldKey);

  boolean existsByFieldKey(String fieldKey);
}
