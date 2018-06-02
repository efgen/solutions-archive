program Z;

{$APPTYPE CONSOLE}
uses
  SysUtils;
var a:array[1..50,0..1] of integer;
n,i,j,k,x,h:integer;
procedure Add(x,k:integer);
begin
  if k>h then inc(h);
  if a[k,0]=0 then
  begin
    a[k,0]:=1;
    a[k,1]:=x;
  end else
  if a[k,0]=1 then
  begin
    a[k,0]:=0;
    if a[k,1] = x then Add(x,k+1) else
    if k=h then while (h>1) and (a[h,0]=0) do dec(h);
  end;
end;
begin
  {Assign(input,'input.txt');
  Assign(output,'output.txt');
 } Reset(input); Rewrite(output);
  FillChar(a,SizeOf(a),0); h:=1;
  Read(n);
  for i:=1 to n do
  begin
    Read(x);
    Add(x,1);
  end;
  Write(a[h,1]);
 // Close(input); Close(output);
end.