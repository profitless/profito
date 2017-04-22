package by.kanarski.gksolutions.entities.catalog;

import by.kanarski.gksolutions.entities.AbstractEntity;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * @author Dzmitry Kanarski
 * @version 1.0
 */

@Entity
@AttributeOverride(name = "id", column = @Column(name = "user_status_id"))
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class UserStatus extends AbstractEntity {

    private static final long serialVersionUID = 2311595513154602828L;
    private String userStatusName;

    @Builder
    public UserStatus(Integer userStatusId, String userStatusName) {
        super(userStatusId);
        this.userStatusName = userStatusName;
    }

    @Column(nullable = false, length = 145)
    public String getUserStatusName() {
        return userStatusName;
    }

    public enum Fields {userStatusName, serialVersionUID}
}
