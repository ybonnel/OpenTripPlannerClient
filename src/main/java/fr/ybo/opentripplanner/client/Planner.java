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
import java.lang.reflect.Type;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;

import com.google.gson.*;

import fr.ybo.opentripplanner.client.modele.Request;
import fr.ybo.opentripplanner.client.modele.Response;

public class Planner {

	private String urlPlanner;

	protected Planner(String baseUrl) {
		urlPlanner = baseUrl;
	}

	protected Response getItineraries(Request request) throws OpenTripPlannerException {
		Response reponse;
		try {
			URL url = new URL(request.constructUrl(urlPlanner));

			System.out.println(url);
			URLConnection connection = url.openConnection();
			connection.setRequestProperty("Content-Type", "application/json");
			connection.setRequestProperty("Accept", "application/json");

			Gson gson = new GsonBuilder().registerTypeAdapter(
					Date.class,
					new JsonDeserializer<Date>() {
						@Override
						public Date deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
							return new Date(json.getAsJsonPrimitive().getAsLong());
						}
					}
			).create();
			Reader reader = new InputStreamReader(connection.getInputStream(), Constantes.ENCODAGE);
			try {
				reponse = gson.fromJson(reader, Response.class);
			} finally {
				try {
					reader.close();
				} catch (Exception ignore) {

				}
			}
		} catch (Exception exception) {
			throw new OpenTripPlannerException(exception, request);
		}
		return reponse;
    }

}
