{$APPTYPE CONSOLE}
var a:array[1.. 25010] of integer;
n,i:integer;
procedure sort(l,r:integer);
var i,j,x,q:integer;
begin
  i:=l; j:=r; x:=a[(l+r) div 2];
  repeat
    while a[i]>x do inc(i);
    while a[j]<x do dec(j);
    if i<=j then
    begin
      q:=a[i]; a[i]:=a[j]; a[j]:=q;
      inc(i); dec(j);
    end;
  until i>j;
  if l<j then sort(l,j);
  if i<r then sort(i,r);
end;
begin
{  Assign(input,'input.txt');
  Assign(output,'output.txt');
  Reset(input); Rewrite(output);   }
  Read(n);
  for i:=1 to n do Readln(a[i]);
  sort(1,n);
  for i:=1 to n do Writeln(a[i]);
 // Close(input); Close(output);
end.