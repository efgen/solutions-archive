{$APPTYPE CONSOLE}
var a,ind:array[1..10000] of integer;
i,n:integer;
procedure sort(l,r:integer);
var i,j,x,q:integer;
begin
  i:=l; j:=r; x:=a[(l+r) div 2];
  repeat
    while a[i]<x do inc(i);
    while a[j]>x do dec(j);
    if i<=j then
    begin
      q:=a[i]; a[i]:=a[j]; a[j]:=q;
      q:=ind[i]; ind[i]:=ind[j]; ind[j]:=q;
      inc(i); dec(j);
    end;
  until i>j;
  if l<j then sort(l,j);
  if i<r then sort(i,r);
end;
begin
{  Assign(input,'input.txt');
  Assign(output,'output.txt');
  Reset(input);Rewrite(output);   }
  Readln(n);
  for i:=1 to n do
  begin
    Readln(a[i]);
    ind[i]:=i;
  end;
  sort(1,n);
  i:=1;
  while i<n do
  begin
    Writeln(ind[i],' ',ind[i+1]);
    i:=i+2;
  end;
 // Close(input);Close(output);
end.
