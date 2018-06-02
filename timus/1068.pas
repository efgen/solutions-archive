var n,sum:longint;
begin
  Readln(n);
  if n>0 then sum:=n*(n+1) div 2
  else sum:=1-((abs(n)*(abs(n)+1)))div 2;
  Writeln(sum);
end.