package in.gov.kfon.dmdm.util;

import java.util.Map;

/**
 * Maps a tenant id to the geographic state code its master data is stored under.
 *
 * <p>Most dmdm masters (district, pincode, pop, streetbox, bank details, gateway) are filtered by
 * the request's {@code X-Tenant-ID}, which for the state circles equals the state code itself
 * ({@code KL}, {@code LD}, {@code PY}, ...). The KFON operator tenant, however, shares the Kerala
 * ({@code KL}) data, so its tenant id must resolve to {@code KL} before any {@code state_code}
 * lookup. An unmapped tenant is returned unchanged (trimmed), so the existing circle tenants keep
 * working exactly as before.
 */
public final class TenantStateCodeResolver {

  private static final Map<String, String> TENANT_STATE_CODE_MAP = Map.of("KFON", "KL");

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
