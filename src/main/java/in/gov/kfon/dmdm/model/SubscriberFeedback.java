package in.gov.kfon.dmdm.model;

import jakarta.persistence.*;
import java.util.UUID;
import lombok.*;

@Entity
@Table(name = "subscriber_feedback")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SubscriberFeedback extends Auditor{

    @Id
    @Column(name = "id", nullable = false, updatable = false)
    private UUID id;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "feedback_id")
    private Long feedback_id;

    @Column(name = "subscriberid")
    private Long subscriberId;

    @Column(length = 256)
    private String username;

    @Column(name = "partnerid")
    private Long partnerId;

    @Column(name = "partnername")
    private String partnerName;

    @Column(name = "ticketid")
    private Long ticketId;

    @Column(length = 100)
    private String circle;

    private Integer rating;

    @Column(columnDefinition = "TEXT")
    private String feedback;

    @Column(name = "status")
    private Integer status = 1;

    @Column(length = 50)
    private String code;

    @Column(length = 256)
    private String name;

    @Column(name = "name_in_local", length = 256)
    private String nameInLocal;

    @Column(name = "is_active")
    private Boolean isActive = true;
}
