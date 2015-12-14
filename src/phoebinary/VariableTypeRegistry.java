package phoebinary;

import java.util.ArrayList;
import java.util.List;

import phoebinary.exceptions.TooManyTypesRegisteredException;
import phoebinary.exceptions.TypeNotRegisteredException;
import phoebinary.variabletypes.VarFolder;
import phoebinary.variabletypes.VarObject;

public class VariableTypeRegistry {

	private List<VariableType> types = new ArrayList<VariableType>();

	public VariableTypeRegistry() {}
	
	public VariableTypeRegistry(VarFolder folder) {
		for (Variable v : folder.getVariables()) {
			VarObject o = (VarObject) v;
			VariableType t = (VariableType) o.getValue();
			types.add(t);
		}
	}
	
	public VarFolder getFolder() {
		VarFolder folder = new VarFolder("SYSTEM_VAR_TYPES");
		for (VariableType t : types) {
			folder.addVariable(new VarObject("", t));
		}
		return folder;
	}
	
	public void registerType(VariableType type) throws TooManyTypesRegisteredException {
		if (types.size() >= 256) {
			throw new TooManyTypesRegisteredException();
		} else {
			types.add(type);
		}
	}
	
	public byte getType(Variable v) throws TypeNotRegisteredException {
		for (byte i = 0; i < types.size(); i++) {
			if (types.get(0).isTypeOf(v)) {
				return i;
			}
		}
		throw new TypeNotRegisteredException();
	}
	
	
}
