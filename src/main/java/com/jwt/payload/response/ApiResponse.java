package com.jwt.payload.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.Data;
import lombok.NonNull;

/**
 * Generic Api Response model.
 * @param <T> payload type
 */
@Data
@JsonInclude(Include.NON_NULL)
public class ApiResponse<T extends IResponsePayload> {

    /**
     * Error status. True - successful operation, false - operation failed.
     */
    @NonNull
    private Boolean error;

    /**
     * Provided message to the frontend.
     */
    @NonNull
    private String message;

    /**
     * Some payload provided by server. Payload is not required.
     */
    private T payload;

    public ApiResponse(@NonNull Boolean error, @NonNull String message, T payload) {
        this.error = error;
        this.message = message;
        this.payload = payload;
    }

    public ApiResponse(@NonNull Boolean error, @NonNull String message) {
        this.error = error;
        this.message = message;
    }
}
