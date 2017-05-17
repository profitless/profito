package by.kanarski.profito.entities.journal;

import by.kanarski.profito.entities.AbstractEntity;
import by.kanarski.profito.entities.registry.User;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

/**
 * @author Dzmitry Kanarski
 * @version 1.0
 */

@Entity
@AttributeOverride(name = "id", column = @Column(name = "user_history_id"))
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class UserHistory extends AbstractEntity {

    private static final long serialVersionUID = 433417541097446364L;
    private User user;
    private String userHistoryAction;
    private Date userHistoryTimestamp;

    @Builder
    public UserHistory(Integer userHistoryId, User user, String userHistoryAction, Date userHistoryTimestamp) {
        super(userHistoryId);
        this.user = user;
        this.userHistoryAction = userHistoryAction;
        this.userHistoryTimestamp = userHistoryTimestamp;
    }

    @ManyToOne
    @JoinColumn(
            name = "user_id",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_j_user_history_r_user1")
    )
    public User getUser() {
        return user;
    }

    @Column(nullable = false, length = 200)
    public String getUserHistoryAction() {
        return userHistoryAction;
    }

    @Column
    @Temporal(TemporalType.TIMESTAMP)
    public Date getUserHistoryTimestamp() {
        return userHistoryTimestamp;
    }

    public enum Fields {user, userHistoryAction, userHistoryTimestamp, serialVersionUID}
}
