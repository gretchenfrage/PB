package phoebinary;

import java.util.ArrayList;
import java.util.List;

public abstract class Variable {

	private String name;
	
	public Variable(String nameIn) {
		name = nameIn;
	}
	
	public abstract List<Byte> getBinaryContents();
	public abstract void construct(List<Byte> binaryContents);
	
	/*
	 * variable type - 1 byte
	 * name byte length - 4 bytes
	 * name - indeterminate bytes
	 * contents byte length - 4 bytes
	 * contents - indeterminate bytes
	 */
	public final List<Byte> getBinary() {
		List<Byte> bytes = new ArrayList<Byte>();
		bytes.add(getType(this));
		List<Byte> nameBytes = ByteOperations.stringToByteList(name);
		List<Byte> nameLength = ByteOperations.justify(ByteOperations.intToMultibyteList(nameBytes.size()), 4);
		bytes.addAll(nameLength);
		bytes.addAll(nameBytes);
		List<Byte> binaryContents = getBinaryContents();
		List<Byte> contentsLength = ByteOperations.justify(ByteOperations.intToMultibyteList(binaryContents.size()), 4);
		bytes.addAll(contentsLength);
		bytes.addAll(binaryContents);
		return bytes;
	}
	
	public final String getName() {
		return name;
	}
	
	public final void rename(String nameIn) {
		name = nameIn;
	}
	
}
