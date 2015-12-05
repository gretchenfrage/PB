package pbinary;

import java.util.ArrayList;
import java.util.List;

public class VarBoolean extends Variable {

	private boolean value;
	
	public VarBoolean(String nameIn, boolean valueIn) {
		super(nameIn);
		value = valueIn;
	}
	
	public VarBoolean(String nameIn) {
		this(nameIn, false);
	}
	
	public VarBoolean(String nameIn, List<Byte> binaryContents) {
		super(nameIn);
		if (binaryContents.size() == 1) {
			value = binaryContents.get(0) == 1;
		} else {
			throw new MalformedVariableException();
		}
	}

	@Override
	public List<Byte> getBinaryContents() {
		List<Byte> out = new ArrayList<Byte>();
		out.add((byte) (value ? 1 : 0));
		return out;
	}
	
	public void setValue(boolean i) {
		value = i;
	}
	
	public boolean getValue() {
		return value;
	}
	
}
