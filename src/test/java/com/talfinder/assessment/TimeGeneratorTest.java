package com.talfinder.assessment;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;

public class TimeGeneratorTest {

  @Rule
  public ErrorCollector errorCollector = new ErrorCollector();

  @Test
  public void generateMaxTimePreNoonTimes_Given0584_Expect0854() {
    String time = TimeGenerator.generateMaxTime(new int[]{0, 5, 8, 4});
    errorCollector.checkThat(time, is(equalTo("08:54")));
  }

  @Test
  public void generateMaxTimePreNoonTimes_Given0764_Expect0746() {
    String time = TimeGenerator.generateMaxTime(new int[]{0, 7, 6, 4});
    errorCollector.checkThat(time, is(equalTo("07:46")));
  }

  @Test
  public void generateMaxTimeHourBoundaries_Given0300_Expect0300() {
    String time = TimeGenerator.generateMaxTime(new int[]{0, 3, 0, 0});
    errorCollector.checkThat(time, is(equalTo("03:00")));
  }

  @Test
  public void generateMaxTimeHourBoundaries_Given0900_Expect0900() {
    String time = TimeGenerator.generateMaxTime(new int[]{0, 9, 0, 0});
    errorCollector.checkThat(time, is(equalTo("09:00")));
  }

  @Test
  public void generateMaxTimeHourBoundaries_Given0001_Expect1000() {
    String time = TimeGenerator.generateMaxTime(new int[]{0, 0, 0, 1});
    errorCollector.checkThat(time, is(equalTo("10:00")));
  }

  @Test
  public void generateMaxTimeHourBoundaries_Given0002_Expect2000() {
    String time = TimeGenerator.generateMaxTime(new int[]{0, 0, 0, 2});
    errorCollector.checkThat(time, is(equalTo("20:00")));
  }

  @Test
  public void generateMaxTimeHourBoundaries_Given2300_Expect2300() {
    String time = TimeGenerator.generateMaxTime(new int[]{2, 3, 0, 0});
    errorCollector.checkThat(time, is(equalTo("23:00")));
  }

  @Test
  public void generateMaxTimeHourMinuteBoundaries_Given3300_Expect0330() {
    String time = TimeGenerator.generateMaxTime(new int[]{3, 3, 0, 0});
    errorCollector.checkThat(time, is(equalTo("03:30")));
  }

  @Test
  public void generateMaxTimeHourMinuteBoundaries_Given0990_Expect0909() {
    String time = TimeGenerator.generateMaxTime(new int[]{0, 9, 9, 0});
    errorCollector.checkThat(time, is(equalTo("09:09")));
  }

  @Test
  public void generateMaxTimeHourMinuteBoundaries_Given0101_Expect1100() {
    String time = TimeGenerator.generateMaxTime(new int[]{0, 1, 0, 1});
    errorCollector.checkThat(time, is(equalTo("11:00")));
  }

  @Test
  public void generateMaxTimeHourMinuteBoundaries_Given2002_Expect2200() {
    String time = TimeGenerator.generateMaxTime(new int[]{2, 0, 0, 2});
    errorCollector.checkThat(time, is(equalTo("22:00")));
  }

  @Test
  public void generateMaxTimePostNoonTimes_Given1259_Expect2159() {
    String time = TimeGenerator.generateMaxTime(new int[]{1, 2, 5, 9});
    errorCollector.checkThat(time, is(equalTo("21:59")));
  }

  @Test
  public void generateMaxTimePostNoonTimes_Given1374_Expect1743() {
    String time = TimeGenerator.generateMaxTime(new int[]{1, 3, 7, 4});
    errorCollector.checkThat(time, is(equalTo("17:43")));
  }

  @Test
  public void generateMaxTimePostNoonTimes_Given1413_Expect1431() {
    String time = TimeGenerator.generateMaxTime(new int[]{1, 4, 1, 3});
    errorCollector.checkThat(time, is(equalTo("14:31")));
  }

  @Test
  public void generateMaxTimePostNoonTimes_Given2919_Expect1929() {
    String time = TimeGenerator.generateMaxTime(new int[]{2, 9, 1, 9});
    errorCollector.checkThat(time, is(equalTo("19:29")));
  }

  @Test
  public void generateMaxTimePostNoonTimes_Given2112_Expect2121() {
    String time = TimeGenerator.generateMaxTime(new int[]{2, 1, 1, 2});
    errorCollector.checkThat(time, is(equalTo("21:21")));
  }

  @Test
  public void generateMaxTimePostNoonTimes_Given3113_Expect1331() {
    String time = TimeGenerator.generateMaxTime(new int[]{3, 1, 1, 3});
    errorCollector.checkThat(time, is(equalTo("13:31")));
  }

  @Test
  public void generateMaxTimeBoundaryTests_Given0000_Expect0000() {
    String time = TimeGenerator.generateMaxTime(new int[]{0, 0, 0, 0});
    errorCollector.checkThat(time, is(equalTo("00:00")));
  }

  @Test
  public void generateMaxTimeBoundaryTests_Given5923_Expect2359() {
    String time = TimeGenerator.generateMaxTime(new int[]{5, 9, 2, 3});
    errorCollector.checkThat(time, is(equalTo("23:59")));
  }

  @Test
  public void generateMaxTimeOutOfRangeInputs_Given9999_ExpectNull() {
    String time = TimeGenerator.generateMaxTime(new int[]{9, 9, 9, 9});
    errorCollector.checkThat(time, is(equalTo(null)));
  }

  @Test
  public void generateMaxTimeOutOfRangeInputs_Given5699_ExpectNull() {
    String time = TimeGenerator.generateMaxTime(new int[]{5, 6, 9, 9});
    errorCollector.checkThat(time, is(equalTo(null)));
  }

  @Test
  public void generateMaxTimeOutOfRangeInputs_Given1699_ExpectNull() {
    String time = TimeGenerator.generateMaxTime(new int[]{1, 6, 9, 9});
    errorCollector.checkThat(time, is(equalTo(null)));
  }

  @Test
  public void generateMaxTimeOutOfRangeInputs_Given9289_ExpectNull() {
    String time = TimeGenerator.generateMaxTime(new int[]{9, 2, 8, 9});
    errorCollector.checkThat(time, is(equalTo(null)));
  }

  @Test
  public void generateMaxTimeOutOfRangeInputs_Given7382_ExpectNull() {
    String time = TimeGenerator.generateMaxTime(new int[]{7, 3, 8, 2});
    errorCollector.checkThat(time, is(equalTo(null)));
  }

  @Test
  public void generateMaxTimeOutOfRangeInputs_Given6237_ExpectNull() {
    String time = TimeGenerator.generateMaxTime(new int[]{6, 2, 3, 7});
    errorCollector.checkThat(time, is(equalTo(null)));
  }

  @Test
  public void generateMaxTimeInvalidInputs_GivenN9999_ExpectNull() {
    String time = TimeGenerator.generateMaxTime(new int[]{-9, 9, 9, 9});
    errorCollector.checkThat(time, is(equalTo(null)));
  }

  @Test
  public void generateMaxTimeInvalidInputs_Given12N94_ExpectNull() {
    String time = TimeGenerator.generateMaxTime(new int[]{1, 2, -9, 4});
    errorCollector.checkThat(time, is(equalTo(null)));
  }

  @Test
  public void generateMaxTimeInvalidInputs_Given111212_ExpectNull() {
    String time = TimeGenerator.generateMaxTime(new int[]{11, 12, 1, 2});
    errorCollector.checkThat(time, is(equalTo(null)));
  }
}