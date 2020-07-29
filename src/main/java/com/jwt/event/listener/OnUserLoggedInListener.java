package com.jwt.event.listener;

import com.jwt.event.OnUserLoggedInEvent;
import com.jwt.repository.RefreshTokenRepository;
import com.jwt.security.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
public class OnUserLoggedInListener implements ApplicationListener<OnUserLoggedInEvent> {

    private RefreshTokenRepository refreshTokenRepository;

    @Autowired
    public OnUserLoggedInListener(RefreshTokenRepository refreshTokenRepository) {
        this.refreshTokenRepository = refreshTokenRepository;
    }

    /**
     * As soon as a logged in event is complete, invoke payload procedure in an another thread pool
     */
    @Override
    @Async
    public void onApplicationEvent(OnUserLoggedInEvent onUserLoggedInEvent) {
        checkStaleTokensForLoggedInUser(onUserLoggedInEvent);
    }

    /**
     * Delete all expired refresh tokens for that currently logged in user.
     * U can implement your custom logic here.
     * For example, if you want user to have only 5 active refresh tokens, your can remove old ones and etc.
     */
    private void checkStaleTokensForLoggedInUser(OnUserLoggedInEvent event) {
        final UserDetailsImpl userDetails = event.getUserDetails();
        final Long currentTimeInSeconds = Instant.now().getEpochSecond();
        refreshTokenRepository.deleteByUserIdAndExpiredInSecondsBefore(userDetails.getId(), currentTimeInSeconds);
    }
}
