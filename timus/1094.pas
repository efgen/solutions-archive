program Z1094;

{$APPTYPE CONSOLE}
uses
  SysUtils;
var a:array[1..80] of char;
c:char;
p:integer;
begin
{  Assign(input,'input.txt');
  Assign(output,'output.txt');
  Reset(input); Rewrite(output);
 } for p:=1 to 80 do a[p]:=' ';  p:=1;
  while not Eof do
  begin
    Read(c);
    case c of
      #13,#10:continue;
      '>': if p=80 then p:=1 else inc(p);
      '<': if p>1 then dec(p);
      else begin a[p]:=c;if p=80 then p:=1 else inc(p);end;
    end;
  end;
  for p:=1 to 80 do Write(a[p]);
//  Close(input); Close(output);
end.
