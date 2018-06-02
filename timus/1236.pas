{$APPTYPE CONSOLE}
var a,b:array[1..10001] of byte;
c:char;
i,j,k,n:integer;
x:byte;
procedure Show(x:byte);
var h:byte;
begin
  h:=x div 16; x:=x mod 16;
  if h<10 then Write(h) else Write(chr(h-10+ord('A')));
  if x<10 then Write(x) else Write(chr(x-10+ord('A')));
end;
begin
 { Assign(input,'input.txt');
  Assign(output,'output.txt');
  Reset(input);Rewrite(output);      }
  k:=0;
  while true do
  begin
    Read(c);
    if c = #13 then break;
    if c in ['0'..'9'] then x:=ord(c)-ord('0') else x:=ord(c)-ord('A')+10;
    x:=16*x;
    Read(c);
    if c in ['0'..'9'] then x:=x+ord(c)-ord('0') else x:=x+ord(c)-ord('A')+10;
    inc(k);
    a[k]:=x;
  end;
  Read(c); n:=k; k:=0;
  while true do
  begin
    Read(c);
    if (c = #13) or (c = #26) then break;
    if c in ['0'..'9'] then x:=ord(c)-ord('0') else x:=ord(c)-ord('A')+10;
    x:=16*x;
    Read(c);
    if c in ['0'..'9'] then x:=x+ord(c)-ord('0') else x:=x+ord(c)-ord('A')+10;
    inc(k);
    b[k]:=x;
  end;
  k:=b[1] xor 32;
  for i:=1 to n do
  begin
    Show(k);
    k:=(a[i] xor k) xor b[i+1];
  end;
  Show(k);
//  Close(input);Close(output);
end.
