var a:array[0..5000] of longint;
i,j,n,k,x,cur:longint;
s:string;
begin
  FillChar(a,SizeOf(a),0);
  Readln(n);
  for i:=1 to n do
  begin
    Readln(x);
    inc(a[x]);
  end;
  Readln(s);
  if s<>'###' then begin Writeln('!!!'); exit; end;
  Readln(k);
  for i:=1 to k do
  begin
    Readln(x);
    j:=0; cur:=0;
    while j<x do
    begin
      inc(cur);
      j:=j+a[cur];
    end;
    Writeln(cur);
  end;
end.