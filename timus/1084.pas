var r,stor:integer;
a,s,alf,sina,cosa:extended;
begin
  Readln(stor,r);
  a:=stor/2;
  if 2*r<=stor   then S:=Pi*sqr(r) else
  if R>sqrt(2)*a then S:=sqr(stor) else
  begin
    cosA:=a/r;
    sinA:=sqrt(1-sqr(cosA));
    alf:=arctan(sinA/cosA);
    S:=sqr(r)*(Pi-4*alf);
    S:=S+4*R*a*sinA;
   end;
  Writeln(S:3:3);
end.