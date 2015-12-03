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
    
}
