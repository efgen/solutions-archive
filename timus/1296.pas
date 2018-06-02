var n,grav,best,i:longint;
    a:integer;
begin
  grav:=0; best:=0;
  Readln(n);
  i:=1;
  while i<=n do
  begin
    Read(a);
    grav:=grav+a;
    if grav>best then best:=grav;
    if grav<0 then grav:=0;
    inc(i);
  end;
  Writeln(best);
end.