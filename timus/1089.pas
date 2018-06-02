{$APPTYPE CONSOLE}
var a:array[1..111] of string;
s:string;
i,j,k,n,mist:integer;
c:char;
function run(s:string):string;
var i,j,len,res,p:integer;
begin
  p:=0;
  len:=length(s);
  for i:=1 to n do
    if length(a[i])=len then
    begin
      res:=0;
      for j:=1 to len do
        if s[j]<>a[i][j] then inc(res);
      if res=0 then begin Result:=s; exit; end;
      if res=1 then p:= i;
    end;
  if p = 0 then Result:=s else
  begin inc(mist); Result:=a[p]; end;
end;
begin
  {Assign(input,'input.txt');
  Assign(output,'output.txt');
  Reset(input); Rewrite(output);  }
  n:=0; mist:=0;
  while true do
  begin
    Readln(s);
    if s='#' then break;
    inc(n);
    a[n]:=s;
  end;
  while true do
  begin
    repeat
      Read(c);
      if c=#26 then
      begin
        Write(mist);
        Close(input); Close(output);
        halt(0);
      end;
      if c in ['a'..'z'] then break;
      Write(c);
    until false;
    s:='';
    while c in ['a'..'z'] do
    begin
      s:=s+c;
      Read(c);
    end;
    Write(run(s));
    Write(c);
  end;

 // Close(input); Close(output);
end.