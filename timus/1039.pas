{$APPTYPE CONSOLE}
type list = ^node;
node = record
  x:integer;
  p:list;
end;
var a:array[1..6000] of list;
m1,m2,pr,rank:array[1..6000] of integer;
i,j,k,n,x,y,root:integer;
p:list;
function max(a,b:integer):integer;
begin
  if a>b then Result:=a else Result:=b;
end;
procedure solv(v:integer);
var p:list;
max1,max2,w:integer;
begin
  p:=a[v];
  m1[v]:=rank[v]; m2[v]:=0;
  while p<>nil do
  begin
    w:=p.x; p:=p.p;
    solv(w);
    inc(m2[v],max(m1[w],m2[w]));
    inc(m1[v],m2[w]);
  end;
end;

begin
{  Assign(input,'input.txt');
  Assign(output,'output.txt');
  Reset(input);Rewrite(output);  }
  Read(n);
  for i:=1 to n do  Read(rank[i]);
  for i:=1 to n do a[i]:=nil;
  for i:=1 to n do pr[i]:=0;
  for i:=2 to n do
  begin
    Read(x,y);
    pr[x]:=y;
    p:=new(list);
    p.x:=x;
    p.p:=a[y];
    a[y]:=p;
  end;
  for i:=1 to n do
    if pr[i] = 0 then
    begin
      root:=i;
      break;
    end;
  solv(root);
  Writeln(max(m1[root],m2[root]));
 // Close(input);Close(output);
end.
