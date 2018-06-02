{$APPTYPE CONSOLE}
var t,n:integer;
function Prime(x:integer):boolean;
var p:integer;
begin
  if x=2 then Result:=true else
  if x mod 2 = 0 then Result:=false else
  begin
    p:=3;
    while p*p<=x do
      if x mod p = 0 then
        begin Result:=false; exit; end else p:=p+2;
    Result:=true;
  end;
end;
procedure solv(x:integer);
var p:integer;
begin
  p:=3;
  repeat
    if Prime(p) then
      if Prime(x-p) then
      begin
        Writeln(p,' ',x-p);
        exit;
      end;
    p:=p+2;
  until false;
end;
begin
 { Assign(input,'input.txt');
  Assign(output,'output.txt');
  Reset(input); Rewrite(output);  }
  Read(t);
  while t>0 do
  begin
    dec(t); Read(n);
    if Prime(n) then Writeln(n) else
    if n mod 2 = 1 then
      if Prime(n-2) then Writeln(2,' ',n-2) else
        begin Write('3 '); solv(n-3); end
    else solv(n);
  end;
//  Close(input); Close(output);
end.