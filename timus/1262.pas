{$APPTYPE CONSOLE}
var a:array['0'..'9'] of integer = (0,1,2,3,2,1,2,3,4,2);
var c:char;
res:integer;
begin
{  Assign(input,'input.txt');
  Assign(output,'output.txt');
  Reset(input);Rewrite(output);   }
  res:=0;
  repeat
    Read(c);
    if c in ['0'..'9'] then inc(res,a[c]) else break;
  until false;
  Writeln(res);
 // Close(input);Close(output);
end.
