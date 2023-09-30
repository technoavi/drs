package com.as.drs.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "DealersMaster")
@Data
public class Dealer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long dealerId;

    private String dealerSFID;
    private String miOutletCode;
    private String miOutletName;
    private String dealerName;
    private String dealerRegion;
    private String dealerParent;
    private String dealerMapCode;
    private String dealerLocationCode;
    private String dealerType;
    private String dealerLocationDesc;
    private String dealerSalesCode;
    private String dealerForCode;
    private String dealerOutletCode;
    private String dealerTVCode;
    private String dealerConsigneeCode;
    private String address;
    private String primaryContactNumber;
    private String secondaryContactNumber;
    private String dealerChannel;
    private String dealerCity;
    private String dealerOutletType;
    private String createdBy;
    private Date createdDate;
    private Boolean isActive;
    private String dealerGSTNum;
    private String nonProductiveTag;
    private String photoIdURL;
    private String penCard;
    private String dealerNameAsPerBankAcc;
    private String bankAccNo;
    private String ifscCode;
    private String gstNo;
    private String onBoardingCreateById;
    private Date onBoardingCreateOn;
    private String onBoardingApproveById;
    private Date onBoardingApproveOn;
    private String emailID;
    private String onBoardingStatus;
    private String dealerRegionDesc;
    private String dealerCityCode;
    private String dealeremail;
    private String dealerceomail;
    private String dealerSuperMail;
    private Boolean dealerActive;
    private String dealerStateDesc;
    private String dealerStateCode;
    private String dealerZone;
    private String dealerPartnerid;
    private String dealerRolecd;
    private String dealerCategory;
    private String dealerLatitude;
    private String dealerLongitude;
    private String dealermulsprcd;
    private String dealermulsrvcd;
    private String dealerPin;
    private String dealerSalesStockyardin;
    private String dealersparesStockyardin;
    private String subscribeEmailID;
    private String onBoardingRemark;
    private Long onBoardingStatusLogId;
    private String requestID;
    private Boolean hideonboarding;
    private String onboardingMobileNo;
    private Boolean compFA;
    private String oldDealerId;
    private Long dealerSubscriptionPlanId;


}
