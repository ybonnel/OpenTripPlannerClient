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

import java.util.ArrayList;
import java.util.List;

public class TraverseModeSet implements Cloneable {

	private List<TraverseMode> modes = new ArrayList<TraverseMode>();

    public TraverseModeSet(TraverseMode... modes) {
        for (TraverseMode mode : modes) {
			this.modes.add(mode);
        }
    }

    public TraverseModeSet(List<TraverseMode> modeList) {
        this(modeList.toArray(new TraverseMode[0]));
    }

    public String toString() {
		String out = "";
		for (TraverseMode mode : modes) {
			if (out != "") {
				out += ",";
			}
			out += mode;
		}
		return out;
    }

}
