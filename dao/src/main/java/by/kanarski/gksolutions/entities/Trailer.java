package by.kanarski.gksolutions.entities;

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
@AttributeOverride(name = "id", column = @Column(name = "trailer_id"))
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class Trailer extends AbstractEntity {

    private static final long serialVersionUID = -5473883741009014726L;
    private LoadingType loadingType;
    private TrailerType trailerType;
    private Forwarder forwarder;
    private Byte trailerIsLeased;
    private Date trailerLeasedTill;
    private Document document;

    @Builder
    public Trailer(Integer trailerId, LoadingType loadingType, TrailerType trailerType,
                   Forwarder forwarder, Byte trailerIsLeased, Date trailerLeasedTill, Document document) {
        super(trailerId);
        this.loadingType = loadingType;
        this.trailerType = trailerType;
        this.forwarder = forwarder;
        this.trailerIsLeased = trailerIsLeased;
        this.trailerLeasedTill = trailerLeasedTill;
        this.document = document;
    }

    @ManyToOne
    @JoinColumn(
            name = "loading_type_id",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_h_trailer_c_loading_type1")
    )
    public LoadingType getLoadingType() {
        return loadingType;
    }

    @ManyToOne
    @JoinColumn(
            name = "trailer_type_id",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_h_trailer_c_trailer_type1")
    )
    public TrailerType getTrailerType() {
        return trailerType;
    }

    @ManyToOne
    @JoinColumn(
            name = "forwarder_id",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_h_trailer_h_forwarder_info1")
    )
    public Forwarder getForwarder() {
        return forwarder;
    }

    @Column
    public Byte getTrailerIsLeased() {
        return trailerIsLeased;
    }

    @Column
    public Date getTrailerLeasedTill() {
        return trailerLeasedTill;
    }

    @ManyToOne
    @JoinColumn(
            name = "document_id",
            nullable = true,
            foreignKey = @ForeignKey(name = "fk_h_trailer_h_document1")
    )
    public Document getDocument() {
        return document;
    }

    public enum Fields {loadingType, trailerType, forwarder, trailerIsLeased, trailerLeasedTill, document, serialVersionUID}
}
