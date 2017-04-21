package by.kanarski.gksolutions.entities;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;

/**
 *
 * @author Dzmitry Kanarski
 * @version 1.0
 */

@Entity
@AttributeOverride(name = "id", column = @Column(name = "user_id"))
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class User extends AbstractEntity {

    private static final long serialVersionUID = 3760054555990552525L;
    private String userEmail;
    private String userPassword;
    private Byte userIsLocked;
    private Company company;
    private String userFirstName;
    private String userFatherName;
    private String userLastName;
    private Timestamp userCreateTime;
    private User userParent;
//    private Set<User> childUsersSet;
    private Integer userChildQuantity;
    private String skype;
    private Set<Phone> phoneSet;
    private Set<UserFunction> userFunctionSet;
    private UserStatus userUserStatus;

    @Builder
    public User(Integer userId, String userEmail, String userPassword, Byte userIsLocked, Company company,
                String userFirstName, String userFatherName, String userLastName, Timestamp userCreateTime,
                User userParent, Integer userChildQuantity, String skype, Set<Phone> phoneSet,
                Set<UserFunction> userFunctionSet, UserStatus userUserStatus) {
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
        this.skype = skype;
        this.phoneSet = phoneSet;
        this.userFunctionSet = userFunctionSet;
        this.userUserStatus = userUserStatus;
    }

    @Column(nullable = false, length = 40)
    public String getUserEmail() {
        return userEmail;
    }

    @Column(nullable = false)
    public String getUserPassword() {
        return userPassword;
    }

    @Column(nullable = false)
    public Byte getUserIsLocked() {
        return userIsLocked;
    }

    @ManyToOne
    @JoinColumn(
            name = "company_id",
            nullable = false,
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
    public Timestamp getUserCreateTime() {
        return userCreateTime;
    }

    @ManyToOne
    @JoinColumn(
            name = "user_parent_id",
            nullable = true,
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

    @Column(unique = true)
    public String getSkype() {
        return skype;
    }

    @ManyToMany
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

    @ManyToMany
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

    @ManyToOne
    @JoinColumn(
            name = "user_status_id",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_r_user_c_user_status1")
    )
    public UserStatus getUserUserStatus() {
        return userUserStatus;
    }

    public enum Fields {userEmail, userPassword, userIsLocked, company, userFirstName, userFatherName, userLastName, userCreateTime, userParent, userChildQuantity, skype, phoneSet, userFunctionSet, userUserStatus, serialVersionUID}
}
