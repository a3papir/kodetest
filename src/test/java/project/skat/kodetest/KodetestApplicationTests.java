package project.skat.kodetest;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class KodetestApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void testNumberToStringLiteralValidInputMaximum() {
		String result = NumberToStringLiteral.convert(999999.99);
		String expected = "NINE HUNDRED AND NINETY NINE THOUSAND AND NINE HUNDRED AND NINETY NINE DOLLARS AND NINETY NINE CENTS";
		assertEquals(expected,result);
	}

	@Test
	void testNumberToStringLiteralValidInputMinimum() {
		String result = NumberToStringLiteral.convert(0);
		String result2 = NumberToStringLiteral.convert(0.00);
		String expected = "ZERO DOLLARS AND ZERO CENTS";
		assertEquals(expected,result, result2);
	}

	@Test
	void testAssignmentExamples() {
		String result = NumberToStringLiteral.convert(47.50);
		String result2 = NumberToStringLiteral.convert(5);
		String result3 = NumberToStringLiteral.convert(205.31);
		String result4 = NumberToStringLiteral.convert(4000.0);
		String result5 = NumberToStringLiteral.convert(1.01);


		String expected = "FORTY SEVEN DOLLARS AND FIFTY CENTS";
		String expected2 = "FIVE DOLLARS AND ZERO CENTS";
		String expected3 = "TWO HUNDRED AND FIVE DOLLARS AND THIRTY ONE CENTS";
		String expected4 = "FOUR THOUSAND DOLLARS AND ZERO CENTS";
		String expected5 = "ONE DOLLAR AND ONE CENT";

		assertEquals(expected,result);
		assertEquals(expected2,result2);
		assertEquals(expected3,result3);
		assertEquals(expected4,result4);
		assertEquals(expected5,result5);
	}

	@Test
	void testOutOfBoundsLower() {
		Exception exception = assertThrows(IndexOutOfBoundsException.class, () -> {
			NumberToStringLiteral.convert(-1.0);
		});

		String expectedMessage = "The application accept input from 0 and up to 999999.99";
		String actualMessage = exception.getMessage();

		assertEquals(actualMessage,expectedMessage);
	}

	@Test
	void testOutOfBoundsHigher() {
		Exception exception = assertThrows(IndexOutOfBoundsException.class, () -> {
			NumberToStringLiteral.convert(1000000.0);
		});

		String expectedMessage = "The application accept input from 0 and up to 999999.99";
		String actualMessage = exception.getMessage();

		assertEquals(expectedMessage,actualMessage);
	}

	@Test
	void testAcceptTwoDecimals() {
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			NumberToStringLiteral.convert(1.111);
		});

		String expectedMessage = "The application accept input with up to 2 decimals.";
		String actualMessage = exception.getMessage();

		assertEquals(expectedMessage,actualMessage);
	}
}
