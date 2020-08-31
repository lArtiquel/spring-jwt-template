package com.jwt.templates.arti_tsv.payload.response;

import lombok.Data;
import lombok.NonNull;

import java.util.Collection;

@Data
public class AuthorizationInfoResponse {

    @NonNull
    private String accessToken;

    @NonNull
    private String refreshToken;

    @NonNull
    private Collection<String> authorities;

}
