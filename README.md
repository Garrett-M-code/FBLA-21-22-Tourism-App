# FBLA-21-22-Tourism-App
The creation of a Filtering app for FBLA Coding and Programming. This application was developed using Oracle Java 8 and OpenJDK 11. This application was developed by Euan Ham and Garrett Moore.

[Find the source code here](https://github.com/Garrett-M-code/FBLA-21-22-Tourism-App).
___
## Purpose
The purpose of this application is to filter through locations within the Henry County area and return items that suit your needs.
___
## Setup and Execution
#### Executables
On the official GitHub page, under the mai branch, there will be a folder named "Executables". Within this folder you will find executable versions of our application. For Windows, you will find TourismApp.exe.

I you use an Linux/Unix or Mac operating system, unfourtounly we do not have executables built for you at this time. Nevertheless, feel free to compile and run the code yourself. Instructions on how to do this can be found in the next section. Likewise, you will find TourismApp.sh in the executable directory. It is a shell script and may function for your needs.

#### Compiling
To compile the code, you will need the Java JDK. If you do not have it already installed, you can find it [here](https://www.oracle.com/java/technologies/downloads/). 

**Depending on what version of Java you get and from what supplier will determine the liscensing.**

The code will be found in the main branch in the directory named "Code." The filles required are "GUI.java", "locationData.json", and "json-simple-1.1.1.jar" within the "jars" folder. Depending on what operating system you are on will determine your build commands.

If on Linux/Unix/Mac:
Run this code to compile the application -
`javac -classpath .:./jars/json-simple-1.1.1.jar -d . GUI.java`

And Use this to run the GUI.class file
`java -classpath .:./jars/json-simple-1.1.1.jar GUI`

If on Windows:
Run this code to compile the application 
'javac -classpath ./jars/json-simple-1.1.1.jar GUI.java'
And Use this to run the GUI.class file
'java -cp ".\jars\json-simple-1.1.1.jar;." GUI'
___
## External Libraries & Liscensing
#### JSON-Simple
JSON-Simple is a external library used for read, writing, and parsing through JSON files in Java. The json-simple library is meant to be a free lightweight utility for deserializing and serializing Javascript Object Notation (JSON). It aims to be easy to learn and use with a friendly license. For the development of this project, we used the lastest version (JSON-Simple-1.1.1). The code for JSON-Simple can be found [here](https://github.com/cliftonlabs/json-simple).

#### Liscensing
JSON Simple uses the Apache License 2.0.

>Apache License 2.0: A permissive license whose main conditions require preservation of copyright and license notices. Contributors provide an express grant of patent rights. Licensed works, modifications, and larger works may be distributed under different terms and without source code.

More liscensing information can be found [here](https://github.com/cliftonlabs/json-simple/blob/master/LICENSE).
___
## FAQ
**Q: What is the purpose of this app?**

A: The purpose of this application is to filter through locations within the Henry County area and return items that suit your needs.

**Q: What are the dropdowns on the side for?**

A: The dropdowns on the side allow you to select attributes that the computer can filter with.

**Q: From what point is the distance catagory located from?**

A: The refrence point for the distance factor is the McDonough town square.

**Q: What does the grey box in the center do?**

A: The grey box in the center of the application displays a list of locations that fit your needs.

**Q: Where can I find more information on locations?**

A: You can view more information about the location by clicking on its name.

**Q: Why are no locations showing up when I click Search?**

A: You might not have filled out every field. If you have, I suggest try broadening your searches.
