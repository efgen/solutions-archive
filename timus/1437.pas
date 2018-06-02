{$MINSTACKSIZE $00004000}
{$MAXSTACKSIZE $10000000}
var r:array[0..255,0..255,0..255] of boolean;
g:array[0..1000] of boolean;
a,b,c,k,q,i:integer;
function min(a,b:integer):integer;
begin
  if a<b then min:=a else min:=b;
end;
procedure dfs(x,y,z:integer);
begin
  g[x]:=true;
  g[y]:=true;
  g[z]:=true;
  g[x+y]:=true;
  g[x+z]:=true;
  g[y+z]:=true;
  g[x+y+z]:=true;
  r[x,y,z]:=false;
//  Writeln(x,' ',y,' ',z,' ',x+y+z);
//  if r[0,y,z] then dfs(0,y,z);
//  if r[x,0,z] then dfs(x,0,z);
//  if r[x,y,0] then dfs(x,y,0);
  if r[a,y,z] then dfs(a,y,z);
  if r[x,b,z] then dfs(x,b,z);
  if r[x,y,c] then dfs(x,y,c);

  q:=min(x+y,a);
  if r[q,x+y-q,z] then dfs(q,x+y-q,z);
  q:=min(x+y,b);
  if r[x+y-q,q,z] then dfs(x+y-q,q,z);

  q:=min(x+z,c);
  if r[x+z-q,y,q] then dfs(x+z-q,y,q);
  q:=min(x+z,a);
  if r[q,y,x+z-q] then dfs(q,y,x+z-q);

  q:=min(y+z,c);
  if r[x,y+z-q,q] then dfs(x,y+z-q,q);
  q:=min(y+z,b);
  if r[x,q,y+z-q] then dfs(x,q,y+z-q);
end;

begin
 { Assign(input,'input.txt');
  Assign(output,'output.txt');
  Reset(input);Rewrite(output);          }
  FillChar(r,SizeOf(r),true);
  FillChar(g,SizeOf(g),false);
  Read(a,b,c); dfs(0,0,0);
  k:=0;
  for i:=1 to 1000 do
    if g[i] then inc(k);
  Writeln(k);
//  Close(input);Close(output);
end.
