package pbinary;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PBinaryFile {

	private File file;
	private List<Variable> variables = new ArrayList<Variable>();
	
	public PBinaryFile(File fileIn) {
		file = fileIn;
		readFromFile();
	}
	
	public void readFromFile() {
		try (FileInputStream stream = new FileInputStream(file)) {
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
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void writeToFile() {
		try (FileOutputStream stream = new FileOutputStream(file)) {
			for (Variable v : variables) {
				stream.write(ByteOperations.byteListToArray(v.getBinary()));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Variable> getVariables() {
		return (List<Variable>) ((ArrayList<Variable>) variables).clone();
	}
	
	public void addVariable(Variable v) {
		variables.add(v);
	}
	
	public void removeVariable(Variable v) {
		variables.remove(v);
	}
	
	public void clearVariables() {
		variables = new ArrayList<Variable>();
	}
	
}
