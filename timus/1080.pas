program Z1080;

{$APPTYPE CONSOLE}
uses
  SysUtils;

var a:array[0..100,0..100] of boolean;
c,m:array[0..100] of boolean;
i,j,k,n:integer;
procedure d_f_s(k:integer;cl:boolean);
var i:integer;
begin
  m[k]:=true;
  c[k]:=cl;
  cl:= not (cl);
  for i:=1 to n do
    if a[k,i] then
      if not m[i] then  d_f_s(i,cl) else
        if c[i]=c[k] then
        begin
          Writeln(-1);
          Close(input); Close(output);
          halt(0);
        end;  
end;
begin
  {Assign(input,'input.txt');
  Assign(output,'output.txt');
  Reset(input); Rewrite(output);
  }FillChar(a,SizeOf(a),false);
  FillChar(m,SizeoF(m),false);
  Read(n);
  for i:=1 to n do
    repeat Read(j); a[i,j]:=true; a[j,i]:=true; until j=0;
  d_f_S(1,false);
  for i:=1 to n do
    if c[i] then Write(1) else Write(0);
 // Close(input); Close(output);
end.
