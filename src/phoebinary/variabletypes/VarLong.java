package phoebinary.variabletypes;

import java.util.List;

import phoebinary.ByteOperations;
import phoebinary.Variable;

public class VarLong extends Variable {
	
	private long value;
	
	public VarLong(String name, long valueIn) {
		super(name);
		value = valueIn;
	}
	
	public VarLong(String name) {
		super(name);
		value = 0;
	}
	
	public VarLong() {
		super(null);
	}
	
	public void construct(List<Byte> binaryContents) {
		value = ByteOperations.multibyteToLong(binaryContents);
	}

	@Override
	public List<Byte> getBinaryContents() {
		return ByteOperations.longToMultibyteList(value);
	}
	
	public void setValue(int i) {
		value = i;
	}
	
	public long getValue() {
		return value;
	}
	
	public String toString() {
		return "long " + getName() + " = " + value;
	}
	
}
