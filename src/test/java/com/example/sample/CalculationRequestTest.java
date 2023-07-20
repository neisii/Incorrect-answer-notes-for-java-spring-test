package com.example.sample;

import com.example.sample.exception.BadRequestException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class CalculationRequestTest {

  @DisplayName("유효한 숫자를 파싱할 수 있다.")
  @Test
  void validateParseValidNumber() {

    // given
    String[] parts = {"2", "+", "3"};

    // when
    CalculationRequest calculationRequest = new CalculationRequest(parts);

    // then

    Assertions.assertEquals(2, calculationRequest.getNum1());
    Assertions.assertEquals("+", calculationRequest.getOperator());
    Assertions.assertEquals(3, calculationRequest.getNum2());
  }

  @DisplayName("세자리 숫자가 넘어가는 유효한 숫자를 파싱할 수 있다.")
  @Test
  void validateParseValidNumberOver3length() {

    // given
    String[] parts = {"222", "+", "333"};

    // when
    CalculationRequest calculationRequest = new CalculationRequest(parts);

    // then

    Assertions.assertEquals(222, calculationRequest.getNum1());
    Assertions.assertEquals("+", calculationRequest.getOperator());
    Assertions.assertEquals(333, calculationRequest.getNum2());
  }

  @DisplayName("유효한 길이의  숫자가 들어오지 않으면 에러를 던진다.")
  @Test
  void throwBadRequestExceptionWhenInvalidNumber() {

    // given
    String[] parts = {"222", "+"};

    // when  // then
    assertThrows(BadRequestException.class, () -> new CalculationRequest(parts));
  }

  @DisplayName("유효한 연산자가 들어오지 않으면 에러를 던진다.")
  @Test
  void throwInvalidOperatorExceptionWhenInvalidOperator() {

    // given
    String[] parts = {"222", "!", "333"};

    // when  // then
    assertThrows(InvalidOperatorException.class, () -> new CalculationRequest(parts));
  }

  @DisplayName("유효한 길이의 연산자가 들어오지 않으면 에러를 던진다.")
  @Test
  void throwInvalidOperatorExceptionWhenInvalidOperatorOver1length() {

    // given
    String[] parts = {"222", "+++", "333"};

    // when  // then
    assertThrows(InvalidOperatorException.class, () -> new CalculationRequest(parts));
  }


}