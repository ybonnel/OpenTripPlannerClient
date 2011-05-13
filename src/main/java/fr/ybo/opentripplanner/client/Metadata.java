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

package fr.ybo.opentripplanner.client;

import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.net.URLConnection;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import fr.ybo.opentripplanner.client.modele.GraphMetadata;

public class Metadata {

	private String urlMetadata;

	protected Metadata(String baseUrl) {
		urlMetadata = baseUrl + Constantes.URL_METADATA;
	}

	/**
	 * Returns metadata about the graph -- presently, this is just the extent of
	 * the graph.
	 * 
	 * @return Returns either an XML or a JSON document, depending on the HTTP
	 *         Accept header of the client making the request.
	 * @throws OpenTripPlannerException
	 *             en cas de problème.
	 */
	protected GraphMetadata getMetadata() throws OpenTripPlannerException {
		GraphMetadata reponse = null;
		try {
			URL url = new URL(urlMetadata);
			URLConnection connection = url.openConnection();
			connection.setRequestProperty("Content-Type", "application/json");
			connection.setRequestProperty("Accept", "application/json");
			Gson gson = new GsonBuilder().create();
			Reader reader = new InputStreamReader(connection.getInputStream(), Constantes.ENCODAGE);
			try {
				reponse = gson.fromJson(reader, GraphMetadata.class);
			} finally {
				reader.close();
			}
		} catch (Exception exception) {
			throw new OpenTripPlannerException(exception);
		}

		return reponse;
    }
}
