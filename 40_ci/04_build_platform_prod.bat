set ANT_HOME=..\91_ant
set JAVA_HOME=..\90_java
@call %ANT_HOME%\bin\ant -buildfile .\00_scripts\04_build_platform_prod.xml
pause