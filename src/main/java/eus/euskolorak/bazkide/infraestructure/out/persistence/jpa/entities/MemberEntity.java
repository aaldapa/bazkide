package eus.euskolorak.bazkide.infraestructure.out.persistence.jpa.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.math.BigInteger;
import java.time.LocalDate;

/**
 * @author BICUGUAL
 */
@Data
@NoArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper=false)
@Table(name = "t_members")
@Entity
public class MemberEntity extends AuditableEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMember;

    @Column(name="id_membership")
    private Long idMembership;

    private Long memberNumber;
    private String dni;
    private String name;
    private String surname1;
    private String surname2;
    private LocalDate birthDate;
    private BigInteger phone1;
    private BigInteger phone2;
    private String email;
    private String address;
    private LocalDate startDate;
    private LocalDate endDate;

}
