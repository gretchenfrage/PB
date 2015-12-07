package phoebinary.variabletypes;

import java.util.List;

import phoebinary.ByteOperations;
import phoebinary.Variable;

public class VarInteger extends Variable {

	private int value;
	
	public VarInteger(String name, int valueIn) {
		super(name);
		value = valueIn;
	}
	
	public VarInteger(String name) {
		super(name);
		value = 0;
	}
	
	public VarInteger() {
		super(null);
	}
	
	public void construct(List<Byte> binaryContents) {
		value = ByteOperations.multibyteToInt(binaryContents);
	}

	@Override
	public List<Byte> getBinaryContents() {
		return ByteOperations.intToMultibyteList(value);
	}
	
	public void setValue(int i) {
		value = i;
	}
	
	public int getValue() {
		return value;
	}
	
	public String toString() {
		return "integer " + getName() + " = " + value;
	}

}
