program Z;

{$APPTYPE CONSOLE}
uses
  SysUtils;
var a,x,p,n:integer;
begin
  {Assign(input,'input.txt');
  Assign(output,'output.txt');
  Reset(input); Rewrite(output);
 } Read(n); n:=2*n;
  p:=Trunc(Sqrt(n))+1;
  while p>0 do
  begin
    if n mod p = 0 then
    begin
      x:=n div p - p - 1;
      if (x>=0) and (x mod 2 = 0) then break;
    end;
    dec(p);
  end;
  a:=x div 2 +1;
  Writeln(a,' ',p);
//  Close(input); Close(output);
end.