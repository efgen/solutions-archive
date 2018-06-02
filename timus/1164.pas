{$APPTYPE CONSOLE}
var a:array['A'..'Z'] of integer;
n,m,p,i,j,k:integer;
s:string;
c:char;
begin
{  Assign(input,'input.txt');
  Assign(output,'output.txt');
  Reset(input);Rewrite(output);     }
  FillChar(a,SizeOf(a),0);
  Readln(n,m,p);
  for i:=1 to n do
  begin
    Readln(s);
    for j:=1 to m do
      inc(a[s[j]]);
  end;
  for i:=1 to p do
  begin
    Readln(s);
    for j:=1 to length(s) do
      dec(a[s[j]]);
  end;
  for c:='A' to 'Z' do
  begin
    while a[c]>0 do
    begin
      Write(c);
      dec(a[c]);
    end;
  end;
 // Close(input);Close(output);
end.
