package by.kanarski.profito.entities.handbook;

import by.kanarski.profito.entities.registry.User;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;

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
public class VerificationToken implements Serializable {

    public static final int EXPIRATION_TIME_IN_MINS = 24 * 60;

    private static final long serialVersionUID = 4087513937221525574L;

    private Integer userId;
    private User user;
    private String tokenValue;
    private Date tokenExpiryDate;

    @Builder
    public VerificationToken(Integer userId, User user, String tokenValue, Date tokenExpiryDate) {
        this.userId = userId;
        this.user = user;
        this.tokenValue = tokenValue;
        this.tokenExpiryDate = tokenExpiryDate;
    }

    public VerificationToken(String tokenValue, User user) {
        this.tokenValue = tokenValue;
        this.user = user;
        this.tokenExpiryDate = calculateExpiryDate(EXPIRATION_TIME_IN_MINS);
    }

    @Id
    @Basic
    @GenericGenerator(
            name = "generator",
            strategy = "foreign",
            parameters = @org.hibernate.annotations.Parameter(name = "property", value = "user")
    )
    @GeneratedValue(generator = "generator")
    public Integer getUserId() {
        return userId;
    }

    @OneToOne
    @PrimaryKeyJoinColumn(
            name = "user_id",
            foreignKey = @ForeignKey(name = "fk_h_verification_token_r_user1")
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

    @Override
    public String toString() {
        return "VerificationToken{" +
                "userId=" + userId +
                ", user id=" + user.getId() +
                ", tokenValue='" + tokenValue + '\'' +
                ", tokenExpiryDate=" + tokenExpiryDate +
                '}';
    }
}