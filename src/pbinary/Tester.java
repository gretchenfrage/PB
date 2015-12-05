package pbinary;

import java.io.File;
import java.io.IOException;

public class Tester {

	public static void main(String[] args) throws IOException {
		File file = new File("test.txt");
		file.createNewFile();
		
		PBinaryFile pb = new PBinaryFile(file);
		
		pb.addVariable(new VarBoolean("yes or no", true));
		pb.addVariable(new VarByte("bittle", (byte) 65));
		pb.addVariable(new VarChar("cee", 'c'));
		pb.addVariable(new VarDouble("doble", 231.5234));
		pb.addVariable(new VarInteger("answer", 42));
		pb.addVariable(new VarLong("long", 123213123123123L));
		
		pb.writeToFile();
		
		pb = null;
		
		PBinaryFile pb2 = new PBinaryFile(file);
		System.out.println(pb2.getVariables());
	}
	
}
