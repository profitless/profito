package by.kanarski.gksolutions.entities.registry;

import by.kanarski.gksolutions.entities.AbstractEntity;
import by.kanarski.gksolutions.entities.catalog.Currency;
import by.kanarski.gksolutions.entities.catalog.RequestStatus;
import by.kanarski.gksolutions.entities.handbook.Shipment;
import by.kanarski.gksolutions.entities.handbook.Template;
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
@AttributeOverride(name = "id", column = @Column(name = "request_id"))
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class Request extends AbstractEntity {

    private static final long serialVersionUID = 6457814207815315055L;
    private RequestStatus requestStatus;
    private Tender tender;
    private Template template;
    private Shipment shipmentFrom;
    private Shipment shipmentTo;
    private String requestAdress;
    private String requestRoute;
    private Currency currencyContract;
    private Currency currencyPayment;
    private Currency currencyBill;
    private Double requestMaxBid;
    private Double requestMinBid;
    private Double requestPrice;
    private Integer requestDataEnterTime;
    private String requestCustomArrival;
    private String requestCustomDepart;

    @Builder
    public Request(Integer requestId, RequestStatus requestStatus, Tender tender, Template template,
                   Shipment shipmentFrom, Shipment shipmentTo, String requestAdress, String requestRoute,
                   Currency currencyContract, Currency currencyPayment, Currency currencyBill, Double requestMaxBid,
                   Double requestMinBid, Double requestPrice, Integer requestDataEnterTime, String requestCustomArrival,
                   String requestCustomDepart) {
        super(requestId);
        this.requestStatus = requestStatus;
        this.tender = tender;
        this.template = template;
        this.shipmentFrom = shipmentFrom;
        this.shipmentTo = shipmentTo;
        this.requestAdress = requestAdress;
        this.requestRoute = requestRoute;
        this.currencyContract = currencyContract;
        this.currencyPayment = currencyPayment;
        this.currencyBill = currencyBill;
        this.requestMaxBid = requestMaxBid;
        this.requestMinBid = requestMinBid;
        this.requestPrice = requestPrice;
        this.requestDataEnterTime = requestDataEnterTime;
        this.requestCustomArrival = requestCustomArrival;
        this.requestCustomDepart = requestCustomDepart;
    }

    @ManyToOne
    @JoinColumn(
            name = "request_status_id",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_r_request_c_request_status1")
    )
    public RequestStatus getRequestStatus() {
        return requestStatus;
    }

    @ManyToOne
    @JoinColumn(
            name = "tender_id",
            foreignKey = @ForeignKey(name = "fk_r_order_r_tender1")
    )
    public Tender getTender() {
        return tender;
    }

    @ManyToOne
    @JoinColumn(
            name = "template_id",
            foreignKey = @ForeignKey(name = "fk_r_order_h_template1")
    )
    public Template getTemplate() {
        return template;
    }

    @ManyToOne
    @JoinColumn(
            name = "shipment_id_from",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_r_passage_h_shipment1")
    )
    public Shipment getShipmentFrom() {
        return shipmentFrom;
    }

    @ManyToOne
    @JoinColumn(
            name = "shipment_id_to",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_r_passage_h_shipment2")
    )
    public Shipment getShipmentTo() {
        return shipmentTo;
    }

    @Column(nullable = false, length = 200)
    public String getRequestAdress() {
        return requestAdress;
    }

    @Column(nullable = false)
    public String getRequestRoute() {
        return requestRoute;
    }

    @ManyToOne
    @JoinColumn(
            name = "currency_id_contract",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_r_passage_c_currency1")
    )
    public Currency getCurrencyContract() {
        return currencyContract;
    }

    @ManyToOne
    @JoinColumn(
            name = "currency_id_payment",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_r_passage_c_currency2")
    )
    public Currency getCurrencyPayment() {
        return currencyPayment;
    }

    @ManyToOne
    @JoinColumn(
            name = "currency_id_bill",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_r_template_c_currency1")
    )
    public Currency getCurrencyBill() {
        return currencyBill;
    }

    @Column(nullable = false)
    public Double getRequestMaxBid() {
        return requestMaxBid;
    }

    @Column(nullable = false)
    public Double getRequestMinBid() {
        return requestMinBid;
    }

    @Column(nullable = false)
    public Double getRequestPrice() {
        return requestPrice;
    }

    @Column(nullable = false)
    public Integer getRequestDataEnterTime() {
        return requestDataEnterTime;
    }

    @Column
    public String getRequestCustomArrival() {
        return requestCustomArrival;
    }

    @Column
    public String getRequestCustomDepart() {
        return requestCustomDepart;
    }

    public enum Fields {requestStatus, tender, template, shipmentFrom, shipmentTo, requestAdress, requestRoute, currencyContract, currencyPayment, currencyBill, requestMaxBid, requestMinBid, requestPrice, requestDataEnterTime, requestCustomArrival, requestCustomDepart, serialVersionUID}
}
