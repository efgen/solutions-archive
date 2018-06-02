var n,m,i,x:integer;
a:array[1..10000] of integer;
begin
  FillChar(a,SizeOf(a),0);
  Readln(n,m);
  for i:=1 to m do
  begin
    Read(x);
    inc(a[x]);
  end;
  for i:=1 to n do
    Writeln((a[i]*100/m):4:2,'%')
end.