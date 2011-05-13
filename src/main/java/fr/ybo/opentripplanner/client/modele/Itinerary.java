/* This program is free software: you can redistribute it and/or
 modify it under the terms of the GNU Lesser General Public License
 as published by the Free Software Foundation, either version 3 of
 the License, or (at your option) any later version.

 This program is distributed in the hope that it will be useful,
 but WITHOUT ANY WARRANTY; without even the implied warranty of
 MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 GNU General Public License for more details.

 You should have received a copy of the GNU General Public License
 along with this program.  If not, see <http://www.gnu.org/licenses/>. */
package fr.ybo.opentripplanner.client.modele;

import java.io.Serializable;
import java.util.Date;

/**
 * An Itinerary is one complete way of getting from the start location to the end location.
 */
public class Itinerary implements Serializable {
	
	private static final long serialVersionUID = 1L;

    /**
     * Duration of the trip on this itinerary, in milliseconds.
     */
    public long duration = 0;

    /**
     * Time that the trip departs.
     */
    public Date startTime = null;
    /**
     * Time that the trip arrives.
     */
    public Date endTime = null;

    /**
     * How much time is spent walking, in milliseconds.
     */
    public long walkTime = 0;
    /**
     * How much time is spent on transit, in milliseconds.
     */
    public long transitTime = 0;
    /**
     * How much time is spent waiting for transit to arrive, in milliseconds.
     */
    public long waitingTime = 0;

    /**
     * How far the user has to walk, in meters.
     */
    public Double walkDistance = 0.0;

    /**
     * How much elevation is lost, in total, over the course of the trip, in meters. As an example,
     * a trip that went from the top of Mount Everest straight down to sea level, then back up K2,
     * then back down again would have an elevationLost of Everest + K2.
     */
    public Double elevationLost = 0.0;
    /**
     * How much elevation is gained, in total, over the course of the trip, in meters. See
     * elevationLost.
     */
    public Double elevationGained = 0.0;

    /**
     * The number of transfers this trip has.
     */
    public Integer transfers = 0;

    /**
     * The cost of this trip
     */
    public Fare fare = new Fare();

    /**
     * A list of Legs. Each Leg is either a walking (cycling, car) portion of the trip, or a transit
     * trip on a particular vehicle. So a trip where the use walks to the Q train, transfers to the
     * 6, then walks to their destination, has four legs.
     */
	public Legs legs = null;

    /**
     * This itinerary has a greater slope than the user requested (but there are no possible 
     * itineraries with a good slope). 
     */
    public boolean tooSloped = false;

}
