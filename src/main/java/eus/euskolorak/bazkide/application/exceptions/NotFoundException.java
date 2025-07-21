package eus.euskolorak.bazkide.application.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.ErrorResponseException;

import java.time.Instant;

/**
 * @author BICUGUAL
 */
public class NotFoundException extends ErrorResponseException {


    public NotFoundException() {
        super(HttpStatus.NOT_FOUND, problemDetailFrom(null), null);
    }

    public NotFoundException(String message) {
        super(HttpStatus.NOT_FOUND, problemDetailFrom(message), null);
    }

    private static ProblemDetail problemDetailFrom(String detail) {
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, detail);
        //problemDetail.setType(URI.create("http://localhost:8080/errors/not-found"));
        problemDetail.setTitle("Entity not found");
        //problemDetail.setInstance(URI.create(path));
        problemDetail.setProperty("timestamp", Instant.now()); // additional data
        return problemDetail;
    }

}
