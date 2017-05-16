package by.kanarski.profito.entities.handbook;

import by.kanarski.profito.entities.AbstractEntity;
import by.kanarski.profito.entities.catalog.TractorBrand;
import by.kanarski.profito.entities.registry.Forwarder;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.*;

/**
 * @author Dzmitry Kanarski
 * @version 1.0
 */

@Entity
@AttributeOverride(name = "id", column = @Column(name = "tractor_id"))
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class Tractor extends AbstractEntity {

    private static final long serialVersionUID = 2982642232282061314L;
    private TractorBrand tractorBrand;
    private Forwarder forwarder;
    private String tractorPlate;
    private Boolean tractorIsLeased;
    private Document document;

    @Builder
    public Tractor(Integer tractorId, TractorBrand tractorBrand, Forwarder forwarder,
                   String tractorPlate, Boolean tractorIsLeased, Document document) {
        super(tractorId);
        this.tractorBrand = tractorBrand;
        this.forwarder = forwarder;
        this.tractorPlate = tractorPlate;
        this.tractorIsLeased = tractorIsLeased;
        this.document = document;
    }

    @ManyToOne
    @JoinColumn(
            name = "tractor_brand_id",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_h_tractor_c_tractor_brand1")
    )
    public TractorBrand getTractorBrand() {
        return tractorBrand;
    }

    @ManyToOne
    @JoinColumn(
            name = "forwarder_id",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_h_tractor_h_forwarder_info1")
    )
    public Forwarder getForwarder() {
        return forwarder;
    }

    @Column(nullable = false, length = 15)
    public String getTractorPlate() {
        return tractorPlate;
    }

    @Type(type = "org.hibernate.type.BooleanType")
    @Column(columnDefinition = "BIT")
    public Boolean getTractorIsLeased() {
        return tractorIsLeased;
    }

    @ManyToOne
    @JoinColumn(
            name = "document_id",
            nullable = true,
            foreignKey = @ForeignKey(name = "fk_h_tractor_h_document1")
    )
    public Document getDocument() {
        return document;
    }

    public enum Fields {tractorBrand, forwarder, tractorPlate, tractorIsLeased, document, serialVersionUID}
}