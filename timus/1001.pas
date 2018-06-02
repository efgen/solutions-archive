{$APPTYPE CONSOLE}
var a:array[1..1000000] of extended;
p:integer;
begin
//  Assign(input,'input.txt');
 // Assign(output,'output.txt');
 // Reset(input); Rewrite(output);
  p:=0;
  while not SeekEof do
  begin
    inc(p);
    Read(a[p]);
  end;
  while p>0 do
  begin
    Writeln(Sqrt(a[p]):0:4);
    dec(p);
  end;
 // Close(input); Close(output);
end.