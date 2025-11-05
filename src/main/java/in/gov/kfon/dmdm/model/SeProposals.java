package in.gov.kfon.dmdm.model;


import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "se_proposals")
@Data
public class SeProposals extends Auditor{
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "proposals_id")
    private UUID proposalsId;

    @Column(name = "code")
    private String code;

    @Column(name = "name")
    private String name;

    @Column(name = "name_in_local")
    private String nameInLocal;

    @Column(name = "is_active")
    private Boolean isActive;

    @Column(name = "id")
    private Integer id;

    @Column(name = "customerid")
    private Integer customerId;

    @Column(name = "proposal_name")
    private String proposalName;

    @Column(name = "con_count")
    private Integer conCount;

    @Column(name = "service_days")
    private Integer serviceDays;

    @Column(name = "remarks")
    private String remarks;

    @Column(name = "approve_status")
    private Integer approveStatus;

    @Column(name = "is_rejected")
    private Integer isRejected;
}
