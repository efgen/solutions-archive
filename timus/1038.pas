{$APPTYPE CONSOLE}
var c:char;
res:integer;
Let,Blet,SLet,Sp:set of char;
procedure ReadW();
begin
  repeat
    Read(c);
    if c in Blet then inc(res);
  until not(c in Let);
end;
procedure ReadPr();
begin
  repeat
    Read(c);
    if c = #26 then
    begin
      Writeln(res);
    //  Close(input);Close(output);
      halt(0);
    end;
  until c in Let;
  if c in Slet then inc(res);
  while true do
  begin
    ReadW();
    repeat
      if c in ['!','?','.'] then exit;
      Read(c);
      if c = #26 then
    begin
      Writeln(res);
    //  Close(input);Close(output);
      halt(0);
    end;
    until c in Let;
  end;
end;
begin
 { Assign(input,'input.txt');
  Assign(output,'output.txt');
  Reset(input);Rewrite(output); }
  res:=0; Let:=['a'..'z','A'..'Z'];
  Blet:=['A'..'Z'];
  Slet:=['a'..'z'];
  while not Eof do
    ReadPr();
  Writeln(res);
//  Close(input);Close(output);
end.
