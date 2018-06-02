program Z1333;

{$APPTYPE CONSOLE}
uses
  SysUtils;

var x,y,r:array[1..10] of extended;
i,j,k,n,res:integer;
px,py:extended;
f:boolean;
begin
 { Assign(input,'input.txt');
  Assign(output,'output.txt');
  Reset(input); Rewrite(output);
  }Read(n);  res:=0;
  for i:=1 to n do Read(x[i],y[i],r[i]);
  px:=0;
  for i:=0 to 1000 do
  begin
    px:=px+0.001; py:=0;
    for j:=0 to 1000 do
    begin
      py:=py+0.001;
      f:=false;
      for k:=1 to n do
        if (Sqr(px-x[k])+Sqr(py-y[k])-Sqr(r[k])<=0) then
        begin
        f:=true;
        break;
        end;
      if f then inc(res);
    end;
  end;
  Writeln(res div 10000);


//  Close(input); Close(output);
end.