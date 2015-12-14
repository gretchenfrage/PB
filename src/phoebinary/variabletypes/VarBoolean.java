package phoebinary.variabletypes;

import java.util.ArrayList;
import java.util.List;

import phoebinary.Variable;
import phoebinary.exceptions.MalformedVariableException;

public class VarBoolean extends Variable {

	private boolean value;
	
	public VarBoolean(String name, boolean valueIn) {
		super(name);
		value = valueIn;
	}
	
	public VarBoolean(String name) {
		super(name);
		value = false;
	}
	
	public VarBoolean(String nameIn, List<Byte> binaryContents) {
		super(nameIn);
		if (binaryContents.size() == 1) {
			value = binaryContents.get(0) == 1;
		} else {
			throw new MalformedVariableException();
		}
	}
	
	public VarBoolean construct(String name, List<Byte> binaryContents) {
		super(name)
		if (binaryContents.size() == 1) {
			value = binaryContents.get
		}
	}
	
	public void construct(List<Byte> binaryContents) {
		if (binaryContents.size() == 1) {
			value = binaryContents.get(0);
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
	
	public String toString() {
		return "boolean " + getName() + " = " + value;
	}
	
}
