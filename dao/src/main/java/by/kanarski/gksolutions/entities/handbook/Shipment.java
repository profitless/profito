package by.kanarski.gksolutions.entities.handbook;

import by.kanarski.gksolutions.entities.AbstractEntity;
import by.kanarski.gksolutions.entities.components.Point;
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
@AttributeOverride(name = "id", column = @Column(name = "shipment_id"))
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class Shipment extends AbstractEntity {

    private static final long serialVersionUID = 8501927284567201747L;
    private Integer regionId;
    private Country country;
    // TODO: 25.04.2017 Разобраться, что за point
    // TODO: 05.05.2017 Пока использую два поля Х и У
    private Point shipmetCoordinates;
    private Date shipmentStart;
    private Date shipmentFinish;
    private String shipmentContact;
    private String shipmentInfo;
    private Float shipmentTime;

    @Builder
    public Shipment(Integer shipmentId, Integer regionId, Country country, Point shipmetCoordinates,
                    Date shipmentStart, Date shipmentFinish, String shipmentContact, String shipmentInfo,
                    Float shipmentTime) {
        super(shipmentId);
        this.regionId = regionId;
        this.country = country;
        this.shipmetCoordinates = shipmetCoordinates;
        this.shipmentStart = shipmentStart;
        this.shipmentFinish = shipmentFinish;
        this.shipmentContact = shipmentContact;
        this.shipmentInfo = shipmentInfo;
        this.shipmentTime = shipmentTime;
    }

    @Column
    public Integer getRegionId() {
        return regionId;
    }

    @ManyToOne
    @JoinColumn(
            name = "country_id",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_h_shipment_c_country2")
    )
    public Country getCountry() {
        return country;
    }

    @Embedded
    @AttributeOverrides(
            {
                    @AttributeOverride(name="x", column = @Column(name="shipment_coordinate_x") ),
                    @AttributeOverride(name="y", column = @Column(name="shipment_coordinate_y") )
            }
    )
    public Point getShipmetCoordinates() {
        return shipmetCoordinates;
    }

    @Column
    public Date getShipmentStart() {
        return shipmentStart;
    }

    @Column
    public Date getShipmentFinish() {
        return shipmentFinish;
    }

    @Column(nullable = false, length = 200)
    public String getShipmentContact() {
        return shipmentContact;
    }

    @Column
    public String getShipmentInfo() {
        return shipmentInfo;
    }

    @Column
    public Float getShipmentTime() {
        return shipmentTime;
    }

    public enum Fields {regionId, country, shipmetCoordinates, shipmentStart, shipmentFinish, shipmentContact, shipmentInfo, shipmentTime, serialVersionUID}
}
