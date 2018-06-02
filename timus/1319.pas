var a:array[1..100,1..100] of integer;
num,k,h,l,i,j,n:integer;
begin
  Readln(n);
  FillChar(a,SizeOf(a),0);
  num:=1;

  k:=n;
  h:=0;
  while k>1 do
  begin
    j:=k; i:=1;
    for l:=0 to h do
    begin
      a[i+l][j+l]:=num;
      inc(num);
    end;
    inc(h);
    dec(k);
  end;

  k:=1;
  h:=n-1;
  while k<=n do
  begin
    i:=k; j:=1;
    for l:=0 to h do
    begin
      a[i+l][j+l]:=num;
      inc(num);
    end;
    dec(h);
    inc(k);
  end;

  for i:=1 to n do
  begin
    for j:=1 to n do
    Write(a[i,j],' ');
    Writeln;
  end;
end.
