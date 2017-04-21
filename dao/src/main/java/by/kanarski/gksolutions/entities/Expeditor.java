package by.kanarski.gksolutions.entities;

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
@AttributeOverride(name = "id", column = @Column(name = "expeditor_id"))
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class Expeditor extends AbstractEntity {

    private static final long serialVersionUID = -7302690254029709364L;
    private Policy policy;
    private Byte expeditorIsInsured;
    private String expeditorInfo;

    @Builder
    public Expeditor(Integer expeditorId, Policy policy, Byte expeditorIsInsured, String expeditorInfo) {
        super(expeditorId);
        this.policy = policy;
        this.expeditorIsInsured = expeditorIsInsured;
        this.expeditorInfo = expeditorInfo;
    }

    @ManyToOne
    @JoinColumn(
            name = "policy_id",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_r_expeditor_info_h_policy1")
    )
    public Policy getPolicy() {
        return policy;
    }

    @Column(nullable = false)
    public Byte getExpeditorIsInsured() {
        return expeditorIsInsured;
    }

    @Column(nullable = false, length = 200)
    public String getExpeditorInfo() {
        return expeditorInfo;
    }

    public enum Fields {policy, expeditorIsInsured, expeditorInfo, serialVersionUID}
}