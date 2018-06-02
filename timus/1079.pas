program Z1079;

{$APPTYPE CONSOLE}

uses
  SysUtils;

var
  a,b:array[0..100100] of integer;
  i,n:integer;
begin
  {Assign(input,'input.txt');
  Assign(output,'output.txt');
  Reset(input); Rewrite(output);
  }a[0]:=0; a[1]:=1;  b[0]:=0; b[1]:=1;
  for i:=2 to 100100 do
  begin
    if i mod 2 = 0 then a[i]:=a[i div 2] else
    a[i]:=a[i div 2] + a[i div 2 +1];
    if a[i]>b[i-1] then b[i]:=a[i] else b[i]:=b[i-1];
  end;
  Read(n);
  while n>0 do
  begin
    Writeln(b[n]);
    Read(n);
  end;
//  Close(input); Close(output);
end.
