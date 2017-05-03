Set wshShell = CreateObject("WScript.Shell")
' Display the current value
Set wshSystemEnv = wshShell.Environment("SYSTEM")
Set wshUserEnv = wshShell.Environment("User")

wshUserEnv("_JAVA_OPTIONS") = ""
wshUserEnv("IBM_JAVA_OPTIONS") = ""
wshUserEnv("JAVA_TOOL_OPTIONS") = ""

wshSystemEnv("_JAVA_OPTIONS") =""
wshSystemEnv("IBM_JAVA_OPTIONS") =""
wshSystemEnv("JAVA_TOOL_OPTIONS") =""

set wshUserEnv = Nothing
Set wshSystemEnv = Nothing
Set wshShell     = Nothing
