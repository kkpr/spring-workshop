package com.tli.amin.user.api;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tli.amin.user.domain.AuthorizationToken;
import com.tli.amin.user.domain.RestUser;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author: Iain Porter
 */
@XmlRootElement
public class ExternalUser implements Principal {

    private String id;

    @Length(max=50)
    private String firstName;

    @Length(max=50)
    private String lastName;

    @NotNull
    @Email
    private String emailAddress;

    private boolean isVerified;

    @JsonIgnore
    private String role;

    private List<SocialProfile> socialProfiles = new ArrayList<SocialProfile>();

    public ExternalUser() {}

    public ExternalUser(String userId) {
        this.id = userId;
    }

    public ExternalUser(RestUser restUser) {
        this.id = restUser.getUuid().toString();
        this.emailAddress = restUser.getEmailAddress();
        this.firstName = restUser.getFirstName();
        this.lastName = restUser.getLastName();
        this.isVerified = restUser.isVerified();
        role = restUser.getRole().toString();
    }

    public ExternalUser(RestUser restUser, AuthorizationToken activeSession) {
        this(restUser);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public List<SocialProfile> getSocialProfiles() {
        return socialProfiles;
    }

    public String getId() {
        return id;
    }

    public boolean isVerified() {
        return isVerified;
    }

    public String getName() {
        return emailAddress;
    }

    public String getRole() {
        return role;
    }
}
