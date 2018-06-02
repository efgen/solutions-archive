var x,y,s:longint;
begin
  Readln(x,y);
  s:=x+y-1;
  x:=s-x; y:=s-y;
  Writeln(x,' ',y);
end.