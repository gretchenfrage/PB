package phoebinary.variabletypes;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import phoebinary.ByteOperations;
import phoebinary.MalformedVariableException;
import phoebinary.MiscFunctions;
import phoebinary.PhoeBinaryParser;
import phoebinary.PhoeBinarySerializer;
import phoebinary.Variable;

public class VarFolder extends Variable {

	private List<Variable> variables = new ArrayList<Variable>();
	
	public VarFolder(String name) {
		super(name);
	}
	
	public VarFolder() {
		super(null);
	}
	
	public void construct(List<Byte> binaryContents) {
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
		Variable variable = MiscFunctions.getVariableNamed(path[0], variables);
		if (variable instanceof VarFolder) {
			return ((VarFolder) variable).getVariable(MiscFunctions.reducePath(path));
		} else {
			return variable;
		}
	}
	
}
