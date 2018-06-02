var X,Y:longint;
begin
Readln(X,Y);
if (X<0)or(Y<0)then writeln(X,' ',Y)
else
if (X+Y)mod 2 = 0 then writeln(X,' ',Y)
else writeln(Y,' ',X);
end.