package phoebinary;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import phoebinary.variabletypes.VarFolder;

public class PhoeBinaryFile {

	private File file;
	private List<Variable> variables;
	private VariableTypeRegistry registry;
	
	public PhoeBinaryFile(File fileIn) {
		file = fileIn;
		read();
	}
	
	public void read() {
		try (FileInputStream stream = new FileInputStream(file)) {
			PhoeBinaryParser parser = new PhoeBinaryParser(stream);
			variables = parser.parse();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void () {
		try (FileOutputStream stream = new FileOutputStream(file)) {
			PhoeBinarySerializer serializer = new PhoeBinarySerializer(variables);
			serializer.serialize(stream);
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
	
	public Variable getVariable(String rawPath) {
		String[] path = rawPath.split("\\.");
		Variable variable = Variable.getVariableNamed(path[0], variables);
		if (variable instanceof VarFolder) {
			return ((VarFolder) variable).getVariable(Variable.reducePath(path));
		} else {
			return variable;
		}
	}
	
}
