var a:array[0..31,0..31] of integer;
p:array[0..31] of integer;
i,j,k,kk,n,m,l,r:integer;
msk,res:integer;
ff:boolean;
function can:boolean;
var q:array[0..31] of integer;
f:array[0..31] of boolean;
s,t,x,i:integer;
begin
  FillChar(f,SizeOf(f),false);
  s:=0; t:=0; q[s]:=0; f[0]:= true;
  while s<=t do
  begin
    x:=q[s]; inc(s);
    for i:=n-1 downto 0 do
      if not f[i] then
        if (a[x][i] and msk)>0 then
        begin
          f[i]:=true;
          inc(t);
          q[t]:=i;
        end;
  end;
  Result:=f[1];
end;
procedure gen(k:integer);
var i:integer;
begin
  if ff then exit;
  if (k>m) then
  begin
    msk:=0;
    for i:=1 to m do
      msk:=msk or (1 shl (p[i]-1));
    if can then
    begin
      res:=msk;
      ff:=true;
    end;
    exit;
  end;
  for i:=p[k-1]+1 to kk-m+k do
  begin
    p[k]:=i;
    gen(k+1);
  end;
end;
begin
//  reset(input,'input.txt');
// rewrite(output,'output.txt');
  Read(kk,n,m);
  FillChar(a,SizeOf(a),0);
  while m>0 do
  begin
    dec(m);
    Read(i,j,k);
    a[i][j]:=a[i][j] or (1 shl k);
    a[j][i]:=a[j][i] or (1 shl k);
  end;
  L:=1; R:=kk; res:=-1;
  while L<R do
  begin
    m:=(L+R) div 2;
    ff:=false;
    p[0]:=0;
    gen(1);
    if ff then R:=m else L:=m+1;
  end;
  Writeln(R);
  for i:=0 to kk-1 do
    if (res and (1 shl i))>0 then Write(i,' '); 
end.