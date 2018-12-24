package functional.demo1;

import java.util.*;

public class FieldConfAccompany {
	
	private static Map<String, FieldConf> fieldConfMap = new HashMap<String, FieldConf>();
	private static List<String> allFields = new ArrayList<>();
	
	static {
		for (FieldConf fc : FieldConf.values()) {
			fieldConfMap.put(fc.name(), fc);
			allFields.add(fc.getName());
		}
	}
	
	public static FieldConf getInstance(String name) {
		return fieldConfMap.get(name);
	}
	
	public static List<String> getAllFields() {
		return Collections.unmodifiableList(allFields);
	}
}