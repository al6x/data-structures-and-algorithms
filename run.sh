# Variables.
DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" && pwd )"
CLASSPATH=.:$DIR/vendor/junit-4.10.jar:$DIR/build

# Cleaning.
if [ ! -d $DIR/build ];
then
    mkdir $DIR/build
fi
rm -rf $DIR/build/*

# Compiling.
javac -cp $CLASSPATH -d $DIR/build $DIR/*.java
# javac -cp $CLASSPATH -d $DIR/build $DIR/test/*.java

# Running.
java -cp $CLASSPATH org.junit.runner.JUnitCore Queue