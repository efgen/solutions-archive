var a:array[0..101,0..101] of byte;
i,j,n,s,h:byte;
begin
  FillChar(a,SizeOf(a),0);
  Readln(n);
  for i:=1 to n do
    for j:=1 to n do
      Read(a[i,j]);
  i:=0; j:=0; s:=1; h:=1;

  repeat
    if a[i,j]=0 then
    begin
      i:=s; j:=h;
      if s<n then inc(s) else if h<n then inc(h);
    end
    else
    begin
      Write(a[i,j],' ');
      if (i=n)and(j=n) then halt;
      dec(i); inc(j);
    end;
  until false;
end.