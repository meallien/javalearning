package javalearning;

/* print gray code
 * n-bit gray code, means an array of n-bit codes, one of each differs with its neighbor by only one binary bit.
 * Example: 1-bit gray code, {"0", "1"}
 * */

public class GrayCode {
	public static void main(String[] args)
	{
		GrayCode codeFactory = new GrayCode();
		String[] codes = codeFactory.generateCode(4);
		GrayCode.printCodes(codes);
	}
	
	public String[] generateCode(int depth)
	{
		if (depth <= 1)
		{
			String[] data = {"0", "1"};
			return data;
		}
		
		int length = 1 << (depth);
		String[] lastData = generateCode(depth-1);
		String[] data = new String[length];
		
		int dataIndex = 0;
		for (int i = 0; i < lastData.length; i+=2)
		{
			String code = lastData[i];
			data[dataIndex++] = code + "0";
			data[dataIndex++] = code + "1";
			code = lastData[i+1];
			data[dataIndex++] = code + "1";
			data[dataIndex++] = code + "0";			
		}
		
		return data;
	}
	
	public static void printCodes(String[] codes)
	{
		System.out.print("{");
		int i;
		for (i = 0; i < codes.length; i++)
		{
			if (0 == i)
				System.out.print(codes[i]);
			else
				System.out.print(", " + codes[i]);
		}
		System.out.print("}");
	}
}
