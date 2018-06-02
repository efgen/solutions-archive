var i,n:integer;
CurrentA:array [1..1900] of char;
SizeA:integer;
Znak:boolean;

procedure NextA(n:integer);
var i:integer;
    b:boolean;
    s:string;
    sinus:string;
begin
  if n=1 then
  begin
    CurrentA[1]:='s';
    CurrentA[2]:='i';
    CurrentA[3]:='n';
    CurrentA[4]:='(';
    CurrentA[5]:='1';
    SizeA:=5;
    Znak:=true;
    exit;
  end;
  sinus:='sin(';

  inc(SizeA);
  Znak:=not(Znak);
  if Znak then CurrentA[SizeA]:='+' else CurrentA[SizeA]:='-';
  for i:=1 to 4 do CurrentA[SizeA+i]:=sinus[i];
  SizeA:=SizeA+4;
  Str(n,s);
  for i:=1 to length(s) do
    CurrentA[SizeA+i]:=s[i];
  SizeA:=SizeA+length(s);
end;

procedure PrintA(n:integer);
var i:integer;
begin
  NextA(n);
  for i:=1 to SizeA do Write(CurrentA[i]);
  for i:=1 to n do Write(')');
end;

begin
  Readln(n);
  if (n<1) or (n>200) then exit;
  Writeln;
  for i:=1 to n-1 do Write('(');
  for i:=1 to n-1 do
  begin
    PrintA(i);
    Write('+');
    Write(n-i+1);
    Write(')');
  end;
  PrintA(n);
  Write('+');
  Write('1');
end.
