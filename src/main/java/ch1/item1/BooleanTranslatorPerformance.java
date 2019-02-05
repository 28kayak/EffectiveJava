package ch1.item1;

import ch1.item1.BooleanTranslator;

public class BooleanTranslatorPerformance {
  public static void main(String[] args) {
    Boolean[] booleans1 = new Boolean[100000000];
    BooleanTranslator[] booleans2 = new BooleanTranslator[100000000];

    long startTime1 = System.nanoTime();
    for (int index = 0; index < booleans1.length; index++){
      booleans1[index] = BooleanTranslator.valueOf(false);
    }
    long stopTime1 = System.nanoTime();
    long elapsedTime1 = stopTime1 - startTime1;




    System.out.println("--- Factory method ---");
    System.out.println(elapsedTime1);



    long startTime2 = System.nanoTime();

    for (int i = 0; i < booleans2.length; i++){
      booleans2[i] = new  BooleanTranslator(false);
    }

    long stopTime2 = System.nanoTime();
    long elapsedTime2 = stopTime2 - startTime2;
    System.out.println("--- Constructor ---");
    System.out.println(elapsedTime2);

  }
}
