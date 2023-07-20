package com.example.sample;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.*;

class CalculationRequestReaderTest {

  @DisplayName("System.in으로 데이터를 읽어들일 수 있다.")
  @Test
  void test() {

    // given
    CalculationRequestReader calculationRequestReader = new CalculationRequestReader();
    // when
    System.setIn(new ByteArrayInputStream("2 + 3".getBytes()));
    CalculationRequest result = calculationRequestReader.read();

    // then
    assertEquals(2L, result.getNum1());
    assertEquals("+", result.getOperator());
    assertEquals(3L, result.getNum2());

  }

}