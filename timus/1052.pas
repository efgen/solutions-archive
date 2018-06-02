program Z1052;

{$APPTYPE CONSOLE}

uses
  SysUtils;

var
  x,y:array[1..210] of integer;
  a,b,c,n,i,j,k,max,kolv:integer;
begin
{  Assign(input,'input.txt');
  Assign(output,'output.txt');
  Reset(input); Rewrite(output);
 } Read(n); max:=0;
  for i:=1 to n do Read(x[i],y[i]);
  for i:=1 to n do
    for j:=i+1 to n do
    begin
      a:=y[j]-y[i];
      b:=x[i]-x[j];
      c:=a*x[i]+b*y[i];
      kolv:=0;
      for k:=1 to n do
        if (a*x[k]+b*y[k]=c) then inc(kolv);
      if kolv>max then max:=kolv;
    end;
  Writeln(max);
//  Close(input); Close(output);
end.
