
program Z;

{$APPTYPE CONSOLE}
uses
  SysUtils;
type Matrix = array[1..51,1..51] of boolean;
var A,B,R,Res:Matrix;
n,i,j,k,x:integer;
f:boolean;
procedure Mult(var A,B,R:Matrix);
var i,j,k:integer;
begin
  FillChar(R,SizeOf(R),0);
  for i:=1 to n do
    for j:=1 to n do
      for k:=1 to n do
        R[i,j]:=R[i,j] or A[i,k] and B[k,j];
end;
procedure Add(var A:Matrix);
var i,j:integer;
begin
  for i:=1 to n do
    for j:=1 to n do
      Res[i,j]:=Res[i,j] or A[i,j];
end;
procedure Pow(var A,R:Matrix;st:integer);
var P,Q,T:Matrix;
begin
  P:=A;
  for i:=1 to n do
    for j:=1 to n do
     if i=j then Q[i,j]:=true else Q[i,j]:=false;
  while st>0 do
    if st mod 2 = 0 then
    begin
      st:=st div 2;
      Mult(P,P,T); P:=T;
    end else
    begin
      st:=st-1;
      Mult(Q,P,T); Q:=T;
    end;
  Mult(Q,P,R);
end;
begin
  {Assign(input,'input.txt');
  Assign(output,'output.txt');
  Reset(input); Rewrite(output);
 } FillChar(Res,SizeOf(Res),0);
  Read(n);
  for i:=1 to n do
    for j:=1 to n do
    begin
      Read(x);
      A[i,j]:=(x>0);
    end;

  Pow(A,B,n*(n-1));
  for i:=n*(n-1) to n*(n+1) do
  begin
    Mult(A,B,R);
    B:=R;
    Add(R);
  end;
  f:=true;
  for i:=1 to n do
    for j:=1 to n do
      f:=f and Res[i,j];
  if f then Writeln('Yes') else Writeln('No');
//  Close(input); Close(output);
end.