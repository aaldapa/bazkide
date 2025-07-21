package eus.euskolorak.bazkide.domain.vos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;

/**
 * @author BICUGUAL
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ContactDataVO {

    private BigInteger phone1;
    private BigInteger phone2;
    private String email;
    private String address;

}
