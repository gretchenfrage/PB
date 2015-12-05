package pbinary;

import java.util.List;

public class VarDouble extends Variable {

	private double value;
	
	public VarDouble(String nameIn, double valueIn) {
		super(nameIn);
		value = valueIn;
	}
	
	public VarDouble(String nameIn) {
		this(nameIn, 0);
	}
	
	public VarDouble(String nameIn, List<Byte> binaryContents) {
		super(nameIn);
		try {
			value = Double.parseDouble(ByteOperations.bytesToString(binaryContents));
		} catch (NumberFormatException e) {
			throw new MalformedVariableException();
		}
	}
	
	@Override
	public List<Byte> getBinaryContents() {
		return ByteOperations.stringToByteList(Double.toString(value));
	}
	
	public void setValue(double i) {
		value = i;
	}
	
	public double getValue() {
		return value;
	}
	
	public String toString() {
		return getName() + "=" + value;
	}
	
}
