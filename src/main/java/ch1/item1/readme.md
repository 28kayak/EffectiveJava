## Chapter 1 : Creating and Destroying Object
### item1 consider static factory methods and instead of constructs 
#### Advantages 
1. a factory method can describe it rule by a well-chosen name. 
2. a factory method does not create a new object for each invocation. 
3. a factory method can return any object that is sub-class(sub-type) of their return type. 
4. a factory method can determine which type of object returns, depending on the parameters. 
5. a factory method does not require an existence of the returned object by the time class is written. 
item
#### Disadvantages 
1. A class that does not have public/protected constructors cannot be subclassed. 
2. Unlike constructor, it is difficult for programmers to figure out how to instantiate a class.

#### Experiment advantages 2
In this section, I would like to see what the author recommends is really efficient, especially the statement below.  
> a factory method does not create a new object for each invocation. 

To check if a factory method is truly more `efficient` than  a constructor, I created a class called `BooleanTranslator.java` .
`BooleanTranslator.java` is a class written one method and one constructor to compare. 

```java 

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

```
Now, with this class, we will test efficiency from two perspectives. 

1. Memory usage  
2. Performance 

###  Memory usage 
To determine which memory usage is efficient,  we use the class `BoolTranslatorPerformance.java`, which simply comparing memory usage after invoking 100000000 times of the factory method or constructor.  
The result of memory usage difference is below.

| a factory method|  constructor |  constructor-like method |
|---------------|------------- | ---------|
| 381     (MiB) | 2289 (MiB) |1907(MiB)    |


### Performance 
To determine the better performance, we will use the class named, `BooleanTranslatorPerformance.java`. 
This class simply measure time to generate 100000000 objects from both a factory method or a constructor. 

|(nano sec)|factory method | constructor |
|-----|-----------------|---------------|
||84844528|33968004853  |
||81088767|32082543122  |
||88523115|32993035995  |
||83016412|32305969553  |  
|(sec)|--------|-------------|
||~0.08|~32.0|


### Conclusion 

Typically it is better to use a factory method when you create many many objects in your programs.
a factory method can save your resource tremendously. 
