{$APPTYPE CONSOLE}
var s,p:string;
f:array[1..250010] of integer;
i,j,k,n,m,q:integer;
begin
{  Assign(input,'input.txt');
  Assign(output,'output.txt');
  Reset(input); Rewrite(output); }
  Readln(m);
  q:=-1;
  Readln(s);
  Readln(p);
  s:=s+s;
  n:=2*m;
  f[1]:=0; k:=0;
  for j:=2 to m do
  begin
    while (k>0) and (p[j]<>p[k+1]) do k:=f[k];
    if p[j]=p[k+1] then inc(k);
    f[j]:=k;
  end;
  j:=0;
  for i:=1 to n do
  begin
    while (j>0) and (s[i]<>p[j+1]) do j:=f[j];
    if s[i]=p[j+1] then inc(j);
    if j = m then
    begin
      q:=n-i;
      break;
    end;
  end;
  if q>=m then q:=q-m;
  Writeln(q);
//  Close(input); Close(output);
end.