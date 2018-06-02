const max=50000;
var   n,m,i,j,s:longint;
      a,b:array[1..max] of integer;
begin
  Readln(n); for i:=1 to n do Read(a[i]);
  Readln(m); for i:=1 to m do Read(b[i]);
  i:=1; j:=1;
  while (i<=n) and (j<=m) do
  begin
    s:=a[i]+b[j];
    if s>10000 then inc(j) else
    if s<10000 then inc(i) else
    begin Writeln('YES');halt;end;
  end;
  Writeln('NO');
end.