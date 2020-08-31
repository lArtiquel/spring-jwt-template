package com.jwt.templates.arti_tsv.payload.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class LoginRequest {

	@NotBlank
    private String email;

	@NotBlank
	private String password;

}
