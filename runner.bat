cd C:\Git\Instagram

for /l %%a in (1,1,100) do (call :subroutine)

:subroutine
set /a timeout=%RANDOM% * 9 / 32768 + 2
timeout /t %timeout%
"C:\Program Files\Java\jre1.8.0_201\bin\javaw.exe" -Dfile.encoding=Cp1252 -classpath C:\Git\Instagram\bin;C:\Git\Selenium\src;C:\Git\Selenium\bin;C:\Git\Selenium\JAR\byte-buddy-1.8.15.jar;C:\Git\Selenium\JAR\client-combined-3.141.59-sources.jar;C:\Git\Selenium\JAR\client-combined-3.141.59.jar;C:\Git\Selenium\JAR\commons-exec-1.3.jar;C:\Git\Selenium\JAR\guava-25.0-jre.jar;C:\Git\Selenium\JAR\okhttp-3.11.0.jar;C:\Git\Selenium\JAR\okio-1.14.0.jar;C:\Git\Selenium\JAR\commons-io-2.6.jar;C:\Git\Selenium\JAR\commons-io-2.6-javadoc.jar;C:\Git\Selenium\JAR\commons-io-2.6-sources.jar;C:\Git\Selenium\JAR\commons-io-2.6-tests.jar;C:\Git\Selenium\JAR\commons-io-2.6-test-sources.jar scripts.UnitTest