@echo off 
echo *************************************
echo 自动打jar包的方法
echo author：shaoiln 
echo 版权所有，盗版必究
echo *************************************
set name=%1
set url=%2
set saveurl=%3
%4
cd %url%
call mvn package
rd/s/q %saveurl%\%name%
md %saveurl%\%name%
copy %url%\target\%name%.jar %saveurl%\%name%
md %saveurl%\%name%\lib
xcopy %url%\target\lib %saveurl%\%name%\lib
copy %url%\target\classes\application.properties %saveurl%\%name%
echo *************************************
echo %name%打包成功
echo 存储位置为%saveurl%/%name%
echo *************************************