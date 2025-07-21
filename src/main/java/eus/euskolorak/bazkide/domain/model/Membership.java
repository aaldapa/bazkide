package eus.euskolorak.bazkide.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author BICUGUAL
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Membership {

    private Long idMembership;
    private FeeType feeType;
    private List<Member> members;
    private String membershipName;
    private String accountNumber;
    private String iban;

}
