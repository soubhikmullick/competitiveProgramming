import java.util.*;
public class SampleCodeTesting {
  class HoldingBal {

  }

  /* Driver program to test above function */
  public static void main(String[] args)
  {

    Object val = Optional.ofNullable("USD").orElse("asads");
    System.out.println(val.toString());
  }


}
