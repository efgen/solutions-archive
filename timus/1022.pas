var a:array[1..100,1..100] of boolean;
i,j,k,n:integer;
r:set of byte;
flag:boolean;
por:array[1..100] of integer;
procedure Show;
begin
  for i:=0 to n-1 do
  Write(por[n-i],' ');
  halt;
end;
begin
  Readln(n);k:=0;
  FillChar(a,SizeOf(a),0);
  for i:=1 to n do
    repeat
      Read(j);
      if j=0 then break;
      a[i,j]:=true;
    until false;
  r:=[];   i:=0;
  while i<=n do
  begin
    if i<n then inc(i) else i:=1;
    if i in r then continue;
    flag:=false;
    for j:=1 to n do flag:=flag or a[i,j];
    if not flag then
    begin
      inc(k);
      por[k]:=i;
      r:=r+[i];
      if k=n then Show;
      for j:=1 to n do a[j,i]:=false;
    end;
  end;
end.