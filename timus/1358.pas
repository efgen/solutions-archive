{$APPTYPE CONSOLE}
var a:array[0..1000,0..1000] of boolean;
q,d,lev:array[0..1000] of integer;
n,m,i,j,x,y,s,t:integer;
px,py:array[0..1000] of extended;
dis:extended;
begin
 { Assign(input,'input.txt');
  Assign(output,'output.txt');
  Reset(input); Rewrite(output); }
  dis:=1.5;
  FillChar(a,SizeOf(a),false);
  Read(n);
  for i:=2 to n do
  begin
    Read(x,y);
    a[x,y]:=true;
    a[y,x]:=true;
  end;
  s:=1; t:=1; q[1]:=1;
  for i:=1 to n do d[i]:=n; d[1]:=0;
  for i:=1 to n do lev[i]:=0; lev[0]:=1;
  while s<=t do
  begin
    x:=q[s]; inc(s);
    for y:=1 to n do
      if a[x,y] and (d[y] = n) then
      begin
        d[y]:=d[x]+1;
        inc(lev[d[y]]);
        inc(t);
        q[t]:=y;
        py[y]:=d[y]*dis-1000;
        px[y]:=lev[d[y]]*dis-1000;
      end;
  end;
  px[1]:=-1000;
  py[1]:=-1000;
  for i:=1 to n do Writeln(px[i],' ',py[i]);
//  Close(input); Close(output);
end.