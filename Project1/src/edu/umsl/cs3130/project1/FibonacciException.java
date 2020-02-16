/*******************************************************************************
 * Copyright (c) 2020 Jared Diehl. All rights reserved.
 *******************************************************************************/
package edu.umsl.cs3130.project1;

/**
 * @author Jared Diehl
 * 
 *         A custom exception just to be used for
 *         this project.
 */
public class FibonacciException extends Exception {

  private static final long serialVersionUID = 1L;

  public FibonacciException(String message) {
    super(message);
  }

}
