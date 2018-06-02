{$APPTYPE CONSOLE}
var res,x,y,i,v,k,t,s,n,m,sz,com:integer;
a:array[0..4*100*100] of integer;
f:array[0..100,0..100] of boolean;
c:array[0..4000] of integer;
begin
 // reset(input,'input.txt');
 // rewrite(output,'output.txt');
  res:=0;
  FIllChar(f,SizeOf(f),0);
  Read(n,m);
  sz:=4*n*m-1;
  t:=m+1;
  for i:=0 to sz do
  begin
    Read(x,y);
    a[i]:=x*m+y-t;
  end;
  inc(sz); sz:=sz div 4;
  Read(com);
  for i:=1 to com do
  begin
    Read(x);
    c[i]:=(x-1)*sz;
  end;
  for s:=sz-1 downto 0 do
    begin
      v:=s;
      for i:=1 to com do
         v:=a[v+c[i]];
      x:= v div m;
      y:= v mod m;
      if not f[x][y]  then  begin f[x][y]:= true; inc(res); end;
    end;
  Writeln(res);
  for x:=0 to n-1 do
    for y:=0 to m-1 do
      if f[x][y] then Writeln(x+1,' ',y+1);
  
end.
