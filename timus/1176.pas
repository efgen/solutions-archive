{$APPTYPE CONSOLE}
type list = ^node;
node = record
  x:integer;
  p:list;
end;
var a:array[1..1000] of list;
h,p,spp,pp,sp:list;
i,j,k,n,s,x,v,w:integer;
begin
 { Assign(input,'input.txt');
  Assign(output,'output.txt');
  Reset(input);Rewrite(output); }
  Read(n,s);
  for i:=1 to n do a[i]:=nil;
  for i:=1 to n do
    for j:=1 to n do
    begin
      Read(x);
      if (i<>j) and (x=0) then
      begin
        p:=new(list);
        p.x:=j;
        p.p:=a[i];
        a[i]:=p;
      end;
    end;
  h:=new(list); h.x:=s; h.p:=nil;
  p:=h;
  while p<>nil do
  begin
    if a[p.x]<>nil then
    begin
      sp:=p; spp:=p.p; v:=p.x; w:=v;
      repeat
        pp:=new(list); p.p:=pp;
        pp.x:=a[v].x; a[v]:=a[v].p;
        v:=pp.x; p:=pp;
      until v=w;
      p.p:=spp; p:=sp;
    end else p:=p.p;
  end;
  p:=h;
  while p.p<>nil do
  begin
    Writeln(p.x,' ',p.p.x);
    p:=p.p;
  end;
//  Close(input);Close(output);
end.
