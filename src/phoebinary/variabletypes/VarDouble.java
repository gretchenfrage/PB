package phoebinary.variabletypes;

import java.util.List;

import phoebinary.ByteOperations;
import phoebinary.MalformedVariableException;
import phoebinary.Variable;

public class VarDouble extends Variable {

	private double value;
	
	public VarDouble(String name, double valueIn) {
		super(name);
		value = valueIn;
	}
	
	public VarDouble(String name) {
		super(name);
		value = 0;
	}
	
	public VarDouble() {
		super(null);
	}
	
	public void construct(List<Byte> binaryContents) {
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
		return "double " + getName() + " = " + value;
	}
	
}
