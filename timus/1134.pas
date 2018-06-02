{$APPTYPE CONSOLE}
var a:array[0..1001] of integer;
f:array[0..1001] of boolean;
i,j,k,n,m,x:integer;
fl:boolean;
begin
 { Assign(input,'input.txt');
  Assign(output,'output.txt');
  Reset(input);Rewrite(output);  }
  FillChar(a,SizeOf(a),0);
  FillChar(f,SizeOf(f),false);
  fl:=true;
  Read(n,m);
  for i:=1 to m do
  begin
    Read(x);
    if x>n then fl:=false;
    if not fl then break;
    inc(a[x]);
  end;
  f[n+1]:=true;
  if a[0]>1 then fl:=false;
  if a[0]=1 then f[1]:=true;
  for i:=1 to n do
  begin
    while a[i]>0 do
    begin
      dec(a[i]);
      if not f[i] then
      begin
        f[i]:=true;
      end else
      if not f[i+1] then f[i+1]:=true else fl:=false;
    end;
  end;
  if fl then Writeln('YES') else Writeln('NO');
//  Close(input);Close(output);
end.
