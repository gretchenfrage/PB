package pbinary;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class ByteOperations {
    
	/*
	 * converts a java byte, which can hold values from -128 to 127
	 * to an integer, which may hold values from 0 to 255
	 */
	public static int twosComplimentToPositive(byte b) {
        if (b >= 0) {
            return b;
        } else {
            return b + 256;
        }
    }
	
	/*
	 * converts a base 256 byte array number to an integer of equal value
	 */
    public static int multibyteToInt(byte[] bytes) {
        int out = 0;
        for (int i = 0; i < bytes.length; i++) {
            out += twosComplimentToPositive(bytes[bytes.length - 1 - i]) * Math.pow(256, i);
        }
        return out;
    }
    
    /*
     * converts a base 256 byte list number to an integer of equal value
     */
    public static int multibyteToInt(List<Byte> bytes) {
    	int out = 0;
    	for (int i = 0; i < bytes.size(); i++) {
    		out += twosComplimentToPositive(bytes.get(bytes.size() - 1 - i)) * Math.pow(256, i);
    	}
    	return out;
    }
    
    /*
     * converts an integer to a base 256 byte list number of equal value
     */
    public static List<Byte> intToMultibyteList(int n) {
    	List<Byte> out = new ArrayList<Byte>();
        while (n != 0) {
            out.add(0, (byte) (n % 256));
            n /= 256;
        }
        return out;
    }
    
    /*
     * converts an integer to a base 256 byte array number of equal value
     */
    public static byte[] intToMultibyteArray(int n) {
        List<Byte> bytes = intToMultibyteList(n);
        byte[] out = new byte[bytes.size()];
        for (int i = 0; i < out.length; i++) {
            out[i] = bytes.get(i);
        }
        return out;
    }
    
    /*
     * converts the base 256 byte list number to a long of equal value
     */
    public static long multibyteToLong(List<Byte> bytes) {
    	long out = 0;
    	for (int i = 0; i < bytes.size(); i++) {
    		out += twosComplimentToPositive(bytes.get(bytes.size() - 1 - i)) * Math.pow(256, i);
    	}
    	return out;
    }
    
    /*
     * converts the long to a base 256 byte list number of equal value
     */
    public static List<Byte> longToMultibyteList(long n) {
    	List<Byte> out = new ArrayList<Byte>();
    	while (n != 0) {
    		out.add(0, (byte) (n % 256));
    		n /= 256;
    	}
    	return out;
    }
    
    /*
     * converts the string to a byte array
     */
    public static byte[] stringToByteArray(String string) {
    	return string.getBytes(StandardCharsets.UTF_8);
    }
    
    /*
     * converts the string to a byte list
     */
    public static List<Byte> stringToByteList(String string) {
    	List<Byte> out = new ArrayList<Byte>();
    	for (byte b : stringToByteArray(string)) {
    		out.add(b);
    	}
    	return out;
    }
    
    /*
     * converts the byte array to a string
     */
    public static String bytesToString(byte[] bytes) {
    	return new String(bytes, StandardCharsets.UTF_8);
    }
    
    /*
     * converts the byte list to a string
     */
    public static String bytesToString(List<Byte> bytes) {
    	byte[] array = new byte[bytes.size()];
    	for (int i = 0; i < array.length; i++) {
    		array[i] = bytes.get(i);
    	}
    	return bytesToString(array);
    }
    
    /*
     * returns the byte array, prefixed with zeroes until it's >= length
     */
    public static byte[] justify(byte[] bytes, int length) {
    	if (bytes.length >= length) {
    		return bytes;
    	} else {
    		byte[] out = new byte[length];
    		for (int i = 0; i < length; i++) {
    			out[out.length - 1 - i] = bytes[bytes.length - 1 - i];
    		}
    		return out;
    	}
    }
    
    /*
     * returns the byte list, prefixed with zeroes until it's >= length
     */
    public static List<Byte> justify(List<Byte> bytes, int length) {
    	List<Byte> out = new ArrayList<Byte>();
    	for (byte b : bytes) {
    		out.add(b);
    	}
    	while (out.size() < length) {
    		out.add(0, (byte) 0); 
    	}
    	return out;
    }
    
    /*
     * converts the byte array to a byte list
     */
    public static List<Byte> byteArrayToList(byte[] bytes) {
    	List<Byte> out = new ArrayList<Byte>();
    	for (byte b : bytes) {
    		out.add(b);
    	}
    	return out;
    }
    
    /*
     * converts the byte list to a byte array
     */
    public static byte[] byteListToArray(List<Byte> bytes) {
    	byte[] out = new byte[bytes.size()];
    	for (int i = 0; i < out.length; i++) {
    		out[i] = bytes.get(i);
    	}
    	return out;
    }
}