var x,n,m,y,i,num:integer;
flag:boolean;
begin
  Readln(n,m,y); flag:=false;
  for x:=0 to m-1 do
  begin
    num:=x;
    for i:=2 to n do
      num:=(num*x) mod m;
    if num=y then
    begin flag:=true; Write(x,' '); end;
  end;
  if not(flag) then writeln(-1) else Writeln;
end.