var a:array[0..101,0..101] of integer;
n,m,i,j,napr,x,y,days:integer;
flag:boolean;

procedure Dum;
begin
  if flag then
  begin
    if a[i,j]=2 then flag:=false;
  end
    else
  begin
    inc(days);
    if a[i,j]=2 then
    begin Writeln(days); halt; end;
  end;
  a[i,j]:=0;
end;

begin
  Read(n,m);
  FillChar(a,SizeOf(a),0);
  for i:=1 to n do
    for j:=1 to m do
      a[i,j]:=1;
  Read(i,j); a[i,j]:=2;
  Read(i,j); a[i,j]:=2;
  days:=0; napr:=0;
  flag:=true;
  i:=1; j:=1;
  if a[1,1]=2 then flag:=false;
  a[1,1]:=0;
  repeat
    case napr of
      0:if a[i,j+1]<>0 then begin inc(j);dum; end else inc(napr);
      1:if a[i+1,j]<>0 then begin inc(i);dum; end else inc(napr);
      2:if a[i,j-1]<>0 then begin dec(j);dum; end else inc(napr);
      3:if a[i-1,j]<>0 then begin dec(i);dum; end else napr:=0;
    end;
  until false;
end.