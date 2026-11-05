package in.gov.kfon.dmdm.util;

import java.util.Map;

/**
 * Maps a tenant id to the geographic state code its master data is stored under.
 *
 * <p>Most dmdm masters (district, pincode, pop, streetbox, bank details, gateway) are filtered by
 * the request's {@code X-Tenant-ID}, which for the state circles equals the state code itself
 * ({@code KFON}, {@code LD}, {@code PY}, ...). The KFON operator tenant's master data is stored
 * under {@code state_code = 'KFON'}, so it needs no mapping. Add an entry here only when a tenant id
 * differs from the state code its data is stored under. An unmapped tenant is returned unchanged
 * (trimmed).
 */
public final class TenantStateCodeResolver {

  private static final Map<String, String> TENANT_STATE_CODE_MAP = Map.of();

  private TenantStateCodeResolver() {}

  /**
   * @param tenantId tenant id / circle code, case-insensitive; may be null or blank
   * @return the state code to query by: the mapped code, or the trimmed input when unmapped, or the
   *     input unchanged when null/blank
   */
  public static String resolve(String tenantId) {
    if (tenantId == null || tenantId.isBlank()) return tenantId;
    String key = tenantId.trim();
    return TENANT_STATE_CODE_MAP.getOrDefault(key.toUpperCase(), key);
  }
}
