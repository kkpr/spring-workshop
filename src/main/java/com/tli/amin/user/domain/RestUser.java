package com.tli.amin.user.domain;


import com.tli.amin.util.HashUtil;
import com.tli.amin.model.BaseEntity;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.springframework.util.StringUtils;

import javax.persistence.*;
import java.security.MessageDigest;
import java.util.*;


/**
* RestUser: porter
* Date: 09/03/2012
* Time: 18:56
*/
@Entity
@Table(name="rest_user")
public class RestUser extends BaseEntity {

     /**
     * Add additional salt to password hashing
     */
    private static final String HASH_SALT = "d8a8e885-ecce-42bb-8332-894f20f0d8ed";

    private static final int HASH_ITERATIONS = 1000;

    private String firstName;
    private String lastName;
    private String emailAddress;
    private String hashedPassword;
    private boolean isVerified;

    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToMany(mappedBy="restUser",
                 targetEntity=VerificationToken.class,
                 cascade= CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<VerificationToken> verificationTokens = new ArrayList<VerificationToken>();

    @OneToOne(fetch = FetchType.LAZY,
            mappedBy = "restUser",
            cascade = CascadeType.ALL)
    private AuthorizationToken authorizationToken;

    public RestUser() {
        this(UUID.randomUUID());
    }

    public RestUser(UUID uuid) {
        super(uuid);
        setRole(Role.anonymous); //all user are anonymous until credentials are proved
    }

    public void setHashedPassword(String hashedPassword) {
        this.hashedPassword = hashedPassword;
    }

    public String getHashedPassword() {
        return this.hashedPassword;
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

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public boolean hasRole(Role role) {
        return role.equals(this.role);
    }


    public boolean equals(Object otherUser) {
        boolean response = false;

        if(otherUser == null) {
            response = false;
        }
        else if(! (otherUser instanceof RestUser)) {
            response = false;
        }
        else {
            if(((RestUser)otherUser).getUuid().equals(this.getUuid())) {
                response = true;
            }
        }

        return response;
    }

    public int hashCode() {
        return getUuid().hashCode();
    }

    public String getName() {
        if(StringUtils.hasText(getFirstName())) {
           return getFirstName() + " " + getLastName();
        }
        return "";
    }


    public synchronized void addVerificationToken(VerificationToken token) {
        verificationTokens.add(token);
    }

    public synchronized List<VerificationToken> getVerificationTokens() {
        return Collections.unmodifiableList(this.verificationTokens);
    }

    public synchronized void setAuthorizationToken(AuthorizationToken token) {


        this.authorizationToken = token;
    }

    public synchronized AuthorizationToken getAuthorizationToken() {
        return authorizationToken;
    }

    /**
     * If the restUser has a VerificationToken of type VerificationTokenType.lostPassword
     * that is active return it otherwise return null
     *
     * @return verificationToken
     */
    public VerificationToken getActiveLostPasswordToken() {
        return getActiveToken(VerificationToken.VerificationTokenType.lostPassword);
    }

    /**
     * If the restUser has a VerificationToken of type VerificationTokenType.emailVerification
     * that is active return it otherwise return null
     *
     * @return verificationToken
     */
    public VerificationToken getActiveEmailVerificationToken() {
        return getActiveToken(VerificationToken.VerificationTokenType.emailVerification);
    }

    /**
     * If the restUser has a VerificationToken of type VerificationTokenType.emailRegistration
     * that is active return it otherwise return null
     *
     * @return verificationToken
     */
    public VerificationToken getActiveEmailRegistrationToken() {
        return getActiveToken(VerificationToken.VerificationTokenType.emailRegistration);
    }

    private VerificationToken getActiveToken(VerificationToken.VerificationTokenType tokenType) {
         VerificationToken activeToken = null;
        for (VerificationToken token : getVerificationTokens()) {
            if (token.getTokenType().equals(tokenType)
                    && !token.hasExpired() && !token.isVerified()) {
                activeToken = token;
                break;
            }
        }
        return activeToken;
    }

    public boolean isVerified() {
        return isVerified;
    }

    public void setVerified(boolean verified) {
        isVerified = verified;
    }

    /**
     * Hash the password using salt values
     * See https://www.owasp.org/index.php/Hashing_Java
     *
     * @param passwordToHash
     * @return hashed password
     */
    public String hashPassword(String passwordToHash) throws Exception {
        return hashToken(passwordToHash, getUuid().toString() + HASH_SALT );
    }


    private String hashToken(String token, String salt) throws Exception {
        return HashUtil.byteToBase64(getHash(HASH_ITERATIONS, token, salt.getBytes()));
    }

    public byte[] getHash(int numberOfIterations, String password, byte[] salt) throws Exception {
       MessageDigest digest = MessageDigest.getInstance("SHA-256");
       digest.reset();
       digest.update(salt);
       byte[] input = digest.digest(password.getBytes("UTF-8"));
       for (int i = 0; i < numberOfIterations; i++) {
           digest.reset();
           input = digest.digest(input);
       }
       return input;
   }

}
