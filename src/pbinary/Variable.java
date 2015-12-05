package pbinary;

import java.util.ArrayList;
import java.util.List;

public abstract class Variable {
	
	/*
	 * returns the byte associated for var's type
	 */
	public static final byte getType(Variable var) {
		if (var instanceof VarInteger) {
			return VAR_INT;
		} else if (var instanceof VarBoolean) {
			return VAR_BOOLEAN;
		} else if (var instanceof VarByte) {
			return VAR_BYTE;
		} else if (var instanceof VarChar) {
			return VAR_CHAR;
		} else if (var instanceof VarDouble) {
			return VAR_DOUBLE;
		} else if (var instanceof VarLong) {
			return VAR_LONG;
		} else {
			//this should never happen
			return -1;
		}
	}
	
	/*
	 * the associated byte values for different variable types
	 */
	public static final byte VAR_INT = 0;
	public static final byte VAR_BOOLEAN = 1;
	public static final byte VAR_BYTE = 2;
	public static final byte VAR_CHAR = 3;
	public static final byte VAR_DOUBLE = 4;
	public static final byte VAR_LONG = 5;

	/*
	 * the name of the variable
	 */
	protected final String name;
	
	/*
	 * constructs a variable with the given name
	 */
	public Variable(String nameIn) {
		name = nameIn;
	}
	
	/*
	 * convert the object's data into binary contents that can be read later
	 */
	public abstract List<Byte> getBinaryContents();
	
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
	
	/*
	 * constructs a new variable object from a type, a name, and binary contents. should only throw malformedvariableexception if data is corrupted
	 */
	public static final Variable constructFromBinary(byte type, String nameIn, List<Byte> contents) {
		if (type == VAR_INT) {
			return new VarInteger(nameIn, contents);
		} else if (type == VAR_BYTE) {
			return new VarByte(nameIn, contents);
		} else if (type == VAR_CHAR) {
			return new VarChar(nameIn, contents);
		} else if (type == VAR_DOUBLE) {
			return new VarDouble(nameIn, contents);
		} else if (type == VAR_LONG) {
			return new VarLong(nameIn, contents);
		} else {
			throw new MalformedVariableException();
		}
	}
	
}