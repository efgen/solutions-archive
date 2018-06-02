var n,x,r,i:longint;
function NOD(x,y:longint):longint;
begin
   if x=0 then NOD:=y else NOD:=NOD(y mod x, x);
end;
begin
  Readln(n);      r:=0;
  for i:=1 to n do
  begin
    Read(x);
    r:=NOD(r,x);
  end;
  Writeln(r);
end.