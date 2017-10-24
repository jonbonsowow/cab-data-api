
# Cab Data API

Author: Jon Bonso

## Running the application:

./gradlew build && java -jar build/libs/cab-data-api-0.0.1-SNAPSHOT.jar


## Sample Command Line commands via Curl:
`curl -X GET 'http://localhost:8080/getCountByMedallionAndPickupDatetime?medallionId=000318C2E3E6381580E5C99910A60668&pickupDate=2013-12-03'`
`curl -X GET 'http://localhost:8080/getCountByMedallionAndPickupDatetime?medallionId=000318C2E3E6381580E5C99910A60668,00377E15077848677B32CE184CE7E871&pickupDate=2013-12-03'`


## Sample API Calls (WEB):

![alt text](https://raw.githubusercontent.com/jsbonso/cab-data-api/master/sampleresponse.png)

### Single Medallion/Cab Query WITH Caching:

`http://localhost:8080/getCountByMedallionAndPickupDatetime?medallionId=000318C2E3E6381580E5C99910A60668&pickupDate=2013-12-03`


### Multiple Medallion/Cab Query WITH Caching:

`http://localhost:8080/getCountByMedallionAndPickupDatetime?medallionId=000318C2E3E6381580E5C99910A60668,00377E15077848677B32CE184CE7E871&pickupDate=2013-12-03`


### Single Medallion/Cab Query WITHOUT Caching:

`http://localhost:8080/getCountByMedallionAndPickupDatetime?cached=false&medallionId=000318C2E3E6381580E5C99910A60668&pickupDate=2013-12-03`


### Multiple Medallion/Cab Query WITHOUT Caching:

`http://localhost:8080/getCountByMedallionAndPickupDatetime?cached=false&medallionId=000318C2E3E6381580E5C99910A60668,00377E15077848677B32CE184CE7E871&pickupDate=2013-12-03`

