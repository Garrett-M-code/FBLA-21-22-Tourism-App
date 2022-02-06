#This compiles the java file.
javac -classpath .:./jars/json-simple-1.1.1.jar -d . GUI.java

#This runs the java file.
java -classpath .:./jars/json-simple-1.1.1.jar GUI
