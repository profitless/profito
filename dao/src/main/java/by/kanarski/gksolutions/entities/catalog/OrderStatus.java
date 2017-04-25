package by.kanarski.gksolutions.entities.catalog;

import by.kanarski.gksolutions.entities.AbstractEntity;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * @author Dzmitry Kanarski
 * @version 1.0
 */

@Entity
@AttributeOverride(name = "id", column = @Column(name = "order_status_id"))
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class OrderStatus extends AbstractEntity {

    private static final long serialVersionUID = 1587338490498163139L;
    private String orderStatusName;

    @Builder
    public OrderStatus(Integer orderStatusId, String orderStatusName) {
        super(orderStatusId);
        this.orderStatusName = orderStatusName;
    }

    @Column(nullable = false, length = 145)
    public String getOrderStatusName() {
        return orderStatusName;
    }

    public enum Fields {orderStatusName, serialVersionUID}
}
