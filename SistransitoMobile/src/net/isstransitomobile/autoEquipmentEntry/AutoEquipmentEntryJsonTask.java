package net.isstransitomobile.autoEquipmentEntry;

import java.util.ArrayList;

import net.sistransitomobile.database.DatabaseCreator;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;

public class AutoEquipmentEntryJsonTask {
	private AutoEquipmentEntry autoEquipmentEntry;
	private ArrayList<AutoEquipmentEntry> entries;
	private JSONArray jsonArray;
	private JSONObject object;

	private Context context;

	private String json;

	public AutoEquipmentEntryJsonTask(String json, Context context) {

		this.context = context;
		this.json = json;

	}

	public void prepareEntry() {

		try {
			entries = new ArrayList<AutoEquipmentEntry>();
			jsonArray = new JSONArray(json);
			for (int i = 0; i < jsonArray.length(); i++) {
				object = jsonArray.getJSONObject(i);
				autoEquipmentEntry = new AutoEquipmentEntry(
						object.getString("descricao"),
						object.getString("marca"), object.getString("modelo"),
						object.getString("validade"));
				entries.add(autoEquipmentEntry);
			}
			(DatabaseCreator.getPrepopulatedDBOpenHelper(context))
					.setAutoEquipamentoEntryCoursor(entries);

		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
