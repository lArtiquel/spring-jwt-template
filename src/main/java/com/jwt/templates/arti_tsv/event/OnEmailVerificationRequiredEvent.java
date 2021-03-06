package com.jwt.templates.arti_tsv.event;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public class OnEmailVerificationRequiredEvent extends ApplicationEvent {

    private String mailAddress;
    private String token;

    public OnEmailVerificationRequiredEvent(String mailAddress, String token) {
        super("Email verification required for: " + mailAddress + " with token: " + token);
        this.mailAddress = mailAddress;
        this.token = token;
    }

}
