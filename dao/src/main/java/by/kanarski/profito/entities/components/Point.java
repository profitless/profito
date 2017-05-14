package by.kanarski.profito.entities.components;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * @author Dzmitry Kanarski
 * @version 1.0
 */

@Embeddable
@Data
@NoArgsConstructor
public class Point implements Serializable {

    private static final long serialVersionUID = 1486897947370017011L;
    private Double x;
    private Double y;

    @Builder
    public Point(Double x, Double y) {
        this.x = x;
        this.y = y;
    }

    @Column
    public Double getX() {
        return x;
    }

    @Column
    public Double getY() {
        return y;
    }

    public enum Fields {xCoordinate, yCoordinate, serialVersionUID}
}
