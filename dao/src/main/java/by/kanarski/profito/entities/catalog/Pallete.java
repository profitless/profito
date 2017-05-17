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
@AttributeOverride(name = "id", column = @Column(name = "pallete_id"))
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class Pallete extends AbstractEntity {

    private static final long serialVersionUID = -3345699160701424081L;
    private String palleteName;
    private Double palleteWidth;
    private Double palleteHeight;
    private Double palleteLength;

    @Builder
    public Pallete(Integer palleteId, String palleteName, Double palleteWidth, Double palleteHeight,
                   Double palleteLength) {
        super(palleteId);
        this.palleteName = palleteName;
        this.palleteWidth = palleteWidth;
        this.palleteHeight = palleteHeight;
        this.palleteLength = palleteLength;
    }

    @Column(nullable = false, length = 45)
    public String getPalleteName() {
        return palleteName;
    }

    @Column(nullable = false)
    public Double getPalleteWidth() {
        return palleteWidth;
    }

    @Column(nullable = false)
    public Double getPalleteHeight() {
        return palleteHeight;
    }

    @Column(nullable = false)
    public Double getPalleteLength() {
        return palleteLength;
    }

    public enum Fields {palleteName, palleteWidth, palleteHeight, palleteLength, serialVersionUID}
}
