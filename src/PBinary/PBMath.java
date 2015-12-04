package PBinary;

import java.util.ArrayList;
import java.util.List;

public class PBMath {
    
    public static int multibyteToInt(byte[] bytes) {
        int out = 0;
        for (int i = 0; i < bytes.length; i++) {
            out += twosComplimentToPositive(bytes[bytes.length - 1 - i]) * Math.pow(256, i);
        }
        return out;
    }
    
    public static int twosComplimentToPositive(byte b) {
        if (b >= 0) {
            return b;
        } else {
            return b + 256;
        }
    }
    
    public static byte[] intToMultibyte(int n) {
        List<Byte> bytes = new ArrayList<Byte>();
        while (n != 0) {
            bytes.add(0, (byte) (n % 256));
            n /= 256;
        }
        
        byte[] out = new byte[bytes.size()];
        for (int i = 0; i < out.length; i++) {
            out[i] = bytes.get(i);
        }
        return out;
    }
    
}