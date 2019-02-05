package ch1.item1;

import ch1.item1.BooleanTranslator;

public class BoolTranslatorMemUsage {
  private static final long MEGABYTE = 1024L * 1024L;

  public static long bytesToMegabytes(long bytes){
    return bytes / MEGABYTE;
  }
  public static void main(String[] args) {
    BooleanTranslator[] booleans2 = new BooleanTranslator[100000000];
    Boolean[] booleans1 = new Boolean[100000000];

    for (int index = 0; index < booleans1.length; index++){
      booleans1[index] = BooleanTranslator.valueOf(false);
      //booleans2[index] = new BooleanTranslator(false);
    }
    //get the java runtime
    Runtime runtime = Runtime.getRuntime();
    //run the garbage collector
    runtime.gc();
    //calculate the used memory
    long memory = runtime.totalMemory() - runtime.freeMemory();
    System.out.println("Used memory in bytes: " + memory);
    System.out.println("Used memory in megabytes : " + bytesToMegabytes(memory));

  }
}
