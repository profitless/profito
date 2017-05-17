package by.kanarski.profito.entities.handbook;

import by.kanarski.profito.entities.AbstractEntity;
import by.kanarski.profito.entities.catalog.Scope;
import by.kanarski.profito.entities.registry.Company;
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
@AttributeOverride(name = "id", column = @Column(name = "company_setting_id"))
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class CompanySetting extends AbstractEntity {

    private static final long serialVersionUID = 257742287038905154L;
    private Company company;
    private Scope scopeWatchAuction;
    private Scope scopeWatchTender;
    private Scope scopeActionAuction;
    private Scope scopeActionTender;
    private Integer companySettingMinAuctionTime;
    private Boolean companySettingTenderToAuction;
    private Boolean companySettingTemplBet;
    private Boolean companySettingTenderBet;
    private String companySettingAdvertise;
    private String companySettingPartnersPrefer;
    private Boolean companySettingAuctionFindMinBid;
    private Boolean companySettingPolicyMandatory;
    private Boolean companySettingOnlyForwarder;
    private Boolean companySettingOnlyExpeditor;
    private Boolean companySettingNoPolicyOwners;

    @Builder
    public CompanySetting(Integer companySettingId, Company company, Scope scopeWatchAuction, Scope scopeWatchTender,
                          Scope scopeActionAuction, Scope scopeActionTender, Integer companySettingMinAuctionTime,
                          Boolean companySettingTenderToAuction, Boolean companySettingTemplBet,
                          Boolean companySettingTenderBet, String companySettingAdvertise,
                          String companySettingPartnersPrefer, Boolean companySettingAuctionFindMinBid,
                          Boolean companySettingPolicyMandatory, Boolean companySettingOnlyForwarder,
                          Boolean companySettingOnlyExpeditor, Boolean companySettingNoPolicyOwners) {
        super(companySettingId);
        this.company = company;
        this.scopeWatchAuction = scopeWatchAuction;
        this.scopeWatchTender = scopeWatchTender;
        this.scopeActionAuction = scopeActionAuction;
        this.scopeActionTender = scopeActionTender;
        this.companySettingMinAuctionTime = companySettingMinAuctionTime;
        this.companySettingTenderToAuction = companySettingTenderToAuction;
        this.companySettingTemplBet = companySettingTemplBet;
        this.companySettingTenderBet = companySettingTenderBet;
        this.companySettingAdvertise = companySettingAdvertise;
        this.companySettingPartnersPrefer = companySettingPartnersPrefer;
        this.companySettingAuctionFindMinBid = companySettingAuctionFindMinBid;
        this.companySettingPolicyMandatory = companySettingPolicyMandatory;
        this.companySettingOnlyForwarder = companySettingOnlyForwarder;
        this.companySettingOnlyExpeditor = companySettingOnlyExpeditor;
        this.companySettingNoPolicyOwners = companySettingNoPolicyOwners;
    }

    @ManyToOne
    @JoinColumn(
            name = "company_id",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_h_company_setting_r_company1")
    )
    public Company getCompany() {
        return company;
    }

    @ManyToOne
    @JoinColumn(
            name = "scope_id_watch_auction",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_h_company_settings_c_scope1")
    )
    public Scope getScopeWatchAuction() {
        return scopeWatchAuction;
    }

    @ManyToOne
    @JoinColumn(
            name = "scope_id_watch_tender",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_h_company_setting_c_scope1")
    )
    public Scope getScopeWatchTender() {
        return scopeWatchTender;
    }

    @ManyToOne
    @JoinColumn(
            name = "scope_id_action_auction",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_h_company_setting_c_scope2")
    )
    public Scope getScopeActionAuction() {
        return scopeActionAuction;
    }

    @ManyToOne
    @JoinColumn(
            name = "scope_id_action_tender",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_h_company_setting_c_scope3")
    )
    public Scope getScopeActionTender() {
        return scopeActionTender;
    }

    @Column
    public Integer getCompanySettingMinAuctionTime() {
        return companySettingMinAuctionTime;
    }

    @Type(type = "org.hibernate.type.BooleanType")
    @Column(columnDefinition = "BIT")
    public Boolean getCompanySettingTenderToAuction() {
        return companySettingTenderToAuction;
    }

    @Type(type = "org.hibernate.type.BooleanType")
    @Column(columnDefinition = "BIT")
    public Boolean getCompanySettingTemplBet() {
        return companySettingTemplBet;
    }

    @Type(type = "org.hibernate.type.BooleanType")
    @Column(columnDefinition = "BIT")
    public Boolean getCompanySettingTenderBet() {
        return companySettingTenderBet;
    }

    @Column(columnDefinition = "TEXT")
    public String getCompanySettingAdvertise() {
        return companySettingAdvertise;
    }

    @Column(columnDefinition = "TEXT")
    public String getCompanySettingPartnersPrefer() {
        return companySettingPartnersPrefer;
    }

    @Type(type = "org.hibernate.type.BooleanType")
    @Column(columnDefinition = "BIT")
    public Boolean getCompanySettingAuctionFindMinBid() {
        return companySettingAuctionFindMinBid;
    }

    @Type(type = "org.hibernate.type.BooleanType")
    @Column(columnDefinition = "BIT")
    public Boolean getCompanySettingPolicyMandatory() {
        return companySettingPolicyMandatory;
    }

    @Type(type = "org.hibernate.type.BooleanType")
    @Column(columnDefinition = "BIT")
    public Boolean getCompanySettingOnlyForwarder() {
        return companySettingOnlyForwarder;
    }

    // TODO: 07.05.2017 blank
    public Boolean getCompanySettingOnlyExpeditor() {
        return companySettingOnlyExpeditor;
    }

    @Type(type = "org.hibernate.type.BooleanType")
    @Column(columnDefinition = "BIT")
    public Boolean getCompanySettingNoPolicyOwners() {
        return companySettingNoPolicyOwners;
    }

    public enum Fields {company, scopeWatchAuction, scopeWatchTender, scopeActionAuction, scopeActionTender, companySettingMinAuctionTime, companySettingTenderToAuction, companySettingTemplBet, companySettingTenderBet, companySettingAdvertise, companySettingPartnersPrefer, companySettingAuctionFindMinBid, companySettingPolicyMandatory, companySettingOnlyForwarder, companySettingOnlyExpeditor, companySettingNoPolicyOwners, serialVersionUID}
}
