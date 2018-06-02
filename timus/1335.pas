{$APPTYPE CONSOLE}
var n:integer;
begin
 { Assign(input,'input.txt');
  Assign(output,'output.txt');
  Reset(input);Rewrite(output);  }
  Read(n);
  Writeln(n*n+2*n,' ',n*n+n,' ',n*n);
 // Close(input);Close(output);
end.
