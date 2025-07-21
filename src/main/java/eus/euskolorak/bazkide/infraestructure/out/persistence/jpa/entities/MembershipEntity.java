package eus.euskolorak.bazkide.infraestructure.out.persistence.jpa.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

/**
 * @author BICUGUAL
 */
@Data
@NoArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper=false)
@Table(name = "t_memberships")
@Entity
public class MembershipEntity extends AuditableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMembership;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name="id_fee_type")
    private FeeTypeEntity feeType;

//    @OneToMany(mappedBy = "membership", cascade = CascadeType.PERSIST, orphanRemoval = true)
    @OneToMany( cascade = CascadeType.DETACH)
    @OrderBy("idMember ASC")
    @JoinColumn(name = "id_membership")
    private List<MemberEntity> members;

    private String membershipName;
    private String accountNumber;
    private String iban;

}
