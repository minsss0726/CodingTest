package codetest.test06;

import java.util.Arrays;

public class SolutionRunner {

	public static void main(String[] args) {

		ConvertNumber test = new ConvertNumber();

		String[] str1 = { "ZASSETE", "S4Z537B", "7_ASZEYB" };

		String[] str2 = { "2455373", "425", "373", "378" };

		// System.out.println(Arrays.toString(test.solution(str1, str2)));

		String[] str3 = { "ZAZZ373" };

		String[] str4 = { "2422373", "5455373", "2455373" };

		System.out.println(Arrays.toString(test.solution(str3, str4)));
	}

}
