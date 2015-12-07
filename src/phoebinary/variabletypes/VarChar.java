package phoebinary.variabletypes;

import java.util.List;

import phoebinary.ByteOperations;
import phoebinary.Variable;

public class VarChar extends Variable {

	private char value;

	public VarChar(String name, char valueIn) {
		super(name);
		value = valueIn;
	}

	public VarChar(String name) {
		super(name);
		value = ' ';
	}
	
	public VarChar() {
		super(null);
	}
	
	public void construct(List<Byte> binaryContents) {
		value = (char) ByteOperations.multibyteToInt(binaryContents);
	}

	@Override
	public List<Byte> getBinaryContents() {
		return ByteOperations.intToMultibyteList(value);
	}

	public void setValue(char i) {
		value = i;
	}
	
	public char getValue() {
		return value;
	}
	
	public String toString() {
		return "char " + getName() + " = '" + value + "'";
	}

}
