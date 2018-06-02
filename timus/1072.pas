program Z;

{$APPTYPE CONSOLE}
uses
  SysUtils;
var i,j,n,k:integer;
a:array[1..100,0..5] of LongWord;
Q,d,p:array[1..100] of integer;
ip,msk,x,y,uk1,uk2:LongWord;
S:String;
f:boolean;
procedure Show(v:integer);
begin
  if p[v]=0 then Write(v) else
  begin
    Show(p[v]);
    Write(' ',v);
  end;
end;
begin
{  Assign(input,'input.txt');
  Assign(output,'output.txt');
  Reset(input); Rewrite(output);
}  ReadLn(n);
  for i:=1 to n do
  begin
    Readln(a[i,0]);
    for j:=1 to a[i,0] do
    begin
      Readln(S);
      ip:=0; msk:=0; k:=1; x:=0;
      while true do
      begin
        if (s[k]='.') or (s[k]=' ') then
        begin ip:=256*ip+x; x:=0; end else
        x:=10*x+ord(s[k])-ord('0');
        if (s[k]=' ') then break;
        inc(k);
      end;
      inc(k);
      while true do
      begin
        if (s[k]='.') or (k>length(s)) then
        begin msk:=256*msk+x; x:=0; end else
        x:=10*x+ord(s[k])-ord('0');
        if (k>length(s)) then break;
        inc(k);
      end;
      a[i,j]:=ip and msk;
    end;
  end;
  Readln(x,y);
  uk1:=0; uk2:=1; Q[1]:=x;
  for i:=1 to n do d[i]:=-1; d[x]:=0;
  for i:=1 to n do p[i]:=-1; p[x]:=0;
  while (uk1<uk2) do
  begin
    inc(uk1); x:=Q[uk1];
    for i:=1 to n do
    begin
      if d[i]>=0 then continue;
      f:=false;
      for j:=1 to a[x,0] do
        for k:=1 to a[i,0] do
          f:=f or (a[x,j]=a[i,k]);
      if not(f) then continue;
      inc(uk2); Q[uk2]:=i;
      d[i]:=d[x]+1;
      p[i]:=x;
      if i=y then
      begin Writeln('Yes'); Show(y); {Close(input); Close(output);  }halt(0); end;
    end;
  end;
  Writeln('No');
//  Close(input); Close(output);
end.