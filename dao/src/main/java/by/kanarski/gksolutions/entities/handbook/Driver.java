package by.kanarski.gksolutions.entities.handbook;

import by.kanarski.gksolutions.entities.AbstractEntity;
import by.kanarski.gksolutions.entities.registry.Forwarder;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;

/**
 * @author Dzmitry Kanarski
 * @version 1.0
 */

@Entity
@AttributeOverride(name = "id", column = @Column(name = "driver_id"))
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class Driver extends AbstractEntity {

    private static final long serialVersionUID = 7557592177739833468L;
    private Forwarder forwarder;
    private String driverFirstName;
    private String driverLastName;
    private String driverFatherName;
    private String driverPassportNumber;
    private Date driverPassportWhen;
    private String driverPassportWhom;
    private String driverInfo;
    private Phone phone;

    @Builder
    public Driver(Integer driverId, Forwarder forwarder, String driverFirstName, String driverLastName,
                  String driverFatherName, String driverPassportNumber, Date driverPassportWhen,
                  String driverPassportWhom, String driverInfo, Phone phone) {
        super(driverId);
        this.forwarder = forwarder;
        this.driverFirstName = driverFirstName;
        this.driverLastName = driverLastName;
        this.driverFatherName = driverFatherName;
        this.driverPassportNumber = driverPassportNumber;
        this.driverPassportWhen = driverPassportWhen;
        this.driverPassportWhom = driverPassportWhom;
        this.driverInfo = driverInfo;
        this.phone = phone;
    }

    @ManyToOne
    @JoinColumn(
            name = "forwarder_id",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_h_driver_r_forwarder1")
    )
    public Forwarder getForwarder() {
        return forwarder;
    }

    @Column(nullable = false, length = 45)
    public String getDriverFirstName() {
        return driverFirstName;
    }

    @Column(nullable = false, length = 45)
    public String getDriverLastName() {
        return driverLastName;
    }

    @Column(nullable = false, length = 45)
    public String getDriverFatherName() {
        return driverFatherName;
    }

    @Column(nullable = false, length = 45)
    public String getDriverPassportNumber() {
        return driverPassportNumber;
    }

    @Column(nullable = false)
    public Date getDriverPassportWhen() {
        return driverPassportWhen;
    }

    @Column(nullable = false, length = 150)
    public String getDriverPassportWhom() {
        return driverPassportWhom;
    }

    @Column(length = 250)
    public String getDriverInfo() {
        return driverInfo;
    }

    @ManyToOne
    @JoinColumn(
            name = "forwarder_id",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_h_driver_h_phone1")
    )
    public Phone getPhone() {
        return phone;
    }

    public enum Fields {forwarder, driverFirstName, driverLastName, driverFatherName, driverPassportNumber, driverPassportWhen, driverPassportWhom, driverInfo, phone, serialVersionUID}
}
