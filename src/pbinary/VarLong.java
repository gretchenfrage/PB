package pbinary;

import java.util.List;

public class VarLong extends Variable {
	
	private long value;
	
	public VarLong(String nameIn, long valueIn) {
		super(nameIn);
		value = valueIn;
	}
	
	public VarLong(String nameIn) {
		this(nameIn, 0);
	}
	
	public VarLong(String nameIn, List<Byte> binaryContents) {
		super(nameIn);
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
	
}
