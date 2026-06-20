package in.gov.kfon.dmdm.Config;

import java.util.List;
import java.util.UUID;

/**
 * Utility for building stable, order-independent Redis cache keys from UUID or String lists.
 *
 * <p>Usage in @Cacheable:
 *
 * <pre>
 *   key = "T(in.gov.kfon.dmdm.Config.CacheKeyUtil).sortedUuids(#districtIds)"
 * </pre>
 */
public final class CacheKeyUtil {

  private CacheKeyUtil() {}

  /**
   * Returns a deterministic comma-joined string from the given UUID list regardless of input order.
   */
  public static String sortedUuids(List<UUID> ids) {
    if (ids == null || ids.isEmpty()) {
      return "empty";
    }
    return ids.stream().map(UUID::toString).sorted().reduce((a, b) -> a + "," + b).orElse("empty");
  }

  /**
   * Returns a deterministic comma-joined string from the given String list regardless of input
   * order.
   */
  public static String sortedStrings(List<String> values) {
    if (values == null || values.isEmpty()) {
      return "empty";
    }
    return values.stream().sorted().reduce((a, b) -> a + "," + b).orElse("empty");
  }
}