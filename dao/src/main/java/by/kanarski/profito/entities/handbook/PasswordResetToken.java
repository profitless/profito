package by.kanarski.profito.entities.handbook;

import by.kanarski.profito.entities.registry.User;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

/**
 * @author Dzmitry Kanarski
 * @version 1.0
 */

@Entity
@DynamicUpdate
@DynamicInsert
@Data
@NoArgsConstructor
public class PasswordResetToken implements Serializable {

    public static final int EXPIRATION_TIME_IN_MINS = 24 * 60;
    private static final long serialVersionUID = -8011631406709233043L;

    private Integer userId;
    private User user;
    private String tokenValue;
    private Date tokenExpiryDate;

    @Builder
    public PasswordResetToken(Integer userId, User user, String tokenValue, Date tokenExpiryDate) {
        this.userId = userId;
        this.user = user;
        this.tokenValue = tokenValue;
        this.tokenExpiryDate = tokenExpiryDate;
    }

    public PasswordResetToken(String tokenValue) {
        this.tokenValue = tokenValue;
        this.tokenExpiryDate = calculateExpiryDate(EXPIRATION_TIME_IN_MINS);
    }

    @Id
    @GenericGenerator(name = "generator", strategy = "foreign",
            parameters = @Parameter(name = "property", value = "user"))
    @GeneratedValue(generator = "generator")
    @Column(unique = true, nullable = false)
    public Integer getUserId() {
        return userId;
    }

    @OneToOne(mappedBy = "passwordResetToken")
    @PrimaryKeyJoinColumn(
            name = "user_id",
            foreignKey = @ForeignKey(name = "fk_h_password_reset_token_r_user1")
    )
    public User getUser() {
        return user;
    }

    @Column(nullable = false)
    public String getTokenValue() {
        return tokenValue;
    }

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    public Date getTokenExpiryDate() {
        return tokenExpiryDate;
    }

    private Date calculateExpiryDate(final int expiryTimeInMinutes) {
        final Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(new Date().getTime());
        cal.add(Calendar.MINUTE, expiryTimeInMinutes);
        return new Date(cal.getTime().getTime());
    }

    public void updateToken(final String tokenValue) {
        this.tokenValue = tokenValue;
        this.tokenExpiryDate = calculateExpiryDate(EXPIRATION_TIME_IN_MINS);
    }

}