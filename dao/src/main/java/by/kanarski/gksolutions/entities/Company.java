package by.kanarski.gksolutions.entities;

import by.kanarski.gksolutions.entities.manyToMany.AuctionCompany;
import by.kanarski.gksolutions.entities.manyToMany.TenderCompany;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

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
    private Byte companyIsLocked;
    private String companyName;
    private Country country;
    private Region region;
    private Document document;
    private Expeditor expeditor;
    private Forwarder forwarder;
    private Adress jurAdress;
    private Adress factAdress;
    private Adress postAdress;
    private CompanyType companyType;
    private String companyRegistrationNumber;
    private String companyAdditionNumber;
    private Integer companyTariffPlan;
    private Double companyBallance;
    private String companySite;
    private Byte companyIsDebt;
    private Date companyLockDate;
    private Double companyKPI;
    private LegalForm legalForm;
    private Set<AuctionCompany> auctionCompanySet;
    private Set<TenderCompany> tenderCompanySet;
    private Set<Phone> companyPhoneSet;
    private Set<BankAccount> companyBankAccount;

    @Builder
    public Company(Integer companyId, Byte companyIsLocked, String companyName, Country country,
                   Region region, Document document, Expeditor expeditor, Forwarder forwarder,
                   Adress jurAdress, Adress factAdress, Adress postAdress, CompanyType companyType,
                   String companyRegistrationNumber, String companyAdditionNumber, Integer companyTariffPlan,
                   Double companyBallance, String companySite, Byte companyIsDebt, Date companyLockDate,
                   Double companyKPI, LegalForm legalForm, Set<AuctionCompany> auctionCompanySet,
                   Set<TenderCompany> tenderCompanySet, Set<Phone> companyPhoneSet,
                   Set<BankAccount> companyBankAccount) {
        super(companyId);
        this.companyIsLocked = companyIsLocked;
        this.companyName = companyName;
        this.country = country;
        this.region = region;
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

    @Column(nullable = false)
    public Byte getCompanyIsLocked() {
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

    @ManyToOne
    @JoinColumn(
            name = "region_id",
            nullable = true,
            foreignKey = @ForeignKey(name = "fk_h_company_info_c_region1")
    )
    public Region getRegion() {
        return region;
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

    @Column(nullable = false)
    public Byte getCompanyIsDebt() {
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
            name = "fact_adress_id",
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

    public enum Fields {companyIsLocked, companyName, country, region, document, expeditor, forwarder, jurAdress, factAdress, postAdress, companyType, companyRegistrationNumber, companyAdditionNumber, companyTariffPlan, companyBallance, companySite, companyIsDebt, companyLockDate, companyKPI, legalForm, auctionCompanySet, tenderCompanySet, companyPhoneSet, companyBankAccount, serialVersionUID}
}