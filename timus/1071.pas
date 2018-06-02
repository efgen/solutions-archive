{$APPTYPE CONSOLE}
var x,y,bas,k1,k2,n,i,j:integer;
a,b:array[1..30] of integer;
begin
 { Assign(input,'input.txt');
  Assign(output,'output.txt');
  Reset(input); Rewrite(output);
  }Read(x,y);
  if y>x then
  begin
    Write('No solution');
    Close(input); Close(output);
    halt(0);
  end;
  for bas:=2 to x do
  begin
    n:=x; k1:=0;
    while n>0 do
    begin
      inc(k1);
      a[k1]:=n mod bas;
      n:=n div bas;
    end;
    n:=y; k2:=0;
    while n>0 do
    begin
      inc(k2);
      b[k2]:=n mod bas;
      n:=n div bas;
    end;
    j:=k1;
    for i:=k2 downto 1 do
    begin
      while (b[i]<>a[j]) and (j>0) do dec(j);
      dec(j);
    end;
    if j>=0 then
    begin
      Write(bas);
      Close(input); Close(output);
      halt(0);
  end;
  end;
  Writeln('No solution');
//  Close(input); Close(output);
end.