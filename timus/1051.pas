var a,b,c,r:integer;
begin
Read(a,b);
if a>b then begin c:=a; a:=b; b:=c; end;
if a=1 then r:=(b+1) div 2 else
begin
if (a mod 3 = 0) or (b mod 3 = 0) then r:=2 else r:=1;
end;
Write(r);
end.