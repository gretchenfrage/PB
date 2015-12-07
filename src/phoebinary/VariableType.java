package phoebinary;

import java.io.Serializable;
import java.util.List;

public abstract class VariableType implements Serializable {

	public Class variableClass;
	
	public VariableType(Class variableClassIn) {
		variableClass = variableClassIn;
	}
	
	public Variable construct(String name, List<Byte> binaryContents) {
		return 
	}
	
}
