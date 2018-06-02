var a,b,p:longint;
begin
  Readln(a,b);
  if a>b then exit
    else
  if a=b then Writeln(a mod 2)
    else
  begin
    p:=0;
    if a mod 2 = 0 then inc(a);
    if b mod 2 = 1 then inc(b);
    Writeln((b-a+1) div 2);
  end;
end.