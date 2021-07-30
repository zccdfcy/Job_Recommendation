package rpc;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URLDecoder;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONArray;
import org.json.JSONObject;
import entity.Item;


public class RpcHelper {
	// Writes a JSONArray to http response.
		public static void writeJsonArray(HttpServletResponse response, JSONArray array) throws IOException{
			response.setContentType("application/json");
			response.getWriter().print(array);

		}

	              // Writes a JSONObject to http response.
		public static void writeJsonObject(HttpServletResponse response, JSONObject obj) throws IOException {		
			response.setContentType("application/json");
			response.getWriter().print(obj);

		}
		// Convert a JSON Object to Item Object
		public static Item parseFavoriteItem(JSONObject favoriteItem) {
			Set<String> keywords = new HashSet<>();
			JSONArray array = favoriteItem.getJSONArray("keywords");
			for (int i = 0; i < array.length(); ++i) {
				keywords.add(array.getString(i));
			}
			return Item.builder()
					.itemId(favoriteItem.getString("item_id"))
					.name(favoriteItem.getString("name"))
					.address(favoriteItem.getString("address"))
					.url(favoriteItem.getString("url"))
					.imageUrl(favoriteItem.getString("image_url"))
			        .keywords(keywords)
			        .build();
		}
		// Read a JSONObject from a http request
		public static JSONObject readJSONObject(HttpServletRequest request) {
			try {
				BufferedReader br = new BufferedReader(new InputStreamReader(
						request.getInputStream()));
				String line = null;
				StringBuilder sb = new StringBuilder();
				while ((line = br.readLine()) != null) {
					sb.append(line);
				}
	 
				String reqBody = sb.toString();
				JSONObject json = new JSONObject(reqBody);
				return json;
			} catch (Exception e) {
				return null;
			}

		}


}
