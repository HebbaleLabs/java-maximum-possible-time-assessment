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
  public void generateMaxTimePreNoonTimes() {
    String time = TimeGenerator.generateMaxTime(new int[]{0, 5, 8, 4});
    errorCollector.checkThat(time, is(equalTo("08:54")));

    time = TimeGenerator.generateMaxTime(new int[]{0, 7, 6, 4});
    errorCollector.checkThat(time, is(equalTo("07:46")));
  }

  @Test
  public void generateMaxTimeHourBoundaries() {
    String time = TimeGenerator.generateMaxTime(new int[]{0, 3, 0, 0});
    errorCollector.checkThat(time, is(equalTo("03:00")));

    time = TimeGenerator.generateMaxTime(new int[]{0, 9, 0, 0});
    errorCollector.checkThat(time, is(equalTo("09:00")));

    time = TimeGenerator.generateMaxTime(new int[]{0, 0, 0, 1});
    errorCollector.checkThat(time, is(equalTo("10:00")));

    time = TimeGenerator.generateMaxTime(new int[]{0, 0, 0, 2});
    errorCollector.checkThat(time, is(equalTo("20:00")));

    time = TimeGenerator.generateMaxTime(new int[]{2, 3, 0, 0});
    errorCollector.checkThat(time, is(equalTo("23:00")));
  }

  @Test
  public void generateMaxTimeHourSecondBoundaries() {
    String time = TimeGenerator.generateMaxTime(new int[]{3, 3, 0, 0});
    errorCollector.checkThat(time, is(equalTo("03:30")));

    time = TimeGenerator.generateMaxTime(new int[]{0, 9, 9, 0});
    errorCollector.checkThat(time, is(equalTo("09:09")));

    time = TimeGenerator.generateMaxTime(new int[]{0, 1, 0, 1});
    errorCollector.checkThat(time, is(equalTo("11:00")));

    time = TimeGenerator.generateMaxTime(new int[]{2, 0, 0, 2});
    errorCollector.checkThat(time, is(equalTo("22:00")));
  }

  @Test
  public void generateMaxTimePostNoonTimes() {
    String time = TimeGenerator.generateMaxTime(new int[]{1, 2, 5, 9});
    errorCollector.checkThat(time, is(equalTo("21:59")));

    time = TimeGenerator.generateMaxTime(new int[]{1, 3, 7, 4});
    errorCollector.checkThat(time, is(equalTo("17:43")));

    time = TimeGenerator.generateMaxTime(new int[]{1, 4, 1, 3});
    errorCollector.checkThat(time, is(equalTo("14:31")));

    time = TimeGenerator.generateMaxTime(new int[]{2, 9, 1, 9});
    errorCollector.checkThat(time, is(equalTo("19:29")));

    time = TimeGenerator.generateMaxTime(new int[]{2, 1, 1, 2});
    errorCollector.checkThat(time, is(equalTo("21:21")));

    time = TimeGenerator.generateMaxTime(new int[]{3, 1, 1, 3});
    errorCollector.checkThat(time, is(equalTo("13:31")));
  }

  @Test
  public void generateMaxTimeBoundaryTests() {
    String time = TimeGenerator.generateMaxTime(new int[]{0, 0, 0, 0});
    errorCollector.checkThat(time, is(equalTo("00:00")));

    time = TimeGenerator.generateMaxTime(new int[]{5, 9, 2, 3});
    errorCollector.checkThat(time, is(equalTo("23:59")));
  }

  @Test
  public void generateMaxTimeOutOfRangeInputs() {
    String time = TimeGenerator.generateMaxTime(new int[]{9, 9, 9, 9});
    errorCollector.checkThat(time, is(equalTo(null)));

    time = TimeGenerator.generateMaxTime(new int[]{5, 6, 9, 9});
    errorCollector.checkThat(time, is(equalTo(null)));

    time = TimeGenerator.generateMaxTime(new int[]{1, 6, 9, 9});
    errorCollector.checkThat(time, is(equalTo(null)));

    time = TimeGenerator.generateMaxTime(new int[]{9, 2, 8, 9});
    errorCollector.checkThat(time, is(equalTo(null)));

    time = TimeGenerator.generateMaxTime(new int[]{7, 3, 8, 2});
    errorCollector.checkThat(time, is(equalTo(null)));

    time = TimeGenerator.generateMaxTime(new int[]{6, 2, 3, 7});
    errorCollector.checkThat(time, is(equalTo(null)));
  }

  @Test
  public void generateMaxTimeInvalidInputs() {
    String time = TimeGenerator.generateMaxTime(new int[]{-9, 9, 9, 9});
    errorCollector.checkThat(time, is(equalTo(null)));

    time = TimeGenerator.generateMaxTime(new int[]{1, 2, -9, 4});
    errorCollector.checkThat(time, is(equalTo(null)));

    time = TimeGenerator.generateMaxTime(new int[]{11, 12, 1, 2});
    errorCollector.checkThat(time, is(equalTo(null)));
  }
}