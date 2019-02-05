package ch1.item1;
/*
* Item1: Consider static factory method instead of constructors
* Benefits
* 1) One advantage of static factory methods is that, unlike constructors, they have names.
* 2) A second advantage of static factory method is that, unlike constructors,
* they are not required to create a new object each time they are invoked.
*
* */
public class BooleanTranslator {
  //for memory calculation
  private static final long MEGABYTE = 1024L * 1024L;
  boolean bool;

/*Better*/
  public static Boolean valueOf(boolean b){
    return b ? Boolean.TRUE : Boolean.FALSE;
  }

  public BooleanTranslator(boolean b){
    bool = b;
  }

}
