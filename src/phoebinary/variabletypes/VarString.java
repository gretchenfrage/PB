package phoebinary.variabletypes;

import java.util.List;

import phoebinary.ByteOperations;
import phoebinary.Variable;

public class VarString extends Variable {

	private String value;
	
	public VarString(String name, String valueIn) {
		super(name);
		value = valueIn;
	}
	
	public VarString(String name) {
		super(name);
		value = "";
	}
	
	public VarString() {
		super(null);
	}
	
	public void construct(List<Byte> binaryContents) {
		value = ByteOperations.bytesToString(binaryContents);
	}

	@Override
	public List<Byte> getBinaryContents() {
		return ByteOperations.stringToByteList(value);
	}
	
	public void setValue(String i) {
		value = i;
	}
	
	public String getValue() {
		return value;
	}
	
	public String toString() {
		return "string " + getName() + " = \"" + value + "\"";
	}
	
}
