package com.company.cabdataapi.repository;

import com.company.cabdataapi.service.CabDataService;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Optional;

/**
 * Created by jsbonso on 22/10/17.
 */
@RestController
@EnableCaching
public class CabRepository{

    @Autowired
    private TripRepository tripRepository;

    @Autowired
    CabDataService cabService;


    /**
     *
     * Returns how many trips a particular cab (medallion) has made given a particular pickup date
     * ( using pickup_datetime and only considering the date part)
     * @param medallionId
     * @param pickupDate
     * @param cached - An Optional field to if you want to get the cached data or not.
     * @return
     */
    @RequestMapping(value="/getCountByMedallionAndPickupDatetime", method = RequestMethod.GET, produces = "application/json")
    public String getNumberOfTrips(@RequestParam(value = "medallionId") String[] medallionId,
                                   @RequestParam(value= "pickupDate") @DateTimeFormat(pattern="yyyy-MM-dd") Date pickupDate,
                                   @RequestParam("cached") Optional<Boolean> cached){


        // Transform the Date to a String with this pattern : "yyyy-MM-dd"
        LocalDateTime ldt = LocalDateTime.ofInstant(pickupDate.toInstant(), ZoneId.systemDefault());
        String formattedDate = ldt.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        // Parse the results to be in JSON format.
        JSONObject result = new JSONObject();
        JSONArray resultArray = new JSONArray();

        // Caching is enabled by default
        boolean isCached = true;

        if(cached.isPresent())
            isCached = cached.get();

        // Process each medallion/cabs
        for (int i=0; i < medallionId.length; i++){
            JSONObject jsonObj = new JSONObject();
            long tripCount;
            tripCount = cabService.getCountByMedallionAndPickupDatetime(medallionId[i], formattedDate, isCached);
            jsonObj.put("medallionId", medallionId[i]);
            jsonObj.put("totalTripCount" , tripCount);
            resultArray.put(jsonObj);
        }

        result.put("results", resultArray);
        result.put("pickupDate", formattedDate);
        return result.put("results",resultArray).toString();
    }



}
