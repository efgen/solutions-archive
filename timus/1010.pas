{$APPTYPE CONSOLE}
var n,i,bi:integer;
a,b,best:Int64;
begin
  Read(n,b); best:=0; bi:=1;
  for i:=1 to n-1 do
  begin
    a:=b; Read(b);
    if abs(a-b)>best then
    begin
      best:=abs(a-b);
      bi:=i;
    end;
  end;
  Writeln(bi,' ',bi+1);
end.
