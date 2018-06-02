var n,m,k,i,j,x,p,r:integer;
a:array[0..1001] of integer;
begin
 { Assign(input,'input.txt');
  Assign(output,'output.txt');
  Reset(input);Rewrite(output); }
  FillChar(a,SizeOf(a),0);
  r:=1100;
  Read(n,m,k);
  for i:=1 to n do
    for j:=1 to m do
    begin
      Read(x);
      inc(a[x]);
      if x<r then r:=x;
    end;
  if k>0 then
  begin
    p:=0;
    while p<=1000 do
    begin
      dec(k,a[p]);
      inc(a[p+1],a[p]);
      inc(p);
      if k=0 then break;
      if k<0 then
      begin
        dec(p);
        break;
      end;
    end;
    r:=p;
    if k>0 then
    begin
      x:=a[1001];
      r:=1001+(k div x);
    end;
  end;
  Writeln(r);
//  Close(input);Close(output);
end.
