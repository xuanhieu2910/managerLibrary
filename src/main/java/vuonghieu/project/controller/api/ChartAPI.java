package vuonghieu.project.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import vuonghieu.project.dto.ChartDTO;
import vuonghieu.project.service.impl.ChartServiceImpl;

@RestController
@RequestMapping("/api/chart")
public class ChartAPI {

    @Autowired
    ChartServiceImpl chartService;

    @GetMapping
    public ResponseEntity filterTime(){
//        switch (time){
//            case "oneDayAgo":
//            case "sevenDaysAgo":
//            case "oneMonthAgo":
//            case "oneYearsAgo":
//                break;
//        }
        return new ResponseEntity( chartService.getSumResultChart(),HttpStatus.OK);
    }
}
