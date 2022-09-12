set ANT_HOME=..\91_ant
set JAVA_HOME=..\90_java
@call %ANT_HOME%\bin\ant -buildfile .\00_scripts\03_deploy_test_microservice_1.xml
pause