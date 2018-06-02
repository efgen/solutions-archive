{$APPTYPE CONSOLE}
const inf = 1000000000;
var a:array[1..100000] of integer;
f:array[#0..#255] of boolean;
i,l1,l2,k,t:integer;
c:char;
begin
  FillChar(f,SizeOf(f),false);
  for c:='a' to 'z' do f[c]:=true;
  for c:='A' to 'Z' do f[c]:=true;
  f[' ']:=true;
  Readln(l2,l1);
  k:=-1; i:=0;
  while true do
  begin
    Read(c);
    if c = #13 then break else inc(i);
    if f[c] then
    begin
      if i-l2>0 then a[i]:=a[i-l2]+1 else a[i]:=1;
      if i-l1>k then t:=i-l1 else t:=k;
      if a[t]<a[i] then a[i]:=a[t]+1;
    end else
    begin
      k:=i;
      if i-l2>0 then a[i]:=a[i-l2]+1 else a[i]:=1;
    end;
  end;
  Writeln(a[i]);
end.
