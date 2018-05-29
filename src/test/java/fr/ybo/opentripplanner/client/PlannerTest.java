package fr.ybo.opentripplanner.client;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import fr.ybo.opentripplanner.client.modele.Itinerary;
import fr.ybo.opentripplanner.client.modele.Leg;
import fr.ybo.opentripplanner.client.modele.Request;
import fr.ybo.opentripplanner.client.modele.Response;
import fr.ybo.opentripplanner.client.modele.TraverseMode;
import fr.ybo.opentripplanner.client.modele.TraverseModeSet;

public class PlannerTest {
	
	@Test
	public void choixMode() throws ParseException, OpenTripPlannerException {
		Date date = new Date();
		// toPlace=44.825920698932%2C-0.58469463769264&fromPlace=44.830912280174%2C-0.57263542596218
		Request request = new Request(44.830912280174, -0.57263542596218, 44.825920698932, -0.58469463769264, date);
		boolean bus = true;
		boolean tram = true;
		List<TraverseMode> modes = new ArrayList<TraverseMode>();
		modes.add(TraverseMode.WALK);
		if (bus && tram) {
			modes.add(TraverseMode.TRANSIT);
		} else if (bus) {
			modes.add(TraverseMode.BUSISH);
			modes.add(TraverseMode.BUS);
		} else if (tram) {
			modes.add(TraverseMode.TRAM);
			modes.add(TraverseMode.TRAINISH);
		}
		request.setModes(new TraverseModeSet(modes));
		ClientOpenTripPlanner client = new ClientOpenTripPlanner(
				"http://109.238.11.47:8080", "bordeaux");
		Response response = client.getItineraries(request);
		System.out.println(response.getPlan().itineraries.size());
		System.out.println(response.toString());

	}

	@Test
	public void testPlannerAno() throws ParseException, OpenTripPlannerException {
		SimpleDateFormat SDF = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date date = SDF.parse("05/04/2011 12:00:00");
		Request request = new Request(48.3349386, -1.1211244, 48.1160495, -1.6789079, date);
		ClientOpenTripPlanner client = new ClientOpenTripPlanner(
				"http://109.238.11.47:8080", "bordeaux");
		client.getItineraries(request);
	}

	// 91 rue de paris :
	// lat=48.1138212, lng=-1.6606638
	// 29 rue d'antrain
	// lat=48.1160495, lng=-1.6789079

	@Test
	@Ignore
	public void testPlanner() throws ParseException, OpenTripPlannerException {
		SimpleDateFormat SDF = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date date = new Date();
		Request request = new Request(48.1138212, -1.6606638, 48.1160495, -1.6789079, date);
		ClientOpenTripPlanner client = new ClientOpenTripPlanner(
				"http://109.238.11.47:8080", "rennes");
		Response response = client.getItineraries(request);
		System.out.println(response.toString());
		assertNotNull(response);
		assertNull(response.getError());
		assertNotNull(response.getPlan());
		assertEquals(date.getTime() /1000, response.getPlan().date.getTime() / 1000);
		assertNotNull(response.getPlan().from);
		assertEquals(48.1138212, response.getPlan().from.lat, 0.001);
		assertEquals(-1.6606638, response.getPlan().from.lon, 0.001);
		assertEquals("Origin", response.getPlan().from.name);
		assertEquals(48.1160495, response.getPlan().to.lat, 0.001);
		assertEquals(-1.6789079, response.getPlan().to.lon, 0.001);
		assertEquals("Destination", response.getPlan().to.name);
		assertEquals(3, response.getPlan().itineraries.size());
		Itinerary itineraire = response.getPlan().itineraries.get(0);
		
		assertEquals(1024, itineraire.duration);
		
		assertEquals(782, itineraire.walkTime);
		
		assertEquals(240, itineraire.transitTime);
		// 3 minutes 43 secondes
		assertEquals(2, itineraire.waitingTime);
		assertEquals(994.7831353333723, itineraire.walkDistance, 0.001);
		assertEquals(0.0, itineraire.elevationLost, 0.001);
		assertEquals(0.0, itineraire.elevationGained, 0.001);
		assertEquals(0, itineraire.transfers.intValue());
		assertFalse(itineraire.tooSloped);
		assertNotNull(itineraire.legs);
		assertEquals(3, itineraire.legs.size());
		// Première étape, à pied jusqu'à l'arret oberthur.
		Leg leg = itineraire.legs.get(0);
		assertEquals("WALK", leg.mode);
		

		// Bus de oberthur à république
		leg = itineraire.legs.get(1);
		assertEquals("BUS", leg.mode);
		assertEquals("44", leg.route);
		assertEquals("République", leg.headsign);
		System.out.println(leg.legGeometry);
		assertEquals("1:1115", leg.from.stopId);
		assertEquals("1:1118", leg.to.stopId);

		leg = itineraire.legs.get(2);
		assertEquals("WALK", leg.mode);
	}

	@Test(expected = OpenTripPlannerException.class)
	public void testPlannerError() throws ParseException, OpenTripPlannerException {
		SimpleDateFormat SDF = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date date = SDF.parse("05/04/2011 12:00:00");
		Request request = new Request(48.1138212, -1.6606638, 48.1160495, -1.6789079, date);
		ClientOpenTripPlanner client = new ClientOpenTripPlanner("http://tutu:8080", "");
		client.getItineraries(request);
	}

}
