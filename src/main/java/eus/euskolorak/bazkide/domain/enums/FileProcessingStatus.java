package eus.euskolorak.bazkide.domain.enums;

/**
 * @author BICUGUAL
 */
public enum FileProcessingStatus {

    ERROR(0),         // Procesamiento fallido.
    UPLOADED(1),      // Fichero recibido pero aún no procesado.
    PROCESSING(2),    // Procesamiento en curso.
    PARTIALLY_PROCESSED(3), // Procesamiento completado parcialmente (opcional, si aplicable).
    PROCESSED(4);     // Procesamiento completado exitosamente.

    private final int code;

    FileProcessingStatus(int code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    // Método para convertir el valor numérico en el enum correspondiente
    public static FileProcessingStatus fromValue(Integer value) {
        for (FileProcessingStatus status : FileProcessingStatus.values()) {
            if (status.getCode().equals(value)) {
                return status;
            }
        }
        throw new IllegalArgumentException("Unexpected value: " + value);
    }

}
