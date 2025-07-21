package eus.euskolorak.bazkide.infraestructure.out.persistence.jpa.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author BICUGUAL
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "SEC_PERMISSIONS")
public class PermissionEntity {

    @Id
    @Column(name = "PERMISSIONNAME", length = 50)
    private String permissionName;

    @Column(name = "DESCRIPTION", length = 300)
    private String description;

    @Column(name = "CREATED_ON")
    private LocalDateTime createdOn;

    @Column(name = "CREATED_BY", length = 50)
    private String createdBy;

    @Column(name = "UPDATED_ON")
    private LocalDateTime updatedOn;

    @Column(name = "UPDATED_BY", length = 50)
    private String updatedBy;

    /* No necesito mapeo de permisos a roles
    @ManyToMany(mappedBy = "permissions")  // se refiere al campo en RoleEntity
    private Set<RoleEntity> users = new HashSet<>();
     */

}
