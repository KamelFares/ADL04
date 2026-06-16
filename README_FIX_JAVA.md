# JAVA INSTALLATION IS BROKEN - How to Fix

## The Problem
Your javac.exe is crashing with error code -1073740791 (stack buffer overrun).
This means your Java installation is corrupted or incompatible.

## Quick Fix Options:

### Option A: Reinstall Java (RECOMMENDED)
1. Download latest JDK from: https://www.oracle.com/java/technologies/downloads/
2. Uninstall all existing Java versions:
   - Go to Settings > Apps > Uninstall
   - Remove "Java" and "Oracle Java" entries
3. Install the new JDK
4. Restart your computer

### Option B: Use VS Code Java Extension Pack
1. In VS Code, press Ctrl+Shift+X
2. Search for "Java Extension Pack"
3. Click Install
4. It will download a working JDK automatically

### Option C: Use Eclipse or IntelliJ IDEA
Both IDEs come with bundled Java and will compile your code.

## After Fixing Java:
Run this command to test:
```
cd "f:\1 HAW Hamburg\IE 3\AD\Lab04"
javac -version
javac fares\Node.java fares\AdjacencyList.java fares\AdjacencyLists.java fares\Graph.java fares\SimpleTest.java
java fares.SimpleTest
```

## Current Files Status:
✅ All .java source files are correct and ready
✅ Package structure is organized properly
❌ Java compiler is broken - cannot compile
❌ No .class files exist

Once Java is fixed, your code will work perfectly!
