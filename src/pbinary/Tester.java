package pbinary;

import java.util.List;

public class Tester {

	public static void main(String[] args) {
		VarInteger i = new VarInteger("cookies", 7);
		System.out.println(i.getValue());
		List<Byte> b = i.getBinaryContents();
		VarInteger i2 = (VarInteger) Variable.constructFromBinary(Variable.VAR_INT, "coooookies", i.getBinaryContents());
		System.out.println(i2.getValue());
		System.out.println(i2.getBinary());
	}
	
}
