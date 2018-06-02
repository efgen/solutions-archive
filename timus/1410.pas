var a,b,w,na,nb:integer;
c:char;
inw:boolean;
f:array[#0..#255] of boolean;
begin
  {Assign(input,'input.txt');
  Assign(output,'output.txt');
  Reset(input);Rewrite(output);}
  FillChar(f,SizeOf(f),false);
  for c:='a' to 'z' do f[c]:=true;
  for c:='A' to 'Z' do f[c]:=true;

  inw:=false; a:=0; b:=0;
  while true do
  begin
    Read(c);
    if inw then
    begin
      if f[c] then inc(w) else
      begin
        na:=b+w;
        if a>b then nb:=a else nb:=b;
        a:=na; b:=nb;
        inw:=false;
        if c = #26 then break;
      end;
    end else
    begin
      if f[c] then
      begin
        inw:=true;
        w:=1;
      end else
      if c = #26 then break;
    end;
  end;
  if a>b then Write(a) else Write(b);
//  Close(input);Close(output);
end.
