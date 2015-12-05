package pbinary;

import java.util.List;

public class VarString extends Variable {

	private String value;
	
	public VarString(String nameIn, String valueIn) {
		super(nameIn);
		value = valueIn;
	}
	
	public VarString(String nameIn) {
		this(nameIn, "");
	}
	
	public VarString(String nameIn, List<Byte> binaryContents) {
		super(nameIn);
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
		return getName() + "=\"" + value + "\"";
	}
	
}
