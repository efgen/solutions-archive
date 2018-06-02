{$APPTYPE CONSOLE}
var n,m,i,x,p,s,t:integer;
mean,bestmean:extended;
d,best,Q:array[1..300] of integer;
a:array[1..300,1..4] of integer;
begin
 { Assign(input,'input.txt');
  Assign(output,'output.txt');
  Reset(input);Rewrite(output); }
  bestmean:=1E+10;
  FillChar(a,SizeOf(a),0);
  Read(n,m);
  for x:=1 to n do
  begin
    if x+m<=n then a[x,1]:=x+m;
    if x-m>=1 then a[x,2]:=x-m;
    a[x,3]:=x+1;
    a[x,4]:=x-1;
  end;
  a[1,4]:=n; a[n,3]:=1;
  for p:=1 to n do
  begin
    for i:=1 to n do d[i]:=-1; d[p]:=0;
    Q[1]:=p; s:=1; t:=1;
    while s<=t do
    begin
      x:=Q[s]; inc(s);
      for i:=1 to 4 do
        if a[x,i]>0 then
          if d[a[x,i]]<0 then
          begin
            inc(t);
            Q[t]:=a[x,i];
            d[Q[t]]:=d[x]+1;
          end;
    end;
    mean:=0;
    for i:=1 to n do mean:=mean+d[i];
    mean:=mean/n;
    if mean<bestmean then
    begin
      bestmean:=mean;
      for i:=1 to n do best[i]:=d[i];
    end;
  end;
  Writeln('Mean = ',bestmean:0:2);
  for x:=1 to n do
    if x mod m = 0 then Writeln(best[x]) else Write(best[x],' ');
 // Close(input);Close(output);
end.
