package by.kanarski.gksolutions.entities.registry;

import by.kanarski.gksolutions.entities.AbstractEntity;
import by.kanarski.gksolutions.entities.catalog.OrderStatus;
import by.kanarski.gksolutions.entities.handbook.Driver;
import by.kanarski.gksolutions.entities.handbook.Tractor;
import by.kanarski.gksolutions.entities.handbook.Trailer;
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
@AttributeOverride(name = "id", column = @Column(name = "order_id"))
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class Order extends AbstractEntity {

    private static final long serialVersionUID = -8223936477574943214L;
    private Request request;
    private OrderStatus orderStatus;
    private Double orderPrice;
    private String orderInfo;
    private Tractor tractor;
    private Trailer trailer;
    private Driver driver;
    private String orderDriver;
    private String orderCar;
    private String orderCustomDepart;
    private String orderCustomArrival;

    @Builder
    public Order(Integer id, Request request, OrderStatus orderStatus, Double orderPrice, String orderInfo,
                 Tractor tractor, Trailer trailer, Driver driver, String orderDriver, String orderCar,
                 String orderCustomDepart, String orderCustomArrival) {
        super(id);
        this.request = request;
        this.orderStatus = orderStatus;
        this.orderPrice = orderPrice;
        this.orderInfo = orderInfo;
        this.tractor = tractor;
        this.trailer = trailer;
        this.driver = driver;
        this.orderDriver = orderDriver;
        this.orderCar = orderCar;
        this.orderCustomDepart = orderCustomDepart;
        this.orderCustomArrival = orderCustomArrival;
    }

    @ManyToOne
    @JoinColumn(
            name = "reqest_id",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_r_order_r_request1")
    )
    public Request getRequest() {
        return request;
    }

    @ManyToOne
    @JoinColumn(
            name = "order_status_id",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_r_order_c_order_status1")
    )
    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    @Column(nullable = false)
    public Double getOrderPrice() {
        return orderPrice;
    }

    @Column
    public String getOrderInfo() {
        return orderInfo;
    }

    @ManyToOne
    @JoinColumn(
            name = "tractor_id",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_r_order_h_tractor1")
    )
    public Tractor getTractor() {
        return tractor;
    }

    @ManyToOne
    @JoinColumn(
            name = "trailer_id",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_r_order_h_trailer1")
    )
    public Trailer getTrailer() {
        return trailer;
    }

    @ManyToOne
    @JoinColumn(
            name = "driver_id",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_r_order_h_driver1")
    )
    public Driver getDriver() {
        return driver;
    }

    @Column
    public String getOrderDriver() {
        return orderDriver;
    }

    @Column
    public String getOrderCar() {
        return orderCar;
    }

    @Column
    public String getOrderCustomDepart() {
        return orderCustomDepart;
    }

    @Column
    public String getOrderCustomArrival() {
        return orderCustomArrival;
    }

    public enum Fields {request, orderStatus, orderPrice, orderInfo, tractor, trailer, driver, orderDriver, orderCar, orderCustomDepart, orderCustomArrival, serialVersionUID}
}
