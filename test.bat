@echo off
cd /d "f:\1 HAW Hamburg\IE 3\AD\Lab04"
echo Compiling...
javac TestSimple.java
if %ERRORLEVEL% EQU 0 (
    echo Compilation successful
    echo Running...
    java TestSimple
) else (
    echo Compilation failed with error code %ERRORLEVEL%
)
pause
