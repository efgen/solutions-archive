{$APPTYPE CONSOLE}
var a:array[1..10000] of integer;
i,n:integer;
procedure solv(l,r:integer);
var x:integer;
begin
   if l>r then exit;
   if l=r then
   begin
     Writeln(a[r]);
     exit;
   end;
   x:=l;
   while a[x]<a[r] do inc(x);
   solv(x,r-1);
   solv(l,x-1);
   Writeln(a[r]);
end;
begin
{  Assign(input,'input.txt');
  Assign(output,'output.txt');
  Reset(input);Rewrite(output);}
  Read(n);
  for i:=1 to n do Read(a[i]);
  solv(1,n);
//  Close(input);Close(output);
end.
