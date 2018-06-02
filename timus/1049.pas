program Z1049;

{$APPTYPE CONSOLE}

uses
  SysUtils;

var
st:array[1..10000] of integer;
i,n,x,p,res:integer;
begin
{  Assign(input,'input.txt');
  Assign(output,'output.txt');
  Reset(input); Rewrite(output);
}  FillChar(st,SizeOf(st),0);
  for i:=1 to 10 do begin
    Read(x); p:=2;
    while x>1 do
      if x mod p = 0 then
      begin inc(st[p]); x:=x div p; end else
      begin if p*p>x then p:=x else inc(p); end;
  end;
  res:=1;
  for i:=2 to 10000 do
    res:=(res*(st[i]+1)) mod 10;
  Writeln(res);

//  Close(input); Close(output);
end.
