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
    private double lowerLeftLatitude, lowerLeftLongitude, upperRightLatitude, upperRightLongitude;

    public double getLowerLeftLatitude() {
        return lowerLeftLatitude;
    }

    public void setLowerLeftLatitude(double lowerLeftLatitude) {
        this.lowerLeftLatitude = lowerLeftLatitude;
    }

    public double getLowerLeftLongitude() {
        return lowerLeftLongitude;
    }

    public void setLowerLeftLongitude(double lowerLeftLongitude) {
        this.lowerLeftLongitude = lowerLeftLongitude;
    }

    public double getUpperRightLatitude() {
        return upperRightLatitude;
    }

    public void setUpperRightLatitude(double upperRightLatitude) {
        this.upperRightLatitude = upperRightLatitude;
    }

    public double getUpperRightLongitude() {
        return upperRightLongitude;
    }

    public void setUpperRightLongitude(double upperRightLongitude) {
        this.upperRightLongitude = upperRightLongitude;
    }
    
    public double getMinLatitude() {
        return lowerLeftLatitude;
    }
    
    public double getMinLongitude() {
        return lowerLeftLongitude;
    }
    
    public double getMaxLatitude() {
        return upperRightLatitude;
    }
    
    public double getMaxLongitude() {
        return upperRightLongitude;
    }
}
