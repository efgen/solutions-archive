{$APPTYPE CONSOLE}
var a:array[0..500,0..500] of Int64;
b,c:array[0..500] of integer;
i,j,k,n,m:integer;
inf:Int64;
function f(l,r:integer):Int64;
begin
  Result:=((r-l+1)-(b[r]-b[l-1]))*(b[r]-b[l-1]);
end;
function min(a,b:Int64):Int64;
begin
  if a<b then min:=a else min:=b;
end;
begin
 { Assign(input,'input.txt');
  Assign(output,'output.txt');
  Reset(input);Rewrite(output);      }
  FillChar(a,SizeOf(a),0);
  FillChar(b,SizeOf(b),0);
  FillChar(c,SizeOf(c),0);
  Read(n,m);
  inf:=1000000000000;
  for i:=1 to n do
  begin
    Read(c[i]);
    b[i]:=b[i-1]+c[i];
  end;
  for i:=1 to n do a[1,i]:=f(1,i);
  for k:=2 to m do
  begin
    for i:=k to n do
    begin
      a[k,i]:=inf;
      for j:=k to i do
        a[k,i]:=min(a[k,i],a[k-1,j-1]+f(j,i));
    end;
  end;
  Writeln(a[m,n]);
//  Close(input);Close(output);
end.
