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


public class GraphMetadata {

    /**
     * The bounding box of the graph, in decimal degrees.
     */
    private double minLatitude, minLongitude, maxLatitude, maxLongitude;


    public void setMinLatitude(double minLatitude) {
        this.minLatitude = minLatitude;
    }

    public double getMinLatitude() {
        return minLatitude;
    }

    public void setMaxLongitude(double maxLongitude) {
        this.maxLongitude = maxLongitude;
    }

    public double getMaxLongitude() {
        return maxLongitude;
    }

    public void setMinLongitude(double minLongitude) {
        this.minLongitude = minLongitude;
    }

    public double getMinLongitude() {
        return minLongitude;
    }

    public void setMaxLatitude(double maxLatitude) {
        this.maxLatitude = maxLatitude;
    }

    public double getMaxLatitude() {
        return maxLatitude;
    }
}
