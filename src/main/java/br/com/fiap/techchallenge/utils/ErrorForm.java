package br.com.fiap.techchallenge.utils;

public class ErrorForm {
  
  private final String field;
  private final String error;

  public ErrorForm(String field, String error) {
    this.field = field;
    this.error = error;
  }

  public String getField() {
    return field;
  }

  public String getError() {
    return error;
  }
}
