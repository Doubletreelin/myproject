@echo off 
echo *************************************
echo �Զ���jar���ķ���
echo author��shaoiln 
echo ��Ȩ���У�����ؾ�
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
echo %name%����ɹ�
echo �洢λ��Ϊ%saveurl%/%name%
echo *************************************