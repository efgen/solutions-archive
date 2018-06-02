var n,k,b:integer;
fak:longint;
s:string;
begin
  Read(n,s);
  k:=length(s)-1;
  fak:=1;
  if n mod k = 0 then b:=k else b:=n mod k;
  while b<=n do
  begin fak:=fak*b; b:=b+k; end;
  Writeln(fak);
end.

