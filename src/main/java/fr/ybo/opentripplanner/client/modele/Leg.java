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
import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.sun.xml.internal.xsom.impl.scd.Step;

/**
 * One leg of a trip -- that is, a temporally continuous piece of the journey that takes place on a
 * particular vehicle (or on foot).
 */

public class Leg implements Serializable {
	
	private static final long serialVersionUID = 1L;

    /**
     * The date and time this leg begins.
     */
    public Date startTime = null;
    
    /**
     * The date and time this leg ends.
     */
    public Date endTime = null;
    
    /**
     * The distance traveled while traversing the leg in meters.
     */
    public Double distance = null;

    /**
     * The mode (e.g., <code>Walk</code>) used when traversing this leg.
     */
    public String mode = TraverseMode.WALK.toString();

    /**
     * For transit legs, the route of the bus or train being used. For non-transit legs, the name of
     * the street being traversed.
     */
    public String route = "";

    /**
     * For transit legs, the headsign of the bus or train being used. For non-transit legs, null.
     */
    public String headsign = null;

    /**
     * For transit legs, the ID of the transit agency that operates the service used for this leg.
     * For non-transit legs, null.
     */
    public String agencyId = null;
    
    /**
     * The Place where the leg originates.
     */
    public Place from = null;
    
    /**
     * The Place where the leg begins.
     */
    public Place to = null;
    
    /**
     * The leg's geometry.
     */
    public EncodedPolylineBean legGeometry;

    /**
     * A series of turn by turn instructions used for walking, biking and driving. 
     */
	public List<WalkStep> steps = null;
    
    /** 
     * The leg's duration in milliseconds
     */
    public long getDuration() {
        return endTime.getTime() - startTime.getTime();
    }

	public String getDirection() {
		String[] split = headsign.split("\\|");
		if (split.length < 2) {
			return headsign;
		}
		String direction = split[1];
		while (direction.charAt(0) == ' ') {
			direction = direction.substring(1);
		}
		return direction;
	}

    @Override
    public String toString() {
        return "Leg{" +
                "startTime=" + startTime +
                ", endTime=" + endTime +
                ", distance=" + distance +
                ", mode='" + mode + '\'' +
                ", route='" + route + '\'' +
                ", headsign='" + headsign + '\'' +
                ", agencyId='" + agencyId + '\'' +
                ", from=" + from +
                ", to=" + to +
                ", legGeometry=" + legGeometry +
                ", steps=" + steps +
                '}';
    }
}
