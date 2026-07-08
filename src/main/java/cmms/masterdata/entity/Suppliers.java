package cmms.masterdata.entity;

import cmms.masterdata.usercontext.UserContext;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SoftDelete;
import org.hibernate.annotations.SoftDeleteType;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import java.time.LocalDateTime;
import java.time.ZoneId;

@Entity
@Table(name = "suppliers")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@SoftDelete(strategy = SoftDeleteType.DELETED, columnName = "is_deleted")
public class Suppliers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "supplier_name", nullable = false)
    private String supplierName;

    @Column(name = "supplier_code", nullable = false, unique = true)
    private String supplierCode;

    @Email(message = "Invalid email format")
    @Column(name = "contact_email", nullable = false)
    private String contactEmail;

    @Min(value = 1, message = "Rating must be at least 1")
    @Max(value = 5, message = "Rating cannot exceed 5")
    @Column(nullable = false)
    private Integer rating;

    @Pattern(
            regexp = "^\\d{2}[A-Z]{5}\\d{4}[A-Z][A-Z\\d]Z[A-Z\\d]$",
            message = "Invalid 15-character Indian GSTIN format"
    )
    private String gstin;

    @Column(name = "gst_number", length = 15)
    private String gstNumber;

    @Builder.Default
    @Column(name = "is_active", nullable = false)
    private Boolean isActive = true;

    @CreatedDate
    @Column(name = "created_at", nullable = false ,columnDefinition = "TIMESTAMP DEFAULT '2026-06-23 19:54:30'")
    private LocalDateTime createdAt;

    @CreatedBy
    @Column(name = "created_by", nullable = false , columnDefinition = "BIGINT DEFAULT 1")
    private Long createdBy;

    @LastModifiedDate
    @Column(name = "last_modified_at", nullable = false ,columnDefinition = "TIMESTAMP DEFAULT '2026-06-23 19:54:30'")
    private LocalDateTime lastModifiedAt;

    @LastModifiedBy
    @Column(name = "last_modified_by", nullable = false, columnDefinition = "BIGINT DEFAULT 1")
    private Long lastModifiedBy;

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now(ZoneId.of("UTC"));
        this.lastModifiedAt = LocalDateTime.now(ZoneId.of("UTC"));

        this.createdBy = UserContext.getUserId();
        this.lastModifiedBy = UserContext.getUserId();
    }

    @PreUpdate
    protected void onUpdate() {
        this.lastModifiedAt = LocalDateTime.now(ZoneId.of("UTC"));
        this.lastModifiedBy = UserContext.getUserId();
    }

}
