package ch.hfict.controller;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;

@ManagedBean
public class StatisticsController implements Serializable {
  private String numbers = null;
  
  public StatisticsController() {}

  public void setNumbers(String numbers) {
    this.numbers = numbers;
  }

  public String getNumbers() {
    return numbers;
  }

  public String getAverage() {
    return "You got it.";
  }
}
