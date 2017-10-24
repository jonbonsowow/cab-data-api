package com.company.cabdataapi.repository;

/**
 * @author Jon Bonso
 */
public interface SimpleCabRepository {

  int getCountByMedallionAndPickupDatetime(String medallionId, String pickupDate, boolean isCached);

}
