{$APPTYPE CONSOLE}
var a,b:array[1..100000] of integer;
d:array[0..30001] of integer;
i,j,k,n,r,res:integer;
procedure sort(l,r:integer);
var i,j,x,q:integer;
begin
  i:=l; j:=r; x:=a[(l+r)div 2];
  repeat
    while a[i]<x do inc(i);
    while a[j]>x do dec(j);
    if i<=j then
    begin
      q:=a[i]; a[i]:=a[j]; a[j]:=q;
      q:=b[i]; b[i]:=b[j]; b[j]:=q;
      inc(i); dec(j);
    end;
  until i>j;
  if l<j then sort(l,j);
  if i<r then sort(i,r);
end;
function max(x:integer):integer;
begin
  if x>=r then Result:=d[x] else Result:=d[r];
end;
procedure modif(pos,x:integer);
var i:integer;
begin
  for i:=x+1 to r do d[i]:=d[r];
  r:=pos;
  d[r]:=x;
end;
begin
 { Assign(input,'input.txt');
  Assign(output,'output.txt');
  Reset(input);Rewrite(output);    }
  FillChar(d,SizeOf(d),0);   r:=30001;
  Read(n);
  for i:=1 to n do Read(a[i],b[i]);
  sort(1,n);
  for i:=n downto 1 do
    if max(b[i]+1)+1>max(a[i]) then modif(a[i],max(b[i]+1)+1);
  Writeln(d[r]);
  //Close(input);Close(output);
end.
