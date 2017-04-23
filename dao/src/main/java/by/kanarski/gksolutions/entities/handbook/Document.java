package by.kanarski.gksolutions.entities.handbook;

import by.kanarski.gksolutions.entities.AbstractEntity;
import by.kanarski.gksolutions.entities.catalog.DocumentStatus;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Blob;
import java.sql.Timestamp;

/**
 * @author Dzmitry Kanarski
 * @version 1.0
 */

@Entity
@AttributeOverride(name = "id", column = @Column(name = "document_id"))
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class Document extends AbstractEntity {

    private static final long serialVersionUID = -9101128038856055219L;
    private String documentName;
    private Blob documentContent;
    private String documentInfo;
    private Timestamp createDate;
    private DocumentStatus documentStatus;

    @Builder
    public Document(Integer documentId, String documentName, Blob documentContent, String documentInfo,
                    Timestamp createDate, DocumentStatus documentStatus) {
        super(documentId);
        this.documentName = documentName;
        this.documentContent = documentContent;
        this.documentInfo = documentInfo;
        this.createDate = createDate;
        this.documentStatus = documentStatus;
    }

    @Column(nullable = false, length = 100)
    public String getDocumentName() {
        return documentName;
    }

    @Column(nullable = false)
    public Blob getDocumentContent() {
        return documentContent;
    }

    @Column(nullable = true)
    public String getDocumentInfo() {
        return documentInfo;
    }

    @Column(nullable = false)
    public Timestamp getCreateDate() {
        return createDate;
    }

    @ManyToOne
    @JoinColumn(
            name = "document_status_id",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_h_document_c_document_status1")
    )
    public DocumentStatus getDocumentStatus() {
        return documentStatus;
    }

    public enum Fields {documentName, documentContent, documentInfo, createDate, documentStatus, serialVersionUID}
}
