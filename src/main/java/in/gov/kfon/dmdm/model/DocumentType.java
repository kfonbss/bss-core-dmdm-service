package in.gov.kfon.dmdm.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "document_type")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class DocumentType {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(name = "id", nullable = false, updatable = false)
  private UUID id;

  @Column(name = "document_name", nullable = false, unique = true, length = 255)
  private String documentName;

  @Column(name = "is_active")
  private Boolean isActive = true;

  @Column(name = "created_date", updatable = false)
  private LocalDateTime createdDate = LocalDateTime.now();

  @Column(name = "updated_date")
  private LocalDateTime updatedDate = LocalDateTime.now();
}
