var a:array[0..10000] of longint;
n,i,j,x,q:longint;
begin
  FillChar(a,SizeOf(a),0);
  Read(n);
  for i:=1 to n do
  begin
    Read(x);
    a[i]:=a[i-1]+x;
  end;

  Read(q);
  for n:=1 to q do
  begin
    Read(i,j);
    Writeln(a[j]-a[i-1]);
  end;
end.