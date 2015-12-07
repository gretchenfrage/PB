package phoebinary;

import java.util.List;

public class MiscFunctions {
	
	public static Variable getVariableNamed(String name, List<Variable> variables) {
		for (Variable v : variables) {
			if (v.getName().equals(name)) {
				return v;
			}
		}
		return null;
	}
	
	public static String[] reducePath(String[] path) {
		String[] out = new String[path.length - 1];
		for (int i = 1; i < path.length; i++) {
			out[i - 1] = path[i];
		}
		return out;
	}
	
}
