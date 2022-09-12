set ANT_HOME=..\91_ant
set JAVA_HOME=..\90_java
@call %ANT_HOME%\bin\ant -buildfile .\00_scripts\01_build_platform.xml
pause