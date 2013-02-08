# Variables.
SCRIPTS_DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" && pwd )"
DIR="$(dirname "$SCRIPTS_DIR")"
CLASSPATH=.:$DIR/vendor/junit-4.10.jar:$DIR/build

# Cleaning.
[ -d $DIR/build ] || mkdir $DIR/build
rm -rf $DIR/build/*

# Compiling.
javac -cp $CLASSPATH -d $DIR/build $DIR/*.java

# Running.
java -cp $CLASSPATH org.junit.runner.JUnitCore Queue