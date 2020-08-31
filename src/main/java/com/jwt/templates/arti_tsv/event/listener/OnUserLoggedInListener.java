package com.jwt.templates.arti_tsv.event.listener;

import com.jwt.templates.arti_tsv.event.OnUserLoggedInEvent;
import com.jwt.templates.arti_tsv.repository.RefreshTokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionalEventListener;

import java.time.Instant;

@Component
public class OnUserLoggedInListener {

    private RefreshTokenRepository refreshTokenRepository;

    @Autowired
    public OnUserLoggedInListener(RefreshTokenRepository refreshTokenRepository) {
        this.refreshTokenRepository = refreshTokenRepository;
    }

    /**
     * Delete all expired refresh tokens for that currently logged in user.
     * U can implement your custom logic here.
     * For example, if you want user to have only 5 active refresh tokens, your can remove old ones and etc.
     */
    @Async
    @TransactionalEventListener
    public void handleUserLoggedInEvent(OnUserLoggedInEvent onUserLoggedInEvent) {
        final String userId = onUserLoggedInEvent.getUserId();
        final Long currentTimeInSeconds = Instant.now().getEpochSecond();
        refreshTokenRepository.deleteByUserIdAndExpiredInSecondsBefore(userId, currentTimeInSeconds);
    }

}
