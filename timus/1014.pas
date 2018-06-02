const mn:array[1..8] of integer=(9,8,7,6,5,4,3,2);
var n:longint;
a:array[1..32] of integer;
i,j,k,min,q:integer;
begin
  Readln(n);
  if n=0 then
  begin Writeln(10); halt; end;
  if n<10 then
  begin Writeln(n); halt; end;

  i:=1;  k:=0;
  while (n>1) and (i<9) do
    if n mod mn[i]=0 then
    begin
      n:=n div mn[i];
      inc(k);
      a[k]:=mn[i];
    end
    else inc(i);
  if n=1 then
  begin
    for i:=1 to k do
    begin
      min:=i;
      for j:=i+1 to k do
        if a[j]<a[min] then min:=j;
      q:=a[i]; a[i]:=a[min]; a[min]:=q;
    end;
    for i:=1 to k do Write(a[i]); Writeln;
  end
  else
  Writeln(-1);
end.