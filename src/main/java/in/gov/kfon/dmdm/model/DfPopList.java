package in.gov.kfon.dmdm.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.UUID;
import lombok.*;

@Entity
@Table(name = "df_pop_list")
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DfPopList {

  @Id
  @Column(name = "id", nullable = false)
  private UUID id;

  @Column(name = "df_pop_list_id", updatable = false)
  private Integer dfPopListId;

  @Column(name = "pop_name")
  private String name;

  @Column(length = 50)
  private String code;

  @Column(name = "name_in_local", length = 100)
  private String nameInLocal;

  @Column(name = "is_active")
  private Boolean isActive = true;
}
