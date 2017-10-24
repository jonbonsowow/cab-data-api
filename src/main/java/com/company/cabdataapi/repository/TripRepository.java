package com.company.cabdataapi.repository;

import com.company.cabdataapi.model.Trip;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 * Repository for the cab_trip_data table.
 *
 * This contains 2 methods:
 *   countTripsByMedallion         - Uses Cache Data
 *   countTripsByMedallionNoCache  - Invokes CacheEvict, hence, fetches the database everytime.
 *
 * @author Jon Bonso
 */
public interface TripRepository extends CrudRepository<Trip, Long>  {

    // A Cachable query that gets the count of trips a cab made over a period of a given date
    @Query(value="SELECT COUNT(*) FROM cab_trip_data c WHERE medallion = ?1 AND DATE(c.pickup_datetime) = DATE(?2)",
            nativeQuery = true)
    @Cacheable("tripsQuery")
    Long countTripsByMedallion(String id, String name);


    // A non-cacheable query
    @Query(value="SELECT COUNT(*) FROM cab_trip_data c WHERE medallion = ?1 AND DATE(c.pickup_datetime) = DATE(?2)",
            nativeQuery = true)
    @CacheEvict(value = "tripsQuery", beforeInvocation = true)
    @Cacheable(value = "tripsQuery")
    Long countTripsByMedallionNoCache(String id, String name);


}
