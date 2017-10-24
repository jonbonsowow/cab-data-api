package com.company.cabdataapi.service;

import com.company.cabdataapi.repository.SimpleCabRepository;
import com.company.cabdataapi.repository.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by jsbonso on 22/10/17.
 */
@Service(value = "cabDataService")
public class CabDataService implements SimpleCabRepository {

    @Autowired
    private TripRepository tripRepository;

    /**
     * Returns the trip count of a given medallion/cab.
     *
     * If the isCached flag is true, then it will use the cached query
     * else, it will fire a new query to the database using the
     * countTripsByMedallionNoCache() method.
     *
     * @param medallionId
     * @param pickupDate
     * @param isCached
     * @return
     */
    @Override
    public int getCountByMedallionAndPickupDatetime(String medallionId, String pickupDate, boolean isCached){

        long totalTripCount = isCached ? tripRepository.countTripsByMedallion(medallionId, pickupDate) :
                tripRepository.countTripsByMedallionNoCache(medallionId, pickupDate);

        return (int) totalTripCount;
    }
}
