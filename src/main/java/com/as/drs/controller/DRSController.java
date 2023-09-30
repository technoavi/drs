package com.as.drs.controller;

import com.as.drs.entity.DRS_Score;
import com.as.drs.models.MarginData;
import com.as.drs.models.OrderDiscount;
import com.as.drs.models.OrderRequest;
import com.as.drs.models.Person;
import com.as.drs.repository.DRS_ScoreRepository;
import com.as.drs.repository.DRS_SummaryDataRepository;
import com.as.drs.service.OrderDiscountService;
import com.as.drs.service.PointsCalculationService;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/drs")
public class DRSController {

  @Autowired
  private PointsCalculationService pointsCalculationService;
  @Autowired
  private DRS_SummaryDataRepository drsSummaryDataRepository;

  @Autowired
  private DRS_ScoreRepository drsScoreRepository;
    @Autowired
    private OrderDiscountService orderDiscountService;

    @GetMapping("/test/{msg}")
    public String test(@PathVariable("msg") String msg) {
        return "Hello "+ msg;
    }
    @PostMapping("/get-discount")
    public ResponseEntity<OrderDiscount> getDiscount(@RequestBody OrderRequest orderRequest) {
        OrderDiscount discount = orderDiscountService.getDiscount(orderRequest);
        return new ResponseEntity<>(discount, HttpStatus.OK);
    }

    @GetMapping("/m1")
    public String m1() {
      List<DRS_Score> ls= drsScoreRepository.findAll();
        System.out.println(" "+ls.toString());
        return  "Success!";
    }
  @GetMapping("/total")
  public Double getTotalNCSMarginAmount(
          @RequestParam Long dealerId, @RequestParam String startDate, @RequestParam String endDate) throws ParseException {

    Date sDate = new SimpleDateFormat("yyyy-MM-dd").parse(startDate);
    Date eDate = new SimpleDateFormat("yyyy-MM-dd").parse(endDate);
    return drsSummaryDataRepository.calculateTotalNCSMarginAmount(dealerId, sDate, eDate);
  }



//  @GetMapping("/calculate")
//  public Integer calculatePoints(
//          @RequestParam Long dealerId,
//          @RequestParam String startDate,
//          @RequestParam String endDate
//  ) throws ParseException {
//    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//    Date sDate = dateFormat.parse(startDate);
//    Date eDate = dateFormat.parse(endDate);
//   Double amount= drsSummaryDataRepository.calculateTotalNCSMarginAmount(dealerId, sDate, eDate);
//    System.out.println(" amount "+amount);
//   // Call the service method to calculate points using Drools rules
//    return pointsCalculationService.calculatePoints(amount);
//  }

  @PostMapping("/calculate-points")
  public ResponseEntity<String> calculatePoints(@RequestBody MarginData marginData) {
    pointsCalculationService.calculatePoints(marginData);
    int points = marginData.getPoints();
    return ResponseEntity.ok("Points: " + points);
  }

  @PostMapping("/margin-points")
  public ResponseEntity<String> marginPoints(@RequestBody MarginData marginData) throws ParseException {
    Date sDate = new SimpleDateFormat("yyyy-MM-dd").parse(marginData.getStartDate());
    Date eDate = new SimpleDateFormat("yyyy-MM-dd").parse(marginData.getEndDate());


    double marginAmount=    drsSummaryDataRepository.calculateTotalNCSMarginAmount(marginData.getDealerId(),sDate, eDate);
    System.out.println(" marginAmount: "+marginAmount);
    marginData.setMargin(marginAmount);
    pointsCalculationService.calculatePoints(marginData);

    int points = marginData.getPoints();
    Map<String, Object> response = new HashMap<>();
    response.put("marginAmount", marginAmount);
    response.put("points", points);
    return ResponseEntity.ok(response.toString());
  }
}
