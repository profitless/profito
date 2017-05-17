package by.kanarski.profito.entities.registry;

import by.kanarski.profito.entities.*;
import by.kanarski.profito.entities.catalog.CompanyType;
import by.kanarski.profito.entities.catalog.LegalForm;
import by.kanarski.profito.entities.handbook.*;
import by.kanarski.profito.entities.manyToMany.AuctionCompany;
import by.kanarski.profito.entities.manyToMany.TenderCompany;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.sql.Date;
import java.util.Set;

/**
 * @author Dzmitry Kanarski
 * @version 1.0
 */

@Entity
@AttributeOverride(name = "id", column = @Column(name = "company_id"))
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class Company extends AbstractEntity {

    private static final long serialVersionUID = -7155231707204319958L;
    private Boolean companyIsLocked;
    private String companyName;
    private Country country;
    private Integer regionId;
    private Document document;
    private Expeditor expeditor;
    private Forwarder forwarder;
    private Adress jurAdress;
    private Adress factAdress;
    private Adress postAdress;
    private CompanyType companyType;
//    Это инн
    private String companyRegistrationNumber;
//    Это ОКПО
    private String companyAdditionNumber;
    private Integer companyTariffPlan;
    private Double companyBallance;
    private String companySite;
    private Boolean companyIsDebt;
    private Date companyLockDate;
    private Double companyKPI;
    private LegalForm legalForm;
    private Set<AuctionCompany> auctionCompanySet;
    private Set<TenderCompany> tenderCompanySet;
    private Set<Phone> companyPhoneSet;
    private Set<BankAccount> companyBankAccount;
    private CurrencyCondition currencyCondition;

    @Builder
    public Company(Integer companyId, Boolean companyIsLocked, String companyName, Country country,
                   Integer regionId, Document document, Expeditor expeditor, Forwarder forwarder,
                   Adress jurAdress, Adress factAdress, Adress postAdress, CompanyType companyType,
                   String companyRegistrationNumber, String companyAdditionNumber, Integer companyTariffPlan,
                   Double companyBallance, String companySite, Boolean companyIsDebt, Date companyLockDate,
                   Double companyKPI, LegalForm legalForm, Set<AuctionCompany> auctionCompanySet,
                   Set<TenderCompany> tenderCompanySet, Set<Phone> companyPhoneSet,
                   Set<BankAccount> companyBankAccount) {
        super(companyId);
        this.companyIsLocked = companyIsLocked;
        this.companyName = companyName;
        this.country = country;
        this.regionId = regionId;
        this.document = document;
        this.expeditor = expeditor;
        this.forwarder = forwarder;
        this.jurAdress = jurAdress;
        this.factAdress = factAdress;
        this.postAdress = postAdress;
        this.companyType = companyType;
        this.companyRegistrationNumber = companyRegistrationNumber;
        this.companyAdditionNumber = companyAdditionNumber;
        this.companyTariffPlan = companyTariffPlan;
        this.companyBallance = companyBallance;
        this.companySite = companySite;
        this.companyIsDebt = companyIsDebt;
        this.companyLockDate = companyLockDate;
        this.companyKPI = companyKPI;
        this.legalForm = legalForm;
        this.auctionCompanySet = auctionCompanySet;
        this.tenderCompanySet = tenderCompanySet;
        this.companyPhoneSet = companyPhoneSet;
        this.companyBankAccount = companyBankAccount;
    }

    @Column(nullable = false, length = 60)
    public String getCompanyName() {
        return companyName;
    }

    @Type(type = "org.hibernate.type.BooleanType")
    @Column(columnDefinition = "BIT")
    public Boolean getCompanyIsLocked() {
        return companyIsLocked;
    }

    @ManyToOne
    @JoinColumn(
            name = "country_id",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_h_company_info_c_country1")
    )
    public Country getCountry() {
        return country;
    }

    @Column
    public Integer getRegionId() {
        return regionId;
    }

    @ManyToOne
    @JoinColumn(
            name = "document_id",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_h_company_info_h_document1")
    )
    public Document getDocument() {
        return document;
    }

    @ManyToOne
    @JoinColumn(
            name = "expeditor_id",
            nullable = true,
            foreignKey = @ForeignKey(name = "fk_h_company_info_h_expeditor_info1")
    )
    public Expeditor getExpeditor() {
        return expeditor;
    }

    @ManyToOne
    @JoinColumn(
            name = "forwarder_id",
            nullable = true,
            foreignKey = @ForeignKey(name = "fk_h_company_info_h_forwarder_info1")
    )
    public Forwarder getForwarder() {
        return forwarder;
    }

    @ManyToOne
    @JoinColumn(
            name = "jur_adress_id",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_h_company_info_h_adress")
    )
    public Adress getJurAdress() {
        return jurAdress;
    }

    @ManyToOne
    @JoinColumn(
            name = "fact_adress_id",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_h_company_info_h_adress1")
    )
    public Adress getFactAdress() {
        return factAdress;
    }

    @ManyToOne
    @JoinColumn(
            name = "post_adress_id",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_h_company_info_h_adress2")
    )
    public Adress getPostAdress() {
        return postAdress;
    }

    @ManyToOne
    @JoinColumn(
            name = "company_type_id",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_h_company_h_company_type1")
    )
    public CompanyType getCompanyType() {
        return companyType;
    }

    @Column(nullable = false)
    public String getCompanyRegistrationNumber() {
        return companyRegistrationNumber;
    }

    @Column
    public String getCompanyAdditionNumber() {
        return companyAdditionNumber;
    }

    @Column
    public Integer getCompanyTariffPlan() {
        return companyTariffPlan;
    }

    @Column(nullable = false)
    public Double getCompanyBallance() {
        return companyBallance;
    }

    @Column(length = 45)
    public String getCompanySite() {
        return companySite;
    }

    @Type(type = "org.hibernate.type.BooleanType")
    @Column(columnDefinition = "BIT")
    public Boolean getCompanyIsDebt() {
        return companyIsDebt;
    }

    @Column(nullable = false)
    public Date getCompanyLockDate() {
        return companyLockDate;
    }

    @Column
    public Double getCompanyKPI() {
        return companyKPI;
    }

    @ManyToOne
    @JoinColumn(
            name = "legal_form_id",
            nullable = true,
            foreignKey = @ForeignKey(name = "fk_h_company_h_legal_form1")
    )
    public LegalForm getLegalForm() {
        return legalForm;
    }

    @OneToMany(mappedBy = "auctionCompanyPK.company", cascade = CascadeType.ALL)
    public Set<AuctionCompany> getAuctionCompanySet() {
        return auctionCompanySet;
    }

    @OneToMany(mappedBy = "tenderCompanyPK.company", cascade = CascadeType.ALL)
    public Set<TenderCompany> getTenderCompanySet() {
        return tenderCompanySet;
    }

    @ManyToMany
    @JoinTable(
            name = "nn_company_phone",
            joinColumns = @JoinColumn(
                    name = "company_id",
                    nullable = false,
                    foreignKey = @ForeignKey(
                            name = "fk_nn_company_phones_h_company_info1"
                    )
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "phone_id",
                    nullable = false,
                    foreignKey = @ForeignKey(
                            name = "fk_nn_company_phones_h_phone1"
                    )
            )
    )
    public Set<Phone> getCompanyPhoneSet() {
        return companyPhoneSet;
    }

    @ManyToMany
    @JoinTable(
            name = "nn_company_phone",
            joinColumns = @JoinColumn(
                    name = "company_id",
                    nullable = false,
                    foreignKey = @ForeignKey(
                            name = "fk_nn_company_info_bank_account_h_bank_account1"
                    )
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "bank_account_id",
                    nullable = false,
                    foreignKey = @ForeignKey(
                            name = "fk_nn_company_info_bank_account_h_company_info1"
                    )
            )
    )
    public Set<BankAccount> getCompanyBankAccount() {
        return companyBankAccount;
    }

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "company", cascade = CascadeType.ALL)
    public CurrencyCondition getCurrencyCondition() {
        return currencyCondition;
    }

    public enum Fields {companyIsLocked, companyName, country, region, document, expeditor, forwarder, jurAdress, factAdress, postAdress, companyType, companyRegistrationNumber, companyAdditionNumber, companyTariffPlan, companyBallance, companySite, companyIsDebt, companyLockDate, companyKPI, legalForm, auctionCompanySet, tenderCompanySet, companyPhoneSet, companyBankAccount, serialVersionUID}
}
