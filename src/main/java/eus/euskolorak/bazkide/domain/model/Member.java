package eus.euskolorak.bazkide.domain.model;

import eus.euskolorak.bazkide.domain.vos.ContactDataVO;
import eus.euskolorak.bazkide.domain.vos.ContactDataVO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * @author BICUGUAL
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Member {

    private Long idMember;
    private Long idMembership;
    private Long memberNumber;
    private LocalDate birthDate;
    private String dni;
    private String name;
    private String surname1;
    private String surname2;
    private ContactDataVO contactData;
    private LocalDate startDate;
    private LocalDate endDate;

}

