package by.kanarski.profito.entities.handbook;

import by.kanarski.profito.entities.AbstractEntity;
import by.kanarski.profito.entities.catalog.Currency;
import by.kanarski.profito.entities.registry.Cargo;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @author Dzmitry Kanarski
 * @version 1.0
 */

@Entity
@AttributeOverride(name = "id", column = @Column(name = "template_id"))
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class Template extends AbstractEntity {

    private static final long serialVersionUID = -1519916393986119399L;
    private Shipment shipmentFrom;
    private Shipment shipmentTo;
    private String templateAdress;
    private String templateRoute;
    private Currency currencyContract;
    private Currency currencyPayment;
    private Currency currencyBill;
    private Double templateMaxBid;
    private Double templateCurrentBid;
    private Cargo cargo;
    private String templateInfo;
    private String templateCustomDepart;
    private String templateCustomArrival;

    @Builder
    public Template(Integer templateId, Shipment shipmentFrom, Shipment shipmentTo, String templateAdress,
                    String templateRoute, Currency currencyContract, Currency currencyPayment,
                    Currency currencyBill, Double templateMaxBid, Double templateCurrentBid, Cargo cargo,
                    String templateInfo, String templateCustomDepart, String templateCustomArrival) {
        super(templateId);
        this.shipmentFrom = shipmentFrom;
        this.shipmentTo = shipmentTo;
        this.templateAdress = templateAdress;
        this.templateRoute = templateRoute;
        this.currencyContract = currencyContract;
        this.currencyPayment = currencyPayment;
        this.currencyBill = currencyBill;
        this.templateMaxBid = templateMaxBid;
        this.templateCurrentBid = templateCurrentBid;
        this.cargo = cargo;
        this.templateInfo = templateInfo;
        this.templateCustomDepart = templateCustomDepart;
        this.templateCustomArrival = templateCustomArrival;
    }

    @ManyToOne
    @JoinColumn(
            name = "shipment_id_from",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_r_passage_h_shipment10")
    )
    public Shipment getShipmentFrom() {
        return shipmentFrom;
    }

    @ManyToOne
    @JoinColumn(
            name = "shipment_id_to",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_r_passage_h_shipment20")
    )
    public Shipment getShipmentTo() {
        return shipmentTo;
    }

    @Column(length = 200)
    public String getTemplateAdress() {
        return templateAdress;
    }

    @Column
    public String getTemplateRoute() {
        return templateRoute;
    }

    @ManyToOne
    @JoinColumn(
            name = "currency_id_contract",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_r_passage_c_currency10")
    )
    public Currency getCurrencyContract() {
        return currencyContract;
    }

    @ManyToOne
    @JoinColumn(
            name = "currency_id_payment",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_r_passage_c_currency20")
    )
    public Currency getCurrencyPayment() {
        return currencyPayment;
    }

    @ManyToOne
    @JoinColumn(
            name = "currency_id_bill",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_r_template_c_currency10")
    )
    public Currency getCurrencyBill() {
        return currencyBill;
    }

    @Column(nullable = false)
    public Double getTemplateMaxBid() {
        return templateMaxBid;
    }

    @Column(nullable = false)
    public Double getTemplateCurrentBid() {
        return templateCurrentBid;
    }

    @ManyToOne
    @JoinColumn(
            name = "cargo_id",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_h_template_r_cargo1")
    )
    public Cargo getCargo() {
        return cargo;
    }

    @Column
    public String getTemplateInfo() {
        return templateInfo;
    }

    @Column
    public String getTemplateCustomDepart() {
        return templateCustomDepart;
    }

    @Column
    public String getTemplateCustomArrival() {
        return templateCustomArrival;
    }

    public enum Fields {shipmentFrom, shipmentTo, templateAdress, templateRoute, currencyContract, currencyPayment, currencyBill, templateMaxBid, templateCurrentBid, cargo, templateInfo, templateCustomDepart, templateCustomArrival, serialVersionUID}
}
