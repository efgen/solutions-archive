{$APPTYPE CONSOLE}
const max = 100000;
type bor = record
  alph:array[0..9] of integer;
  metka:integer;
end;

var a:array[1..max] of bor;
dict:array[1.. 50000] of string[50];
T,s:string;
res,best:array[0..110] of integer;
n,i,j,c,nods,p,len,sz:integer;
per:array['a'..'z'] of integer =(2,2,2,3,3,3,4,4,1,1,5,5,6,6,0,7,0,7,7,8,8,8,9,9,9,0);

procedure go(p,pos:integer);
begin
  if p = 0 then exit;
  if pos>len then
  begin
    if a[p].metka=0 then exit;
    inc(res[0]);
    res[res[0]]:=a[p].metka;
    if res[0]<best[0] then best:=res;
    dec(res[0]);
    exit;
  end;
  go(a[p].alph[ord(T[pos])-ord('0')],pos+1);
  if a[p].metka>0 then
    if res[0]+1<best[0] then
    begin
      inc(res[0]);
      res[res[0]]:=a[p].metka;
      go(1,pos);
      dec(res[0]);
    end;
end;

begin
  {Assign(input,'input.txt');
  Assign(output,'output.txt');
  Reset(input); Rewrite(output);  }
  nods:=0;
  sz:=SizeOf(a[1]);
  while true do
  begin
    Readln(T);
    if not(T[1] in ['0'..'9']) then break;
    Readln(n);
    for i:=1 to nods do FillChar(a[i],sz,0);

    nods:=1;
    len:=length(T);
    for i:=1 to n do
    begin
      Readln(s);
      dict[i]:=s;
      p:=1;
      for j:=1 to length(s) do
      begin
        c:=per[s[j]];
        if a[p].alph[c]>0 then p:=a[p].alph[c] else
        begin
          inc(nods);
          a[p].alph[c]:=nods;
          p:=nods;
        end;
      end;
      a[p].metka:=i;
    end;
    best[0]:=max;
    res[0]:=0;
    go(1,1);
    if best[0]=max then Writeln('No solution.') else
    begin
      Write(dict[best[1]]);
      for i:=2 to best[0] do Write(' ',dict[best[i]]);
      Writeln;
    end;
  end;
 // Close(input); Close(output);
end.