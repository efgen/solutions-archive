{Legko vzlomat!!! 17-18.10.2005}
var a,b:array[0..100] of longint;
i,l:integer;
s:string;
begin
  Readln(s);
  l:=Length(s);
  b[0]:=5;
  for i:=1 to l do
  begin
    b[i]:=ord(s[i])-97;
  end;

  for i:=1 to l do
  begin
    a[i]:=(b[i]-b[i-1]+26) mod 26;
  end;

  for i:=1 to l do Write(chr(a[i]+97)); Writeln;
end.