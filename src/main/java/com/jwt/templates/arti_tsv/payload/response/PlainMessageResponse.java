package com.jwt.templates.arti_tsv.payload.response;

import lombok.Data;
import lombok.NonNull;

/** Plain message response. */
@Data
public class PlainMessageResponse {

    /** Provided message to the frontend. */
    @NonNull
    private String message;

}
