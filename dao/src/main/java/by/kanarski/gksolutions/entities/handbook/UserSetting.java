package by.kanarski.gksolutions.entities.handbook;

import by.kanarski.gksolutions.entities.AbstractEntity;
import by.kanarski.gksolutions.entities.registry.User;
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
@AttributeOverride(name = "id", column = @Column(name = "user_setting_id"))
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class UserSetting extends AbstractEntity {

    private static final long serialVersionUID = 7963303516490138708L;
    private Date userSettingShipmentFrom;
    private Date userSettingShipmentTo;
    private User user;
    private CountryArray countryArrayDepart;
    private CountryArray countryArrayArrival;

    @Builder
    public UserSetting(Integer userSettingId, Date userSettingShipmentFrom, Date userSettingShipmentTo, User user,
                       CountryArray countryArrayDepart, CountryArray countryArrayArrival) {
        super(userSettingId);
        this.userSettingShipmentFrom = userSettingShipmentFrom;
        this.userSettingShipmentTo = userSettingShipmentTo;
        this.user = user;
        this.countryArrayDepart = countryArrayDepart;
        this.countryArrayArrival = countryArrayArrival;
    }

    @Column(columnDefinition = "DATETIME")
    public Date getUserSettingShipmentFrom() {
        return userSettingShipmentFrom;
    }

    @Column(columnDefinition = "DATETIME")
    public Date getUserSettingShipmentTo() {
        return userSettingShipmentTo;
    }

    @ManyToOne
    @JoinColumn(
            name = "user_id",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_h_user_setting_r_user1")
    )
    public User getUser() {
        return user;
    }

    @ManyToOne
    @JoinColumn(
            name = "country_array_id_depart",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_h_user_setting_h_country_array1")
    )
    public CountryArray getCountryArrayDepart() {
        return countryArrayDepart;
    }

    @ManyToOne
    @JoinColumn(
            name = "country_array_id_arrival",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_h_user_setting_h_country_array2")
    )
    public CountryArray getCountryArrayArrival() {
        return countryArrayArrival;
    }

    public enum Fields {userSettingShipmentFrom, userSettingShipmentTo, user, countryArrayDepart, countryArrayArrival, serialVersionUID}
}
