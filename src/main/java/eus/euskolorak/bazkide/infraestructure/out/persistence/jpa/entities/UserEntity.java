package eus.euskolorak.bazkide.infraestructure.out.persistence.jpa.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @author BICUGUAL
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
@Table(name = "SEC_USERS")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USERNAME", length = 50)
    private String username;

    @Column(name = "PASSWORD", nullable = false, length = 256)
    private String password;

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

    @ManyToMany
    @JoinTable(
            name = "SEC_USERS_ROLES", // nombre de la tabla intermedia
            joinColumns = @JoinColumn(name = "USERNAME"),  // FK a UserEntity
            inverseJoinColumns = @JoinColumn(name = "ROLENAME")  // FK a RoleEntity
    )
    @ToString.Exclude
    private List<RoleEntity> roles = new ArrayList<>();
}



