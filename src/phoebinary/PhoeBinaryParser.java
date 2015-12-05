package phoebinary;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class PhoeBinaryParser {

	private InputStream stream;
	
	public PhoeBinaryParser(InputStream streamIn) {
		stream = streamIn;
	}
	
	public List<Variable> parse() throws IOException {
		List<Variable> variables = new ArrayList<Variable>();
		while (stream.available() > 0) {
			byte type = (byte) stream.read();
			
			byte[] nameLengthBytes = new byte[4];
			stream.read(nameLengthBytes);
			int nameLength = ByteOperations.multibyteToInt(nameLengthBytes);
			byte[] nameBytes = new byte[nameLength];
			stream.read(nameBytes);
			String name = ByteOperations.bytesToString(nameBytes);
			
			byte[] contentsLengthBytes = new byte[4];
			stream.read(contentsLengthBytes);
			int contentsLength = ByteOperations.multibyteToInt(contentsLengthBytes);
			byte[] contentsBytes = new byte[contentsLength];
			stream.read(contentsBytes);
			List<Byte> contents = ByteOperations.byteArrayToList(contentsBytes);
			
			variables.add(Variable.constructFromBinary(type, name, contents));
		}
		return variables;
	}
	
}
