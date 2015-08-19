# Mower

This is an implementation of the mower example using java8.

## Approach
The mower example consists of a delimited squared lawn in which 1 or N mowers can move based on a sequence of instructions.  
Those instructions arrive as a String of letters where each letter represents a movement.
### Instructions
The possible instructions are:
 - D = Turn right (90°)
 - G = Turn left (90°)
 - A =  move forward in the direction where the mower is facing.

## Prerequisites
JDK 1.8

## Installation

From your command line, clone the project using
```sh
$ git clone https://github.com/dicaormu/mower.git
$ cd mower
```
This projet uses gradle and a gradlew file is provided, so, you don't have to install it.

To generate this project for intellij, from the command line, in the folder where this project was cloned, type:
```sh
$ ./gradlew idea
```

To build the project and run the tests
```sh
$ ./gradlew build
```

## How it works?
The project contains a class 'MowerService' in the package
'fr.com.mowitnow.service'.
This class contains a public method called 'computeInstructions', which is in charge of receiving:
- All the instructions from a 'supplier' (one has been implemented to read from a given file in 'fr.com.mowitnow.suppliers.FileComputeSupplier').
- A consumer in order to  print the final position of each mower. 

This method returns the lawn with all the processed mowers in their final positions.
Instructions must arrive as follow:
- 1 line: Lawn's max position in the cartesian plane. Coordinates are separated by 1 space.  (ex: 5 5)
- 2 - n lines: tuples of lines representing:
   - First line of the tuple: The position of the mower in the lawn and the direction (north - N, south - S, east - E, west - W. ex: 1 2 N)
   - Second line of the tuple: instructions of the mower (ex: GADAAGA)

### Make it run
1.  Create a supplier, examples:
  - Supplier that provides a list.
```
Supplier<List<String>> supplier = () -> Arrays.asList("5 5", "1 2 N", "GAGAGAGAA", "3 3 E", "AADAADADDA");
```
- Supplier that provides a file
```
 Supplier<List<String>> supplier = new FileComputeSupplier(MowerService.class
                .getClassLoader().getResource("file.txt").getPath());
```
2. Create an instance of the class 'fr.com.mowitnow.service.MowerService', example:
```
MowerService service = new MowerService();
```
3. Call the method 'computeInstructions' using the supplier created in point 1 and a consumer to print the mower, example: 
```
service.computeInstructions(supplier, System.out::println);
```

Unit tests provide example data and a file (file.txt) with some instructions.
