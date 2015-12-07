package phoebinary;

import java.io.File;
import java.io.IOException;

import phoebinary.variabletypes.VarBoolean;
import phoebinary.variabletypes.VarByte;
import phoebinary.variabletypes.VarChar;
import phoebinary.variabletypes.VarDouble;
import phoebinary.variabletypes.VarFolder;
import phoebinary.variabletypes.VarInteger;
import phoebinary.variabletypes.VarLong;
import phoebinary.variabletypes.VarObject;
import phoebinary.variabletypes.VarString;

public class Tester {

	public static void main(String[] args) throws IOException {
		File file = new File("test.txt");
		file.createNewFile();
		
		PhoeBinaryFile pb = new PhoeBinaryFile(file);
		
		pb.clearVariables();
		pb.addVariable(new VarBoolean("yes or no", true));
		VarFolder folder = new VarFolder("folder");
		folder.addVariable(new VarInteger("one", 1));
		folder.addVariable(new VarDouble("pi", 3.14));
		folder.addVariable(new VarString("best show ever", "Star Trek: Deep Space 9"));
		pb.addVariable(folder);
		pb.addVariable(new VarByte("bittle", (byte) 65));
		pb.addVariable(new VarChar("cee", 'c'));
		pb.addVariable(new VarDouble("doble", 231.5234));
		pb.addVariable(new VarInteger("answer", 42));
		pb.addVariable(new VarLong("long", 123213123123123L));
		pb.addVariable(new VarString("hello", "world"));
		pb.addVariable(new VarObject("serializable objewct test htingey", "hello world!!!"));
		
		pb.write();
		
		pb = null;
		
		PhoeBinaryFile pb2 = new PhoeBinaryFile(file);
		System.out.println(pb2.getVariables());
		
		System.out.println(pb2.getVariable("folder.one"));
	}
	
}
