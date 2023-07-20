package com.example.sample;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CalculatorTest {

  @DisplayName("덧셈 연산을 할 수 있다.")
  @Test
  void validatePerformAdditionOperation() {

    // given
    long num1 = 2;
    String operator = "+";
    long num2 = 3;
    Calculator calculator = new Calculator();

    // when
    long result = calculator.calculate(num1, operator, num2);

    // then
    assertEquals(5, result); // junit assertion
    Assertions.assertThat(result).isEqualTo(5);// assertj assertion
  }

  @DisplayName("뺄셈 연산을 할 수 있다.")
  @Test
  void validatePerformSubOperation() {

    // given
    long num1 = 2;
    String operator = "-";
    long num2 = 3;
    Calculator calculator = new Calculator();

    // when
    long result = calculator.calculate(num1, operator, num2);

    // then
    assertEquals(-1, result); // junit assertion
  }

  @DisplayName("곱셈 연산을 할 수 있다.")
  @Test
  void validatePerformMultipleOperation() {

    // given
    long num1 = 2;
    String operator = "*";
    long num2 = 3;
    Calculator calculator = new Calculator();

    // when
    long result = calculator.calculate(num1, operator, num2);

    // then
    assertEquals(6, result); // junit assertion
  }

  @DisplayName("나눗셈 연산을 할 수 있다.")
  @Test
  void validatePerformDivideOperation() {

    // given
    long num1 = 6;
    String operator = "/";
    long num2 = 3;
    Calculator calculator = new Calculator();

    // when
    long result = calculator.calculate(num1, operator, num2);

    // then
    assertEquals(2, result); // junit assertion
  }


  @DisplayName("잘못된 연산자가 요청으로 들어올 경우 에러가 난다.")
  @Test
  void validateInvalidOperation() {

    // given
    long num1 = 6;
    String operator = "x";
    long num2 = 3;
    Calculator calculator = new Calculator();

    // when // then
    assertThrows(InvalidOperatorException.class, () -> {
      calculator.calculate(num1, operator, num2);
    });
  }

}