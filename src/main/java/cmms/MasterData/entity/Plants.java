package cmms.MasterData.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "plants")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Plants {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false, unique = true)
    private String code;

    @Column(nullable = false)
    private String location;

    @Column(name = "capacity_per_day", nullable = false)
    private Integer capacityPerDay;

    @Builder.Default
    @Column(name = "is_active", nullable = false)
    private Boolean isActive = true;


//    @Column(name = "last_modified_at", nullable = false)
//    @NotNull(message = "Last modified date cannot be null")
//    private LocalDateTime lastModifiedAt = LocalDateTime.MIN;
//
//
//    @Column(name = "last_modified_by ",nullable = false)
//    private Long lastModifiedBy = 0L;

}

