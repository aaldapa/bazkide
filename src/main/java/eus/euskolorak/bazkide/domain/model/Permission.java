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
public class Permission {

    private String permissionName;
    private String description;

}
