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

/**
 *
 */
public class Response implements Serializable {

	private static final long serialVersionUID = 1L;
	private TripPlan plan;
    private PlannerError error = null;


    /**
     * The actual trip plan.
     */
    public TripPlan getPlan() {
        return plan;
    }

    public void setPlan(TripPlan plan) {
        this.plan = plan;
    }

    /**
     * The error (if any) that this response raised.
     */
    public PlannerError getError() {
        return error;
    }

    public void setError(PlannerError error) {
        this.error = error;
    }

    @Override
    public String toString() {
        return "Response{" +
                "plan=" + plan +
                ", error=" + error +
                '}';
    }
}