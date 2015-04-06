package net.sistransitomobile.autode;

public class AutoDeObgect {
	private static AutoDeData autoDeData;

	private AutoDeObgect() {
		autoDeData = new AutoDeData();
	}

	public static AutoDeData getAutoDeOject() {
		return autoDeData;
	}

	public static void setAutoDeObject(AutoDeData data) {
		autoDeData = data;
	}
}
