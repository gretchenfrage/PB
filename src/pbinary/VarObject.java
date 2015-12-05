package pbinary;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.List;

/*
 * may not hold null values
 */
public class VarObject extends Variable {

	private Object value;
	
	public VarObject(String nameIn, Object valueIn) {
		super(nameIn);
		if (valueIn == null) {
			throw new NullPointerException();
		} else {
			value = valueIn;
		}
	}
	
	public VarObject(String nameIn, List<Byte> binaryContents) {
		super(nameIn);
		byte[] bytes = ByteOperations.byteListToArray(binaryContents);
		try (
				ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
				ObjectInput in = new ObjectInputStream(bais)
						) {
			value = in.readObject();
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
	
	public void setValue(Object i) {
		if (i == null) {
			throw new NullPointerException();
		} else {
			value = i;
		}
	}
	
	public Object getValue() {
		return value;
	}
	
	public String toString() {
		return "object " + getName() + " = " + value;
	}
	
}
