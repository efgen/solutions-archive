var a:array[1..60000] of longint;
n,i,j,min:longint;
function Kw(n:longint):boolean;
begin
  if n=Sqr(Trunc(Sqrt(n))) then Kw:=true else Kw:=false;
end;

begin
  Readln(n);
  if Kw(n) then begin Writeln(1); exit; end;
  for i:=1 to n do
  begin
    if Kw(i) then a[i]:=1 else
    begin
      j:=1; min:=60000;
      while (i-j*j)>=1 do
      begin
        if a[i-j*j]<min then min:=a[i-j*j];
        inc(j);
      end;
      a[i]:=min+1;
    end;
  end;
  Writeln(a[n]);
end.