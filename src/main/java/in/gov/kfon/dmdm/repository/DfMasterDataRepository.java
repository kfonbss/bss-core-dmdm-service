package in.gov.kfon.dmdm.repository;

import in.gov.kfon.dmdm.model.DfMasterData;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface DfMasterDataRepository extends JpaRepository<DfMasterData, UUID> {

  /**
   * Adds delta to the route's consumed strand count in one statement, never below 0, so two callers
   * at once cannot lose an update. Returns the rows changed (0: no such route).
   */
  @Modifying(clearAutomatically = true, flushAutomatically = true)
  @Query(
      """
      UPDATE DfMasterData m
      SET m.noOfStrandsConsumed =
          CASE WHEN COALESCE(m.noOfStrandsConsumed, 0) + :delta < 0 THEN 0
               ELSE COALESCE(m.noOfStrandsConsumed, 0) + :delta END
      WHERE m.dataId = :dataId
      """)
  int adjustStrandsConsumed(@Param("dataId") UUID dataId, @Param("delta") int delta);
}
