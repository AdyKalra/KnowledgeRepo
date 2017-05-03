Set wshShell = CreateObject("WScript.Shell")
' Display the current value
Set wshSystemEnv = wshShell.Environment("SYSTEM")

Set wshUserEnv = wshShell.Environment("User")

wshUserEnv("_JAVA_OPTIONS") ="-Xrunjvmhook -Xbootclasspath/a:C:\PROGRA~2\HP\QUICKT~1\bin\JAVA_S~1\classes;C:\PROGRA~2\HP\QUICKT~1\bin\JAVA_S~1\classes\jasmine.jar"
		
wshUserEnv("IBM_JAVA_OPTIONS") ="-Xrunjvmhook -Xbootclasspath/a:C:\PROGRA~2\HP\QUICKT~1\bin\JAVA_S~1\classes;C:\PROGRA~2\HP\QUICKT~1\bin\JAVA_S~1\classes\jasmine.jar"

For Each strItem In wshUserEnv
	'WScript.Echo strItem
	If strItem = "JAVA_TOOL_OPTIONS=" Then
	'WScript.Echo "FOUND"
	wshUserEnv.Remove("JAVA_TOOL_OPTIONS")
	End If
Next
'Set wshUserEnv = Nothing
'Set wshShell   = Nothing

fldr="C:\PROGRA~2\HP\UNIFIE~1"
Set fso = CreateObject("Scripting.FileSystemObject")
   If (fso.FolderExists(fldr)) Then
      wshSystemEnv("_JAVA_OPTIONS") ="-Xrunjvmhook -Xbootclasspath/a:C:\PROGRA~2\HP\UNIFIE~1\bin\JAVA_S~1\classes;C:\PROGRA~2\HP\UNIFIE~1\bin\JAVA_S~1\classes\jasmine.jar"
		
	  wshSystemEnv("IBM_JAVA_OPTIONS") ="-Xrunjvmhook -Xbootclasspath/a:C:\PROGRA~2\HP\UNIFIE~1\bin\JAVA_S~1\classes;C:\PROGRA~2\HP\UNIFIE~1\bin\JAVA_S~1\classes\jasmine.jar"
   Else
      wshSystemEnv("_JAVA_OPTIONS") ="-Xrunjvmhook -Xbootclasspath/a:C:\PROGRA~2\HP\QUICKT~1\bin\JAVA_S~1\classes;C:\PROGRA~2\HP\QUICKT~1\bin\JAVA_S~1\classes\jasmine.jar"
	
	wshSystemEnv("IBM_JAVA_OPTIONS") ="-Xrunjvmhook -Xbootclasspath/a:C:\PROGRA~2\HP\QUICKT~1\bin\JAVA_S~1\classes;C:\PROGRA~2\HP\QUICKT~1\bin\JAVA_S~1\classes\jasmine.jar"
End If


wshSystemEnv("JAVA_TOOL_OPTIONS") ="-agentlib:jvmhook"

wshSystemEnv("JAVA_HOME") = "C:\Program Files\Java\jdk1.7.0_40"

Set wshSystemEnv = Nothing
Set wshShell     = Nothing

