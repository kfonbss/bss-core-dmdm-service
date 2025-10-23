package in.gov.kfon.dmdm.contract;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Response<T> {
  private int status;
  private String message;
  private Object error;
  private T data;

  public static <T> Response<T> ok(T data, String message) {
    return Response.<T>builder()
        .status(200)
        .message(message == null ? "OK" : message)
        .error(null)
        .data(data)
        .build();
  }

  public static <T> Response<T> created(T data, String message) {
    return Response.<T>builder()
        .status(201)
        .message(message == null ? "Created" : message)
        .error(null)
        .data(data)
        .build();
  }

  public static <T> Response<T> fail(int status, String message, Object error) {
    return Response.<T>builder()
        .status(status)
        .message(message == null ? "Error" : message)
        .error(error)
        .data(null)
        .build();
  }
}
