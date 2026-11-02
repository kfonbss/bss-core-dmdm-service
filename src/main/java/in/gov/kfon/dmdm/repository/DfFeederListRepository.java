package in.gov.kfon.dmdm.repository;

import in.gov.kfon.dmdm.model.DfFeederList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface DfFeederListRepository extends JpaRepository<DfFeederList, UUID> {

  /** The POP's active feeders, by the POP's legacy id (df_pop_list.id), by name. */
  List<DfFeederList> findByPopIdAndIsActiveTrueOrderByFeederNameAsc(Integer popId);

  /** By the legacy ids (df_link_details.feeder_id), inactive ones too. */
  List<DfFeederList> findByIdIn(Collection<Integer> ids);

  /**
   * Adds delta to the feeder's noof_strands_consumed, never below 0, by its legacy id
   * (df_link_details.feeder_id). Returns the rows changed.
   */
  @Modifying(clearAutomatically = true, flushAutomatically = true)
  @Query(
      """
      UPDATE DfFeederList f
      SET f.noOfStrandsConsumed =
          CASE WHEN COALESCE(f.noOfStrandsConsumed, 0) + :delta < 0 THEN 0
               ELSE COALESCE(f.noOfStrandsConsumed, 0) + :delta END
      WHERE f.id = :id
      """)
  int adjustStrandsConsumed(@Param("id") Integer id, @Param("delta") int delta);
}
