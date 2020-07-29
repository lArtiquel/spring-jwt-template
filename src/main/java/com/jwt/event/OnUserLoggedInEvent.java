package com.jwt.event;

import com.jwt.security.UserDetailsImpl;
import org.springframework.context.ApplicationEvent;

public class OnUserLoggedInEvent extends ApplicationEvent {

    private UserDetailsImpl userDetails;

    /**
     * @param userDetails passing user details of currently logged in user to the event
     */
    public OnUserLoggedInEvent(UserDetailsImpl userDetails) {
        super(userDetails);
        this.userDetails = userDetails;
    }

    public UserDetailsImpl getUserDetails() {
        return userDetails;
    }

    public void setUserDetails(UserDetailsImpl userDetails) {
        this.userDetails = userDetails;
    }
}
