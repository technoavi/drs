package com.as.drs.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "DRS_Score")
@Access(AccessType.FIELD)
@Data
@JsonIgnoreProperties
public class DRS_Score implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "drsmarginid")
    private Long drsMarginId;

    @Column(name = "dealerid")
    private Long dealerId;

    @Column(name = "recordtype")
    private String recordType;

    @Column(name = "fiscalyear")
    private String fiscalYear;

    @Column(name = "fiscalmonth")
    private String fiscalMonth;

    @Column(name = "fiscalquarter")
    private Integer fiscalQuarter;

    @Column(name = "ncs_marginamount")
    private Double ncsMarginAmount;

    @Column(name = "ncs_drfamount")
    private Double ncsDrfAmount;

    @Column(name = "ncs_cashbackamount")
    private Double ncsCashbackAmount;

    @Column(name = "ncs_macnacamount")
    private Double ncsMacNacAmount;

    @Column(name = "ncs_bscnscamount")
    private Double ncsBscNscAmount;

    @Column(name = "tv_pocgrossmargin")
    private Double tvPocGrossMargin;

    @Column(name = "tv_pocincentive")
    private Double tvPocIncentive;

    @Column(name = "ab_msgagnaearning")
    private Double abMsgagnaeEarning;

    @Column(name = "ab_msgagnaincentive")
    private Double abMsgagnaIncentive;

    @Column(name = "ab_minewpolicies")
    private Integer abMiNewPolicies;

    @Column(name = "ab_mirenewalpolicies")
    private Integer abMiRenewalPolicies;

    @Column(name = "ab_financepayout")
    private Double abFinancePayout;

    @Column(name = "ab_ewearning")
    private Double abEwEarning;

    @Column(name = "ab_msrearning")
    private Double abMsrEarning;

    @Column(name = "spl_servicelabour")
    private Double splServiceLabour;

    @Column(name = "spl_servicespare")
    private Double splServiceSpare;

    @Column(name = "spl_ccpnew")
    private Double splCcpNew;

    @Column(name = "spl_ccprenewal")
    private Double splCcpRenewal;

    @Column(name = "spl_bodyshoplabour")
    private Double splBodyshopLabour;

    @Column(name = "spl_bodyshopspare")
    private Double splBodyshopSpare;

    @Column(name = "spl_accessoriessale")
    private Double splAccessoriesSale;

    @Column(name = "spl_oillubricant")
    private Double splOilLubricant;

    @Column(name = "spl_serviceincentive")
    private Double splServiceIncentive;
}
