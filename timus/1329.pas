{$M 16777216}

program Z1329;

{$APPTYPE CONSOLE}
uses
  SysUtils;

type Link = ^Node;
Node = record
  x:Integer;
  p:Link;
end;
var h:array[1..40010] of Link;
s,f:array[1..40010] of integer;
i,n,v,w,r,time,L,x,y,sp:integer;
p:Link;
procedure d_f_s(v:integer);
begin
  inc(time); s[v]:=time;
  while h[v]<>nil do
  begin
    if s[h[v].x]=0 then d_f_s(h[v].x);
    h[v]:=h[v].p;
  end;
  inc(time); f[v]:=time;
end;
{procedure d_f_s();
label B,E;
begin
  B: inc(time); s[v]:=time;
  E: while h[v]<>nil do
     begin
       if s[h[v].x]=0 then begin inc(sp); st[sp]:=v; v:=h[v].x; goto B; end;
       h[v]:=h[v].p;
     end;
     inc(time); f[v]:=time;
     if sp=0 then exit;
     v:=st[sp]; dec(sp);  goto E;
end;       }

begin
{  Assign(input,'input.txt');
  Assign(output,'output.txt');
  Reset(input); Rewrite(output);
}  FillChar(s,SizeOf(s),0);
  FillChar(f,SizeOf(f),0);
  Read(n);
  for i:=1 to n do h[i]:=nil;
  for i:=1 to n do
  begin
    Read(w,v);
    if v<>-1 then
    begin
      p:=new(Link);
      p.x:=w;
      p.p:=h[v];
      h[v]:=p;
    end else r:=w;
  end;
 // v:=r;  sp:=0;
  d_f_s(r);
  Read(L);
  for i:=1 to L do
  begin
    Read(x,y);
    if (s[x]<s[y]) and (f[y]<f[x]) then Writeln(1) else
    if (s[y]<s[x]) and (f[x]<f[y]) then Writeln(2) else Writeln(0);
  end;
// Close(input); Close(output);
end.