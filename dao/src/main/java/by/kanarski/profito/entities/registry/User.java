package by.kanarski.profito.entities.registry;

import by.kanarski.profito.entities.AbstractEntity;
import by.kanarski.profito.entities.catalog.UserFunction;
import by.kanarski.profito.entities.catalog.UserStatus;
import by.kanarski.profito.entities.handbook.PasswordResetToken;
import by.kanarski.profito.entities.handbook.Phone;
import by.kanarski.profito.entities.handbook.VerificationToken;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 *
 * @author Dzmitry Kanarski
 * @version 1.0
 */

@Entity
@DynamicUpdate
@DynamicInsert
@AttributeOverride(name = "id", column = @Column(name = "user_id"))
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Accessors(chain = true)
@PrimaryKeyJoinColumn
public class User extends AbstractEntity {

    private static final long serialVersionUID = -4621405787796919012L;
    private String userEmail;
    private String userPassword;
    private Boolean userIsLocked;
    private Company company;
    private String userFirstName;
    private String userFatherName;
    private String userLastName;
    private Date userCreateTime;
    private User userParent;
    private Integer userChildQuantity;
    private String userSkype;
    private Set<Phone> phoneSet;
    private Set<UserFunction> userFunctionSet;
    private UserStatus userStatus;
    private VerificationToken verificationToken;
    private PasswordResetToken passwordResetToken;

    @Builder
    public User(Integer userId, String userEmail, String userPassword, Boolean userIsLocked, Company company,
                String userFirstName, String userFatherName, String userLastName, Date userCreateTime,
                User userParent, Integer userChildQuantity, String userSkype, Set<Phone> phoneSet,
                Set<UserFunction> userFunctionSet, UserStatus userStatus, VerificationToken verificationToken,
                PasswordResetToken passwordResetToken) {
        super(userId);
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        this.userIsLocked = userIsLocked;
        this.company = company;
        this.userFirstName = userFirstName;
        this.userFatherName = userFatherName;
        this.userLastName = userLastName;
        this.userCreateTime = userCreateTime;
        this.userParent = userParent;
        this.userChildQuantity = userChildQuantity;
        this.userSkype = userSkype;
        this.phoneSet = phoneSet;
        this.userFunctionSet = userFunctionSet;
        this.userStatus = userStatus;
        this.verificationToken = verificationToken;
        this.passwordResetToken = passwordResetToken;
    }

    @Builder

    @Column(nullable = false, length = 40)
    public String getUserEmail() {
        return userEmail;
    }

    @Column(nullable = false)
    public String getUserPassword() {
        return userPassword;
    }

    @Type(type = "org.hibernate.type.BooleanType")
    @Column(nullable = false, columnDefinition = "BIT default 0")
    public Boolean getUserIsLocked() {
        return userIsLocked;
    }

    // TODO: 09.05.2017 Сделал для регитрации
    @ManyToOne
    @JoinColumn(
            name = "company_id",
//            nullable = false,
            foreignKey = @ForeignKey(name = "fk_r_user_h_company1")
    )
    public Company getCompany() {
        return company;
    }

    @Column(nullable = false, length = 30)
    public String getUserFirstName() {
        return userFirstName;
    }

    @Column(length = 30)
    public String getUserFatherName() {
        return userFatherName;
    }

    @Column(nullable = false, length = 30)
    public String getUserLastName() {
        return userLastName;
    }

    @Column(nullable = false)
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    public Date getUserCreateTime() {
        return userCreateTime;
    }

    @ManyToOne
    @JoinColumn(
            name = "user_parent_id",
            foreignKey = @ForeignKey(name = "fk_r_user_r_user1")
    )
    public User getUserParent() {
        return userParent;
    }

//    @OneToMany
//    public Set<User> getChildUsersSet() {
//        return childUsersSet;
//    }

    @Column
    public Integer getUserChildQuantity() {
        return userChildQuantity;
    }

    @Column(nullable = false)
    public String getUserSkype() {
        return userSkype;
    }

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "nn_user_phone",
            joinColumns = @JoinColumn(
                    name = "user_id",
                    nullable = false,
                    foreignKey = @ForeignKey(name = "fk_nn_user_info_phone_h_phone1")
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "phone_id",
                    nullable = false,
                    foreignKey = @ForeignKey(name = "fk_nn_user_phone_r_user1")
            )
    )
    public Set<Phone> getPhoneSet() {
        return phoneSet;
    }

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "nn_user_user_function",
            joinColumns = @JoinColumn(
                    name = "user_id",
                    nullable = false,
                    foreignKey = @ForeignKey(
                            name = "fk_nn_user_user_function_c_user_function1"
                    )
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "user_function_id",
                    nullable = false,
                    foreignKey = @ForeignKey(
                            name = "fk_nn_user_user_function_r_user1"
                    )
            )
    )
    public Set<UserFunction> getUserFunctionSet() {
        return userFunctionSet;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(
            name = "user_status_id",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_r_user_c_user_status1")
    )
    public UserStatus getUserStatus() {
        return userStatus;
    }

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "user")
    public VerificationToken getVerificationToken() {
        return verificationToken;
    }

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "user")
    public PasswordResetToken getPasswordResetToken() {
        return passwordResetToken;
    }

    public enum Fields {userEmail, userPassword, userIsLocked, company, userFirstName, userFatherName, userLastName, userCreateTime, userParent, userChildQuantity, userSkype, phoneSet, userFunctionSet, userStatus, verificationToken, passwordResetToken, serialVersionUID}
}
