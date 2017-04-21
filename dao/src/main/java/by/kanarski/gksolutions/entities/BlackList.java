package by.kanarski.gksolutions.entities;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * @author Dzmitry Kanarski
 * @version 1.0
 */

@Entity
@AttributeOverride(name = "id", column = @Column(name = "blacklist_id"))
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class BlackList extends AbstractEntity {

    private static final long serialVersionUID = -3990891418199358999L;
    private Company author;
    private Company target;
    private Timestamp blacklistDate;
    private String blacklistReason;

    @Builder
    public BlackList(Integer blacklistId, Company author, Company target, Timestamp blacklistDate, String blacklistReason) {
        super(blacklistId);
        this.author = author;
        this.target = target;
        this.blacklistDate = blacklistDate;
        this.blacklistReason = blacklistReason;
    }

    @ManyToOne
    @JoinColumn(
            name = "company_id_author",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_h_blacklist_h_company1")
    )
    public Company getAuthor() {
        return author;
    }

    @ManyToOne
    @JoinColumn(
            name = "company_id_target",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_h_blacklist_h_company2")
    )
    public Company getTarget() {
        return target;
    }

    @Column(nullable = false)
    public Timestamp getBlacklistDate() {
        return blacklistDate;
    }

    @Column
    public String getBlacklistReason() {
        return blacklistReason;
    }

    public enum Fields {target, blacklistDate, blacklistReason, author}
}
