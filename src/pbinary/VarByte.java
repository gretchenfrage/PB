package pbinary;

import java.util.ArrayList;
import java.util.List;

public class VarByte extends Variable {

	private byte value;
	
	public VarByte(String nameIn, byte valueIn) {
		super(nameIn);
		value = valueIn;
	}
	
	public VarByte(String nameIn) {
		this(nameIn, (byte) 0);
	}
	
	public VarByte(String nameIn, List<Byte> binaryContents) {
		super(nameIn);
		if (binaryContents.size() == 1) {
			value = binaryContents.get(0);
		} else {
			throw new MalformedVariableException();
		}
	}

	@Override
	public List<Byte> getBinaryContents() {
		List<Byte> out = new ArrayList<Byte>();
		out.add(value);
		return out;
	}
	
	public void setValue(byte i) {
		value = i;
	}
	
	public byte getValue() {
		return value;
	}
	
}
