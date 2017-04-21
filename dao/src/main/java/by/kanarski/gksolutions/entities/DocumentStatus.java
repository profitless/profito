package by.kanarski.gksolutions.entities;

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
@AttributeOverride(name = "id", column = @Column(name = "document_status_id"))
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class DocumentStatus extends AbstractEntity {

    private static final long serialVersionUID = -8291057193459645999L;
    private String documentStatusName;

    @Builder
    public DocumentStatus(Integer documentId, String documentStatusName) {
        super(documentId);
        this.documentStatusName = documentStatusName;
    }

    @Column(unique = true, nullable = false, length = 145)
    public String getDocumentStatusName() {
        return documentStatusName;
    }

    public enum Fields {documentStatusName, serialVersionUID}
}
