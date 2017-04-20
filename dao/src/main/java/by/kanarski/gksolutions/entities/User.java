package by.kanarski.gksolutions.entities;

import lombok.Builder;
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
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class User extends AbstractEntity {

    private static final long serialVersionUID = 755092399090937570L;

    private String firstName;
    private String middleName;
    private String lastName;
    private String email;
    private String password;
    private String skype;
    private Set<Phone> phoneSet;
    private Company company;
    private Set<User> childUsersSet;
    private User parentUser;
    private Timestamp createTime;
    private Set<Role> roleSet;
    private Status userStatus;

    @Builder
    public User(Integer userId, String password, String firstName, String middleName, String lastName, String email,
                String skype, Set<Phone> phoneSet, Company company, Set<User> childUsersSet, User parentUser,
                Timestamp createTime, Set<Role> roleSet, Status userStatus) {
        super(userId);
        this.password = password;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.email = email;
        this.skype = skype;
        this.phoneSet = phoneSet;
        this.company = company;
        this.childUsersSet = childUsersSet;
        this.parentUser = parentUser;
        this.createTime = createTime;
        this.roleSet = roleSet;
        this.userStatus = userStatus;
    }

    @Column(nullable = false)
    public String getPassword() {
        return password;
    }

    @Column(nullable = false)
    public String getFirstName() {
        return firstName;
    }

    @Column
    public String getMiddleName() {
        return middleName;
    }

    @Column(nullable = false)
    public String getLastName() {
        return lastName;
    }

    @ManyToMany
    @JoinTable(
            name = "user_phones",
            joinColumns = @JoinColumn(
                    name = "user_id",
                    nullable = false,
                    foreignKey = @ForeignKey(name = "fk_user_phone")
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "phone_id",
                    nullable = false,
                    foreignKey = @ForeignKey(name = "fk_phone_user")
            )
    )
    public Set<Phone> getPhoneSet() {
        return phoneSet;
    }

    @ManyToOne
    public Company getCompany() {
        return company;
    }

    @OneToMany
    public Set<User> getChildUsersSet() {
        return childUsersSet;
    }

    @ManyToOne
    public User getParentUser() {
        return parentUser;
    }

    @Column(nullable = false)
    public Timestamp getCreateTime() {
        return createTime;
    }

    @Column(
            unique = true,
            nullable = false
    )
    public String getEmail() {
        return email;
    }

    @Column(unique = true)
    public String getSkype() {
        return skype;
    }

    @ManyToMany
    @JoinTable(
            name = "user_user_roles",
            joinColumns = @JoinColumn(
                    name = "user_id",
                    nullable = false,
                    foreignKey = @ForeignKey(name = "fk_user_phone")
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "role_id",
                    nullable = false,
                    foreignKey = @ForeignKey(name = "fk_role_user")
            )
    )
    public Set<Role> getRoleSet() {
        return roleSet;
    }

    @ManyToOne
    @JoinColumn(
            name = "status_id",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_user_status")
    )
    public Status getUserStatus() {
        return userStatus;
    }

    public enum Fields {firstName, middleName, lastName, email, password, skype, phoneSet, company, childUsersSet, parentUser, createTime, roleSet, userStatus, serialVersionUID}
}
