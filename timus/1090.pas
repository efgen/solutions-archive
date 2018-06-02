{$APPTYPE CONSOLE}
var a,b:array[1..10000] of integer;
i,j,k,n,max,res,x:integer;
function solv(l,r:integer):integer;
var i,j,k,res,x:integer;
begin
  if l>=r then
  begin
    Result:=0;
    exit;
  end;
  if l+1=r then
  begin
    if a[l]>a[r] then
    begin
      Result:=1;
      x:=a[l]; a[l]:=a[r]; a[r]:=x;
    end else Result:=0;
    exit;
  end;
  x:=(l+r) div 2;
  res:=solv(l,x)+solv(x+1,r);
  i:=l; j:=x+1;
  for k:=l to r do
  begin
    if i>x then
    begin
      b[k]:=a[j];
      inc(j);
    end else
    if j>r then
    begin
      b[k]:=a[i];
      //
      inc(i);
    end else
    if a[i]<a[j] then
    begin
      b[k]:=a[i];
      inc(i);
    end else
    begin
      b[k]:=a[j];
      res:=res+x-i+1;
      inc(j);
    end;
  end;
  for k:=l to r do
    a[k]:=b[k];
  Result:=res;
end;
begin
  {Assign(input,'test.in');
  Assign(output,'test.out');
  Reset(input);Rewrite(output); }
  Read(n,k);
  max:=0; res:=1;
  for i:=1 to k do
  begin
    for j:=1 to n do Read(a[j]);
    x:=solv(1,n);
    if x>max then
    begin
      max:=x;
      res:=i;
    end;
  end;
  Writeln(res);
 // Close(input);Close(output);
end.
