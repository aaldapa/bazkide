package eus.euskolorak.bazkide.infraestructure.out.persistence.jpa.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Set;

/**
 * @author BICUGUAL
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "SEC_ROLES")
public class RoleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ROLENAME", length = 50)
    private String roleName;

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

    /*
        No necesito
    @ManyToMany(mappedBy = "roles")  // se refiere al campo en UserEntity
    private Set<UserEntity> users = new HashSet<>();
     */

    @ManyToMany
    @JoinTable(
            name = "SEC_ROLES_PERMISSIONS", // nombre de la tabla intermedia
            joinColumns = @JoinColumn(name = "ROLENAME"),  // FK a RoleEntity
            inverseJoinColumns = @JoinColumn(name = "PERMISSIONNAME")  // FK a PermissionEntity
    )
    @ToString.Exclude
    private Set<PermissionEntity> permissions;
}
