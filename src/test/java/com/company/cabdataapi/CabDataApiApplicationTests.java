package com.company.cabdataapi;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CabDataApiApplicationTests {


	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void contextLoads() {
	}


	/**
	 * Test for single medallion with cache
	 */
	@Test
	public void singleMedallionTest() {
		String testUrl = "/getCountByMedallionAndPickupDatetime?medallionId=000318C2E3E6381580E5C99910A60668" +
				"&pickupDate=2013-12-03";
		String body = this.restTemplate.getForObject(testUrl, String.class);
		JSONObject response = new JSONObject(body);
		JSONArray result = new JSONArray( (response.get("results")).toString() );
		JSONObject cab1 = new JSONObject(result.get(0).toString());

		assertThat(response.get("pickupDate")).isEqualTo("2013-12-03");

		assertThat(cab1.get("medallionId")).isEqualTo("000318C2E3E6381580E5C99910A60668");
		assertThat(cab1.get("totalTripCount")).isEqualTo(7);
	}

	/**
	 * Test for multiple medallion with cache
	 */
	@Test
	public void multipleMedallionTest() {
		String testUrl = "/getCountByMedallionAndPickupDatetime?medallionId=000318C2E3E6381580E5C99910A60668," +
				"00377E15077848677B32CE184CE7E871&pickupDate=2013-12-03";
		String body = this.restTemplate.getForObject(testUrl, String.class);
		JSONObject response = new JSONObject(body);
		JSONArray result = new JSONArray( (response.get("results")).toString() );
		JSONObject cab1 = new JSONObject(result.get(0).toString());
		JSONObject cab2 = new JSONObject(result.get(1).toString());

		assertThat(response.get("pickupDate")).isEqualTo("2013-12-03");

		assertThat(cab1.get("medallionId")).isEqualTo("000318C2E3E6381580E5C99910A60668");
		assertThat(cab1.get("totalTripCount")).isEqualTo(7);

		assertThat(cab2.get("medallionId")).isEqualTo("00377E15077848677B32CE184CE7E871");
		assertThat(cab2.get("totalTripCount")).isEqualTo(4);

	}

	/**
	 * Test for single medallion without cache
	 * by adding a query parameter: (cached=false)
	 */
	@Test
	public void singleMedallionTestWithoutCache() {
		String testUrl = "/getCountByMedallionAndPickupDatetime?medallionId=000318C2E3E6381580E5C99910A60668" +
				"&pickupDate=2013-12-03&cached=false";
		String body = this.restTemplate.getForObject(testUrl, String.class);
		JSONObject response = new JSONObject(body);
		JSONArray result = new JSONArray( (response.get("results")).toString() );
		JSONObject cab1 = new JSONObject(result.get(0).toString());

		assertThat(response.get("pickupDate")).isEqualTo("2013-12-03");

		assertThat(cab1.get("medallionId")).isEqualTo("000318C2E3E6381580E5C99910A60668");
		assertThat(cab1.get("totalTripCount")).isEqualTo(7);
	}

	/**
	 * Test for multiple medallion without cache
	 * by adding a query parameter: (cached=false)
	 */
	@Test
	public void multipleMedallionTestWithoutCache() {
		String testUrl = "/getCountByMedallionAndPickupDatetime?medallionId=000318C2E3E6381580E5C99910A60668," +
				"00377E15077848677B32CE184CE7E871&pickupDate=2013-12-03&cached=false";
		String body = this.restTemplate.getForObject(testUrl, String.class);
		JSONObject response = new JSONObject(body);
		JSONArray result = new JSONArray( (response.get("results")).toString() );
		JSONObject cab1 = new JSONObject(result.get(0).toString());
		JSONObject cab2 = new JSONObject(result.get(1).toString());

		assertThat(response.get("pickupDate")).isEqualTo("2013-12-03");

		assertThat(cab1.get("medallionId")).isEqualTo("000318C2E3E6381580E5C99910A60668");
		assertThat(cab1.get("totalTripCount")).isEqualTo(7);

		assertThat(cab2.get("medallionId")).isEqualTo("00377E15077848677B32CE184CE7E871");
		assertThat(cab2.get("totalTripCount")).isEqualTo(4);

	}


}
