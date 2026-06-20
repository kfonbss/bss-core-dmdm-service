package in.gov.kfon.dmdm.Config;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.jsontype.BasicPolymorphicTypeValidator;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;

@Configuration
public class RedisConfig {

  @Bean
  public RedisCacheManager cacheManager(RedisConnectionFactory connectionFactory) {
    GenericJackson2JsonRedisSerializer serializer = buildSerializer();

    RedisCacheConfiguration defaults =
        RedisCacheConfiguration.defaultCacheConfig()
            .entryTtl(Duration.ofMinutes(30))
            .disableCachingNullValues()
            .serializeValuesWith(
                RedisSerializationContext.SerializationPair.fromSerializer(serializer));

    Map<String, RedisCacheConfiguration> perCacheConfig = new HashMap<>();

    // ---- 4-hour TTL: geographic constants that almost never change ----
    perCacheConfig.put(CacheNames.ALL_STATES, defaults.entryTtl(Duration.ofHours(4)));
    perCacheConfig.put(CacheNames.STATE_BY_ID, defaults.entryTtl(Duration.ofHours(4)));
    perCacheConfig.put(CacheNames.STATES_BY_CODES, defaults.entryTtl(Duration.ofHours(4)));
    perCacheConfig.put(CacheNames.ALL_DISTRICTS, defaults.entryTtl(Duration.ofHours(4)));
    perCacheConfig.put(CacheNames.DISTRICT_BY_ID, defaults.entryTtl(Duration.ofHours(4)));

    // ---- 2-hour TTL: pincode/post office and block data (rarely changes) ----
    perCacheConfig.put(CacheNames.ALL_PINCODES, defaults.entryTtl(Duration.ofHours(2)));
    perCacheConfig.put(CacheNames.PINCODE_BY_ID, defaults.entryTtl(Duration.ofHours(2)));
    perCacheConfig.put(CacheNames.ALL_PINCODE_DETAILS, defaults.entryTtl(Duration.ofHours(2)));
    perCacheConfig.put(CacheNames.PINCODE_DETAILS_BY_ID, defaults.entryTtl(Duration.ofHours(2)));
    perCacheConfig.put(
        CacheNames.POST_OFFICE_BY_PINCODE, defaults.entryTtl(Duration.ofHours(2)));
    perCacheConfig.put(
        CacheNames.POST_OFFICE_DETAILS_BY_PINCODE, defaults.entryTtl(Duration.ofHours(2)));
    perCacheConfig.put(
        CacheNames.PINCODE_DETAILS_BY_DISTRICT, defaults.entryTtl(Duration.ofHours(2)));
    perCacheConfig.put(
        CacheNames.PINCODE_DETAIL_BY_PINCODE, defaults.entryTtl(Duration.ofHours(2)));
    perCacheConfig.put(
        CacheNames.DISTRICT_DETAILS_BY_PINCODE, defaults.entryTtl(Duration.ofHours(2)));
    perCacheConfig.put(
        CacheNames.BLOCK_CORPORATION_BY_DISTRICT, defaults.entryTtl(Duration.ofHours(2)));
    perCacheConfig.put(
        CacheNames.BLOCK_PANCHAYAT_BY_DISTRICT, defaults.entryTtl(Duration.ofHours(2)));
    perCacheConfig.put(
        CacheNames.BLOCK_NAME_BY_DISTRICT, defaults.entryTtl(Duration.ofHours(2)));
    perCacheConfig.put(CacheNames.BLOCK_BY_ID, defaults.entryTtl(Duration.ofHours(2)));
    perCacheConfig.put(
        CacheNames.VILLAGE_TYPE_BY_LOCATION, defaults.entryTtl(Duration.ofHours(2)));

    // ---- 1-hour TTL: master/reference data (POP, packages, service types, etc.) ----
    perCacheConfig.put(CacheNames.ALL_POP_MASTERS, defaults.entryTtl(Duration.ofHours(1)));
    perCacheConfig.put(CacheNames.POP_MASTER_BY_ID, defaults.entryTtl(Duration.ofHours(1)));
    perCacheConfig.put(
        CacheNames.ALL_POP_MASTER_BACKUPS, defaults.entryTtl(Duration.ofHours(1)));
    perCacheConfig.put(
        CacheNames.POP_MASTER_BACKUP_BY_ID, defaults.entryTtl(Duration.ofHours(1)));
    perCacheConfig.put(CacheNames.ALL_DF_POP_LISTS, defaults.entryTtl(Duration.ofHours(1)));
    perCacheConfig.put(CacheNames.DF_POP_BY_ID, defaults.entryTtl(Duration.ofHours(1)));
    perCacheConfig.put(CacheNames.ALL_PACKAGE_MAPS, defaults.entryTtl(Duration.ofHours(1)));
    perCacheConfig.put(CacheNames.PACKAGE_MAP_BY_ID, defaults.entryTtl(Duration.ofHours(1)));
    perCacheConfig.put(
        CacheNames.ALL_PACKAGE_CATEGORIES, defaults.entryTtl(Duration.ofHours(1)));
    perCacheConfig.put(
        CacheNames.PACKAGE_CATEGORY_BY_ID, defaults.entryTtl(Duration.ofHours(1)));
    perCacheConfig.put(CacheNames.ALL_PACKAGES, defaults.entryTtl(Duration.ofHours(1)));
    perCacheConfig.put(CacheNames.PACKAGES_BY_ID, defaults.entryTtl(Duration.ofHours(1)));
    perCacheConfig.put(CacheNames.ALL_PACKAGE, defaults.entryTtl(Duration.ofHours(1)));
    perCacheConfig.put(CacheNames.PACKAGE_BY_ID, defaults.entryTtl(Duration.ofHours(1)));
    perCacheConfig.put(CacheNames.ALL_SERVICE_TYPES, defaults.entryTtl(Duration.ofHours(1)));
    perCacheConfig.put(CacheNames.SERVICE_TYPE_BY_ID, defaults.entryTtl(Duration.ofHours(1)));
    perCacheConfig.put(CacheNames.ALL_SERVICES, defaults.entryTtl(Duration.ofHours(1)));
    perCacheConfig.put(CacheNames.SERVICE_BY_ID, defaults.entryTtl(Duration.ofHours(1)));
    perCacheConfig.put(CacheNames.ALL_STREETBOXES, defaults.entryTtl(Duration.ofHours(1)));
    perCacheConfig.put(CacheNames.ALL_COMPANY_DETAILS, defaults.entryTtl(Duration.ofHours(1)));
    perCacheConfig.put(CacheNames.COMPANY_DETAIL_BY_ID, defaults.entryTtl(Duration.ofHours(1)));
    perCacheConfig.put(CacheNames.ALL_CAF_DETAILS, defaults.entryTtl(Duration.ofHours(1)));
    perCacheConfig.put(CacheNames.CAF_DETAIL_BY_ID, defaults.entryTtl(Duration.ofHours(1)));
    // Inventory master/reference data
    perCacheConfig.put(CacheNames.ALL_DEVICE_MAKES, defaults.entryTtl(Duration.ofHours(1)));
    perCacheConfig.put(CacheNames.DEVICE_MAKE_BY_ID, defaults.entryTtl(Duration.ofHours(1)));
    perCacheConfig.put(CacheNames.ALL_DEVICE_MODELS, defaults.entryTtl(Duration.ofHours(1)));
    perCacheConfig.put(CacheNames.DEVICE_MODEL_BY_ID, defaults.entryTtl(Duration.ofHours(1)));
    perCacheConfig.put(CacheNames.ALL_DEVICE_TYPES, defaults.entryTtl(Duration.ofHours(1)));
    perCacheConfig.put(CacheNames.DEVICE_TYPE_BY_ID, defaults.entryTtl(Duration.ofHours(1)));
    perCacheConfig.put(CacheNames.ALL_DEVICE_VENDORS, defaults.entryTtl(Duration.ofHours(1)));
    perCacheConfig.put(CacheNames.DEVICE_VENDOR_BY_ID, defaults.entryTtl(Duration.ofHours(1)));
    perCacheConfig.put(CacheNames.ALL_DEVICE_CATS, defaults.entryTtl(Duration.ofHours(1)));
    perCacheConfig.put(CacheNames.DEVICE_CAT_BY_ID, defaults.entryTtl(Duration.ofHours(1)));
    perCacheConfig.put(CacheNames.ALL_DEVICE_STATUSES, defaults.entryTtl(Duration.ofHours(1)));
    perCacheConfig.put(CacheNames.DEVICE_STATUS_BY_ID, defaults.entryTtl(Duration.ofHours(1)));
    perCacheConfig.put(CacheNames.ALL_DEVICE_RETURNS, defaults.entryTtl(Duration.ofHours(1)));
    perCacheConfig.put(CacheNames.DEVICE_RETURN_BY_ID, defaults.entryTtl(Duration.ofHours(1)));
    perCacheConfig.put(
        CacheNames.ALL_DEVICE_CONDITION_STATUSES, defaults.entryTtl(Duration.ofHours(1)));
    perCacheConfig.put(
        CacheNames.DEVICE_CONDITION_STATUS_BY_ID, defaults.entryTtl(Duration.ofHours(1)));

    // ---- 30-minute TTL: roles, modules, users, bank, tax, revenue (admin-managed data) ----
    perCacheConfig.put(CacheNames.ALL_ANP_USERS, defaults.entryTtl(Duration.ofMinutes(30)));
    perCacheConfig.put(CacheNames.ALL_ROLE_TYPES, defaults.entryTtl(Duration.ofMinutes(30)));
    perCacheConfig.put(CacheNames.ROLE_TYPE_BY_ID, defaults.entryTtl(Duration.ofMinutes(30)));
    perCacheConfig.put(CacheNames.ALL_ROLES, defaults.entryTtl(Duration.ofMinutes(30)));
    perCacheConfig.put(CacheNames.ROLE_BY_ID, defaults.entryTtl(Duration.ofMinutes(30)));
    perCacheConfig.put(CacheNames.ALL_ROLES_MODULES, defaults.entryTtl(Duration.ofMinutes(30)));
    perCacheConfig.put(CacheNames.ROLES_MODULE_BY_ID, defaults.entryTtl(Duration.ofMinutes(30)));
    perCacheConfig.put(CacheNames.ALL_MODULES, defaults.entryTtl(Duration.ofMinutes(30)));
    perCacheConfig.put(CacheNames.MODULE_BY_ID, defaults.entryTtl(Duration.ofMinutes(30)));
    perCacheConfig.put(CacheNames.ALL_BANK_DETAILS, defaults.entryTtl(Duration.ofMinutes(30)));
    perCacheConfig.put(CacheNames.BANK_DETAILS_BY_ID, defaults.entryTtl(Duration.ofMinutes(30)));
    perCacheConfig.put(
        CacheNames.BANK_DETAILS_BY_IFSC, defaults.entryTtl(Duration.ofMinutes(30)));
    perCacheConfig.put(CacheNames.ALL_SAMPLE_TAX, defaults.entryTtl(Duration.ofMinutes(30)));
    perCacheConfig.put(CacheNames.SAMPLE_TAX_BY_ID, defaults.entryTtl(Duration.ofMinutes(30)));
    perCacheConfig.put(
        CacheNames.ALL_TAX_COLLECTIONS, defaults.entryTtl(Duration.ofMinutes(30)));
    perCacheConfig.put(
        CacheNames.TAX_COLLECTION_BY_ID, defaults.entryTtl(Duration.ofMinutes(30)));
    perCacheConfig.put(CacheNames.ALL_TAX_TYPES, defaults.entryTtl(Duration.ofMinutes(30)));
    perCacheConfig.put(
        CacheNames.TAX_TYPES_BY_TYPE_ID, defaults.entryTtl(Duration.ofMinutes(30)));
    perCacheConfig.put(CacheNames.TAX_TYPE_BY_ID, defaults.entryTtl(Duration.ofMinutes(30)));
    perCacheConfig.put(CacheNames.ALL_TAX_DETAILS, defaults.entryTtl(Duration.ofMinutes(30)));
    perCacheConfig.put(CacheNames.TAX_DETAIL_BY_ID, defaults.entryTtl(Duration.ofMinutes(30)));
    perCacheConfig.put(CacheNames.ACTIVE_TAX_DETAIL, defaults.entryTtl(Duration.ofMinutes(30)));
    perCacheConfig.put(CacheNames.ALL_TAX_PAYERS, defaults.entryTtl(Duration.ofMinutes(30)));
    perCacheConfig.put(CacheNames.TAX_PAYER_BY_ID, defaults.entryTtl(Duration.ofMinutes(30)));
    perCacheConfig.put(
        CacheNames.ALL_TAX_DISBURSEMENTS, defaults.entryTtl(Duration.ofMinutes(30)));
    perCacheConfig.put(
        CacheNames.TAX_DISBURSEMENT_BY_ID, defaults.entryTtl(Duration.ofMinutes(30)));
    perCacheConfig.put(
        CacheNames.ALL_TAX_DISTRIBUTIONS, defaults.entryTtl(Duration.ofMinutes(30)));
    perCacheConfig.put(
        CacheNames.TAX_DISTRIBUTION_BY_ID, defaults.entryTtl(Duration.ofMinutes(30)));
    perCacheConfig.put(CacheNames.ALL_REVENUE, defaults.entryTtl(Duration.ofMinutes(30)));
    perCacheConfig.put(CacheNames.REVENUE_BY_ID, defaults.entryTtl(Duration.ofMinutes(30)));
    perCacheConfig.put(
        CacheNames.REVENUE_SHARE_BY_ID, defaults.entryTtl(Duration.ofMinutes(30)));

    // ---- 15-minute TTL: inventory transactional data (changes more frequently) ----
    perCacheConfig.put(
        CacheNames.ALL_CREDIT_NOTES, defaults.entryTtl(Duration.ofMinutes(15)));
    perCacheConfig.put(CacheNames.CREDIT_NOTE_BY_ID, defaults.entryTtl(Duration.ofMinutes(15)));
    perCacheConfig.put(
        CacheNames.ALL_DC_CREDIT_NOTES, defaults.entryTtl(Duration.ofMinutes(15)));
    perCacheConfig.put(
        CacheNames.DC_CREDIT_NOTES_BY_ID, defaults.entryTtl(Duration.ofMinutes(15)));
    perCacheConfig.put(
        CacheNames.ALL_DEVICE_ACKNOWLEDGEMENTS, defaults.entryTtl(Duration.ofMinutes(15)));
    perCacheConfig.put(
        CacheNames.DEVICE_ACKNOWLEDGEMENT_BY_ID, defaults.entryTtl(Duration.ofMinutes(15)));
    perCacheConfig.put(
        CacheNames.ALL_DEVICE_DETAILS, defaults.entryTtl(Duration.ofMinutes(15)));
    perCacheConfig.put(
        CacheNames.DEVICE_DETAILS_BY_ID, defaults.entryTtl(Duration.ofMinutes(15)));
    perCacheConfig.put(
        CacheNames.ALL_DEVICE_DETAILS_AUDITS, defaults.entryTtl(Duration.ofMinutes(15)));
    perCacheConfig.put(
        CacheNames.DEVICE_DETAILS_AUDIT_BY_ID, defaults.entryTtl(Duration.ofMinutes(15)));
    perCacheConfig.put(
        CacheNames.ALL_DEVICE_TRANSFER_REQUESTS, defaults.entryTtl(Duration.ofMinutes(15)));
    perCacheConfig.put(
        CacheNames.DEVICE_TRANSFER_REQUEST_BY_ID, defaults.entryTtl(Duration.ofMinutes(15)));
    perCacheConfig.put(
        CacheNames.ALL_DEVICE_TRANSFER_MOVEMENTS, defaults.entryTtl(Duration.ofMinutes(15)));
    perCacheConfig.put(
        CacheNames.DEVICE_TRANSFER_MOVEMENT_BY_ID, defaults.entryTtl(Duration.ofMinutes(15)));
    perCacheConfig.put(CacheNames.ALL_PO_DETAILS, defaults.entryTtl(Duration.ofMinutes(15)));
    perCacheConfig.put(CacheNames.PO_DETAILS_BY_ID, defaults.entryTtl(Duration.ofMinutes(15)));
    perCacheConfig.put(CacheNames.ALL_PO_DOCUMENTS, defaults.entryTtl(Duration.ofMinutes(15)));
    perCacheConfig.put(CacheNames.PO_DOCUMENT_BY_ID, defaults.entryTtl(Duration.ofMinutes(15)));
    perCacheConfig.put(
        CacheNames.ALL_LNP_DEVICE_REQUESTS, defaults.entryTtl(Duration.ofMinutes(15)));
    perCacheConfig.put(
        CacheNames.LNP_DEVICE_REQUEST_BY_ID, defaults.entryTtl(Duration.ofMinutes(15)));
    perCacheConfig.put(
        CacheNames.ALL_LNP_DEVICE_REQUEST_MOVEMENTS, defaults.entryTtl(Duration.ofMinutes(15)));
    perCacheConfig.put(
        CacheNames.LNP_DEVICE_REQUEST_MOVEMENT_BY_ID, defaults.entryTtl(Duration.ofMinutes(15)));
    perCacheConfig.put(CacheNames.ALL_DC_CREDIT_NOTE, defaults.entryTtl(Duration.ofMinutes(15)));
    perCacheConfig.put(
        CacheNames.DC_CREDIT_NOTE_BY_ID, defaults.entryTtl(Duration.ofMinutes(15)));
    perCacheConfig.put(
        CacheNames.ALL_KFON_DC_DEVICE_REQUESTS, defaults.entryTtl(Duration.ofMinutes(15)));
    perCacheConfig.put(
        CacheNames.KFON_DC_DEVICE_REQUEST_BY_ID, defaults.entryTtl(Duration.ofMinutes(15)));
    perCacheConfig.put(
        CacheNames.ALL_DEVICE_DETAILS_MOVEMENTS, defaults.entryTtl(Duration.ofMinutes(15)));
    perCacheConfig.put(
        CacheNames.DEVICE_DETAILS_MOVEMENT_BY_ID, defaults.entryTtl(Duration.ofMinutes(15)));
    perCacheConfig.put(
        CacheNames.ALL_FAULTY_REQUESTS, defaults.entryTtl(Duration.ofMinutes(15)));
    perCacheConfig.put(
        CacheNames.FAULTY_REQUEST_BY_ID, defaults.entryTtl(Duration.ofMinutes(15)));

    return RedisCacheManager.builder(connectionFactory)
        .cacheDefaults(defaults)
        .withInitialCacheConfigurations(perCacheConfig)
        .build();
  }

  /**
   * Jackson serializer that embeds type metadata so Spring can deserialize generic types (e.g.
   * {@code List<CommonLookUp>}) correctly without extra configuration.
   */
  private GenericJackson2JsonRedisSerializer buildSerializer() {
    ObjectMapper mapper =
        new ObjectMapper()
            .registerModule(new JavaTimeModule())
            .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
            .activateDefaultTyping(
                BasicPolymorphicTypeValidator.builder()
                    .allowIfSubType("in.gov.kfon")
                    .allowIfSubType("java.util")
                    .build(),
                ObjectMapper.DefaultTyping.NON_FINAL,
                JsonTypeInfo.As.WRAPPER_ARRAY);

    return new GenericJackson2JsonRedisSerializer(mapper);
  }
}
