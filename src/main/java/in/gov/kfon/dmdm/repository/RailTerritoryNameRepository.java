package in.gov.kfon.dmdm.repository;

import in.gov.kfon.dmdm.model.RailTerritoryName;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RailTerritoryNameRepository extends JpaRepository<RailTerritoryName, UUID> {
  @Query("select r from RailTerritoryName r where r.cCode = :cCode and r.status = :status")
  List<RailTerritoryName> findByCCodeAndStatus(
      @Param("cCode") String cCode, @Param("status") Integer status);
}