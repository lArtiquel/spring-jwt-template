package com.jwt.templates.arti_tsv.model;

import lombok.Data;
import lombok.NonNull;

/** Generated access token model (short-living token, not persisted in db). */
@Data
public class AccessToken {

    /** Access token */
    @NonNull
    private String token;

}
