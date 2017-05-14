package by.kanarski.profito.entities.registry;

import by.kanarski.profito.entities.AbstractEntity;
import by.kanarski.profito.entities.handbook.Policy;
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
@AttributeOverride(name = "id", column = @Column(name = "expeditor_id"))
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class Forwarder extends AbstractEntity {

    private static final long serialVersionUID = -5951149269498146782L;
    private Policy policy;
    private Boolean forwarderIsInsured;

    @Builder
    public Forwarder(Integer forwarderId, Policy policy, Boolean forwarderIsInsured) {
        super(forwarderId);
        this.policy = policy;
        this.forwarderIsInsured = forwarderIsInsured;
    }

    @ManyToOne
    @JoinColumn(
            name = "policy_id",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_r_forwarder_info_h_policy1")
    )
    public Policy getPolicy() {
        return policy;
    }

    @Type(type = "org.hibernate.type.BooleanType")
    @Column(columnDefinition = "BIT")
    public Boolean getForwarderIsInsured() {
        return forwarderIsInsured;
    }

    public enum Fields {policy, forwarderIsInsured, serialVersionUID}
}
