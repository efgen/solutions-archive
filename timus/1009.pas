var p,q,t,k,n,i:longint;
begin
  Readln(n,k);
  p:=1; t:=k-1;
  for i:=2 to n do
  begin
    q:=t;
    t:=(k-1)*(t+p);
    p:=q;
  end;
  Writeln(t);
end.