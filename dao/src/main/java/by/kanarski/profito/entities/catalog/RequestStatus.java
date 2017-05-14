package by.kanarski.profito.entities.catalog;

import by.kanarski.profito.entities.AbstractEntity;
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
@AttributeOverride(name = "id", column = @Column(name = "request_status_id"))
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class RequestStatus extends AbstractEntity {

    private static final long serialVersionUID = -829297780391621803L;
    private String requestStatusName;

    @Builder
    public RequestStatus(Integer requestStatusId, String requestStatusName) {
        super(requestStatusId);
        this.requestStatusName = requestStatusName;
    }

    @Column(nullable = false, unique = true)
    public String getRequestStatusName() {
        return requestStatusName;
    }

    public enum Fields {requestStatusName, serialVersionUID}
}
