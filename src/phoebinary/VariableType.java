package phoebinary;

import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import phoebinary.exceptions.InvalidVariableClassException;

public class VariableType implements Serializable {

	private Class<? extends Variable> variableClass;
	private Constructor<? extends Variable> variableConstructor;
	
	public VariableType(Class<? extends Variable> variableClassIn) {
		variableClass = variableClassIn;
		try {
			variableConstructor = variableClass.getDeclaredConstructor(String.class, List.class);
			construct("test", new ArrayList<Byte>());
		} catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			throw new InvalidVariableClassException();
		}
	}
	
	public Variable construct(String name, List<Byte> binaryContents) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		return variableConstructor.newInstance(name, binaryContents);
	}
	
	public boolean isTypeOf(Variable v) {
		return v.getClass() == variableClass;
	}
	
}
