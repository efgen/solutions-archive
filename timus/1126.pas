var A,L,R:array[1..26000] of integer;
i,n,m,x:integer;
function max(a,b:integer):integer;
begin
  if a>b then Result:=a else Result:=b;
end;
function prev(x:integer):integer;
begin
  Result:=x and (x-1);
end;
function next(x:integer):integer;
begin
  Result:=(x shl 1) - (x and (x-1));
end;
procedure modif(pos,val:integer);
var x:integer;
begin
  A[pos]:=val;
  x:=pos;
  while x<=n do
  begin
    L[x]:=max(L[x],val);
    x:=next(x);
  end;
  x:=pos;
  while x>0 do
  begin
    R[x]:=max(R[x],val);
    x:=prev(x);
  end;
end;
function rmq(left,right:integer):integer;
var x,res:integer;
begin
  res:=-1;
  x:=left;
  while next(x)<=right do
  begin
    res:=max(res,R[x]);
    x:=next(x);
  end;
  res:=max(res,A[x]);
  x:=right;
  while prev(x)>=left do
  begin
    res:=max(res,L[x]);
    x:=prev(x);
  end;
  Result:=res;
end;
begin
 { Assign(input,'input.txt');
  Assign(output,'output.txt');
  Reset(input); Rewrite(output);
 } FillChar(A,SizeOf(A),-1);
  FillChar(L,SizeOf(L),-1);
  FillChar(R,SizeOf(R),-1);
  Read(m); n:=0;
  repeat
    Read(x);
    if x<0 then break;
    inc(n);
    a[n]:=x;
  until false;
  for i:=1 to n do modif(i,a[i]);
  for i:=1 to n-m+1 do
    Writeln(rmq(i,i+m-1));
// Close(input); Close(output);
end.
