package com.tli.amin.model;

import org.springframework.data.jpa.domain.AbstractPersistable;
import org.springframework.util.Assert;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

/**
 * Simple JavaBean domain object. Base class for all JPA Entities.
 *
 *@author KrishnaPrasad
 */
@MappedSuperclass
public abstract class BaseEntity extends AbstractPersistable<Long> {

    /**
     *  All objects will have a unique UUID which allows for the decoupling from DB generated ids
     *
     */
    private UUID uuid;

    @Version
    private int version;

    private Date timeCreated;

    public BaseEntity() {
        this(UUID.randomUUID());
    }
    public BaseEntity(UUID guid) {
        Assert.notNull(guid, "UUID is required");
        setUuid(guid);
        this.timeCreated = new Date();
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    @Override
    public int hashCode() {
        return getUuid().hashCode();
    }

    /**
     * In most instances we can rely on the UUID to identify the object.
     * Subclasses may want a user friendly identifier for constructing easy to read urls
     *
     * <code>
     *    /user/1883c578-76be-47fb-a5c1-7bbea3bf7fd0 using uuid as the identifier
     *
     *    /user/jsmith using the username as the identifier
     *
     * </code>
     *
     * @return Object unique identifier for the object
     */
    public Object getIdentifier() {
        return getUuid().toString();
    }

    public int getVersion() {
        return version;
    }

    public Date getTimeCreated() {
        return timeCreated;
    }

}
