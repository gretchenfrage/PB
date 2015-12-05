package phoebinary;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

public class PhoeBinarySerializer {
	
	private List<Variable> variables;
	
	public PhoeBinarySerializer(List<Variable> variablesIn) {
		variables = variablesIn;
	}
	
	public void serialize(OutputStream stream) throws IOException {
		for (Variable v : variables) {
			stream.write(ByteOperations.byteListToArray(v.getBinary()));
		}
	}

}
