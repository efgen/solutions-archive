program Timus;
{$APPTYPE CONSOLE}
var x,y,z,vx,vy,vz:array[1..1000] of extended;
i,j,k,n:integer;
bi,bj:integer;
res,a,b,c,d,dis,x1,x2:extended;
const eps = 1e-9;
begin
  Read(n,dis); dis:=sqr(dis);
  for i:=1 to n do Read(x[i],y[i],z[i],vx[i],vy[i],vz[i]);
  res:=1e+300;  bi:=0; bj:=0;
  for i:=1 to n do
    for j:=i+1 to n do
    begin
      a:=sqr(vx[i]-vx[j])+sqr(vy[i]-vy[j])+sqr(vz[i]-vz[j]);
      b:=(vx[i]-vx[j])*(x[i]-x[j])+(vy[i]-vy[j])*(y[i]-y[j])+(vz[i]-vz[j])*(z[i]-z[j]);
      c:=sqr(x[i]-x[j])+sqr(y[i]-y[j])+sqr(z[i]-z[j])-dis;
      d:=b*b-a*c;
      if (d+eps>=0) and (a>eps) then
      begin
        if d>0 then d:=sqrt(d) else d:=0;
        x1:=(-b-d)/a;
        if x1>eps then
        begin
          if x1+eps<res then
          begin
            res:=x1; bi:=i; bj:=j;
          end;
        end;
        x1:=(-b+d)/a;
        if x1>eps then
        begin
          if x1+eps<res then
          begin
            res:=x1; bi:=i; bj:=j;
          end;
        end;
      end;
    end;
  if bi>0 then
  begin
    Writeln('ALARM!');
    Writeln(res:0:3,' ',bi,' ',bj);
  end else Writeln('OK');
//  Close(input); Close(output);
end.