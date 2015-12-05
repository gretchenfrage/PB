package phoebinary;

import java.util.List;

public class VarInteger extends Variable {

	/*
	 * the value of the integer variable
	 */
	private int value;
	
	/*
	 * constructs a VarInteger object with the given name and value
	 */
	public VarInteger(String nameIn, int valueIn) {
		super(nameIn);
		value = valueIn;
	}
	
	/*
	 * constructs a VarInteger object with the given name and the value 0
	 */
	public VarInteger(String nameIn) {
		this(nameIn, 0);
	}
	
	/*
	 * constructs a VarInteger object with the given name and the binary variable contents with which to extract the value
	 */
	public VarInteger(String nameIn, List<Byte> binaryContents) {
		super(nameIn);
		value = ByteOperations.multibyteToInt(binaryContents);
	}

	/*
	 * converts the integer value to the binary contents
	 */
	@Override
	public List<Byte> getBinaryContents() {
		return ByteOperations.intToMultibyteList(value);
	}
	
	/*
	 * sets the integer value
	 */
	public void setValue(int i) {
		value = i;
	}
	
	/*
	 * gets the integer value
	 */
	public int getValue() {
		return value;
	}
	
	public String toString() {
		return "integer " + getName() + " = " + value;
	}

}
