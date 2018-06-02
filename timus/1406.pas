{$APPTYPE CONSOLE}
var a:array[1..2001] of integer;
i,j,k,n,x,s:integer;
c:char;
begin
 { Assign(input,'input.txt');
  Assign(output,'output.txt');
  Reset(input);Rewrite(output); }
  n:=0;
  while true do
  begin
    Read(c);
    if c in ['0'..'9'] then
    begin
      inc(n);
      a[n]:=ord(c)-ord('0');
    end else break;
  end;
  s:=0;
  for i:=n downto 1 do
  begin
    if s>0 then
      if a[i]<9 then
      begin
        inc(a[i]);
        dec(s);
        for j:=i+1 to n do a[j]:=0;
        j:=n;
        while s>0 do
        begin
          if s<9 then a[j]:=s else a[j]:=9;
          dec(s,a[j]);
          dec(j);
        end;
        for j:=1 to n do Write(a[j]);
     //     Close(input);Close(output);
         halt(0);

      end;
    inc(s,a[i]);
  end;
  Writeln(-1);
//  Close(input);Close(output);
end.
