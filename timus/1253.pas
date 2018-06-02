{$APPTYPE CONSOLE}
var a:array[1..9] of string;
f,r:array[1..9] of boolean;
n,i,j,k:integer;
c:char;
s:string;
procedure solv(k:integer);
var lk,lk_len,lk_pos:array[0..10] of integer;
var i,len,x,cnt:integer;
begin
  f[k]:=true;
  len:=length(a[k]); cnt:=0; lk_pos[0]:=-1;
  for i:=1 to len do
    if a[k][i]='*' then
    begin
      inc(cnt);
      x:=ord(a[k][i+1])-ord('0');
      lk[cnt]:=x;
      lk_pos[cnt]:=i;
      if not r[x] then
        if not f[x] then solv(x) else
        begin
          Writeln('#');
          halt(0);
        end;
      lk_len[cnt]:=length(a[x]);
    end;
  x:=len;
  for i:=1 to cnt do
    x:=x+lk_len[i]-2;
  if x>1000000 then
  begin
    Writeln('#');
    halt(0);
  end;
  if cnt>0 then
  begin
    s:='';
    for i:=1 to cnt do
    begin
      for j:=lk_pos[i-1]+2 to lk_pos[i]-1 do s:=s+a[k][j];
      s:=s+a[lk[i]];
    end;
    for j:=lk_pos[cnt]+2 to len do s:=s+a[k][j];
    a[k]:=s;
  end;
  r[k]:=true;
end;
begin
 { Assign(input,'input.txt');
  Assign(output,'output.txt');
  Reset(input);Rewrite(output);     }
  Readln(n); k:=1;
  for i:=1 to n do
  begin
    a[i]:='';
    f[i]:=false;
    r[i]:=false;
  end;
  for k:=1 to n do
    repeat
      Read(c);
      if c<>'#' then a[k]:=a[k]+c else
      begin
        Read(c,c);
        break;
      end;
    until false;
  for k:=n+1 to 9 do a[k]:='';
  solv(1);
  Writeln(a[1]);
//  Close(input);Close(output);
end.
