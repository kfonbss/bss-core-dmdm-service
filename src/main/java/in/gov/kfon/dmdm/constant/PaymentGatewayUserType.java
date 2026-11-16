package in.gov.kfon.dmdm.constant;

import java.util.Arrays;

/** Who a payment gateway is offered to in a state. */
public enum PaymentGatewayUserType {
  /** Subscriber online recharge. */
  SUBSCRIBER,
  /** Partner wallet top-up. */
  PARTNER;

  /**
   * Parses a user type, case-insensitive. {@code LNP} is accepted as {@link #PARTNER}, the value
   * the gateway fetch-all API used before this enum existed.
   *
   * @throws IllegalArgumentException for any other value
   */
  public static PaymentGatewayUserType from(String value) {
    String key = value == null ? "" : value.trim().toUpperCase();
    if ("LNP".equals(key)) {
      return PARTNER;
    }
    return Arrays.stream(values())
        .filter(type -> type.name().equals(key))
        .findFirst()
        .orElseThrow(
            () ->
                new IllegalArgumentException(
                    "Invalid userType: " + value + ". Allowed values: SUBSCRIBER, PARTNER"));
  }
}
