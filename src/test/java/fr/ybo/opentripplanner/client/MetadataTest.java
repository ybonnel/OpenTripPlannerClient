package fr.ybo.opentripplanner.client;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import fr.ybo.opentripplanner.client.modele.GraphMetadata;

public class MetadataTest {

	@Test
	public void testGetMetadata() throws OpenTripPlannerException {
		GraphMetadata metadata = new ClientOpenTripPlanner(
				"http://109.238.11.47:8080", "rennes").getMetadata();
		assertNotNull(metadata);
		assertEquals(47.9179831, metadata.getMinLatitude(), 0.0000001);
		assertEquals(48.3784029, metadata.getMaxLatitude(), 0.0000001);
		assertEquals(-2.0216094, metadata.getMinLongitude(), 0.0000001);
		assertEquals(-1.4226161, metadata.getMaxLongitude(), 0.0000001);
	}

	@Test(expected = OpenTripPlannerException.class)
	public void testGetMetadataErreur() throws OpenTripPlannerException {
		new ClientOpenTripPlanner("http://tutu:8080", "rennes").getMetadata();
	}

}
