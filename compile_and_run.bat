@echo off
setlocal enabledelayedexpansion

cd /d "f:\1 HAW Hamburg\IE 3\AD\Lab04"

echo ====================================
echo Compiling fares package...
echo ====================================

"C:\Program Files\Common Files\Oracle\Java\javapath\javac.exe" -d . -cp . fares\Node.java fares\AdjacencyList.java fares\AdjacencyLists.java fares\Graph.java fares\SimpleTest.java

if !ERRORLEVEL! EQU 0 (
    echo.
    echo ====================================
    echo Compilation SUCCESSFUL!
    echo ====================================
    echo.
    echo Running SimpleTest...
    echo ====================================
    "C:\Program Files\Common Files\Oracle\Java\javapath\java.exe" -cp . fares.SimpleTest
) else (
    echo.
    echo ==================================== 
    echo Compilation FAILED!
    echo Error code: !ERRORLEVEL!
    echo ====================================
)

echo.
echo Done.
pause
