package eus.euskolorak.bazkide.domain.enums;

/**
 * @author BICUGUAL
 */
public enum PeriodicityEnum {
    MENSUAL(1),
    BIMENSUAL(2),
    TRIMESTRAL(3),
    CUATRIMESTRAL(4),
    SEMESTRAL(6),
    ANUAL(12);

    private final Integer value;

    PeriodicityEnum(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    // Método para convertir el valor numérico en el enum correspondiente
    public static PeriodicityEnum fromValue(Integer value) {
        for (PeriodicityEnum periodicity : PeriodicityEnum.values()) {
            if (periodicity.getValue().equals(value)) {
                return periodicity;
            }
        }
        throw new IllegalArgumentException("Unexpected value: " + value);
    }
}
