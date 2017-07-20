package com.tli.amin.user.domain;

import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

/**
 *
 * @version 1.0
 * @author: Iain Porter iain.porter
 * @since 28/12/2012
 */
@Entity
@Table(name="rest_authorization_token")
public class AuthorizationToken extends AbstractPersistable<Long> {

    private final static Integer DEFAULT_TIME_TO_LIVE_IN_SECONDS = (60 * 60 * 24 * 30); //30 Days

    @Column(length=36)
    private String token;

    private Date timeCreated;

    private Date expirationDate;

    @JoinColumn(name = "user_id")
    @OneToOne(fetch = FetchType.LAZY)
    private RestUser restUser;

    public AuthorizationToken() {}

    public AuthorizationToken(RestUser restUser) {
        this(restUser, DEFAULT_TIME_TO_LIVE_IN_SECONDS);
    }

    public AuthorizationToken(RestUser restUser, Integer timeToLiveInSeconds) {
        this.token = UUID.randomUUID().toString();
        this.restUser = restUser;
        this.timeCreated = new Date();
        this.expirationDate = new Date(System.currentTimeMillis() + (timeToLiveInSeconds * 1000L));
    }

    public boolean hasExpired() {
        return this.expirationDate != null && this.expirationDate.before(new Date());
    }

    public String getToken() {
        return token;
    }

    public RestUser getRestUser() {
        return restUser;
    }

    public Date getTimeCreated() {
        return timeCreated;
    }
}
