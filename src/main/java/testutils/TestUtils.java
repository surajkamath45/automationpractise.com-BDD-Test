package testutils;

public class TestUtils {

	public static String randomStringGenerator() {

		String strBase = "ABCDEFGHIJKLMNOPQRSTUWXYZ";
		StringBuilder strToReturn = new StringBuilder(new String(""));
		for (int i = 0; i < 3; i++) {
			strToReturn.append(strBase.charAt((int) Math.ceil(Math.random() * strBase.length() - 1)));
		}

		return strToReturn.toString();
	}

}
