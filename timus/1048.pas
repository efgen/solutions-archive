program Z1038;

{$APPTYPE CONSOLE}

uses
  SysUtils;

var a,b,c:array[1..1000100] of byte;
i,n,um:integer;
begin
//  Assign(input,'input.txt');
//  Assign(output,'output.txt');
 // Reset(input); Rewrite(output);
  Read(n);
  for i:=1 to n do Read(a[i],b[i]);
  um:=0;
  for i:=n downto 1 do
  begin
    um:=a[i]+b[i]+um;
    c[i]:=um mod 10;
    um:=um div 10;
  end;
  for i:=1 to n do Write(c[i]);
 // Close(input); Close(output);
end.
