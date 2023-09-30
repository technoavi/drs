package com.as.drs.service;

import com.as.drs.entity.DRS_SummaryData;
import com.as.drs.models.MarginData;
import com.as.drs.models.OrderDiscount;
import com.as.drs.models.OrderRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.kie.api.KieBase;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import java.util.Date;

@Service
public class PointsCalculationService {

    @Autowired
    private KieContainer kieContainer;

    public int calculatePoints(MarginData marginData) {
      //  MarginData marginData = new MarginData();
        KieSession kieSession = kieContainer.newKieSession();
     //   kieSession.setGlobal("data", marginData);
        kieSession.insert(marginData);

        kieSession.fireAllRules();
        kieSession.dispose();
        return marginData.getPoints();
    }
//    public void calculatePoints(MarginData data) {  KieServices kieServices = KieServices.Factory.get();
//        KieContainer kieContainer = kieServices.getKieClasspathContainer();
//
//        KieBase kieBase = kieContainer.getKieBase("rules");
//        KieSession kieSession = kieBase.newKieSession();
//
//        try {
//            kieSession.insert(data);
//            kieSession.fireAllRules();
//        } finally {
//            kieSession.dispose();
//        }
//    }
//    public Integer calculatePoints(Double amount) {
//        // Load the Drools rules and create a session
//        KieServices kieServices = KieServices.Factory.get();
//        KieContainer kieContainer = kieServices.getKieClasspathContainer();
//        KieBase kieBase = kieContainer.getKieBase("rules");
//        KieSession kieSession = kieBase.newKieSession();
//
//        // Create a DRSSummaryDataEntity with the provided parameters
//        DRS_SummaryData entity = new DRS_SummaryData();
//        entity.setNcsMarginAmount(amount);
//        //entity.setFiscalMonth(startDate); // Set start date as FiscalMonth (adjust setter method as needed)
//      //  entity.setFiscalMonth(endDate); // Set end date as FiscalMonth (adjust setter method as needed)
//
//        kieSession.setGlobal("orderDiscount", entity);
//        // Insert the entity into the session
//        kieSession.insert(entity);
//
//        // Fire the rules and calculate points
//        kieSession.fireAllRules();
//        kieSession.dispose();
//
//        // Return the calculated points
//        return entity.getPoints();
//    }
}
