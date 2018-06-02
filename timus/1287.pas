program Z;
{$APPTYPE CONSOLE}
var a:array[1..1400,1..1400] of integer;
t:array[1..1400,1..1400] of boolean;
r1,r2:integer;
i,j,k,n,m:integer;
c:char;
procedure sm();
var i,j:integer;
begin
  for i:=1 to n do
     for j:=1 to n do
       if t[i,j] then
       begin
         if a[i,j]>r1 then r1:=a[i,j];
       end else
         if a[i,j]>r2 then r2:=a[i,j];
end;
begin
{  Assign(input,'test.in');
  Assign(output,'test.out');
  Reset(input); Rewrite(output);}
  Readln(n);
  for i:=1 to n do
  begin
    for j:=1 to n do
    begin
      Read(c);
      t[i,j]:=(c='S');
    end;
    Readln;
  end;
  r1:=0; r2:=0;
  {-}
  FillChar(a,SizeOf(a),0);
  for i:=1 to n do a[i,1]:=1;
  for i:=1 to n do
    for j:=2 to n do
      if t[i,j]=t[i,j-1] then a[i,j]:=a[i,j-1]+1 else a[i,j]:=1;
  sm;
  {|}
//  FillChar(a,SizeOf(a),0);
  for j:=1 to n do a[1,j]:=1;
  for i:=2 to n do
    for j:=1 to n do
      if t[i,j]=t[i-1,j] then a[i,j]:=a[i-1,j]+1 else a[i,j]:=1;
  sm;
  {\}
 // FillChar(a,SizeOf(a),0);
  for i:=1 to n do a[i,1]:=1;
  for i:=1 to n do a[1,i]:=1;
  for i:=2 to n do
    for j:=2 to n do
      if t[i,j]=t[i-1,j-1] then a[i,j]:=a[i-1,j-1]+1 else a[i,j]:=1;
  sm;
  {/}
 // FillChar(a,SizeOf(a),0);
  for i:=1 to n do a[1,i]:=1;
  for i:=1 to n do a[i,n]:=1;
  for i:=2 to n do
    for j:=n-1 downto 1 do
      if t[i,j]=t[i-1,j+1] then a[i,j]:=a[i-1,j+1]+1 else a[i,j]:=1;
  sm;

  if r1>r2 then
  begin
    Writeln('S');
    Writeln(r1);
  end else
  if r1<r2 then
  begin
    Writeln('s');
    Writeln(r2);
  end else
  begin
    Writeln('?');
    Writeln(r1);
  end;
//  Close(input); Close(output);
end.