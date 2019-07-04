Java Reflection Factory Example
======
The **Jave Reflection Factory Example** is an example of how reflection may be used in a factory to allow applications to be extended without updates to the core application source code as required by most factory patterns. Currently scanning JAR files is unsupported. Also, the class scanner does not scan below the packageName - this is intentional and the behavior of the class scanner can be easily adapted to recurse the directories.

## Output
```
Vehicle is a boat
Vehicle is a train
Vehicle is a truck
Vehicle is a airplane
Vehicle is a car
```

## License 
* see [LICENSE](https://github.com/MannyPeterson/ReflectionFactory/blob/master/LICENSE.md) file
