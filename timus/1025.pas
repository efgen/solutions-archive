const n=101;
var a:array[1..n] of integer;
k,i,j,sum,min,q:integer;
begin
  Readln(k);
  for i:=1 to k do Read(a[i]);

  {Sort}
  for i:=1 to k do
  begin
    min:=i;
    for j:=i to k do
      if a[j]<a[min] then min:=j;
    q:=a[i]; a[i]:=a[min]; a[min]:=q;
  end;

  sum:=0;
  k:=(k div 2)+1;
  for i:=1 to k do sum:=sum+(a[i] div 2)+1;
  Writeln(sum);
end.