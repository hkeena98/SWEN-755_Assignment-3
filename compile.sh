#!/bin/bash
echo "Removing Old Class Files..."
rm *.class
echo "Old Class Files Removed..."
echo "Compiling Thread Pooling & Scheduling Source Files..."
javac *.java
echo "Compilation Complete..."
echo "Running Class Files..."
java Main