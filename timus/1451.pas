{$APPTYPE CONSOLE}
var x1,x2,x3,y1,y2,y3,xs1,xs2,ys1,ys2,x,y,a,b,c:extended;
function dist(x1,y1,x2,y2:extended):extended;
begin
  Result:=Sqrt(Sqr(x1-x2)+Sqr(y1-y2));
end;
function kos(x1,y1,x2,y2:extended):extended;
begin
  Result:=x1*y2-x2*y1;
end;
procedure PS(x1,y1,x2,y2,x3,y3:extended;var rx,ry:extended);
var a,b,c,d,dd,xp,yp:extended;
begin
  d:=dist(x1,y1,x2,y2);
  d:=d*Sqrt(3)/2;
  xp:=(x1+x2)/2;
  yp:=(y1+y2)/2;
  a:=y2-y1;
  b:=x1-x2;
  c:=-a*x1-b*y1;
  dd:=Sqrt(a*a+b*b);
  rx:=xp+a*d/dd;
  ry:=yp+b*d/dd;
  if ((a*rx+b*ry+c>0) and (a*x3+b*y3+c>0))
  or ((a*rx+b*ry+c<0) and (a*x3+b*y3+c<0)) then
  begin
     rx:=xp-a*d/dd;
     ry:=yp-b*d/dd;
  end;
end;
procedure per(x1,y1,x2,y2,x3,y3,x4,y4:extended;var x,y:extended);
var k:extended;
begin
  x:=x2-x1;
  y:=y2-y1;
  k:=kos(x4-x3,y4-y3,x1-x3,y1-y3)/kos(x2-x1,y2-y1,x4-x3,y4-y3);
  x:=x1+x*k;
  y:=y1+y*k;
end;
begin
 { Assign(input,'input.txt');
  Assign(output,'output.txt');
  Reset(input); Rewrite(output);        }
  Read(x1,y1,x2,y2,x3,y3);
  a:=dist(x1,y1,x2,y2);
  b:=dist(x2,y2,x3,y3);
  c:=dist(x3,y3,x1,y1);
  if (a*a+b*b-c*c)/(2*a*b)<=-0.5 then Writeln(x2,' ',y2) else
  if (a*a+c*c-b*b)/(2*a*c)<=-0.5 then Writeln(x1,' ',y1) else
  if (b*b+c*c-a*a)/(2*b*c)<=-0.5 then Writeln(x3,' ',y3) else
  begin
    Ps(x1,y1,x2,y2,x3,y3,xs1,ys1);
    Ps(x1,y1,x3,y3,x2,y2,xs2,ys2);
    per(x2,y2,xs2,ys2,x3,y3,xs1,ys1,x,y);
    Writeln(x,' ',y);
  end;
//  Close(input); Close(output);
end.