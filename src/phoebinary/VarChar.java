package phoebinary;

import java.util.List;

public class VarChar extends Variable {

	private char value;

	public VarChar(String nameIn, char valueIn) {
		super(nameIn);
		value = valueIn;
	}

	public VarChar(String nameIn) {
		this(nameIn, ' ');
	}

	public VarChar(String nameIn, List<Byte> binaryContents) {
		super(nameIn);
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
