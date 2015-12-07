package phoebinary.variabletypes;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.List;

import phoebinary.ByteOperations;
import phoebinary.MalformedVariableException;
import phoebinary.Variable;

/*
 * may not hold null values
 */
public class VarObject extends Variable {

	private Serializable value;
	
	public VarObject(String name, Serializable valueIn) {
		super(name);
		if (valueIn == null) {
			throw new NullPointerException();
		} else {
			value = valueIn;
		}
	}
	
	public VarObject() {
		super(null);
	}
	
	public void construct(List<Byte> binaryContents) {
		byte[] bytes = ByteOperations.byteListToArray(binaryContents);
		try (
				ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
				ObjectInput in = new ObjectInputStream(bais)
						) {
			value = (Serializable) in.readObject();
		} catch (IOException e) {
			e.printStackTrace();
			throw new MalformedVariableException();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new MalformedVariableException();
		}
	}
	
	@Override
	public List<Byte> getBinaryContents() {
		try (
				ByteArrayOutputStream baos = new ByteArrayOutputStream();
				ObjectOutput out = new ObjectOutputStream(baos)
						) {
			out.writeObject(value);
			return ByteOperations.byteArrayToList(baos.toByteArray());
		} catch (IOException e) {
			e.printStackTrace();
			throw new MalformedVariableException();
		}
	}
	
	public void setValue(Serializable i) {
		if (i == null) {
			throw new NullPointerException();
		} else {
			value = i;
		}
	}
	
	public Serializable getValue() {
		return value;
	}
	
	public String toString() {
		return "object " + getName() + " = " + value;
	}
	
}
