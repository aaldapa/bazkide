package eus.euskolorak.bazkide.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author BICUGUAL
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MemberType {

    private Long idMemberType;
    private String label;
    private String description;

}
