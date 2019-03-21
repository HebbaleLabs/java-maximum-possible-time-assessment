package com.talfinder.assessment;

import static org.hamcrest.core.Is.is;

import java.util.Arrays;
import java.util.Collection;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class TimeGeneratorTest {

  @Parameters
  public static Collection<Object[]> parameters() {
    return Arrays.asList(new Object[][] {
        {new int[]{0, 5, 8, 4}, "08:54"},
        {new int[]{0, 7, 6, 4}, "07:46"},
        {new int[]{0, 3, 0, 0}, "03:00"},
        {new int[]{0, 9, 0, 0}, "09:00"},
        {new int[]{0, 0, 0, 1}, "10:00"},
        {new int[]{0, 0, 0, 2}, "20:00"},
        {new int[]{2, 3, 0, 0}, "23:00"},
        {new int[]{3, 3, 0, 0}, "03:30"},
        {new int[]{0, 9, 9, 0}, "09:09"},
        {new int[]{0, 1, 0, 1}, "11:00"},
        {new int[]{2, 0, 0, 2}, "22:00"},
        {new int[]{1, 2, 5, 9}, "21:59"},
        {new int[]{1, 3, 7, 4}, "17:34"},
        {new int[]{0, 0, 0, 0}, "00:00"},
        {new int[]{5, 9, 2, 3}, "23:59"},
        {new int[]{9, 9, 9, 9}, null},
        {new int[]{5, 6, 9, 9}, null},
        {new int[]{1, 6, 9, 9}, null},
        {new int[]{9, 2, 8, 9}, null},
        {new int[]{7, 2, 8, 2}, null},
        {new int[]{-9, 9, 9, 9}, null},
        {new int[]{1, 2, -9, 4}, null}
    });
  }

  private int[] digits;
  private String expectedValue;

  public TimeGeneratorTest(int[] digits, String expectedValue) {
    this.digits = digits;
    this.expectedValue = expectedValue;
  }

  @Test
  public void generateMaxTime() {
    Assert.assertEquals("input:Digits as " + Arrays.toString(digits) , expectedValue, TimeGenerator.generateMaxTime(digits));
  }
}
