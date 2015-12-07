package phoebinary.variabletypes;

import java.util.ArrayList;
import java.util.List;

import phoebinary.MalformedVariableException;
import phoebinary.Variable;

public class VarByte extends Variable {

	private byte value;
	
	public VarByte(String name, byte valueIn) {
		super(name);
		value = valueIn;
	}
	
	public VarByte(String name) {
		super(name);
		value = 0;
	}
	
	public VarByte() {
		super(null);
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
		out.add(value);
		return out;
	}
	
	public void setValue(byte i) {
		value = i;
	}
	
	public byte getValue() {
		return value;
	}
	
	public String toString() {
		return "byte " + getName() + " = " + value;
	}
	
}
