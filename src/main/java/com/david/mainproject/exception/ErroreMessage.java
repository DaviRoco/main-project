package com.david.mainproject.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ErroreMessage {
  private String message;
  private Boolean value;

  public void setMessageError(int tipo) {
    boolean tempValue = false;
    switch (tipo) {
      case 1:
        this.message = "Entity already exists";
        break;
      case 2:
        this.message = "Entity already exists";
        tempValue = true;
        break;

      case 3:
        this.message = "Entity deleted successfully";
        tempValue = true;
        break;

      default:
        this.message = "ERROR";
    }
    this.value = tempValue;
  }
}
