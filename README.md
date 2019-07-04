Java Reflection Factory Example
======
The **Jave Reflection Factory Example** is an example of how reflection may be used in a factory to allow applications to be extended without updates to the core application source code as required by most factory patterns. Currently scanning JAR files is unsupported. Also, the class scanner does not scan below the packageName - this is intentional and the behavior of the class scanner can be easily adapted to recurse the directories.

## Usage
```
/* 
 * Create a new instance of the reflection factory by 
 * passing the package name to the constructor. The class
 * scanner will look in this package for classes. All of the
 * classes in this package must share the same superclass -
 * Vehicle in this case.
 */
VehicleFactory vehicleFactory = new VehicleFactory("org.codehamster.vehicles");

/* 
 * Call the getVehicle() method with the identifier ("name")
 * of the class to create a new instance of.
 */
Vehicle vehicleOne = vehicleFactory.getVehcile("boat");
Vehicle vehicleTwo = vehicleFactory.getVehcile("train");
Vehicle vehicleThree = vehicleFactory.getVehcile("truck");
Vehicle vehicleFour = vehicleFactory.getVehcile("airplane");
Vehicle vehicleFive = vehicleFactory.getVehcile("car");

/* 
 * Call each of the new classes with the println() method
 * to invoke the toString() method and verify the output
 * is correct.
 */
System.out.println(vehicleOne);
System.out.println(vehicleTwo);
System.out.println(vehicleThree);
System.out.println(vehicleFour);
System.out.println(vehicleFive);
```

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
