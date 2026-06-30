package in.gov.kfon.dmdm.revenueshare.specification;

import in.gov.kfon.dmdm.model.RevenueShare;
import jakarta.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.domain.Specification;

public class RevenueShareSpecification {

  private RevenueShareSpecification() {}

  public static Specification<RevenueShare> filter(
      Integer subgroup, UUID providerUuid, String search, Boolean isActive) {
    return (root, query, cb) -> {
      List<Predicate> predicates = new ArrayList<>();

      if (subgroup != null) {
        predicates.add(cb.equal(root.get("subgroup"), subgroup));
      }

      if (providerUuid != null) {
        predicates.add(cb.equal(root.get("providerUuid"), providerUuid));
      }

      if (search != null && !search.isBlank()) {
        String pattern = "%" + search.toLowerCase() + "%";
        predicates.add(
            cb.or(
                cb.like(cb.lower(root.get("shareName")), pattern),
                cb.like(cb.lower(root.get("code")), pattern)));
      }

      if (isActive != null) {
        predicates.add(cb.equal(root.get("isActive"), isActive));
      }

      return cb.and(predicates.toArray(new Predicate[0]));
    };
  }
}
