{$APPTYPE CONSOLE}
var i,j,best,p,x,l,r:integer;
a:array[1..1000000] of integer;
t,bt:extended;
begin
 { Assign(input,'input.txt');
  Assign(output,'output.txt');
  Reset(input);Rewrite(output); }
  a[1]:=1; a[2]:=3; a[3]:=4;
  for x:=4 to 1000000 do
  begin
    if x mod 2 = 0 then
    begin
      a[x]:=a[x div 2]*3;
      continue;
    end;
    p:=3; a[x]:=0;
    while p*p<=x do
      if x mod p = 0 then
      begin
        a[x]:=a[x div p]*(p+1);
        break;
      end else p:=p+2;
    if a[x]=0 then a[x]:=x+1;
  end;
  Read(l,r); bt:=(a[r]-r)/r; best:=r;
  for i:=r downto l do
  begin
   // Writeln(a[i]);
    t:=(a[i]-i)/i;
    if t<bt then
    begin
      bt:=t;
      best:=i;
    end;
  end;
  Writeln(best);
//  Close(input);Close(output);
end.
