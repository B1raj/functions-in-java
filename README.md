# functions-in-java
Codind somrthing which is the basics of functional programming.

- Creating your own Fuction interface
- Creating your own Bifunction interface
- Converting a BiFunction/TriFunction to a function via currying.



## Learning

- Replace if else with ternary operators, its more functional and has no side effects.
- use of instanceof is bad code
- Don't trust names, trust types, because types don't lie
- **Zipping** : taking to lists and converting them to a tuple
- **Unzipping** : Reverse of above
- Generic Functions are hard to write. But Generic methods are good.
- git rm -r --cached myFolder to delete folder/file without deleting the files from local
- **Folding**: converting a list into a single value by using a specific operation, the resulting value may be of different type.
- **Reducing** : Folding to a result of the same type as the list element.
- **recursion** : It starts from last step and defines its relationship with the preceding one.
- **corecursion** : It starts from first step and defines its relationship with the next one.
- foreach
   ``` 
  public static <T> void forEach(Collection<T> ts, Consumer<T> c){
           for (T t : ts){
               c.accept(t);
           }
       }
   ```

