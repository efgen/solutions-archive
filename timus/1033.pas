program Z;

{$APPTYPE CONSOLE}
uses
  SysUtils;
var a:array[0..40,0..40] of integer;
i,j,k,n,res:integer;
c:char;
procedure W(x,y:integer);
begin
  if a[x,y]<>0 then exit;  a[x,y]:=1;
  if a[x-1,y]=0 then W(x-1,y) else if a[x-1,y]<0 then inc(res);
  if a[x+1,y]=0 then W(x+1,y) else if a[x+1,y]<0 then inc(res);
  if a[x,y-1]=0 then W(x,y-1) else if a[x,y-1]<0 then inc(res);
  if a[x,y+1]=0 then W(x,y+1) else if a[x,y+1]<0 then inc(res);
end;
begin
{  Assign(input,'input.txt');
  Assign(output,'output.txt');
  Reset(input); Rewrite(output);
}  FillChar(a,SizeOf(a),0);
  Readln(n);
  for i:=0 to n+1 do
  begin
    a[0,i]:=-1;
    a[i,0]:=-1;
    a[i,n+1]:=-1;
    a[n+1,i]:=-1;
  end;
  for i:=1 to n do
  begin
    for j:=1 to n do
    begin
      Read(c);
      if c='#' then a[i,j]:=-1;
    end;
    Readln;
  end;
  res:=0;
  W(1,1); W(n,n);
  res:=(res-4)*9;
  Writeln(res);
//  Close(input); Close(output);
end.