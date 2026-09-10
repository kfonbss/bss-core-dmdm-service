package in.gov.kfon.dmdm.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(
    name = "document_category_mapping",
    uniqueConstraints = {
      @UniqueConstraint(columnNames = {"document_type_id", "category_id"})
    })
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class DocumentCategoryMapping {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(name = "id", nullable = false, updatable = false)
  private UUID id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "document_type_id", nullable = false)
  private DocumentType documentType;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "category_id", nullable = false)
  private DocumentCategory category;

  @Column(name = "created_date", updatable = false)
  private LocalDateTime createdDate = LocalDateTime.now();
}
