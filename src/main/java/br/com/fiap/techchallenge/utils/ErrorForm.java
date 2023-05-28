package br.com.fiap.techchallenge.utils;

public class ErrorForm {
  
  private String field;
  private String error;

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
