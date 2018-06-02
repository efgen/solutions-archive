{$APPTYPE CONSOLE}
var s1,s2,s3,res:string;
var a:array[1..12,1..4] of integer =
((1,2,3,4),(1,3,4,2),(1,4,2,3),
 (2,3,1,4),(2,1,4,3),(2,4,3,1),
 (3,1,2,4),(3,2,4,1),(3,4,1,2),
 (4,3,2,1),(4,2,1,3),(4,1,3,2));
i,j:integer;
begin
{  Assign(input,'input.txt');
  Assign(output,'output.txt');
  Reset(input); Rewrite(output); }
  res:='different';
  Readln(s1);
  Readln(s2);
  for i:=1 to 12 do
  begin
    s3:=s2;
    for j:=1 to 4 do s3[j] := s2[a[i,j]];
    if (s1=s3) then res:='equal';
  end;
  Writeln(res);
 // Close(input); Close(output);
end.