#!/bin/sh
javac -classpath .:../../../lib/sshfactory.jar -d . SshScriptExample.java
java -cp .:../../../lib/sshfactory.jar SshScriptExample
