/**
 * 
 */
package me.karthik.string2long;

import java.text.ParseException;
import org.junit.Assert;
import org.junit.Test;
import me.karthik.string2long.StringUtil;

/**
 * @author karthik
 *
 */
public class StringUtilTest {

	@Test
	public void testPositiveString() throws ParseException {
		Assert.assertEquals(12345, StringUtil.stringToLong("12345"));
	}

	@Test
	public void testNegativeString() throws ParseException {
		Assert.assertEquals(-12345, StringUtil.stringToLong("-12345"));
	}

	@Test
	public void testMaxLongValue() throws ParseException {
		Assert.assertEquals(Long.MAX_VALUE, StringUtil.stringToLong(Long.MAX_VALUE + ""));
	}

	@Test
	public void testMinLongValue() throws ParseException {
		Assert.assertEquals(Long.MIN_VALUE, StringUtil.stringToLong(Long.MIN_VALUE + ""));
	}

	@Test
	public void testZeroString() throws ParseException {
		Assert.assertEquals(0, StringUtil.stringToLong("0"));
	}

	@Test
	public void testNegativeZeroString() throws ParseException {
		Assert.assertEquals(0, StringUtil.stringToLong("-0"));
	}

	@Test
	public void testEmptyString() throws ParseException {
		Assert.assertEquals(0, StringUtil.stringToLong(""));
	}

	@Test(expected = ParseException.class)
	public void testMinusStringInLast() throws ParseException {
		StringUtil.stringToLong("12345-");
	}

	@Test(expected = ParseException.class)
	public void testNoDecimals() throws ParseException {
		StringUtil.stringToLong("1.00");
	}

	@Test(expected = ParseException.class)
	public void testSpecialChar() throws ParseException {
		StringUtil.stringToLong("1#234$567");
	}

}
