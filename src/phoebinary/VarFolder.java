package phoebinary;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class VarFolder extends Variable {

	private List<Variable> variables = new ArrayList<Variable>();
	
	public VarFolder(String nameIn) {
		super(nameIn);
	}
	
	public VarFolder(String nameIn, List<Byte> binaryContents) {
		super(nameIn);
		try (ByteArrayInputStream stream = new ByteArrayInputStream(ByteOperations.byteListToArray(binaryContents))) {
			PhoeBinaryParser parser = new PhoeBinaryParser(stream);
			variables = parser.parse();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Byte> getBinaryContents() {
		try (ByteArrayOutputStream stream = new ByteArrayOutputStream()) {
			PhoeBinarySerializer serializer = new PhoeBinarySerializer(variables);
			serializer.serialize(stream);
			return ByteOperations.byteArrayToList(stream.toByteArray());
		} catch (IOException e) {
			e.printStackTrace();
			throw new MalformedVariableException();
		}
	}
	
	public void addVariable(Variable v) {
		variables.add(v);
	}

	public List<Variable> getVariables() {
		return variables;
	}
	
	public String toString() {
		return "folder " + getName() + " = {" + variables + "}";
	}
	
	public Variable getVariable(String[] path) {
		Variable variable = Variable.getVariableNamed(path[0], variables);
		if (variable instanceof VarFolder) {
			return ((VarFolder) variable).getVariable(Variable.reducePath(path));
		} else {
			return variable;
		}
	}
	
}
