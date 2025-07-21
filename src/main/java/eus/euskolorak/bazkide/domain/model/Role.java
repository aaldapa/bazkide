package eus.euskolorak.bazkide.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * @author BICUGUAL
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Role {

    private String roleName;
    private String description;
    private List<Permission> permissions = new ArrayList<>();

}
